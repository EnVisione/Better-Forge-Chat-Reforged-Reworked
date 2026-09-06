package com.enviouse.sef.control;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.enviouse.sef.kernel.ActionResult;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@GameTestHolder("sef")
@PrefixGameTestTemplate(false)
public final class ServerControlGameTests {
    private static final List<EffectEvidence> EFFECT_EVIDENCE = new ArrayList<>();

    private ServerControlGameTests() {
    }

    @GameTest(template = "empty")
    public static void everyServerControlSchemaIsTruthfullyClassified(GameTestHelper helper) {
        try (RepositoryFixture fixture = repository()) {
            ServerControlExecutionService executions = new ServerControlExecutionService(fixture.repository());

            MinecraftServerControlRuntime.registerHandlers(executions);

            var diagnostic = executions.diagnostic();
            helper.assertTrue(
                    diagnostic.registeredHandlers().size()
                            + diagnostic.unavailableIntegrations().size()
                            == ServerControlSchemaRegistry.schemas().size(),
                    "not every server control schema has a runtime classification");
            helper.assertTrue(
                    diagnostic.unavailableIntegrations().equals(
                            MinecraftServerControlRuntime.unavailableRuntimeFeatures()),
                    "server control unavailability diagnostics are inaccurate");
            helper.succeed();
        }
    }

    @GameTest(template = "empty")
    public static void unavailableServerControlFamiliesFailClosedWithoutMutation(GameTestHelper helper) {
        Path path = null;
        try {
            path = Files.createTempDirectory("sef-unavailable-control-gametest");
            ServerControlRepository repository = new ServerControlRepository();
            repository.load(path);
            ServerControlExecutionService executions = new ServerControlExecutionService(repository);
            MinecraftServerControlRuntime.registerHandlers(executions);
            UUID actor = UUID.randomUUID();

            for (String feature : MinecraftServerControlRuntime.unavailableRuntimeFeatures()) {
                var schema = ServerControlSchemaRegistry.require(feature);
                var created = repository.create(
                        feature,
                        actor,
                        null,
                        feature + " unavailable audit",
                        "negative contract",
                        null,
                        requiredMetadata(schema));
                helper.assertTrue(created.successful(), feature + " record could not be created: " + created.detail());

                var record = created.value();
                var preview = executions.preview(record.id(), record.revision());
                helper.assertTrue(!preview.ready(), feature + " preview incorrectly reported ready");
                helper.assertTrue(
                        preview.detail().toLowerCase(java.util.Locale.ROOT).contains("unavailable"),
                        feature + " preview did not report unavailability: " + preview.detail());

                var result = executions.execute(
                        record.id(),
                        actor,
                        record.revision(),
                        true,
                        new ServerControlExecutionService.ExecutionContext() {
                            @Override
                            public Object server() {
                                return helper.getLevel().getServer();
                            }

                            @Override
                            public Object source() {
                                return helper.getLevel().getServer().createCommandSourceStack();
                            }
                        });
                helper.assertTrue(!result.successful(), feature + " unavailable execution unexpectedly succeeded");
                helper.assertTrue(
                        result.reason() == ActionResult.ReasonCode.PROVIDER_ERROR,
                        feature + " returned the wrong unavailable reason: " + result.reason());
                helper.assertTrue(
                        repository.find(record.id()).orElseThrow().equals(record),
                        feature + " execution changed the unavailable record");
                helper.assertTrue(
                        repository.executions(null).isEmpty(),
                        feature + " unavailable execution created a durable operation");
            }
            writeUnavailableRuntimeEvidence();
            helper.succeed();
        } catch (IOException exception) {
            throw new IllegalStateException("unavailable control GameTest storage is unavailable", exception);
        } finally {
            deleteTree(path);
        }
    }

