package com.enviouse.sef.audit;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Writes candidate-bound effect observations emitted by dedicated-server GameTests.
 */
public final class CommandEffectEvidenceWriter {
    private static final String FILE_NAME = "command-effect-runtime.json";

    private CommandEffectEvidenceWriter() {
    }

    public static synchronized void record(
            String actionId,
            String testName,
            String result,
            boolean effectObserved,
            boolean unchangedOnFailure,
            String failureClass
    ) {
        record(actionId, testName, result, effectObserved, unchangedOnFailure, failureClass, "mutation");
    }

    public static synchronized void recordReadOnly(String actionId, String testName) {
        record(actionId, testName, "success", true, false, "none", "read_only");
    }

    private static synchronized void record(
            String actionId,
            String testName,
            String result,
            boolean effectObserved,
            boolean unchangedOnFailure,
            String failureClass,
            String oracleClass
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
        if (!actionId.matches("sef:[a-z0-9_.]+") || testName.isBlank()
                || !Set.of("success", "failure").contains(result)
                || failureClass.isBlank()
                || !Set.of("mutation", "read_only").contains(oracleClass)
                || "read_only".equals(oracleClass) && !"success".equals(result)) {
            throw new IllegalArgumentException("effect evidence row is invalid");
        }
        Path root = Path.of(evidenceRoot).toAbsolutePath().normalize();
        if (Files.isSymbolicLink(root)) {
            throw new IllegalArgumentException("effect evidence root is a symlink");
        }
        try {
            Files.createDirectories(root);
            Path output = root.resolve(FILE_NAME);
            if (Files.isSymbolicLink(output)) {
                throw new IllegalArgumentException("effect evidence target is a symlink");
            }
            List<JsonObject> rows = Files.isRegularFile(output)
                    ? readExisting(output, candidateCommit, candidateSha256)
                    : new ArrayList<>();
            rows.removeIf(row -> actionId.equals(row.get("actionId").getAsString())
                    && testName.equals(row.get("testName").getAsString()));
            JsonObject row = new JsonObject();
            row.addProperty("actionId", actionId);
            row.addProperty("testName", testName);
            row.addProperty("result", result);
            row.addProperty("effectObserved", effectObserved);
            row.addProperty("unchangedOnFailure", unchangedOnFailure);
            row.addProperty("failureClass", failureClass);
            row.addProperty("oracleClass", oracleClass);
            row.addProperty("sourceType", "dedicated_server_gametest");
            row.addProperty("runtime", "canonical_linux");
            rows.add(row);
            rows.sort(Comparator.<JsonObject, String>comparing(value -> value.get("actionId").getAsString())
                    .thenComparing(value -> value.get("testName").getAsString()));

            JsonArray serializedRows = new JsonArray();
            rows.forEach(serializedRows::add);
            JsonObject record = new JsonObject();
            record.addProperty("schemaVersion", 1);
            record.addProperty("candidateCommit", candidateCommit);
            record.addProperty("candidateSha256", candidateSha256);
            record.addProperty("source", "CommandEffectEvidenceWriter");
            record.addProperty("rowCount", rows.size());
            record.add("rows", serializedRows);
            Files.writeString(output, record.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new IllegalStateException("effect evidence could not be written", exception);
        }
    }

    private static List<JsonObject> readExisting(Path output, String candidateCommit, String candidateSha256)
            throws IOException {
        JsonElement parsed = JsonParser.parseString(Files.readString(output, StandardCharsets.UTF_8));
        if (!parsed.isJsonObject()) {
            throw new IllegalArgumentException("effect evidence record is not an object");
        }
        JsonObject record = parsed.getAsJsonObject();
        if (!record.has("schemaVersion") || record.get("schemaVersion").getAsInt() != 1
                || !candidateCommit.equals(record.get("candidateCommit").getAsString())
                || !candidateSha256.equals(record.get("candidateSha256").getAsString())
                || !record.has("rows") || !record.get("rows").isJsonArray()
                || !record.has("rowCount")
                || record.get("rowCount").getAsInt() != record.getAsJsonArray("rows").size()) {
            throw new IllegalArgumentException("effect evidence record identity or shape is invalid");
        }
        List<JsonObject> rows = new ArrayList<>();
        Set<String> keys = new HashSet<>();
        for (JsonElement element : record.getAsJsonArray("rows")) {
            if (!element.isJsonObject()) {
                throw new IllegalArgumentException("effect evidence row is not an object");
            }
            JsonObject row = element.getAsJsonObject();
            String actionId = row.get("actionId").getAsString();
            String testName = row.get("testName").getAsString();
            String key = actionId + "\u0000" + testName;
            if (!keys.add(key) || !actionId.matches("sef:[a-z0-9_.]+") || testName.isBlank()
                    || !row.has("result") || !Set.of("success", "failure").contains(row.get("result").getAsString())
                    || !row.has("effectObserved") || !row.has("unchangedOnFailure")
                    || !row.has("failureClass")
                    || row.has("oracleClass") && !Set.of("mutation", "read_only")
                            .contains(row.get("oracleClass").getAsString())
                    || "read_only".equals(row.has("oracleClass")
                            ? row.get("oracleClass").getAsString() : "mutation")
                            && !"success".equals(row.get("result").getAsString())
                    || !"dedicated_server_gametest".equals(row.get("sourceType").getAsString())
                    || !"canonical_linux".equals(row.get("runtime").getAsString())) {
                throw new IllegalArgumentException("effect evidence row is invalid");
            }
            rows.add(row.deepCopy());
        }
        return rows;
    }
}
