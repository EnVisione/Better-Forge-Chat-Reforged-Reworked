package com.enviouse.sef.audit;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandEffectEvidenceWriterTest {
    @TempDir
    Path temporaryDirectory;

    @Test
    void appendsAndReplacesCandidateBoundRows() throws Exception {
        String oldRoot = System.getProperty("sef.audit.evidenceRoot");
        String oldCommit = System.getProperty("sef.audit.candidateCommit");
        String oldSha256 = System.getProperty("sef.audit.candidateSha256");
        try {
            System.setProperty("sef.audit.evidenceRoot", temporaryDirectory.toString());
            System.setProperty("sef.audit.candidateCommit", "0123456789abcdef0123456789abcdef01234567");
            System.setProperty("sef.audit.candidateSha256",
                    "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef");
            CommandEffectEvidenceWriter.record(
                    "sef:item.give.others", "first", "success", true, true, "none");
            CommandEffectEvidenceWriter.record(
                    "sef:control.cleanup.manage", "second", "failure", false, true, "invalid_input");
            CommandEffectEvidenceWriter.record(
                    "sef:item.give.others", "first", "failure", false, true, "storage");

            JsonObject record = JsonParser.parseString(Files.readString(
                    temporaryDirectory.resolve("command-effect-runtime.json"), StandardCharsets.UTF_8)).getAsJsonObject();
            assertEquals(2, record.get("rowCount").getAsInt());
            assertEquals("failure", record.getAsJsonArray("rows").asList().stream()
                    .filter(row -> row.getAsJsonObject().get("actionId").getAsString()
                            .equals("sef:item.give.others"))
                    .findFirst().orElseThrow().getAsJsonObject().get("result").getAsString());
        } finally {
            restore("sef.audit.evidenceRoot", oldRoot);
            restore("sef.audit.candidateCommit", oldCommit);
            restore("sef.audit.candidateSha256", oldSha256);
        }
    }

    @Test
    void recordsReadOnlyOracleSeparatelyFromMutationEvidence() throws Exception {
        String oldRoot = System.getProperty("sef.audit.evidenceRoot");
        String oldCommit = System.getProperty("sef.audit.candidateCommit");
        String oldSha256 = System.getProperty("sef.audit.candidateSha256");
        try {
            System.setProperty("sef.audit.evidenceRoot", temporaryDirectory.toString());
            System.setProperty("sef.audit.candidateCommit", "0123456789abcdef0123456789abcdef01234567");
            System.setProperty("sef.audit.candidateSha256",
                    "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef");
            CommandEffectEvidenceWriter.recordReadOnly(
                    "sef:config.status", "readOnlyRoute");

            JsonObject row = JsonParser.parseString(Files.readString(
                    temporaryDirectory.resolve("command-effect-runtime.json"), StandardCharsets.UTF_8))
                    .getAsJsonObject().getAsJsonArray("rows").get(0).getAsJsonObject();
            assertEquals("read_only", row.get("oracleClass").getAsString());
            assertEquals("success", row.get("result").getAsString());
            assertEquals(true, row.get("effectObserved").getAsBoolean());
        } finally {
            restore("sef.audit.evidenceRoot", oldRoot);
            restore("sef.audit.candidateCommit", oldCommit);
            restore("sef.audit.candidateSha256", oldSha256);
        }
    }

    @Test
    void rejectsExistingEvidenceForAnotherCandidate() throws Exception {
        Path output = temporaryDirectory.resolve("command-effect-runtime.json");
        Files.writeString(output, "{\"schemaVersion\":1,\"candidateCommit\":\"wrong\","
                + "\"candidateSha256\":\"wrong\",\"rowCount\":0,\"rows\":[]}", StandardCharsets.UTF_8);
        String oldRoot = System.getProperty("sef.audit.evidenceRoot");
        String oldCommit = System.getProperty("sef.audit.candidateCommit");
        String oldSha256 = System.getProperty("sef.audit.candidateSha256");
        try {
            System.setProperty("sef.audit.evidenceRoot", temporaryDirectory.toString());
            System.setProperty("sef.audit.candidateCommit", "0123456789abcdef0123456789abcdef01234567");
            System.setProperty("sef.audit.candidateSha256",
                    "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef");
            assertThrows(IllegalArgumentException.class, () -> CommandEffectEvidenceWriter.record(
                    "sef:item.give.others", "first", "success", true, true, "none"));
        } finally {
            restore("sef.audit.evidenceRoot", oldRoot);
            restore("sef.audit.candidateCommit", oldCommit);
            restore("sef.audit.candidateSha256", oldSha256);
        }
    }

    private static void restore(String key, String value) {
        if (value == null) {
            System.clearProperty(key);
        } else {
            System.setProperty(key, value);
        }
    }
}