    @GameTest(template = "empty")
    public static void worldPolicyAppliesValidatedGamerules(GameTestHelper helper) {
        boolean previous = helper.getLevel().getGameRules().getBoolean(GameRules.RULE_DAYLIGHT);
        try {
            ActionResult<ServerControlExecutionService.Execution> result = execute(
                    helper,
                    "world_policy",
                    Map.of(
                            "field.world", helper.getLevel().dimension().location().toString(),
                            "field.gamerules", "doDaylightCycle=false",
                            "field.drift_response", "restore"));

            helper.assertTrue(result.successful(), result.detail());
            helper.assertTrue(
                    !helper.getLevel().getGameRules().getBoolean(GameRules.RULE_DAYLIGHT),
                    "world policy did not change the selected gamerule");
            writeEffectEvidence(
                    "sef:control.world_policy.manage",
                    "worldPolicyAppliesValidatedGamerules",
                    "success",
                    true,
                    true,
                    "none");
        } finally {
            helper.getLevel().getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(previous, null);
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void sleepVoteAppliesValidatedPercentage(GameTestHelper helper) {
        int previous = helper.getLevel().getGameRules().getInt(GameRules.RULE_PLAYERS_SLEEPING_PERCENTAGE);
        try {
            ActionResult<ServerControlExecutionService.Execution> result = execute(
                    helper,
                    "sleep_vote",
                    Map.of(
                            "field.required_percent", "75",
                            "field.acceleration_seconds", "1",
                            "field.ignore_afk", "true",
                            "field.clear_weather", "false"));

            helper.assertTrue(result.successful(), result.detail());
            helper.assertTrue(
                    helper.getLevel().getGameRules().getInt(GameRules.RULE_PLAYERS_SLEEPING_PERCENTAGE) == 75,
                    "sleep vote threshold did not change the gamerule");
            writeEffectEvidence(
                    "sef:control.sleep_vote.manage",
                    "sleepVoteAppliesValidatedPercentage",
                    "success",
                    true,
                    true,
                    "none");
        } finally {
            helper.getLevel().getGameRules().getRule(GameRules.RULE_PLAYERS_SLEEPING_PERCENTAGE).set(previous, null);
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void worldPolicyRejectsTheWholeBatchBeforeMutation(GameTestHelper helper) {
        boolean previous = helper.getLevel().getGameRules().getBoolean(GameRules.RULE_DAYLIGHT);
        ActionResult<ServerControlExecutionService.Execution> result = execute(
                helper,
                "world_policy",
                Map.of(
                        "field.world", helper.getLevel().dimension().location().toString(),
                        "field.gamerules", "doDaylightCycle=false,sefMissingRule=true",
                        "field.drift_response", "restore"));

        helper.assertTrue(!result.successful(), "invalid gamerule batch was accepted");
        helper.assertTrue(
                helper.getLevel().getGameRules().getBoolean(GameRules.RULE_DAYLIGHT) == previous,
                "invalid gamerule batch partially mutated the world");
        writeEffectEvidence(
                "sef:control.world_policy.manage",
                "worldPolicyRejectsTheWholeBatchBeforeMutation",
                "failure",
                false,
                true,
                "invalid_input");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void worldBorderAppliesBoundedCenterAndSize(GameTestHelper helper) {
        var border = helper.getLevel().getWorldBorder();
        double previousX = border.getCenterX();
        double previousZ = border.getCenterZ();
        double previousSize = border.getSize();
        try {
            ActionResult<ServerControlExecutionService.Execution> result = execute(
                    helper,
                    "world_border",
                    Map.of(
                            "field.world", helper.getLevel().dimension().location().toString(),
                            "field.center_x", "32.5",
                            "field.center_z", "-48.5",
                            "field.size", "512",
                            "field.transition_seconds", "0"));

            helper.assertTrue(result.successful(), result.detail());
            helper.assertTrue(border.getCenterX() == 32.5D, "world border center x did not change");
            helper.assertTrue(border.getCenterZ() == -48.5D, "world border center z did not change");
            helper.assertTrue(border.getSize() == 512.0D, "world border size did not change");
            writeEffectEvidence(
                    "sef:control.world_border.manage",
                    "worldBorderAppliesBoundedCenterAndSize",
                    "success",
                    true,
                    true,
                    "none");
        } finally {
            border.setCenter(previousX, previousZ);
            border.setSize(previousSize);
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void cleanupRemovesSelectedItemsWithoutRemovingPlayers(GameTestHelper helper) {
        var player = helper.makeMockServerPlayerInLevel();
        ItemEntity item = new ItemEntity(
                helper.getLevel(),
                player.getX(),
                player.getY(),
                player.getZ(),
                new ItemStack(Items.ROTTEN_FLESH));
        helper.getLevel().addFreshEntity(item);

        ActionResult<ServerControlExecutionService.Execution> result = execute(
                helper,
                "cleanup",
                Map.of(
                        "field.targets", "items",
                        "field.interval_seconds", "10",
                        "field.minimum_age_seconds", "0",
                        "field.worlds", helper.getLevel().dimension().location().toString()));

        helper.assertTrue(result.successful(), result.detail());
        helper.assertTrue(item.isRemoved(), "cleanup did not remove the selected item entity");
        helper.assertTrue(!player.isRemoved(), "cleanup removed a player");
        writeEffectEvidence(
                "sef:control.cleanup.manage",
                "cleanupRemovesSelectedItemsWithoutRemovingPlayers",
                "success",
                true,
                true,
                "none");
        helper.succeed();
    }

    private static ActionResult<ServerControlExecutionService.Execution> execute(
            GameTestHelper helper,
            String feature,
            Map<String, String> metadata
    ) {
        try (RepositoryFixture fixture = repository()) {
            ServerControlRepository repository = fixture.repository();
            ServerControlExecutionService executions = new ServerControlExecutionService(repository);
            MinecraftServerControlRuntime.registerHandlers(executions);
            UUID actor = UUID.randomUUID();
            var created = repository.create(
                    feature,
                    actor,
                    null,
                    feature,
                    "game test",
                    null,
                    metadata);
            if (!created.successful()) {
                return ActionResult.failure(created.reason(), created.detail());
            }
            MinecraftServer server = helper.getLevel().getServer();
            return executions.execute(
                    created.value().id(),
                    actor,
                    created.value().revision(),
                    true,
                    new ServerControlExecutionService.ExecutionContext() {
                        @Override
                        public Object server() {
                            return server;
                        }

                        @Override
                        public Object source() {
                            return server.createCommandSourceStack();
                        }
                    });
        }
    }

    private static RepositoryFixture repository() {
        try {
            Path path = Files.createTempDirectory("sef-control-gametest");
            ServerControlRepository repository = new ServerControlRepository();
            repository.load(path);
            return new RepositoryFixture(repository, path);
        } catch (IOException exception) {
            throw new IllegalStateException("server control game test storage is unavailable", exception);
        }
    }

    private record RepositoryFixture(ServerControlRepository repository, Path path) implements AutoCloseable {
        @Override
        public void close() {
            deleteTree(path);
        }
    }

    private static Map<String, String> requiredMetadata(ServerControlSchemaRegistry.FeatureSchema schema) {
        Map<String, String> metadata = new HashMap<>();
        for (var field : schema.fields()) {
            if (!field.required()) {
                continue;
            }
            String value = switch (field.type()) {
                case TEXT -> "audit";
                case INTEGER, DURATION_SECONDS -> Long.toString(field.minimum());
                case DECIMAL -> Long.toString(field.minimum());
                case BOOLEAN -> "false";
                case ENUM -> field.enumValues().stream().sorted().findFirst().orElseThrow();
                case INSTANT -> Instant.parse("2099-01-01T00:00:00Z").toString();
                case UUID -> "00000000-0000-0000-0000-000000000001";
                case RESOURCE_LOCATION -> "minecraft:overworld";
                case HTTPS_URL -> "https://example.com/audit";
                case HASH -> "0".repeat((int) field.minimum());
                case LIST -> "audit";
            };
            metadata.put("field." + field.id(), value);
        }
        return Map.copyOf(metadata);
    }

    private static void writeUnavailableRuntimeEvidence() throws IOException {
        String evidenceRoot = System.getProperty("sef.audit.evidenceRoot", "").trim();
        if (evidenceRoot.isEmpty()) {
            return;
        }
        String candidateCommit = System.getProperty("sef.audit.candidateCommit", "").trim();
        String candidateSha256 = System.getProperty("sef.audit.candidateSha256", "").trim();
        if (!candidateCommit.matches("[0-9a-f]{40}") || !candidateSha256.matches("[0-9a-f]{64}")) {
            throw new IllegalArgumentException("candidate identity properties are required");
        }
        Path root = Path.of(evidenceRoot).toAbsolutePath().normalize();
        if (Files.isSymbolicLink(root)) {
            throw new IllegalArgumentException("unavailable runtime evidence root is a symlink");
        }
        Files.createDirectories(root);
        Path output = root.resolve("unavailable-runtime.json");
        if (Files.isSymbolicLink(output)) {
            throw new IllegalArgumentException("unavailable runtime evidence target is a symlink");
        }
        JsonArray rows = new JsonArray();
        for (String feature : MinecraftServerControlRuntime.unavailableRuntimeFeatures()) {
            JsonObject row = new JsonObject();
            row.addProperty("familyId", feature);
            row.addProperty("result", "pass");
            row.addProperty("previewDenied", true);
            row.addProperty("executionDenied", true);
            row.addProperty("unchangedRecord", true);
            row.addProperty("noDurableOperation", true);
            row.addProperty("reason", "provider_error");
            rows.add(row);
        }
        JsonObject record = new JsonObject();
        record.addProperty("schemaVersion", 1);
        record.addProperty("candidateCommit", candidateCommit);
        record.addProperty("candidateSha256", candidateSha256);
        record.addProperty("source", "unavailableServerControlFamiliesFailClosedWithoutMutation");
        record.addProperty("rowCount", rows.size());
        record.add("rows", rows);
        Files.writeString(output, record.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
    }

    private static synchronized void writeEffectEvidence(
            String actionId,
            String testName,
            String result,
            boolean effectObserved,
            boolean unchangedOnFailure,
            String failureClass
    ) {
        String evidenceRoot = System.getProperty("sef.audit.evidenceRoot", "").trim();
        if (evidenceRoot.isEmpty()) {
            return;
        }
        String candidateCommit = System.getProperty("sef.audit.candidateCommit", "").trim();
        String candidateSha256 = System.getProperty("sef.audit.candidateSha256", "").trim();
        if (!candidateCommit.matches("[0-9a-f]{40}") || !candidateSha256.matches("[0-9a-f]{64}")) {
            throw new IllegalArgumentException("effect evidence candidate identity properties are required");
        }
        EFFECT_EVIDENCE.removeIf(row -> row.actionId().equals(actionId) && row.testName().equals(testName));
        EFFECT_EVIDENCE.add(new EffectEvidence(
                actionId,
                testName,
                result,
                effectObserved,
                unchangedOnFailure,
                failureClass));
        Path root = Path.of(evidenceRoot).toAbsolutePath().normalize();
        if (Files.isSymbolicLink(root)) {
            throw new IllegalArgumentException("effect evidence root is a symlink");
        }
        try {
            Files.createDirectories(root);
            Path output = root.resolve("server-control-effect-runtime.json");
            if (Files.isSymbolicLink(output)) {
                throw new IllegalArgumentException("effect evidence target is a symlink");
            }
            JsonArray rows = new JsonArray();
            EFFECT_EVIDENCE.stream()
                    .sorted(Comparator.comparing(EffectEvidence::actionId).thenComparing(EffectEvidence::testName))
                    .forEach(row -> {
                        JsonObject value = new JsonObject();
                        value.addProperty("actionId", row.actionId());
                        value.addProperty("testName", row.testName());
                        value.addProperty("result", row.result());
                        value.addProperty("effectObserved", row.effectObserved());
                        value.addProperty("unchangedOnFailure", row.unchangedOnFailure());
                        value.addProperty("failureClass", row.failureClass());
                        value.addProperty("sourceType", "dedicated_server_gametest");
                        value.addProperty("runtime", "canonical_linux");
                        rows.add(value);
                    });
            JsonObject record = new JsonObject();
            record.addProperty("schemaVersion", 1);
            record.addProperty("candidateCommit", candidateCommit);
            record.addProperty("candidateSha256", candidateSha256);
            record.addProperty("source", "ServerControlGameTests");
            record.addProperty("rowCount", rows.size());
            record.add("rows", rows);
            Files.writeString(output, record.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new IllegalStateException("effect evidence could not be written", exception);
        }
    }

    private record EffectEvidence(
            String actionId,
            String testName,
            String result,
            boolean effectObserved,
            boolean unchangedOnFailure,
            String failureClass
    ) {
    }

    private static void deleteTree(Path root) {
        if (root == null || !Files.exists(root)) {
            return;
        }
        try (var paths = Files.walk(root)) {
            paths.sorted(Comparator.reverseOrder()).forEach(path -> {
                try {
                    Files.deleteIfExists(path);
                } catch (IOException exception) {
                    throw new IllegalStateException("server control GameTest cleanup failed", exception);
                }
            });
        } catch (IOException exception) {
            throw new IllegalStateException("server control GameTest cleanup failed", exception);
        }
    }
}
