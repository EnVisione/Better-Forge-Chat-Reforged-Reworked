# Server Essentials Forge 2 Final Audit and Remediation Plan

> **Plan ID:** PLAN-MASTER
> **Plan status:** VALIDATED
> **Planning mode:** FULL_PLAN_CREATOR_REBUILD
> **Project state:** EXISTING
> **Planning subject:** Server Essentials Forge 2 final security, administrator-command, UI, persistence, backend-handling, and integration audit with mandatory remediation closure
> **Requested artifact:** authoritative_plan
> **Plan profile:** software_product
> **Authoring evidence date:** 2026-09-02
> **Diagnostics contract:** 2

This master plan is the authoritative product contract for the final audit and remediation program. It freezes global scope, requirement ownership, decisions, phase order, and completion authority. Each linked file under `phases/` will own the detailed execution blueprint for exactly one phase. Planning completion does not mean that the product audit or remediation is complete.

## 1. Project Identity

```text
Project: Server Essentials Forge 2, displayed as SEFPORTED
Mod id: sef
Primary package: com.enviouse.sef
Repository root: /mnt/hermes/projects/SEFPORTED
Original audit lineage branch: envy/phase-001-security
Original audit lineage commit: e203ece01df76cb076d9112a14a052cac6f4145d
Full rebuild evidence branch: envy/phase-003-commands
Full rebuild evidence commit: 239a73411d7a7217cc4bc5393491ab73ed629279
Starting branch: envy/phase-003-commands
Starting commit: 239a73411d7a7217cc4bc5393491ab73ed629279
Candidate lineage base commit: 0c75bf25c58622096dfa7cc65a5f4b32e6d60ac4
Authoritative remote:
origin
https://github.com/MCEnvision/Server-Essentials-Forge.git
Remote ref: origin/envy/phase-003-commands
Remote commit observed for this rebuild: 239a73411d7a7217cc4bc5393491ab73ed629279
Remote commit: 239a73411d7a7217cc4bc5393491ab73ed629279
Remote default branch at authoring: forge-1.20.1
Product version at authoring: 2.0.0
Minecraft: 1.21.1
NeoForge: 21.1.235
Java: 21
Parchment mappings: 2024.11.17
Requested artifact: authoritative_plan
```

Repository identity, package metadata, source namespace, and remote identity match the owner request. This rebuild observes the active Phase 003 branch at `239a73411d7a7217cc4bc5393491ab73ed629279`; it descends from the candidate lineage selected by `DEC-006`. The older remote default branch is repository and security evidence, not an instruction to merge legacy platform work into this audit or change the supported platform. The saved goal is creation-time provenance and remains unchanged; execution reads this live plan and the registered current phase.

## 2. Planning Subject and Source Roles

| ID | Role | Subject | Source | Intended use |
|---|---|---|---|---|
| SRC-001 | owner_request | Full SEF 2 audit and deliberate plan rebuild | EnVy direct current $plan-creator request on 2026-09-06 | Authoritative scope, portability correction, and rebuild authorization. |
| SRC-002 | requirements | SEF 2 intended behavior and compatibility | /mnt/hermes/projects/SEFPORTED/sef2.md | Product behavior and compatibility contract. |
| SRC-003 | audit_evidence | Historical full codebase audit findings | /mnt/hermes/projects/SEFPORTED/audit.md | Prior findings and evidence gaps requiring renewed proof. |
| SRC-004 | requirements | Manual, multiplayer, integration, UI, persistence, and release verification matrix | /mnt/hermes/projects/SEFPORTED/test.md | Highest-fidelity workflow and acceptance coverage. |
| SRC-005 | repository_evidence | Current implementation and technical documentation | /mnt/hermes/projects/SEFPORTED at the inspected candidate revision | Observed architecture, state, commands, UI, integrations, and build constraints. |
| SRC-006 | repository_evidence | Build, manifests, tests, resources, and CodeGraph inventory | /mnt/hermes/projects/SEFPORTED build metadata and .codegraph | Package identity, dependency direction, test inventory, and reproducibility constraints. |
| SRC-007 | audit_evidence | Remote repository and dependency security state | Read-only GitHub preflight and retained evidence packets | Remote identity and dependency risk context only. |
| SRC-008 | reference | Historical porting and inventory audit | /mnt/hermes/projects/SEFPORTED/SEFAudit.md | Legacy risk cross-check only. |
| SRC-009 | owner_request | Minecraft Java portability and native dependency boundary | EnVy direct current request and prior locked platform correction | One portable Minecraft Java client contract, Linux canonical fixture, conditional host-specific non-client evidence, and in-plan EXT closure. |
| SRC-010 | repository_evidence | Audit writer and compile-only native API implementation | NativeAuditFileProvider, build.gradle, and retained Phase 001 evidence | Opened-object identity, JNA packaging, and provider evidence requirements. |
| SRC-011 | status | Current phase and goal continuity | /mnt/hermes/projects/SEFPORTED/docs/plan/goal.md and supplied checkpoint brief | Active phase and next task context; never authority over the rebuilt product contract. |

The planning subject is the existing SEF 2 product at its current release candidate lineage, not the production of another audit document in isolation. Existing audits are evidence and risk inputs. Existing status documents describe current claims and gaps. The plan requires independent proof against the frozen execution revision before any historical result can close a gate.

Authority follows this order: current owner decisions, this master plan, validated deterministic handoff, registered phase plans for execution detail, verified repository and runtime evidence, then status, audits, references, and inference. Current implementation cannot silently weaken intended behavior. A generated reference proves only what its generator declared unless it is reconciled with the live dispatcher, runtime, and artifact.

## 3. Purpose and Intended Outcome

Server owners and administrators depend on SEF for privileged commands, moderation, stateful administration, optional enhanced clients, and durable server data. A defect at those boundaries can disclose private information, create unintended authority, corrupt state, mislead an operator, or fail only during a restart, disconnect, provider outage, or mixed client session. Existing automated coverage and prior audits are substantial, but current status documents still record incomplete multiplayer and interactive evidence, intentionally unavailable control families, divergent historical counts, and unresolved dependency risk.

This plan produces one release candidate whose declared surfaces have been exhaustively inventoried, audited, remediated, and verified at the highest required fidelity. Primary workflows are:

1. Freeze a traceable audit baseline and map every relevant source, state, command, UI, integration, and evidence surface to one owner.
2. Find and repair sensitive data leaks, backdoor like authority paths, authorization failures, dependency risk, and unsafe trust boundary behavior.
3. Execute the complete administrator command contract, including negative and failure behavior, rather than treating registration or parsing as functional proof.
4. Audit every durable store and database like boundary through corruption, concurrency, migration, shutdown, and recovery scenarios.
5. Polish graphical and textual operator UI and prove accessibility, responsiveness, and server authority.
6. Prove backend lifecycle and cross channel handling under reload, revocation, reconnect, partial failure, and shutdown.
7. Prove Java 21 and NeoForge 21.1.235 behavior on a canonical disposable Linux environment for portable server and shared runtime paths, use the Minecraft Java client fixture for all portable client graphics and input, and run conditional macOS and Windows evidence only when changed or exercised code uses non-client host-specific filesystem, native, startup, process-control, dependency-loading, recovery, or packaging behavior. Security-sensitive writes retain provider-specific or native opened-object identity and fail closed on every supported host.
8. Rerun the complete clean checkout, multiplayer, compatibility, recovery, performance, artifact, dependency, and documentation matrix at one frozen revision.

The observable endpoint is defined by `DEC-003`, `DEC-009`, and Section 18. Minecraft Java support remains cross-platform on Linux, macOS, and Windows. Linux is the canonical host for platform-independent code and shared automated behavior. macOS and Windows host evidence is conditional validation for an affected or exercised host-specific path and is not a general endpoint blocker when no such path changes. `EXT-001` and `EXT-002` retain their evidence and provenance records, while platform-owned or unavailable evidence is not converted into an unsupported-platform claim. The result is release readiness evidence, not authorization to publish or deploy.

## 4. Evidence Based Current State

| Area | Evidence class | Finding | Evidence |
|---|---|---|---|
| Project identity | OBSERVED | The repository builds a NeoForge 1.21.1 mod with mod id `sef`, Java 21, NeoForge 21.1.235, Parchment 2024.11.17, and artifact version 2.0.0. | `gradle.properties`, `build.gradle`, `settings.gradle`, generated mod metadata |
| Repository state | OBSERVED | The active branch is `envy/phase-003-commands` at `239a73411d7a7217cc4bc5393491ab73ed629279`, matching `origin/envy/phase-003-commands` at rebuild intake. Existing modified planning files and the untracked `.playwright-mcp/` directory are preserved as pre-existing work. | Read-only local Git inspection during the full rebuild |
| Planning state | OBSERVED | The authoritative topology remains eight contiguous phases. Stable requirement, decision, future, non-goal, prerequisite, phase, and task IDs are preserved where coherent. The active phase is `SEFAUD-PHASE-003`; its first unfinished mandatory action is `P003-TASK-010`. The saved goal remains immutable. | Existing registered plan set, saved goal, and current owner rebuild authority |
| Source inventory | OBSERVED | The current CodeGraph index covers 512 files and was current during bounded planning inspection. | `.codegraph/` state and CodeGraph exploration on 2026-09-01 |
| Command architecture | OBSERVED | `KernelServices` prepares and seals `CommandCatalog`, registers canonical actions and shortcuts, and constructs `CommandExecutionService` over feature, permission, cooldown, cost, warmup, confirmation, execution, and audit policies. | CodeGraph exploration of [KernelServices](../../src/main/java/com/enviouse/sef/kernel/KernelServices.java), [CommandCatalog](../../src/main/java/com/enviouse/sef/kernel/command/CommandCatalog.java), and [CommandExecutionService](../../src/main/java/com/enviouse/sef/kernel/policy/CommandExecutionService.java); [technical documentation](../../DOCUMENTATION.md) |
| Command reference and coverage | OBSERVED | Current generated and status documents report 694 catalog actions and 315 shortcuts, but some older UI test prose still names 676 entries. Prior GameTests compiled representative routes and directly executed safe read only routes, but did not execute every mutating administrative workflow across every source and state. | [Command reference](../COMMAND_REFERENCE.md), [manual test plan](../../test.md), [prior audit](../../audit.md), and [acceptance ledger](../SEF2_ACCEPTANCE.md) |
| Intentionally unavailable controls | OBSERVED | Fifty nine of 75 server control schemas have runtime handlers. Sixteen named Phase 13 families are deliberately unavailable, report unavailable during preview, and cannot activate or resolve through generic state changes. | [Technical documentation](../../DOCUMENTATION.md), [README](../../README.md), [acceptance ledger](../SEF2_ACCEPTANCE.md), and CodeGraph exploration of server control execution |
| Persistence architecture | OBSERVED | `StorageCoordinator` registers versioned repositories and coordinates periodic and shutdown flush. CodeGraph reports 31 runtime implementations of `StorageRepository.audit`. Other managers and workers also own durable JSON, TOML, NBT, journals, queues, receipts, backups, and caches outside that interface. | CodeGraph exploration, [technical documentation](../../DOCUMENTATION.md), and [storage tests](../../src/test/java/com/enviouse/sef/storage) |
| Storage primitives | OBSERVED | `AtomicFileStore` and `CoalescedPersistenceWorker` provide shared publication and coalescing behavior, while repositories expose recovery, unsupported, error, ready, and closed states. | CodeGraph exploration and [storage tests](../../src/test/java/com/enviouse/sef/storage) |
| GUI and network architecture | OBSERVED | `SefNetwork`, `SefSessionManager`, `SefGuiServer`, typed payload records, `PanelActionValidator`, server projected action sets, and the `SefScreen` family provide optional enhanced UI. Server validation checks session, sequence, feature, panel, record, target, policy, and permission state. | CodeGraph exploration, [technical documentation](../../DOCUMENTATION.md), and [GUI protocol tests](../../src/test/java/com/enviouse/sef/gui/protocol) |
| Audit and redaction | OBSERVED | `AuditService` is called across kernel and policy code. `CommandRedactionPolicy` feeds command journal projection and file logging. Existing tests cover selected redaction, audit, privacy, and logging boundaries. | CodeGraph exploration; `AuditServiceTest`, `CommandRedactionPolicyTest`, `FileLogSinkTest` |
| Prior security result | OBSERVED | The tracked security review reports no unresolved finding in its reviewed scope, while the broader audit records limitations that require controlled multiplayer, provider, UI, packet, process interruption, scale, and dependency environments. These are historical claims, not proof for the future frozen execution revision. | [Security review](../SECURITY_REVIEW.md) and [prior audit](../../audit.md) |
| Dependency risk | OBSERVED | The repository had 26 open Dependabot alerts on 2026-09-01, comprising 12 high, 13 medium, and one low severity alert across transitive Maven dependencies. Applicability to the current candidate branch and packaged artifact was not established. No open code scanning or secret scanning alert was returned by the same preflight. | SRC-007 |
| Cross-platform audit writer | OBSERVED | The integrated lineage contains Linux and macOS POSIX descriptor handling and Windows handle-based handling that inspect opened-object identity and link or reparse state. `jna` and `jna-platform` are compile only. Linux is the canonical runtime and fixture host; macOS and Windows validation is limited to actually exercised non-client host-specific paths. Dependency provenance closure is owned by in-plan work under `EXT-002`. | `NativeAuditFileProvider`, `build.gradle`, SRC-005, SRC-010, and SRC-011 |
| Automated evidence | OBSERVED | Current documents contain differing unit and GameTest counts across historical snapshots. No count is accepted as current merely because it appears in prose. Phase 000 inventory and final execution establish the authoritative identities and counts. | [Acceptance ledger](../SEF2_ACCEPTANCE.md), [technical documentation](../../DOCUMENTATION.md), [README](../../README.md), and [prior audit](../../audit.md) |
| Interactive evidence | OBSERVED | Multiplayer, current LuckPerms, GUI visual and accessibility, InvSee, admission capacity, disguise animation, reconnect, and selected recovery rows remain incomplete or require renewal. Host-specific native-writer evidence is conditional on the provider path being changed or exercised, and platform dependency ownership still requires classification. | [Acceptance ledger](../SEF2_ACCEPTANCE.md), [manual test plan](../../test.md), [compatibility matrix](../COMPATIBILITY_MATRIX.md), and SRC-010 |
| Maintained quality gates | OBSERVED | The existing Gradle build runs unit tests and packaging but the prior audit reports no maintained formatter, warning budget, static analysis, or risk based coverage gate in the build. | [Gradle build](../../build.gradle) and [prior audit](../../audit.md) |
| Release state | OBSERVED | The branch is documented as a test or release candidate preparation build. Public release acceptance remains incomplete. | [README](../../README.md), [acceptance ledger](../SEF2_ACCEPTANCE.md), and [release workflow](../RELEASE_WORKFLOW.md) |

No current behavior is labeled `VERIFIED` by this planning pass. Earlier completed phase packets remain execution evidence only when their identity and invalidation checks still pass. Phase 003 resumes at `P003-TASK-010`; Phase 000 inventory outputs remain the authority for conflicting counts and stale claims.

## 5. Product Contract and Profile Coverage

| Profile area | Status | Source | Contract location | Rationale |
|---|---|---|---|---|
| Inputs and outputs | covered | SRC-001 | Inputs, Outputs, and Observable Endpoint | Commands, payloads, configuration, durable data, evidence, and artifact outputs are defined. |
| Component architecture | covered | SRC-005 | Architecture and Ownership Boundaries | Lifecycle, command, policy, UI, persistence, native writer, integrations, and build ownership are defined. |
| State and persistence | covered | SRC-002 | State and Persistence Contract | All durable and transient state, schema, recovery, concurrency, and migration obligations are in scope. |
| Failure taxonomy | covered | SRC-003 | Failure Taxonomy and Recovery | Invalid input, authorization, dependency, persistence, lifecycle, partial success, and evidence failures are classified. |
| Versioning | covered | SRC-006 | Compatibility and Versioning | Minecraft, NeoForge, Java, protocol, configuration, persistence, and artifact boundaries are pinned. |
| Security | covered | SRC-001 | Security, Privacy, and Supply Chain Contract | Leak, backdoor, trust-boundary, native writer, redaction, dependency, and artifact closure are mandatory. |
| Test system | covered | SRC-004 | Verification Strategy | Unit, GameTest, dedicated server, Minecraft Java client fixture, integration, recovery, performance, security, and artifact evidence are required. |
| Release lifecycle | covered | SRC-009 | Documentation, Operations, and Release Gates | Clean checkout, packaging, compatibility, provenance, evidence, rollback, and release readiness are defined without publication. |
| Generalization | covered | SRC-009 | Supported Environments and Generalization | Linux, macOS, and Windows remain supported Minecraft Java targets with one portable client evidence contract and conditional host-specific non-client checks. |
| Determinism | covered | SRC-004 | Determinism and Evidence Reproducibility | Inventories, generated references, normalized state, evidence manifests, and artifact hashes must reproduce. |

### Inputs, Outputs, and Observable Endpoint

In scope inputs include player, console, RCON, command block, function, scheduled, GUI, alias, bundle, sudo, and server profile command requests where the catalog permits them; typed enhanced client payloads; configuration and migration files; world and server persistent data; optional provider decisions; registry content; lifecycle events; dependency metadata; and release candidate source and resources. Every input is untrusted until the owning server boundary validates its type, size, source, permission, revision, and current policy.

In scope outputs include domain mutations, command feedback, suggestions, graphical screens, HUD state, audit events, redacted observation records, logs, exports, persistent files, migrations, backups, recovery states, generated references, build reports, test evidence, and the packaged JAR. Outputs must reveal only authorized information, identify failure without exposing secrets, and match the final documented contract.

The endpoint is one frozen candidate revision and one artifact digest that satisfy all mandatory requirements, every phase exit, and Section 18. Linux is the canonical runtime for portable Minecraft Java behavior. macOS and Windows remain supported and require direct smoke or native evidence only for changed or exercised host-specific paths. A passing parse, registered command, present source file, historical audit, or headless startup alone cannot satisfy a row that needs higher-fidelity evidence. Unknown or unavailable conditional host evidence is recorded without narrowing support. Direct mod-owned dependency exposure remains a mandatory closure gate, while platform-owned upstream alerts retain a documented not-mod-resolvable disposition.

### State and Persistence Contract

The logical server owns all authoritative gameplay, administration, permission, session, and durable state. Clients own presentation caches only. Durable scope includes every `StorageRepository`, configuration document, world player data adapter, JSON, TOML, NBT, object store, queue, journal, receipt, migration marker, recovery record, backup, audit file, optional log, and durable cache that can change later behavior. An inventory based only on `StorageRepository` is incomplete.

Every durable owner must declare its path, schema or envelope version, identity and cardinality, size and record bounds, write and flush model, concurrency model, idempotency contract, migration rules, unsupported newer version behavior, corruption behavior, backup and restore path, privacy classification, retention, shutdown behavior, and evidence. Unsupported or damaged authoritative data must not become an empty successful state. A repair that changes a schema must preserve supported data through a versioned migration and recovery copy.

Security-sensitive file publication and append operations must bind validation and mutation to the same opened object. On every supported host path, the owning writer must use a provider-specific or native descriptor or handle path that proves opened-object identity, regular-file or directory type, link or reparse state, and stable identity across the write and flush. Path-only checks, a pre-open identity check followed by an unrelated write, or a host exclusion cannot satisfy this invariant. A missing native capability fails the affected operation closed and preserves prior valid state and recovery evidence.

Transient state includes sessions, sequence counters, confirmations, warmups, temporary permission grants, selected GUI targets, open menu authorization, projections, transfers, rate limits, and in flight persistence work. Disconnect, reload, provider refresh, world change, and shutdown must invalidate or settle transient state according to its owner contract. Transient state must not mint durable authority or survive beyond its declared lifecycle.

### Failure Taxonomy and Recovery

| Failure class | Required behavior | Operator evidence | Recovery contract |
|---|---|---|---|
| Invalid or oversized input | Reject before mutation or unsafe decode. Return bounded, actionable feedback where disclosure is safe. | Sanitized validation result and stable action or field identifier | Correct the input and retry. No rollback is needed because no mutation occurred. |
| Authorization or policy failure | Fail closed at discovery and execution boundaries. Recheck immediately before mutation. | Decision source, permission or policy identifier, actor class, and correlation id without sensitive arguments | Restore valid authority or policy, refresh revisions, and submit a new request. Stale confirmations are never reused. |
| Optional provider absent or failed | Preserve documented internal fallback or explicitly disable the provider owned capability. Never grant because a provider failed. | Provider state and bounded diagnostic | Restore the provider and refresh, or continue through the documented fallback. |
| Local dependency or registry failure | Reject unsupported content or adapter capability without corrupting unrelated state. | Namespaced identifier and dependency state | Install or restore a compatible dependency, or use supported content. |
| Persistence validation or corruption failure | Enter explicit recovery, unsupported, or error state. Block writes that could destroy evidence. | Store id, schema state, recovery path, and sanitized cause | Quarantine or restore from validated recovery material, then revalidate before reopening writes. |
| Persistence publication failure | Preserve or restore the last known good state. Distinguish not committed, committed, and outcome unknown. | Revision, operation id, journal or receipt state, and flush health | Retry only idempotent work. Resolve outcome unknown records before another side effect. |
| Concurrency or stale revision | Reject stale mutation and preserve the newer state. | Expected and observed revisions without sensitive payloads | Reload current state and create a new preview or transaction. |
| Partial multi component success | Stop dependent work, preserve compensation or recovery state, and never report full success. | Per component result under one correlation id | Execute the declared compensation or recovery path, then rerun the complete invariant check. |
| Network, session, or replay failure | Drop or reject stale, forged, replayed, incompatible, or out of order requests before mutation. | Session safe rejection and abuse counters | Negotiate a new session or fall back to commands. Old identifiers remain invalid. |
| Lifecycle interruption | Bound shutdown and background work, preserve incomplete markers, and fail startup closed where state is ambiguous. | Worker, repository, and marker status | Complete recovery before enabling the affected domain. |
| Verification or evidence failure | Mark the row failed or blocked. Do not substitute a lower fidelity result. | Exact command or workflow, environment, revision, and decisive failure | Repair the product or environment and rerun every invalidated row. |

### Security, Privacy, and Supply Chain Contract

A backdoor like path means any undocumented or unintended mechanism that grants authority, executes a command, reads or mutates protected data, escapes an owned filesystem path, persists privilege, bypasses hierarchy or exemption, weakens confirmation, reaches a server context, or exposes a hidden identity outside the declared contract. The audit does not presume malicious intent. It must nevertheless search for these paths across direct calls, reflection, mixins, aliases, bundles, profiles, GUI actions, payload handlers, lifecycle callbacks, integrations, configuration, migration, recovery, and packaging.

Sensitive data includes credentials, tokens, private messages, raw or linkable network addresses, hidden identities, moderation reasons where restricted, security evidence, command arguments covered by redaction, private GUI projections, filesystem paths that reveal host details, and provider metadata beyond the viewer contract. Sensitive data must not leak through feedback, suggestions, chat, HUD, GUI, audit, command spy, optional file logs, exports, exceptions, metrics, generated documentation, test fixtures, or the JAR.

Security review must include source to sink tracing, permission and source matrices, bypass inventory, payload and parser bounds, filesystem ownership, symlink and detectable hard link handling, archive and image parsing, deserialization depth, concurrency and time of check behavior, persistent grants, audit integrity, optional provider failure, reflection containment, mixin and access transformer scope, dependency reachability, artifact contents, secret shape scans, and adversarial runtime tests. Any confirmed authorization bypass, sensitive data leak, or backdoor like route is mandatory remediation regardless of severity label.

Supply chain closure must evaluate the resolved candidate graph and packaged mod artifact, with installed NeoForge runtime provenance captured when native or platform-owned APIs are used. Every mod-owned critical or high alert must be repaired or shown inapplicable with exact dependency path, configuration, packaging, affected API, reachability, advisory evidence, and compatible remediation. Platform-owned alerts retain separate candidate-graph, packaged-artifact, installed-runtime, reachability, advisory-applicability, provenance, and remediation dispositions, but an alert supplied only by pinned NeoForge is not a mod-resolvable defect. It must be recorded as platform-owned and not-mod-resolvable when the mod does not directly declare, package, or reach the vulnerable component. No alert may be suppressed, dismissed, or cleared by narrowing operating-system scope. If the mod directly exposes an applicable exploitable vulnerability and no compatible remedy exists, completion remains blocked under `EXT-002`.

JNA or JNA Platform may be used as compile-only APIs only when the exact compatible versions are supplied by the pinned NeoForge 21.1.235 runtime. The mod artifact must not embed a second JNA runtime, duplicate its native classes, or shadow the platform-owned copy. Compile success alone does not prove runtime presence, binary compatibility, native loading, or advisory closure; those facts require `EXT-001` and `EXT-002` evidence when the native path is exercised or changed.

### Supported Environments and Generalization

Mandatory platform support is Minecraft Java on Linux, macOS, and Windows. All three remain supported targets for Java 21, Minecraft 1.21.1, and NeoForge 21.1.235. Linux is the canonical audit host for portable server and shared runtime behavior. Portable Minecraft Java client behavior is evidenced through the Minecraft Java client fixture. `EXT-001` records host manifests and runs macOS or Windows validation when changed or exercised code requires it; an unavailable conditional host leaves only that conditional row unverified and never changes support status. Windows must never be documented as unsupported.

Evidence covers dedicated-server startup, operation, audit writing, save, bounded shutdown, and restart on canonical Linux, plus direct macOS or Windows runs only when a changed or exercised non-client path is host-specific. It also covers matching enhanced and fallback client workflows, protocol compatibility, migrated synthetic data, multiple dimensions, online and known offline identities, registry content outside the `minecraft` namespace, every catalog allowed command source, and optional integrations. Shared proof is valid for demonstrably identical portable code paths. Native writer, filesystem, host-specific dependency loading, startup, shutdown, process-control, and packaging behavior require direct evidence on the affected operating system; client presentation, input, narration, rendering, and matching-client behavior are verified through the Minecraft Java client fixture.

Fixtures must not hard code one player, dimension, namespace, screen size, operating system, path syntax, filesystem behavior, or provider response in a way that hides general behavior. Permission tests include absent, explicit deny, explicit grant, inherited or wildcard state, refresh, reconnect, and outage. Target tests include self, online, offline, equal rank, higher rank, exempt, vanished, unknown, ambiguous, and stale identities where applicable. UI tests include graphical and command fallback paths. Persistence tests include empty, valid, legacy, unsupported newer, malformed, oversized, interrupted, concurrent, and recovered states on each platform-sensitive storage path.

### Determinism and Evidence Reproducibility

At one frozen revision, repeated generation must produce the same normalized command, permission, configuration, storage, UI, trust boundary, and dependency inventories. Tracked generated references must have zero unexplained drift. Identical initial semantic state and authorized input must reach the same canonical action, normalized domain result, permission decision class, audit action id, and durable semantic state after normalizing time, random identifiers, and environment specific paths.

Every evidence record must name the commit, branch, artifact path, SHA-256 and SHA-512 where applicable, operating system family and version when executed, architecture, filesystem, Java and platform versions, resolved runtime dependency identities, fixture manifest, exact command or workflow, expected result, actual result, and disposition. Any implementation, configuration, dependency, schema, protocol, catalog, permission, generated reference, native provider, or test harness change invalidates affected evidence. The final phase reruns the complete portable matrix and every conditional host row affected by the last product change.

## 6. Mandatory Scope

- `SEFAUD-REQ-001` freezes the authoritative audit baseline and complete traceable inventories.
- `SEFAUD-REQ-002` closes security, privacy, sensitive data leak, and backdoor like authority risk.
- `SEFAUD-REQ-003` closes applicable dependency and supply chain risk, including platform-owned runtime dependencies without operating-system scope reduction.
- `SEFAUD-REQ-004` proves and repairs every executable administrator action.
- `SEFAUD-REQ-005` polishes and verifies every in scope graphical and textual operator UI.
- `SEFAUD-REQ-006` closes the full codebase persistence and database integrity audit.
- `SEFAUD-REQ-007` closes backend handling and cross channel integration behavior.
- `SEFAUD-REQ-008` supplies post change clean checkout, Minecraft Java client fixture, canonical Linux runtime, compatibility, recovery, and regression proof, plus direct macOS or Windows proof for changed or exercised non-client host-specific paths.
- `SEFAUD-REQ-009` reconciles documentation and evidence and closes the cross-platform final endpoint with conditional host validation.

Confirmed defects discovered by a mandatory audit row are part of that requirement until repaired and covered by regression proof. A phase cannot exit while one of its owned mandatory defects remains known.

## 7. Optional or Future Scope

- `FUT-001`, excluded. Implement and activate the sixteen intentionally unavailable Phase 13 runtime families.
- `FUT-002`, excluded. Add unrelated commands, UI features, integrations, control families, or gameplay capabilities.
- `FUT-003`, excluded. Perform broad architecture modernization or class decomposition beyond confirmed defect remediation or mandatory evidence enablement.

Future work does not count toward completion and must not be introduced through opportunistic refactoring. Promotion requires a new explicit owner decision and an authorized plan revision.

## 8. Non Goals

- `NG-001`. Do not implement new features, including intentionally unavailable control family runtimes.
- `NG-002`. Do not upgrade or expand Minecraft, NeoForge, mappings, Java, Gradle, loader, or protocol boundaries.
- `NG-003`. Do not publish a release, deploy to production, or run destructive production tests.
- `NG-004`. Do not weaken tests, permissions, redaction, recovery, compatibility, or acceptance gates, and do not mark blocked or unexecuted evidence as passed.
- `NG-005`. Do not use real credentials, private messages, personal addresses, production worlds, or unrelated user data in fixtures or evidence.
- `NG-006`. Do not claim mathematical absence of defects. Completion means the exhaustive declared matrices and adversarial evidence reveal no known disallowed finding at the frozen revision.

## 9. Owner Decisions

### DEC-001 — Audit includes remediation

**Status:** RESOLVED
**Selected choice:** Audit plus mandatory in-scope remediation and regression proof.
**Rationale:** A verified endpoint cannot close while the audit has confirmed an in scope defect.
**Affected requirements:** SEFAUD-REQ-002, SEFAUD-REQ-003, SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-006, SEFAUD-REQ-007, SEFAUD-REQ-008, SEFAUD-REQ-009
**Supersedes:** none

### DEC-002 — Unavailable control families remain unavailable

**Status:** RESOLVED
**Selected choice:** Keep the sixteen named families unavailable, unreachable, side-effect-free, and negatively tested.
**Rationale:** Their runtime implementation is feature expansion, while current repository evidence defines explicit unavailability as the safe contract. They cannot be represented as working commands or release functionality.
**Affected requirements:** SEFAUD-REQ-001, SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-007, SEFAUD-REQ-008, SEFAUD-REQ-009
**Supersedes:** none

The named families are `admin_journal`, `afk_zones`, `approvals`, `capability_leases`, `chat_channels`, `display_ownership`, `display_profiles`, `player_warp_review`, `portal_policy`, `resource_governor`, `resource_worlds`, `rollouts`, `server_presentation`, `spawn_ecology`, `staff_duty`, and `waypoints`.

### DEC-003 — Completion defect boundary

**Status:** RESOLVED
**Selected choice:** No known applicable critical or high exploitable vulnerability, authorization bypass, sensitive leak, executable admin-command defect, UI-blocking defect, persistence-integrity defect, or mandatory backend defect at the frozen revision.
**Rationale:** This converts the owner's audit goal into an observable closure gate without claiming impossible mathematical certainty.
**Affected requirements:** SEFAUD-REQ-001, SEFAUD-REQ-002, SEFAUD-REQ-003, SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-006, SEFAUD-REQ-007, SEFAUD-REQ-008, SEFAUD-REQ-009
**Supersedes:** none

### DEC-004 — Pinned compatibility boundary

**Status:** RESOLVED
**Selected choice:** Preserve Minecraft 1.21.1, NeoForge 21.1.235, Java 21, checked-in Gradle, Parchment 2024.11.17, and current protocol and integration contracts.
**Rationale:** The request is an audit and remediation program, not a platform migration.
**Affected requirements:** SEFAUD-REQ-003, SEFAUD-REQ-005, SEFAUD-REQ-006, SEFAUD-REQ-007, SEFAUD-REQ-008
**Supersedes:** none

### DEC-005 — Safe verification environments and data

**Status:** RESOLVED
**Selected choice:** Use disposable synthetic staging fixtures only and exclude production mutation, credentials, personal data, and production worlds.
**Rationale:** Existing workflows intentionally corrupt files, interrupt processes, and exercise destructive administration. These operations need isolation, not weakened evidence.
**Affected requirements:** SEFAUD-REQ-001, SEFAUD-REQ-002, SEFAUD-REQ-003, SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-006, SEFAUD-REQ-007, SEFAUD-REQ-008, SEFAUD-REQ-009
**Supersedes:** none

### DEC-006 — Candidate lineage

**Status:** RESOLVED
**Selected choice:** Use the SEF 2 candidate lineage beginning at the selected envy/sef2_complete base and preserve branch evidence without silent legacy integration.
**Rationale:** The current branch contains the SEF 2 implementation described by the owner request. Branch divergence is recorded rather than silently reconciled.
**Affected requirements:** SEFAUD-REQ-001, SEFAUD-REQ-002, SEFAUD-REQ-003, SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-006, SEFAUD-REQ-007, SEFAUD-REQ-008, SEFAUD-REQ-009
**Supersedes:** none

### DEC-007 — Optional and future disposition

**Status:** RESOLVED
**Selected choice:** Exclude all optional and future scope unless explicitly promoted later.
**Rationale:** Completion must remain measurable and cannot absorb unrelated expansion.
**Affected requirements:** none
**Supersedes:** none

### DEC-008 — UI scope

**Status:** RESOLVED
**Selected choice:** Include all in-scope graphical screens, HUDs, and administrator command feedback.
**Rationale:** An administrator must receive usable, accurate, accessible state and failure information regardless of enhanced client availability.
**Affected requirements:** SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-007, SEFAUD-REQ-008, SEFAUD-REQ-009
**Supersedes:** none

### DEC-009 — Mandatory cross-platform Minecraft Java support and native dependency boundary

**Status:** RESOLVED
**Selected choice:** Linux is the canonical shared runtime and Minecraft Java client fixture. Minecraft Java mod behavior is one portable contract across Linux, macOS, and Windows. No separate macOS or Windows client evidence is required. Direct macOS or Windows evidence is conditional only for changed or exercised non-client host-specific paths. EXT-001 and EXT-002 are in-plan closure work. JNA remains compile-only from pinned NeoForge with no duplicate native runtime.
**Rationale:** Minecraft Java mod client behavior follows one Java and NeoForge contract across supported desktop operating systems. Duplicating client captures on macOS or Windows would not add coverage of mod-owned portable behavior. Direct host evidence remains necessary only for a non-client path whose implementation or execution is host-specific. The Linux laptop is the only authorized graphical fixture and the canonical shared server, while `node-1` remains headless compute. Dependency ownership never suppresses a finding: the plan proves the mod's declaration, packaging, reachability, installed runtime supply, and compatible remediation state.
**Affected requirements:** SEFAUD-REQ-001, SEFAUD-REQ-002, SEFAUD-REQ-003, SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-006, SEFAUD-REQ-007, SEFAUD-REQ-008, SEFAUD-REQ-009
**Supersedes:** none

## 10. External Prerequisites

The stable `EXT` prefix is preserved for traceability; it does not mean that either prerequisite is external, unavailable, optional, or a reason to wait for owner action. `EXT-001` and `EXT-002` are available, mandatory, in-plan work. Their owners must produce their evidence during the phases below. Failure of an evidence predicate keeps the owning phase incomplete as an ordinary plan failure. It is never reported as an unresolved external blocker.

| ID | Prerequisite | Affected requirements | Availability | Authorization | Required action |
|---|---|---|---|---|---|
| EXT-001 | Canonical Linux Minecraft Java runtime and conditional affected-host evidence | `SEFAUD-REQ-002`, `SEFAUD-REQ-003`, `SEFAUD-REQ-004`, `SEFAUD-REQ-005`, `SEFAUD-REQ-006`, `SEFAUD-REQ-007`, `SEFAUD-REQ-008`, `SEFAUD-REQ-009` | available | not_required | Use the owner-authorized Linux laptop as canonical shared server and sole client fixture. Record macOS or Windows only for an actually exercised non-client host-specific path. Classify a non-exercised path as `NOT_EXERCISED` from the frozen artifact reachability inventory rather than as missing evidence. |
| EXT-002 | NeoForge-owned dependency provenance, runtime supply, reachability, advisory applicability, and mod-owned remediation closure | `SEFAUD-REQ-003`, `SEFAUD-REQ-008`, `SEFAUD-REQ-009` | available | not_required | Derive authoritative coordinates, metadata, hashes, licenses, runtime supply, affected APIs, reachability, advisory applicability, compatible remedy, and packaged-artifact state from the pinned build and runtime. Repair direct mod-owned exposure within `DEC-004`; record unreachable upstream-only exposure as platform owned and not mod resolvable. |

### EXT-001 — Execution environment and host-path closure

**Evidence contract:** Bind every execution record to one candidate commit, one artifact SHA-256 and SHA-512, one fixture identity, Java 21, Minecraft 1.21.1, NeoForge 21.1.235, architecture, filesystem, exact command or workflow, expected result, actual result, and sanitized evidence identifier. The Linux laptop is the canonical shared-server and sole graphical Minecraft-client host. It supplies the one portable client evidence set, including matching and fallback clients, rendering, input, narration, resize, reconnect, mixed-client, and UI behavior. No macOS or Windows Minecraft client is launched or required. `node-1` may perform Gradle, static, unit, data, dedicated headless, and server-only GameTest work, but never graphical work and never substitutes for the canonical laptop shared-server or client evidence. A macOS or Windows row exists only when source-to-runtime reachability proves that the frozen candidate actually exercises a non-client host-specific filesystem, native writer, process-control, server-lifecycle, dependency-loading, recovery, or packaging implementation. An exercised row receives direct evidence on its matching host. A row proven unexercised is closed as `NOT_EXERCISED` with the reachability basis and artifact identity. Mocked operating-system names, path labels, and another host cannot substitute.

**Execution safety:** Every owned test runtime is disposable and synthetic. The Linux client must remain silent from before startup through exit: set isolated instance master audio to zero, bind the exact owned window and PID with `hyprctl clients -j`, correlate only its process tree to its PipeWire or PulseAudio stream, mute and verify that stream, recheck any recreated stream, and stop the client if identity or mute state cannot be proved. Verify an active desktop and discrete RTX renderer before launch. Never run a Minecraft client on `node-1`, through a virtual display, or through software rendering. Set and read back `eula=true` only in the exact disposable server runtime. Stop all owned processes and delete only registered test-owned temporary state after every test or audit, including failures and cancellations.

**Closure:** `SEFAUD-PHASE-000` freezes the host and reachability matrix. Each later phase closes its applicable rows. `SEFAUD-PHASE-006` reproduces the complete final matrix, and `SEFAUD-PHASE-007` validates the evidence joins. No user action is assumed, and `EXT-001` never appears in `Known external blockers`.

### EXT-002 — Dependency ownership and advisory closure

**Evidence contract:** For the same candidate commit and artifact digests, capture the Gradle declared, compile, runtime, test, tooling, and packaged graphs; authoritative repository origin, coordinates, versions, SHA-256 and SHA-512 hashes, licenses, and dependency paths; installed NeoForge runtime artifacts; affected API and configuration; mod reachability; advisory applicability; native load and ABI result where exercised; compatible remediation choice; and final disposition. For JNA and JNA Platform, prove that the pinned NeoForge 21.1.235 runtime supplies the exact compatible APIs used by the compile-only declarations and that the mod JAR contains no duplicate JNA classes, service entries, or native libraries. Absence from the mod JAR alone is not provenance or reachability proof. Transitive or platform ownership never suppresses an alert.

**Disposition rules:** A direct declaration, packaged component, or reachable vulnerable API owned by the mod is remediated through a compatible constraint, exclusion, removal, guarded use, or other in-scope fix that preserves `DEC-004`; its requirement remains incomplete until verified. An alert supplied only by the pinned platform is recorded with its upstream owner and remains visible. It may be classified `NOT_MOD_RESOLVABLE` only after direct declaration, packaging, and affected-API reachability are disproved with authoritative evidence. No operating-system support claim is narrowed to obtain closure.

**Closure:** `SEFAUD-PHASE-001` owns initial complete closure. Phase 005 verifies actual installed-runtime loading, Phase 006 binds it to the final artifact and reruns advisory checks, and Phase 007 validates documentation and traceability. This is in-scope work with no external owner decision or platform change presumed.

Required clients, synthetic identities, disposable worlds, network interruption, capture, fault injection, and optional-provider fixtures are execution inputs under `DEC-005`. They do not authorize production access, credential use, or lower-fidelity substitution.

## 11. Architecture and Ownership Boundaries

| Component or boundary | Canonical owner | Inputs and outputs | Required invariant |
|---|---|---|---|
| Mod lifecycle and service graph | `ServerEssentialsForge`, `KernelServices`, lifecycle handlers | Construction, command registration, server start, ticks, reload, stop, repository and worker state | Initialization is idempotent where declared, common code remains dedicated server safe, and teardown settles or marks every owned resource. |
| Command catalog and execution | `com.enviouse.sef.kernel.command`, `com.enviouse.sef.kernel.policy`, command registrars | Brigadier requests, catalog metadata, policy decisions, domain effects, feedback, audit events | Every executable route maps to one canonical action and one policy pipeline. Convenience routes cannot weaken policy. |
| Permission and authority | `com.enviouse.sef.permissions`, permission manifest, hierarchy and exemption services | Player and nonplayer sources, provider decisions, grants, leases, revisions | Logical server authority is current, least privilege, fail closed, and rechecked before mutation. Temporary authority cannot mint persistent authority. |
| Administrative execution | Sudo, run, silent, alias, bundle, profile, panel, and server control services | Stored or nested command intent, previews, confirmations, exact execution context | Stored text is not executable authority by itself. The effective actor, source, root, target, revision, and audit correlation remain bound. |
| GUI and protocol | `com.enviouse.sef.gui`, `com.enviouse.sef.gui.protocol`, client screen package | Negotiated sessions, bounded typed payloads, server projected choices, screens, HUD, command fallback | The client is presentation only. Every action is selected from server authority and revalidated before mutation. Missing or incompatible clients retain supported commands. |
| Domain services | Teleport, social, moderation, inventory, economy, controls, escrow, tags, disguise, configuration, and other feature packages | Validated domain requests, durable and transient state, game effects | Each domain owns its invariants and exposes mutation only through current policy and explicit failure behavior. |
| Persistence coordination | `StorageCoordinator`, `StorageRepository`, `AtomicFileStore`, coalesced workers, domain adapters | Snapshots, files, migrations, journals, receipts, backups, recovery state | Authoritative data never silently degrades to empty success. Writes are bounded, recoverable, and ordered with side effects. |
| Platform-native audit writer | Audit writer and its Linux, macOS, and Windows provider implementations | Owned audit directories and files, opened descriptors or handles, identity and link metadata, bounded append bytes, flush result | Validation and mutation stay bound to the same opened object on every supported host path. Unsupported identity or link metadata fails closed. |
| Configuration | `ModuleConfigRegistry`, `ModuleConfigService`, NeoForge bootstrap configuration | Typed module files, revisions, migration candidates, generated reference | Publication is transactional, secret fields are filtered, previous known good state survives failure, and reload invalidates dependent authority. |
| Audit and observation | `AuditService`, command journal, redaction policy, optional file sink, observer projections | Immutable action metadata, redacted parameters, health and retention state | Mandatory security audit cannot be disabled by observation filters, and no sink receives data beyond its authorization and retention contract. |
| Optional integrations | Runtime guarded providers and adapters for LuckPerms, FTB Essentials, Curios, and declared bridges | Provider data, optional capability, absent and failed states | Absence cannot block core startup or grant authority. Adapter scope is explicit, bounded, and revocable. |
| Build, tests, and generated references | Gradle build, source and test sets, GameTests, reference generators, CI | Source, resources, resolved dependencies, reports, JAR, evidence | Clean checkout results are reproducible, generated references match live contracts, and the artifact contains only intended content. |
| Platform dependency boundary | Pinned NeoForge 21.1.235 runtime and candidate Gradle declarations | Platform-owned compile and runtime artifacts, JNA APIs, native libraries, advisories, candidate JAR | Compile-only APIs resolve only from the compatible pinned runtime, the mod embeds no duplicate native runtime, and every alert retains separate graph, artifact, reachability, advisory, and remediation evidence. |

Dependency direction is server authority to presentation, catalog policy to domain mutation, and domain snapshots to persistence. The platform-native audit writer depends on the pinned NeoForge-supplied native API at runtime; the mod does not own or embed a second native runtime. Client presentation, generated documentation, logs, cached provider data, and recovery artifacts never become independent authority. Optional integrations sit behind runtime guards and bounded adapters. Dedicated server paths must not load client classes.

The primary trust boundaries are command parsing, source classification, permission providers, temporary or delegated authority, client payload decoding, GUI projection, stored command indirection, configuration and migration input, filesystem path ownership, opened-object identity, platform-native calls, persistence deserialization, archive and image import, optional mod reflection, mixins and access transformers, audit and export projection, NeoForge-owned runtime dependency supply, dependency resolution, and packaged artifacts. Every boundary appears in the Phase 000 matrix with an owner, input class, validation, failure behavior, downstream effect, and required evidence.

Cross cutting invariants are:

1. The logical server is authoritative for identity, permission, policy, target selection, validation, and mutation.
2. Permission, feature, hierarchy, exemption, source, target, confirmation, and revision checks repeat immediately before privileged mutation.
3. One canonical action id carries equivalent command, shortcut, GUI, alias, bundle, panel, and approved integration paths.
4. A failed or unavailable provider never grants access and never turns unsupported state into success.
5. Sensitive content remains out of broad feedback, suggestions, logs, audit parameters, exports, generated references, and artifacts.
6. A nonidempotent side effect is never blindly retried from ambiguous persistence state.
7. Unsupported, malformed, corrupt, or stale persistent data blocks unsafe mutation and retains recovery evidence.
8. Reload, revocation, disconnect, dimension change, and shutdown invalidate or settle dependent transient state.
9. Disabled modules, unavailable control handlers, and incompatible clients cannot retain an alternate mutation path.
10. Every final claim is tied to the frozen revision, environment, exact workflow, and artifact digest.
11. Linux, macOS, and Windows are supported Minecraft Java targets. The Minecraft Java client fixture is canonical for portable client behavior, and Linux is canonical for portable server and shared runtime behavior. A missing host is a conditional evidence gap only when changed or exercised code is host-specific, never an unsupported-platform declaration.
12. A security-sensitive writer validates type, link or reparse state, and identity on the same opened descriptor or handle used for mutation and proves stable opened-object identity after flush.
13. JNA and JNA Platform remain compile only and may be used only when supplied compatibly by the pinned NeoForge runtime; the candidate JAR contains no duplicate JNA classes or native runtime.
14. Platform-owned alerts retain independent graph, packaged-artifact, installed-runtime, reachability, advisory-applicability, provenance, and compatible-remediation records. They are not mod-owned closure blockers when the mod does not directly declare, package, or reach the vulnerable component. Direct mod-owned exposure remains a closure gate.

## Execution Host Matrix

| Host | Authorized work | Required evidence | Prohibited work |
|---|---|---|---|
| Owner Linux laptop with active desktop and verified discrete RTX renderer | Canonical shared server, sole Minecraft client fixture, enhanced and fallback clients, mixed multiplayer, rendering, input, narration, screenshots, recordings, and every other graphical acceptance workflow | Exact host/runtime directory, commit and artifact digests, Java and NeoForge versions, owned window address/class/title/PID, discrete renderer, application-stream mute state, server/client join identity, test result, and cleanup result | Unverified renderer or audio state, use of personal instances or worlds, system-wide mute, unrelated process control, or retained disposable runtime |
| `node-1` | Gradle build, formatting, static analysis, unit tests, data generation, genuinely headless dedicated servers, and server-only GameTests whose task graph starts no client or renderer | Exact checkout and runtime, task graph, commit and artifact digests, Java and NeoForge versions, process ownership, result, and cleanup | Minecraft client, graphical acceptance, virtual display, X11 forwarding, VNC, offscreen rendering, software rendering, or canonical shared-server/client substitution |
| macOS host | Only a non-client macOS-specific path proved actually exercised by the frozen candidate, such as POSIX/native identity, process, dependency-loading, recovery, or packaging behavior | Host manifest, reachability row, exact exercised path, candidate/artifact identity, direct result, sanitization, and cleanup | Any Minecraft client requirement, duplicated portable Java behavior, mocked host identity, or speculative matrix expansion |
| Windows host | Only a non-client Windows-specific path proved actually exercised by the frozen candidate, such as handle/reparse identity, process, dependency-loading, recovery, or packaging behavior | Host manifest, reachability row, exact exercised path, candidate/artifact identity, direct result, sanitization, and cleanup | Any Minecraft client requirement, duplicated portable Java behavior, mocked host identity, or unsupported-platform shortcut |

The Linux laptop is both canonical shared-server host and sole client fixture host for plan evidence. When in-world validation requires a server and client, both use isolated laptop runtimes unless the owner later changes this decision. `node-1` remains useful headless compute and may run independent server-only checks, but it does not replace canonical runtime evidence. macOS and Windows have no general client, build, or runtime matrix. Their direct rows are created only from proven execution of non-client host-specific code. Every test registers its exact owned resources before launch and completes mandatory teardown afterward.

## Diagnostics and Debugging

**Requirement IDs:** `SEFAUD-REQ-001`, `SEFAUD-REQ-002`, `SEFAUD-REQ-003`, `SEFAUD-REQ-004`, `SEFAUD-REQ-005`, `SEFAUD-REQ-006`, `SEFAUD-REQ-007`, `SEFAUD-REQ-008`, `SEFAUD-REQ-009`
**Task IDs:** `P000-TASK-010`, `P000-TASK-011`, `P000-TASK-013`
**Controls:** Add server-authoritative `/sef debug on <category> [target] [seconds] [sample_limit]`, `/sef debug status`, and `/sef debug off`; permit server console and `sef.commands.sef.debug`, default off, reject unknown categories or unauthorized targets, and make `off` idempotent.
**Signals:** Emit versioned structured events for capture identity, sequence, tick/time, side, category, canonical action or component, actor/effective-actor pseudonymous identity, revision, expected/actual decision, reason code, duration, payload bytes, queue depth, drop/truncation counters, persistence/writer state, protocol state, and correlation identifiers.
**Collection procedure:** Follow the numbered local procedure below for every diagnostic evidence capture and retain only its sanitized manifest and bounded support packet.
**Headless verification:** Unit, integration, GameTest, and dedicated-server fixtures prove permissions, state transitions, schemas, correlation, bounds, redaction, timeout/reset, disabled-mode cost, rate limiting, and no gameplay mutation.
**Client verification:** Use only the Linux laptop Minecraft client fixture for client render, input, narration, HUD, screen, reconnect, and mixed-client signals; server-only evidence never proves a client claim and no macOS or Windows client evidence is required.
**Client audio isolation:** Before launch, set the disposable instance master audio to zero. Use `hyprctl` to bind the exact owned Hyprland window and PID, correlate only that process tree to its PipeWire or PulseAudio application stream, mute with `wpctl` or `pactl`, and verify the stream reports muted before assertions. Monitor every stream recreation and mute each replacement. On teardown, stop the watcher and client and remove only their temporary owned audio state. Never mute default or system-wide audio.
**Budgets and privacy:** Default duration is 60 seconds, maximum duration 300 seconds, default sample limit 1,000 events, maximum 10,000 events, maximum output 4 MiB, and maximum accepted rate 100 events per second per capture; redact credentials, tokens, private messages, raw addresses, hidden identities, restricted arguments, artwork bytes, and private absolute paths.
**Regression and support:** Automated tests must fail on schema drift, authorization bypass, leaked fields, missing correlation, unbounded capture, stale enablement, reset failure, disabled-mode hot-path allocation, gameplay mutation, or unsupported success; `DOCUMENTATION.md` and generated command/permission references carry the final operator procedure and recovery guidance.

The shared diagnostic interface is a bounded observation system, never an authority or mutation route. Enabling a capture creates a random opaque `capture_id`, records category and optional target scope, reports expiry and remaining budgets through `status`, and automatically disables on timeout, server reload, server stop, or restart. It must add no material work when disabled, cap per-tick work when enabled, increment explicit dropped and truncated counters, and never change policy, permissions, command outcome, game state, persistent state, or client behavior. Category owners may add fields only through the versioned schema and central sanitizer.

| Signal | Source | Unit or shape | Expected condition |
|---|---|---|---|
| `capture_id`, `schema_version`, `sequence`, `correlation_id` | Shared diagnostic service and action/audit context | Opaque identifiers and monotonic integer | Present, unique where required, stable across one operation, and non-reused after reset |
| `side`, `category`, `component`, `action_id`, `reason_code` | Logical server, client presentation, or bounded worker owner | Stable enum or identifier | Matches the actual owner and never claims success for unavailable or failed behavior |
| `expected_revision`, `observed_revision`, `decision` | Policy, session, configuration, persistence, and domain owners | Integer/string plus allowed/rejected/stale/error | Stale or unauthorized work is rejected before mutation |
| `duration_ms`, `payload_bytes`, `queue_depth` | Timed boundary, codec, queue, writer, or worker | Nonnegative bounded values | Within declared budget or accompanied by explicit bounded failure |
| `dropped_events`, `truncated_events`, `expired` | Diagnostic service | Counters and boolean | Zero in normal bounded fixtures; explicit and truthful when limits are reached |
| `storage_state`, `writer_state`, `protocol_state` | `StorageCoordinator`, native audit writer, and session/network owners | Stable state and sanitized reason | Matches the real component state and supplies a safe next action |

Collection procedure:

1. Create the disposable server/client/provider fixture, record its commit, artifact, configuration, synthetic actors, expected stimulus, and registered teardown resources, and apply all host and audio preconditions.
2. Start the server, prove readiness and intended client join where applicable, then run `/sef debug on <category> [target] [seconds] [sample_limit]` from an authorized source and record the returned `capture_id` and bounds.
3. Execute exactly one declared stimulus set, including required denial, stale, failure, recovery, or concurrency cases, while recording authoritative state before and after.
4. Run `/sef debug status`, capture the bounded structured output and counters, join it to server, client, audit, persistence, dependency, or artifact evidence by `capture_id` and `correlation_id`, and inspect every field for accuracy and redaction.
5. Run `/sef debug off`; verify idempotent disablement, timeout/reload/restart reset, no later event capture, and no changed gameplay or durable state beyond the declared stimulus.
6. Produce the sanitized support packet with environment and artifact identity, exact commands, expected and actual results, limits, dropped/truncated counters, relevant bounded events, disposition, and recovery action. Keep raw sensitive material outside tracked source.
7. Stop owned processes, verify exit, remove only registered disposable paths and streams/watchers, and record successful cleanup. A failed cleanup leaves the test workflow incomplete.

## 12. Requirements

### SEFAUD-REQ-001 — Authoritative audit baseline and traceability

**Behavior:** Freeze the exact execution revision and create complete, deduplicated inventories for security boundaries, data flows, live Brigadier routes, catalog actions, shortcuts, source classes, graphical and textual UI, `StorageRepository` and nonrepository durable state, backend lifecycle handlers, integrations, configuration, schemas, Linux, macOS, and Windows providers, platform-owned dependencies, tests, documentation, external prerequisites, and known evidence gaps. Every item has one owner, one audit disposition, and one evidence route.
**Owner:** Repository audit contract
**Contributors:** All source domains, build system, documentation, and remote security evidence
**Dependencies:** DEC-002, DEC-003, DEC-004, DEC-005, DEC-006, DEC-007, DEC-008, DEC-009
**Lifecycle stage:** readiness
**Production verification:** none
**Release impact:** stable release

**Acceptance criteria**

1. One baseline manifest records commit, branch, dirty state, remote state, platform versions, dependency graph, artifact inputs, and evidence environment without including secrets.
2. The live dispatcher, sealed catalog, shortcuts, generated command reference, permissions, GUI descriptors, configuration reference, and tests reconcile to exact counts with every discrepancy resolved as a defect, documented exclusion, or stale evidence correction.
3. Every persistent owner is inventoried, including paths outside `StorageRepository`, with schema, lifecycle, concurrency, recovery, privacy, and test ownership.
4. Every graphical screen, HUD, command feedback surface, privileged payload, authority bypass, optional adapter, lifecycle transition, mixin, access transformer, filesystem root, log, export, and packaged resource is assigned exactly one audit row.
5. Historical `VERIFIED` claims are either reexecuted at the frozen revision or labeled stale. No missing, duplicate, or unowned mandatory row remains.
6. The inventory and requirement traceability regenerate deterministically and form the fixed input to all later phases.
7. Linux, macOS, and Windows each have an explicit support, runtime, filesystem, native-writer, server, dependency, and evidence row. The Minecraft Java client fixture is the client evidence surface. No operating system specific client evidence is required. `EXT-001` and `EXT-002` availability and required evidence are recorded without converting an unavailable row into an exclusion.

**Required evidence**

1. CodeGraph and build derived inventory reports tied to the frozen commit.
2. Live catalog, dispatcher, shortcut, permission, descriptor, repository, configuration, source set, dependency, and documentation reconciliation results.
3. A sanitized baseline manifest and requirement to phase to evidence traceability matrix.
4. Drift checks that fail on an added or removed relevant surface without an owned row.
5. Cross-platform environment and native dependency matrix with exact `EXT-001` and `EXT-002` conditional routing and explicit platform-owned dispositions.

### SEFAUD-REQ-002 — Security, privacy, leak, and backdoor like path closure

**Behavior:** Threat model, inspect, repair, and adversarially verify every authority, command execution, payload, filesystem, persistence, platform-native writer, optional integration, logging, audit, export, projection, and packaged artifact boundary. Linux is the canonical host for portable behavior. Any changed or exercised host-specific writer or runtime path receives direct macOS or Windows evidence, and all supported hosts retain fail-closed security behavior. Confirmed authorization bypasses, sensitive data leaks, unintended authority routes, unsafe opened-object handling, and other endpoint relevant security defects receive regression proof.
**Owner:** Security audit boundary
**Contributors:** Command kernel, GUI protocol, persistence, configuration, optional integrations, domain services, packaging
**Dependencies:** SEFAUD-REQ-001, DEC-001, DEC-003, DEC-005, DEC-009, EXT-001
**Lifecycle stage:** change
**Production verification:** none
**Release impact:** stable release

**Acceptance criteria**

1. The threat model covers every Phase 000 trust boundary, normal and privileged flow, hidden or indirect entry route, data classification, abuse case, and failure state.
2. No route grants or retains authority through missing permission, provider failure, stale revision, source confusion, target confusion, delegation, alias, bundle, profile, GUI, payload, reflection, mixin, configuration, migration, recovery, or lifecycle race.
3. No sensitive value or hidden identity is exposed through any in scope output, error, observation, export, fixture, generated reference, or packaged file.
4. Owned filesystem paths reject traversal, symbolic link escape, detectable hard link substitution, unsafe archive content, unbounded input, and overwrite of recovery evidence according to their contract.
5. Security audit is complete, correlated, bounded, tamper evident within the repository contract, and independent from optional observation filters.
6. Adversarial tests cover malformed, forged, stale, replayed, oversized, concurrent, interrupted, absent provider, revoked permission, and indirect execution scenarios.
7. Every confirmed finding is repaired or the phase remains open. No known authorization bypass or sensitive data leak remains at any severity, and no known applicable critical or high exploitable vulnerability remains in repository owned code.
8. Every security-sensitive writer uses a provider-specific or native descriptor or handle on each host path it supports, proves the identity and safe type of the opened object before mutation, proves the same object remains open through flush, rejects unsafe link or reparse state, and fails closed when required identity metadata is unavailable. Linux is the canonical portable evidence host; macOS or Windows runs are required when their host-specific path is changed or exercised.

**Required evidence**

1. Threat boundary matrix and source to sink review with stable finding ids and exact dispositions.
2. Targeted unit, integration, GameTest, payload, parser, permission, redaction, filesystem, and recovery regression results.
3. Read only code scanning and secret scanning results plus repository and JAR secret and path inspection.
4. Updated security review tied to the final repaired commit, with limitations and invalidation rules.
5. `EXT-001` runtime evidence for native writer success, object substitution, hard-link, symbolic-link or reparse-point, metadata-unavailable, write-failure, flush, rotation, and restart behavior on Linux and on any macOS or Windows host-specific provider path that changed or was exercised.

### SEFAUD-REQ-003 — Dependency and supply chain closure

**Behavior:** Resolve every current dependency alert against the actual release candidate dependency graph and packaged mod JAR, and classify the NeoForge-provided runtime graph when platform APIs are used. Repair applicable mod-owned findings without changing the pinned platform boundary, and prove that no applicable critical or high exploitable dependency vulnerability remains in mod-owned code or packaging. Platform ownership and operating-system scope do not waive evidence, but an upstream-only alert with no direct mod declaration, packaging, or reachable API is recorded as not mod resolvable.
**Owner:** Dependency graph
**Contributors:** NeoForge platform, optional integration declarations, CI, packaging, remote security state
**Dependencies:** SEFAUD-REQ-001, DEC-003, DEC-004, DEC-009, EXT-001, EXT-002
**Lifecycle stage:** change
**Production verification:** none
**Release impact:** stable release

**Acceptance criteria**

1. The resolved compile, runtime, test, tooling, and packaged dependency graphs are captured at the frozen revision with authoritative sources and versions.
2. Every open critical or high remote alert receives an evidence based disposition for the candidate branch. Inapplicability names the dependency path, configuration, packaged presence, affected API, reachability, and advisory basis.
3. Applicable findings are fixed through a compatible direct, constrained, excluded, or upstream dependency resolution that preserves `DEC-004` and passes runtime compatibility.
4. Dependency declarations preserve license and provenance expectations, optional integrations remain optional, and the final JAR contains no unintended embedded dependency or duplicate class set.
5. Clean resolution, dependency submission or equivalent graph capture, build, dedicated server, client, and artifact inspection pass after the last dependency change.
6. No critical or high alert is dismissed merely because it is transitive, inherited from the default branch, or absent from a direct declaration.
7. Every platform-owned alert has separate candidate graph, packaged-mod-artifact, installed-runtime-artifact, affected-API reachability, authoritative advisory applicability, provenance, and compatible remediation dispositions. An alert proven upstream-owned and unreachable by mod code is recorded as not mod resolvable. None is suppressed or cleared by narrowing Linux, macOS, or Windows support.
8. JNA and JNA Platform remain compile only, the exact compatible APIs are supplied by the pinned NeoForge runtime, native loading is verified when the provider path is exercised or changed, and the candidate mod JAR contains no duplicate JNA classes or native runtime.

**Required evidence**

1. Gradle resolved compile and runtime dependency reports on Linux, packaged mod and installed runtime class and metadata inspection, and artifact digests, with macOS or Windows reports when their host-specific provider or runtime path is changed or exercised.
2. Alert disposition table linked to authoritative advisories and exact candidate graph, platform runtime, packaged artifact, affected API, and reachability evidence.
3. Compatibility tests for every changed or compile-only dependency and present and absent optional integration state on Linux, plus affected macOS or Windows hosts when a host-specific path is exercised.
4. Final remote alert and security scan snapshot, with branch applicability clearly separated from repository default branch state.
5. `EXT-002` provenance ledger and compatible remediation closure, including exact NeoForge-owned JNA and JNA Platform supply and proof that no duplicate native runtime is embedded.

### SEFAUD-REQ-004 — Administrator command behavioral closure

**Behavior:** Complete one universal matrix row for every implemented, enabled, or otherwise executable administrator action. Verify registration, discovery, permission states, allowed and denied sources, targets, arguments, effects, failures, persistence, equivalent routes, feedback, audit, and redaction. Repair every confirmed defect. Intentionally unavailable control families remain an explicit negative contract and are never counted as working commands.
**Owner:** Command policy kernel
**Contributors:** Permission service, domain command owners, GUI protocol, aliases, bundles, sudo, server controls, audit service, persistence
**Dependencies:** SEFAUD-REQ-001, SEFAUD-REQ-002, SEFAUD-REQ-003, SEFAUD-REQ-006, DEC-002, DEC-008, DEC-009, EXT-001
**Lifecycle stage:** change
**Production verification:** none
**Release impact:** stable release

**Acceptance criteria**

1. The authoritative executable administrator action set is derived from the frozen live dispatcher, sealed catalog, active shortcuts, module state, and command ownership, not from a stale documentation count.
2. Each action passes absent, explicit deny, explicit grant, revocation before mutation, provider refresh, reload, and reconnect permission states, including hierarchy, exemption, feature, source, target, cooldown, quota, cost, warmup, confirmation, and audit policy where applicable.
3. Each action passes every documented allowed source and rejects every undocumented or denied source without mutation. Source coverage includes player, console, RCON, command block, function, scheduled, GUI, alias, bundle, sudo, and server profile contexts where declared.
4. Applicable target coverage includes self, online, offline, equal rank, higher rank, exempt, vanished, unknown, ambiguous, stale, and bulk targets. Applicable arguments cover missing, malformed, minimum, maximum, just below, just above, namespaced registry, long text, and injection like input.
5. Successful commands produce the exact domain effect once, persist and recover as declared, and provide accurate localized or component safe feedback. Denied and failed commands produce zero unauthorized side effect and an actionable safe result.
6. Canonical, shortcut, enhanced GUI, fallback, alias, bundle, panel, and approved integration routes converge on one action id, policy, cooldown identity, effect, and audit class.
7. Preview and confirmation bind actor, source, target, arguments, policy, revision, and expiry. Modification, replay, stale state, and expiry fail closed.
8. Audit records preserve real actor and effective actor attribution, stable metadata, result, and correlation without restricted content.
9. Each of the sixteen unavailable families is named as unavailable in diagnostics and UI, cannot preview as ready, cannot activate or resolve, performs no mutation, and is excluded from release capability claims.
10. No executable administrator command defect remains known. A parser only or safe read only result never substitutes for required mutating workflow proof.
11. A representative privileged mutation, denial, persistence, restart, feedback, and audit workflow passes through the same candidate artifact on canonical Linux. If the command or its audit or persistence path is host-specific, repeat that workflow on the affected macOS or Windows host. The universal action matrix remains bound to shared canonical semantics.

**Required evidence**

1. A machine checked command matrix with one row per executable administrative action and negative rows for unavailable families.
2. Unit and dispatcher tests, command contract GameTests, domain mutation GameTests, and disposable multi actor manual workflows.
3. Before and after state hashes or domain assertions, restart proof, feedback capture, and redacted audit capture for each mutation class.
4. Generated command and permission references reconciled with the live tree and final documentation.
5. `EXT-001` Minecraft Java client fixture representative command workflow evidence tied to the exact candidate artifact, plus affected macOS or Windows runtime manifests when a command path is host-specific.

### SEFAUD-REQ-005 — UI polish and accessibility closure

**Behavior:** Inventory, polish, and verify all in scope `SefScreen` family screens, HUD surfaces, pause entry, administrative workflows, confirmation screens, pickers, item browsers, fallbacks, and administrator command feedback. The result is responsive, readable, accessible, state clear, privacy safe, and server authoritative.
**Owner:** GUI presentation
**Contributors:** GUI protocol, command and message services, domain workflow owners, client caches, accessibility and test harness
**Dependencies:** SEFAUD-REQ-001, SEFAUD-REQ-002, SEFAUD-REQ-004, DEC-008, DEC-009, EXT-001
**Lifecycle stage:** change
**Production verification:** none
**Release impact:** stable release

**Acceptance criteria**

1. Every in scope screen and command feedback surface has an explicit purpose, state hierarchy, primary action, navigation, loading state, empty state, validation state, failure state, success state, and fallback contract where applicable.
2. At GUI scales 1 through 4, 854 by 480, 1280 by 720, representative narrow and wide aspect ratios, and live resize, no required control or content is clipped, overlapped, illegible, unreachable, or hidden behind another layer.
3. Mouse, keyboard only, focus order, escape and back behavior, narration, tooltip, and error announcement are complete. Long translated strings, long values, empty results, pagination, search, and rapid refresh remain usable.
4. Visual hierarchy, spacing, contrast, backgrounds, labels, values, destructive emphasis, confirmation wording, and state badges are consistent across the current design language. Item browsing shows correct icons and bounded native tooltips.
5. Unauthorized entries and private data are absent, not merely disabled. Stale selections, revoked permissions, changed revisions, module disablement, disconnect, and dimension change close or refresh the surface before mutation.
6. Enhanced GUI and command fallback reach equivalent domain results and audit action ids. GUI preferences never alter a complete command's semantics.
7. Intentionally unavailable controls communicate unavailable status and never present a ready or successful mutation affordance.
8. Every UI blocking or materially misleading defect found by the matrix is repaired, and no such known defect remains.
9. A matching enhanced client through the Minecraft Java client fixture passes startup, navigation, input, narration, resize, disconnect, and command-fallback smoke workflows. No operating system specific client workflow is required. Platform-specific defects reopen this requirement rather than narrowing support.

**Required evidence**

1. Automated screen, layout helper, workflow compiler, payload codec, session, stale state, and permission tests.
2. Screenshot set for every screen class at required scales and representative resolutions, plus recordings for dynamic, focus, narration, revocation, reconnect, and animation workflows.
3. Enhanced and fallback client comparison with matching command results and server audit records.
4. Accessibility and visual review ledger tied to the frozen revision and client environment.
5. `EXT-001` portable Minecraft Java client fixture runtime manifests and sanitized captures. No separate operating system client evidence is required.

### SEFAUD-REQ-006 — Full codebase persistence and database integrity closure

**Behavior:** Audit and repair every durable store and cross store invariant for schema, bounds, atomicity, directory durability, concurrency, idempotency, lifecycle flush, corruption, recovery, migration, rollback, path safety, retention, and privacy. The term database includes file backed repositories, JSON, TOML, NBT, journals, queues, receipts, indexes, object stores, backups, and any other durable authority in this codebase.
**Owner:** Persistence layer
**Contributors:** Every domain with durable state, configuration service, audit and logging, offline adapters, lifecycle coordination
**Dependencies:** SEFAUD-REQ-001, SEFAUD-REQ-002, DEC-005, DEC-009, EXT-001
**Lifecycle stage:** change
**Production verification:** none
**Release impact:** stable release

**Acceptance criteria**

1. Every Phase 000 durable owner has a completed audit row for path, data classification, schema, version, bounds, identity, cardinality, compatibility, concurrency, flush, recovery, migration, rollback, retention, and tests.
2. Atomic publication preserves the previous valid state until replacement is durable, rejects owned path escape and unsafe links, reports directory synchronization limitations explicitly, and never overwrites recovery evidence unexpectedly.
3. Concurrent, coalesced, scheduled, startup, periodic, shutdown, and timed out writes have deterministic ownership. Snapshot capture and asynchronous publication do not race mutable game state.
4. Nonidempotent domain side effects use durable ordering, idempotency keys, journals, receipts, compensation, or outcome unknown resolution sufficient to prevent duplication or loss after interruption.
5. Empty, valid, legacy, unsupported newer, malformed, truncated, oversized, deeply nested, duplicate, stale, and semantically invalid data produce the declared state. Damaged enforcement data never becomes an empty successful policy.
6. Migration binds source identity and revision, validates all staged output, retains exact recovery material, refuses conflicting backup state, restores on failure, and proves forward migration and rollback on representative fixtures.
7. Startup, recovery mode, periodic flush, explicit flush, world reuse, shutdown, and worker timeout behavior pass with no silent data loss. Process interruption tests cover each shared persistence primitive and each distinct higher risk commit protocol.
8. Cross store invariants preserve UUID ownership, revisions, references, indexes, claims, receipts, escrow, authorization, expiry, and configuration authority across restart and repair.
9. Sensitive persisted data is minimized, bounded, redacted or hashed as declared, access controlled, retained for the documented period, and excluded from broad exports and fixtures.
10. No known persistence integrity defect remains in any inventoried owner.
11. Every security-sensitive write path uses the operating-system provider required by `DEC-009` and passes normal, linked or reparse, object-swap, identity-metadata failure, write failure, flush, rotation, shutdown, and restart evidence on canonical Linux and on any changed or exercised macOS or Windows provider path without silently falling back to a path-only writer.

**Required evidence**

1. Complete durable owner matrix and schema and path inventory.
2. Unit, integration, fault injection, concurrent write, process interruption, migration, rollback, corruption, recovery, shutdown, and restart results.
3. File and semantic state hashes before and after failure and recovery, with synthetic fixtures and exact operation ids.
4. Storage diagnostics, worker health, recovery artifacts, and updated persistence and migration documentation.
5. `EXT-001` Linux native filesystem and opened-object identity evidence, plus direct macOS or Windows evidence for each changed or exercised provider path.

### SEFAUD-REQ-007 — Backend handling and cross channel integration closure

**Behavior:** Verify and repair backend behavior across initialization, registration, startup, reload, runtime mode change, permission and policy revision, command and GUI convergence, persistence, optional provider loss, disconnect, reconnect, dimension change, shutdown, retry, partial failure, audit correlation, and client, common, and dedicated server boundaries.
**Owner:** Lifecycle integration boundary
**Contributors:** Mod lifecycle, command kernel, GUI network, persistence, configuration, optional integrations, all stateful domain services
**Dependencies:** SEFAUD-REQ-002, SEFAUD-REQ-003, SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-006, DEC-009, EXT-001
**Lifecycle stage:** change
**Production verification:** none
**Release impact:** stable release

**Acceptance criteria**

1. Construction, manifest preparation, command registration, server startup, world load, player login, tick, configuration reload, module publication, provider refresh, player logout, server stopping, and server stopped flows have explicit owners and verified ordering.
2. Feature, permission, policy, configuration, command tree, target, session, panel, record, and persistence revisions invalidate dependent work before an unauthorized or stale mutation.
3. Command, GUI, shortcut, alias, bundle, sudo, panel, scheduled, and approved integration paths converge on one domain mutation and one correlated audit lifecycle.
4. Enhanced GUI disabled, enhanced GUI enabled, fallback client, incompatible protocol, reconnect, and mixed client states preserve command availability and clear client scoped sessions, projections, transfers, and drafts correctly.
5. Optional provider absence, startup failure, runtime outage, removal, malformed data, stale cache, and recovery preserve the declared fallback and never broaden authority or block unrelated core functionality.
6. Partial failure across game effect, persistent state, cost, cooldown, escrow, audit, queue, and external adapter boundaries reports the correct outcome and executes compensation or recovery exactly once.
7. Common and dedicated server paths load no client only class. Client handlers mutate presentation only and schedule work on the correct thread. Server mutations run on the logical server thread or through a proven snapshot and publication boundary.
8. Disconnect, death, respawn, dimension change, module disablement, reload, permission loss, and shutdown settle or invalidate warmups, menus, grants, projections, moderation state, schedules, workers, and pending actions as declared.
9. Runtime diagnostics expose actionable component health without secrets, false success, or hidden unavailable handlers.
10. No mandatory backend integration defect remains known.
11. Dedicated server, matching enhanced client through the Minecraft Java client fixture, fallback path, reload, reconnect, save, bounded shutdown, and restart integrate successfully on the applicable shared runtime. Native audit providers and platform-owned runtime dependencies are validated on Linux and on any changed or exercised macOS or Windows non-client path.

**Required evidence**

1. Lifecycle and cross channel sequence matrix with failure injection at each boundary.
2. Dedicated server, enhanced client, fallback client, incompatible protocol, mixed multiplayer, reconnect, reload, provider outage, dimension, and shutdown workflows.
3. Correlated before and after state, audit events, diagnostics, thread safety assertions, and recovery records.
4. Dedicated server classloading and final JAR package boundary inspection.
5. `EXT-001` Linux lifecycle and native dependency loading evidence, plus direct macOS or Windows evidence for each changed or exercised host-specific path.

### SEFAUD-REQ-008 — Post change runtime, compatibility, recovery, and regression proof

**Behavior:** From a clean checkout of the final candidate revision, pass the complete maintained static, unit, generated reference, GameTest, build, canonical Linux server and the Minecraft Java client fixture, mixed multiplayer, provider, UI, packet abuse, recovery, performance, dependency, artifact, secret, and diff verification matrix. Repeat only changed or exercised non-client host-specific paths on macOS or Windows. Do not repeat client evidence.
**Owner:** Release verification system
**Contributors:** All mandatory requirement owners, Gradle build, CI, staging harness, documentation evidence
**Dependencies:** SEFAUD-REQ-002, SEFAUD-REQ-003, SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-006, SEFAUD-REQ-007, DEC-009, EXT-001, EXT-002
**Lifecycle stage:** post_change
**Production verification:** none
**Release impact:** stable release

**Acceptance criteria**

1. The maintained Gradle `check` lifecycle aggregates a deterministic format gate, compiler warning zero growth gate, reviewed static analysis, unit tests, and risk based line and branch coverage for security and persistence critical code. Suppressions are narrow, justified, and reviewed.
2. A clean Java 21 checkout passes the Gradle wrapper invocation for `check build compileFallbackRuntimeJava generateProjectReferences generatePerformanceReport` on canonical Linux, and any changed or exercised host-specific build path is repeated on macOS or Windows. Zero unexplained tracked generated reference drift remains.
3. All required GameTests pass, including command contract, domain mutation, persistence, permission, integration, and regression coverage. Test counts and catalog counts match the frozen baseline manifest.
4. Dedicated server startup, steady operation, diagnostics, native audit writing, save, bounded shutdown, and restart pass on canonical Linux with enhanced GUI disabled and enabled as applicable. Repeat on macOS or Windows when a changed or exercised path is host-specific.
5. Matching enhanced client startup and command fallback smoke pass through the Minecraft Java client fixture. Do not repeat client evidence by operating system. The full matching enhanced, no SEF fallback, incompatible protocol, and mixed-client matrix connects, remains stable, exercises required workflows, reconnects, and clears state correctly.
6. Current permission provider and applicable optional integrations pass present, absent, outage, refresh, removal, and fallback matrices. Blocked provider specific evidence remains a blocker.
7. GUI visual, accessibility, command feedback, InvSee, admission capacity and FIFO, disguise animation, packet abuse, permission revocation, reconnect, and cross dimension workflows pass at the required fidelity.
8. Persistence process interruption, recovery, migration, rollback, shutdown timeout, and restart workflows pass from disposable snapshots.
9. Performance budgets cover deterministic metadata work and relevant server tick, memory, queue, scan, payload, rendering, and persistence hot paths without unbounded work or log spam.
10. The final JAR, dependency metadata, mixins, access transformer, resources, generated references, licenses, hashes, secrets, host paths, logs, caches, and duplicate entries pass inspection. The complete Git diff contains no unrelated change or user data.
11. Any final product change invalidates affected evidence and triggers the prescribed rerun. The complete full matrix runs after the last change.
12. The installed NeoForge runtime graph supplies every required compile-only native API at the proven compatible version; native loading and behavior pass on Linux and on any changed or exercised host-specific provider path; the mod JAR embeds no duplicate JNA runtime; and every platform-owned alert satisfies the separate `EXT-002` ownership, provenance, reachability, and remediation gates.

**Required evidence**

1. Clean checkout command logs and CI results tied to the exact commit and Java environment.
2. Unit, coverage, static analysis, GameTest, server, client, multiplayer, provider, recovery, performance, and UI evidence manifests.
3. Final JAR SHA-256 and SHA-512, entry inventory, dependency manifest, and complete diff audit.
4. One final rerun ledger with no failed, incomplete, or improperly downgraded mandatory row.
5. `EXT-001` canonical Linux runtime packet plus conditional affected-host packets and `EXT-002` authoritative platform dependency provenance, ownership, reachability, and advisory disposition packet.

### SEFAUD-REQ-009 — Documentation, evidence, and final endpoint closure

**Behavior:** Reconcile all affected documentation and sanitized evidence with the final implementation and artifact, then run a final cross matrix audit. Close only when every mandatory row and endpoint condition passes.
**Owner:** Documentation evidence
**Contributors:** All mandatory requirement owners, user and operator documentation, test and security records, release workflow
**Dependencies:** SEFAUD-REQ-001, SEFAUD-REQ-002, SEFAUD-REQ-003, SEFAUD-REQ-004, SEFAUD-REQ-005, SEFAUD-REQ-006, SEFAUD-REQ-007, SEFAUD-REQ-008, DEC-009, EXT-001, EXT-002
**Lifecycle stage:** post_change
**Production verification:** none
**Release impact:** stable release

**Acceptance criteria**

1. `README.md`, `DOCUMENTATION.md`, command, permission, configuration, compatibility, security, migration, troubleshooting, test, acceptance, performance, installation, and release documents describe only behavior verified at the final commit.
2. Generated command, permission, and configuration references match the final live contracts exactly, including executable and intentionally unavailable control status.
3. Documentation names setup, permissions, failure behavior, recovery, migration, rollback, enhanced and fallback clients, optional integrations, known limitations, and evidence commands needed by users and operators.
4. The sanitized evidence manifest links every requirement and matrix row to the final commit, artifact hashes, environment, exact proof, and result. Raw logs, recordings, and fixtures remain in the approved evidence location and contain no secrets or personal data.
5. The final audit finds no missing requirement owner, phase, matrix row, highest fidelity proof, documentation obligation, or release readiness gate.
6. Every confirmed in scope defect is repaired with regression proof. No known critical or high exploitable vulnerability, authorization bypass, sensitive data leak, executable administrator command defect, UI blocking defect, persistence integrity defect, or mandatory backend integration defect remains.
7. Optional and future scope remains excluded, unavailable controls are not advertised as features, no blocked row is called passed, and no production release or deployment occurs under this plan.
8. Compatibility, installation, troubleshooting, security, acceptance, and release documents identify Linux, macOS, and Windows as supported Minecraft Java targets. Conditional host evidence is labeled pending or not exercised when no host-specific path changed, never translated into a claim that Windows or another target is unsupported.
9. Documentation records the opened-object identity writer contract, compile-only JNA ownership, absence of an embedded duplicate native runtime, platform dependency provenance, separate alert closure gates, and the exact status of `EXT-001` and `EXT-002`.

**Required evidence**

1. Documentation drift and link checks plus generated reference comparison.
2. Final requirement to phase to test to artifact traceability report.
3. Final security, command, UI, persistence, integration, compatibility, and release readiness audit tied to one commit and artifact digest.
4. Completed Definition of Done checklist and Goal Creator completion packet, without publication action.
5. Cross-platform documentation claim audit and resolved links to the `EXT-001` and `EXT-002` evidence packets.

## 13. Phased Roadmap

The master owns this global sequence, canonical requirement ownership, dependency topology, and completion authority. Each linked phase file owns the sole full phase declaration and detailed execution blueprint. Phase files must use `PLAN-PHASE-NNN`, stable `P<NNN>-TASK-###` task ids, and the exact scope frozen here.

| Phase ID | Objective | Owner | Dependencies | Canonical requirements | Entry summary | Exit summary | Next transition | Execution blueprint |
|---|---|---|---|---|---|---|---|---|
| `SEFAUD-PHASE-000` | Freeze one reproducible audit baseline and complete every authoritative inventory, operating-system prerequisite row, and traceability matrix. | Repository audit contract | `DEC-002`, `DEC-003`, `DEC-004`, `DEC-005`, `DEC-006`, `DEC-007`, `DEC-008`, `DEC-009` | `SEFAUD-REQ-001` | The validated plan set is integrated, repository identity matches, and the candidate lineage is available without losing unrelated user state. | Exact current counts and owners reconcile across source, runtime, Linux, macOS, Windows, native providers, generated references, persistence, UI, integrations, dependencies, tests, and docs. `EXT-001` and `EXT-002` are routed explicitly, and no mandatory surface is missing, duplicated, or unowned. | `SEFAUD-PHASE-001` | [Phase 000](phases/plan-phase-000.md) |
| `SEFAUD-PHASE-001` | Close security, privacy, backdoor like path, opened-object writer, and dependency supply chain risk with adversarial regression evidence and conditional host validation. | Security audit boundary | `SEFAUD-PHASE-000`, `SEFAUD-REQ-001`, `DEC-009` | `SEFAUD-REQ-002`, `SEFAUD-REQ-003` | Phase 000 matrices, frozen dependency graph, trust boundaries, platform rows, and evidence rules are complete. Conditional host evidence and platform-owned dependency classifications are recorded before affected paths proceed. | Every boundary and alert has an evidence-based disposition; all confirmed mod-owned findings are repaired; opened-object identity and native runtime supply pass on Linux and on any changed or exercised host-specific path; platform-owned alerts have explicit ownership and reachability dispositions; and no known prohibited security or applicable critical or high mod-owned dependency finding remains. | `SEFAUD-PHASE-002` | [Phase 001](phases/plan-phase-001.md) |
| `SEFAUD-PHASE-002` | Close full codebase persistence and database integrity across normal, concurrent, corrupt, interrupted, migrated, recovered, and platform-sensitive filesystem states. | Persistence layer | `SEFAUD-PHASE-001`, `SEFAUD-REQ-002`, `SEFAUD-REQ-003`, `DEC-009` | `SEFAUD-REQ-006` | Security, platform-native writer, dependency, and filesystem boundaries are closed, and every durable owner has a Phase 000 row. | Every durable owner and cross-store invariant passes its matrix; platform-sensitive write and recovery behavior passes on Linux and on any changed or exercised host-specific path; all confirmed integrity defects are repaired; and recovery evidence proves no silent loss or unsafe empty success. | `SEFAUD-PHASE-003` | [Phase 002](phases/plan-phase-002.md) |
| `SEFAUD-PHASE-003` | Prove every executable administrator action and every unavailable negative contract across authority, effects, failure, persistence, feedback, audit, and representative cross-platform runtime. | Command policy kernel | `SEFAUD-PHASE-002`, `SEFAUD-REQ-006`, `DEC-009` | `SEFAUD-REQ-004` | Security and persistence foundations pass, the authoritative executable action set is frozen, and the Minecraft Java client fixture and shared runtime are available. | Every executable administrator action has a passed universal matrix row, representative privileged workflows pass on Linux, changed or exercised non-client host-specific paths pass on macOS or Windows, unavailable families fail closed, every confirmed command defect is repaired, and generated references match the live tree. | `SEFAUD-PHASE-004` | [Phase 003](phases/plan-phase-003.md) |
| `SEFAUD-PHASE-004` | Deliver polished, accessible, responsive, state clear, privacy safe, and cross-platform graphical and textual operator UI. | GUI presentation | `SEFAUD-PHASE-003`, `SEFAUD-REQ-004`, `DEC-009` | `SEFAUD-REQ-005` | Command semantics, permissions, domain effects, unavailable states, and portable Minecraft Java client fixture environment are stable enough to serve as UI authority. | Every UI surface passes layout, input, accessibility, state, revocation, privacy, and fallback matrices through the Minecraft Java client fixture; changed or exercised non-client host-specific paths pass on macOS or Windows; and no known blocking or materially misleading defect remains. | `SEFAUD-PHASE-005` | [Phase 004](phases/plan-phase-004.md) |
| `SEFAUD-PHASE-005` | Close backend lifecycle and cross-channel integration under normal operation, revision change, provider failure, reconnect, partial failure, shutdown, and supported Minecraft Java environments. | Lifecycle integration boundary | `SEFAUD-PHASE-004`, `SEFAUD-REQ-005`, `DEC-009` | `SEFAUD-REQ-007` | Security, persistence, commands, and UI each pass their owned contract at the current integrated revision on canonical Linux. | Lifecycle and channel matrices prove consistent server authority, equivalence, failure, recovery, classloading, native dependency loading, and audit behavior on Linux, with changed or exercised host-specific paths validated on macOS or Windows, and every confirmed integration defect repaired. | `SEFAUD-PHASE-006` | [Phase 005](phases/plan-phase-005.md) |
| `SEFAUD-PHASE-006` | Produce complete clean-checkout static, Minecraft Java client fixture runtime, conditional host-specific compatibility, recovery, performance, dependency, and artifact proof after all product changes. | Release verification system | `SEFAUD-PHASE-005`, `SEFAUD-REQ-007`, `DEC-009` | `SEFAUD-REQ-008` | All change-stage requirements are integrated, no known owned defect remains, and the candidate revision is frozen for final verification. | Every mandatory automated and real workflow passes at the required fidelity through the Minecraft Java client fixture and applicable shared runtime, changed or exercised non-client host-specific paths pass on macOS or Windows, platform-owned dependencies are classified separately, the final artifact and diff pass inspection, and no result is stale or replaced by lower-fidelity proof. | `SEFAUD-PHASE-007` | [Phase 006](phases/plan-phase-006.md) |
| `SEFAUD-PHASE-007` | Reconcile cross-platform documentation and evidence, audit the complete integrated plan endpoint, and close release readiness without publishing. | Documentation evidence | `SEFAUD-PHASE-006`, `SEFAUD-REQ-008`, `DEC-009` | `SEFAUD-REQ-009` | The final verified commit and artifact digest are immutable for closure, canonical Linux evidence is complete, any changed or exercised host-specific paths are validated, platform dependency ownership is recorded, and all Phase 006 evidence is complete. | Documentation identifies Linux, macOS, and Windows as supported, generated references, conditional prerequisite evidence, requirement traceability, phase gates, and Section 18 all pass at one revision. No disallowed known defect or unclosed mandatory mod-owned row remains. | Final plan-wide completion | [Phase 007](phases/plan-phase-007.md) |

Phase ids are contiguous from `SEFAUD-PHASE-000` through `SEFAUD-PHASE-007`. Dependencies move backward only. `EXT-001` and `EXT-002` are conditional evidence and provenance records. A later phase cannot begin until the prior phase implementation, applicable host-specific evidence, pull request checks, integration, resulting candidate branch verification, and required signed phase tag satisfy the repository workflow. No phase may pass while a known mandatory phase-owned defect or a required direct mod-owned dependency or changed host-specific evidence row remains unresolved.

### Requirement Ownership and Detailed Phase Briefs

| Phase | Sole canonical requirements | Stable task range | Mandatory phase brief |
|---|---|---|---|
| `SEFAUD-PHASE-000` | `SEFAUD-REQ-001` | `P000-TASK-001` through `P000-TASK-014` | Freeze candidate and evidence identities; derive exact command, permission, UI, durable-state, lifecycle, dependency, test, documentation, host-path, and trust-boundary inventories; establish diagnostics contract version 2, drift detection, sanitized evidence schema, cleanup registry, and requirement traceability. Close `EXT-001` availability and reachability classification as in-plan work. |
| `SEFAUD-PHASE-001` | `SEFAUD-REQ-002`, `SEFAUD-REQ-003` | `P001-TASK-001` through `P001-TASK-014` | Threat-model and inspect every authority, payload, filesystem, logging, export, integration, mixin, reflection, native-writer, dependency, and packaged-artifact boundary. Close `EXT-002` in plan; prove opened-object identity and no duplicate native runtime; remediate all confirmed security, privacy, backdoor-like, and direct mod-owned critical/high dependency findings. |
| `SEFAUD-PHASE-002` | `SEFAUD-REQ-006` | `P002-TASK-001` through `P002-TASK-012` | Audit every repository and nonrepository durable owner, configuration, JSON, TOML, NBT, journal, queue, receipt, backup, audit file, cache, schema, cross-store invariant, and nonidempotent effect. Exercise concurrency, interruption, corruption, unsupported versions, migration, rollback, recovery, shutdown, restart, and host-specific opened-object behavior. |
| `SEFAUD-PHASE-003` | `SEFAUD-REQ-004` | `P003-TASK-001` through `P003-TASK-015` | Execute one universal row for every executable administrator action and negative rows for all sixteen unavailable families across discovery, permissions, sources, targets, arguments, preview/confirmation, domain effect, persistence, feedback, audit, redaction, recovery, routes, and performance. Current execution resumes at `P003-TASK-010`, which closes feedback, audit, redaction, and native-writer joins. |
| `SEFAUD-PHASE-004` | `SEFAUD-REQ-005` | `P004-TASK-001` through `P004-TASK-010` | Audit and remediate every screen, workflow, picker, InvSee surface, Fancy Tags surface, HUD, pause entry, overlay, and administrator-feedback state for responsive layout, accessibility, narration, focus, privacy, authority, invalidation, unavailable state, and enhanced/fallback equivalence. All graphical evidence uses the sole Linux client fixture. |
| `SEFAUD-PHASE-005` | `SEFAUD-REQ-007` | `P005-TASK-001` through `P005-TASK-014` | Prove lifecycle construction through shutdown/restart, revision invalidation, channel convergence, optional-provider states, partial-failure outcomes, native dependency loading, logical-side/thread ownership, transient cleanup, performance bounds, diagnostics, and recovery at one integrated revision. |
| `SEFAUD-PHASE-006` | `SEFAUD-REQ-008` | `P006-TASK-001` through `P006-TASK-015` | Freeze the final product candidate; maintain format, warning, static-analysis, unit, coverage, generated-drift, and GameTest gates; run clean builds, canonical Linux server and sole client-fixture workflows, providers, UI, admission, disguise, packet abuse, persistence interruption/recovery, performance, dependency, JAR, secret, and complete-diff audits; rerun after the last change. |
| `SEFAUD-PHASE-007` | `SEFAUD-REQ-009` | `P007-TASK-001` through `P007-TASK-016` | Freeze artifact and closure identities; reconcile every current documentation/evidence claim and generated reference; replay operator procedures; validate sanitized evidence and traceability; conduct the final cross-matrix and false-completion audits; run the final clean checkout and artifact audit; integrate, tag, synchronize, and evaluate the exact endpoint without publication. |

Requirement ownership is exclusive for closure but not for contribution. A defect discovered later reopens its canonical owner and invalidates dependent evidence. Phase files may elaborate these briefs but may not change their scope, task identity, ordering, owner, support contract, in-plan prerequisite status, diagnostics contract, or completion endpoint.

## 14. Verification Strategy

| Requirement | Static or unit evidence | Integration evidence | Real behavior evidence | Security and negative evidence | Artifact or runtime evidence |
|---|---|---|---|---|---|
| `SEFAUD-REQ-001` | Inventory parsers, schema checks, duplicate and ownership checks | Live catalog, dispatcher, reference, repository, build, operating-system, native-provider, and dependency reconciliation | Baseline capture from a clean candidate checkout plus explicit `EXT-001` and `EXT-002` state | Missing, duplicate, stale, unowned, and silently excluded operating-system surface injection tests | Commit, environment, dependency, prerequisite, and evidence manifest |
| `SEFAUD-REQ-002` | Permission, redaction, parser, payload, path, archive, audit, native-writer, and policy tests | Cross-boundary authority, data-flow, and opened-object identity tests | Multi-actor adversarial workflows, provider failure, and native writer runtime on canonical Linux, plus changed or exercised host-specific paths on macOS or Windows | Forgery, replay, revocation, indirect execution, path escape, object substitution, link or reparse abuse, sensitive output, and secret scans | Security report, conditional `EXT-001` packet, scanning snapshot, JAR and export inspection |
| `SEFAUD-REQ-003` | Candidate and platform dependency graph, binary compatibility, and advisory applicability analysis | Changed and compile-only dependency build, runtime load, and optional integration tests | Dedicated-server and Minecraft Java client fixture startup with the resolved NeoForge runtime graph, plus changed or exercised non-client host-specific paths on macOS or Windows | Separate graph, mod artifact, installed runtime, reachability, advisory, provenance, compatible-remediation, and duplicate-native-runtime gates | `EXT-002` ownership and provenance ledger, resolved graphs, metadata, licenses, JAR entries, hashes |
| `SEFAUD-REQ-004` | Dispatcher, catalog, permission, argument, policy, and domain unit tests | Command contract and mutation GameTests | Universal multi-actor administrator matrix plus representative mutation, denial, persistence, restart, feedback, and audit workflows on canonical Linux, with changed or exercised non-client host-specific paths on macOS or Windows | Denied sources, permission states, targets, stale confirmation, failures, unavailable families, audit redaction | Generated command and permission references, conditional `EXT-001` manifests, state and audit evidence |
| `SEFAUD-REQ-005` | Screen, layout helper, workflow, session, codec, and state tests | Enhanced and fallback action equivalence | Full visual and accessibility matrix plus matching-client input, navigation, narration, resize, disconnect, and fallback smoke through the Minecraft Java client fixture, with changed or exercised non-client host-specific paths on macOS or Windows | Revocation, stale state, hidden identity, unavailable control, invalid input, and platform-specific failure | Screenshot, recording, Minecraft Java client fixture manifest, and applicable non-client host manifests tied to the exact commit |
| `SEFAUD-REQ-006` | Repository, schema, atomic store, native writer, worker, bounds, migration, and cross-store tests | Concurrent, opened-object identity, fault injection, interruption, shutdown, restore, and restart tests | Disposable world corruption, native filesystem substitution, migration, process termination, and recovery drills on canonical Linux and each changed or exercised platform-sensitive path | Unsafe path, symlink, hard link, reparse point, object swap, missing identity metadata, malformed and oversized data, stale revision, duplicate side effect, privacy, and retention | Conditional `EXT-001` platform evidence, before and after hashes, journals, receipts, backups, diagnostics |
| `SEFAUD-REQ-007` | Lifecycle, revision, thread, classloading, native dependency load, provider, and correlation tests | Command, GUI, persistence, configuration, provider, and domain convergence | Dedicated server and matching-client smoke through the Minecraft Java client fixture plus mixed clients, reload, reconnect, dimension, outage, and shutdown, with changed or exercised non-client host-specific paths on macOS or Windows | Partial failure, stale state, unavailable adapter, missing native API, client authority, side and thread misuse | Conditional `EXT-001` lifecycle traces, correlated audit, diagnostics, JAR boundary inspection |
| `SEFAUD-REQ-008` | Maintained format, warnings, static analysis, unit, coverage, and drift gates | Complete GameTest, Minecraft Java client fixture build and runtime, conditional host-specific dependency and compatibility matrix | Linux server and Minecraft Java client fixture runtime, enhanced, fallback, multiplayer, provider, UI, recovery, and performance matrix, with changed or exercised non-client host-specific paths on macOS or Windows | Packet abuse, native object substitution, secret scan, failure injection, platform alert ownership and reachability, duplicate native runtime, artifact and diff audit | Conditional `EXT-001`, `EXT-002`, final clean-checkout logs, JAR hashes, dependency and evidence manifests |
| `SEFAUD-REQ-009` | Documentation links, generated reference drift, cross-platform terminology, support-claim, and conditional-evidence checks | Requirement to phase to prerequisite to evidence reconciliation | Operator procedures replayed against the final artifact on canonical Linux, with changed or exercised host-specific procedures on macOS or Windows | False completion, stale claim, unsupported-Windows claim, suppressed platform alert, unavailable feature advertisement, secret and personal data review | Final evidence index, conditional prerequisite records, Definition of Done, release-readiness record |

Tests use synthetic identities and disposable worlds. Destructive cases are isolated from production. Expected and actual results are recorded for each row. A row marked blocked remains incomplete. Unit proof or an operating-system name mock cannot replace required GameTest, Minecraft Java client fixture runtime, or direct macOS or Windows evidence for a changed or exercised non-client host-specific path.

The final maintained command order is:

1. Run the repository format and compiler warning gates through the operating-system-appropriate Gradle wrapper `check` invocation.
2. Run maintained static analysis, unit tests, and risk-based coverage through the same wrapper on the required clean environments.
3. Run generated reference and performance generation and require zero unexplained tracked drift.
4. Run all required GameTests.
5. Run `./gradlew build` and fallback runtime compilation from a clean checkout.
6. On canonical Linux, run clean dependency resolution, dedicated-server startup, operation, native audit writing, save, shutdown, and restart. Repeat host-specific paths on macOS or Windows when changed or exercised.
7. Through the Minecraft Java client fixture, run matching enhanced-client startup and UI and fallback smoke, then run the complete enhanced, fallback, incompatible-protocol, and mixed-multiplayer matrix. Do not repeat client evidence by operating system.
8. Run provider, GUI, command, native-writer substitution, persistence interruption, migration, rollback, and recovery matrices at every required platform fidelity.
9. Inspect performance, the final JAR, platform runtime graphs, JNA ownership, dependencies, resources, secrets, and complete diff; record `EXT-002` ownership and reachability separately from packaged-mod inspection.
10. Rerun every invalidated row after the last product change, then run the final cross matrix audit.

## 15. Compatibility and Versioning, Migration, Rollout, Rollback, and Recovery

The supported platform remains Minecraft 1.21.1, NeoForge 21.1.235, Java 21, the checked-in Gradle wrapper, Parchment 2024.11.17, mod id `sef`, and artifact version lineage 2.0.0. NeoForge only is supported. Minecraft Java runtime support remains cross-platform on Linux, macOS, and Windows. Portable Minecraft Java client behavior is evidenced through the Minecraft Java client fixture, without an operating system client evidence split. Windows is not an optional target and must not be documented as unsupported. The universal JAR remains optional on clients. Enhanced GUI disablement, vanilla or no SEF clients, compatible enhanced clients, and incompatible enhanced protocol clients retain their documented behavior on every supported operating system. MacOS and Windows evidence is conditional only for changed or exercised non-client native, filesystem, server lifecycle, process-control, dependency-loading, recovery, or packaging paths.

Product, network protocol, configuration documentation, persistent schema, generated reference, and public identifier versions remain governed by their current source owners. A repair that changes a wire shape, schema, serialized field, config field, permission id, action id, resource location, or public route must either remain backward compatible or make the smallest appropriate versioned migration. Unsupported newer input fails explicitly. Unknown fields are preserved only where the existing owner contract permits them.

Optional integrations remain optional and runtime guarded. LuckPerms API 5.4, FTB Essentials, Curios, and other declared adapter contracts must be tested against compatible target artifacts where advertised. Absence or failure preserves the documented fallback. A dependency security remedy must not silently broaden or narrow the advertised platform range.

Security-sensitive writes require an operating-system provider that proves the opened object's identity. Linux and macOS may share a POSIX implementation, and Windows may use its handle provider, while direct host runtime proof is required whenever that provider path is changed or exercised. No provider may silently fall back to a path-only check or call Windows unsupported.

JNA and JNA Platform may remain compile-only dependencies only when `EXT-002` records the pinned NeoForge 21.1.235 runtime as the owner of the exact compatible APIs and `EXT-001` proves native loading and behavior on Linux or on any changed or exercised host-specific provider path. The mod JAR must not embed another JNA implementation or native runtime. Platform-owned dependency findings remain separately recorded by resolved candidate graph, packaged mod artifact, installed runtime artifact, affected-API reachability, authoritative advisory applicability, provenance, and compatible remediation. An upstream platform-owned finding with no direct mod declaration, packaging, or reachability is not mod resolvable and does not block the mod endpoint. No gate is cleared by narrowing operating-system scope.

No broad data migration is planned. If remediation changes a persistent schema or configuration contract, the owning phase must add source fingerprinting, version selection, bounded transformation, complete validation, exact recovery copy, failure restoration, forward migration fixtures, rollback procedure, and compatibility documentation. The prior approved JAR and data snapshot remain rollback material until final acceptance. A point of no return is not authorized.

Rollout is sequential through the registered phases and repository branch workflow. Each phase is integrated only after its tests, applicable real behavior evidence, documentation, review, conditional prerequisite records, and required checks pass. Phase 001 may continue while `EXT-001` or `EXT-002` is unknown when no affected host-specific or mod-owned dependency path is being closed. A changed or exercised host-specific path must resolve its applicable `EXT-001` row before that phase exits. A direct mod-owned vulnerability must resolve its applicable `EXT-002` row before that phase exits. Platform-owned upstream alerts remain documented with their owner and do not block solely because the pinned platform cannot be changed. Rollback for an unmerged phase is removal of that phase's isolated change. Rollback after integration uses the prior signed phase state and validated data recovery material. No plan phase deploys to production or publishes a marketplace artifact.

## 16. Documentation, Operations, and Release Gates

1. Keep `README.md` accurate for users and `DOCUMENTATION.md` accurate for developers and operators.
2. Keep command, permission, and configuration references generated from and reconciled with live contracts. A stale count or route is a failed gate.
3. Update compatibility, security, migration, installation, troubleshooting, performance, test, acceptance, and release documents for every verified behavior or limitation change.
4. Preserve intentionally unavailable control families as explicit unavailable surfaces. Do not advertise them as implemented, enabled, or release complete.
5. Document exact build, check, GameTest, server, Minecraft Java client fixture, enhanced client, fallback client, mixed client, provider, native writer, recovery, dependency, and artifact inspection commands and expected results. Document macOS or Windows commands only when a changed or exercised non-client host-specific path requires them. Do not add client commands. Missing conditional evidence is labeled pending or not exercised; Windows and the other supported targets remain supported.
6. Store raw logs, screenshots, recordings, profiles, corrupted fixtures, and world snapshots in the approved sanitized evidence location outside tracked source unless a small synthetic fixture belongs in tests. Tracked evidence summaries must not contain credentials, personal data, host specific private paths, or unbounded logs.
7. Every phase completion packet names commits, checks, runtime proof, documentation, issues or pull requests, integration state, and evidence invalidation. The protected plan set is not a status diary.
8. Required pull request checks, a private independent-review capability preflight and either a passing supported review or an explicit optional unsupported disposition, merge integration, default or candidate branch verification, and a signed phase tag must pass before the next phase begins, consistent with repository instructions.
9. The release candidate JAR receives SHA-256 and SHA-512 hashes, dependency and provenance inspection, generated reference comparison, secret and content inspection, source commit binding, and proof that it contains no duplicate JNA classes or native runtime. NeoForge-provided runtime artifacts receive separate provenance and advisory closure under `EXT-002`.
10. Release readiness does not authorize publication. Marketplace preview, credentials, publishing, deployment, and production change remain outside this plan and require separate explicit owner authority.
11. Compatibility, installation, security, troubleshooting, acceptance, and release documents must state Linux, macOS, and Windows support consistently and must never convert conditional `EXT-001` evidence into an unsupported-platform claim or suppress a platform-owned dependency finding. Direct mod-owned dependency exposure remains a closure gate.

## 17. Risks and Failure Boundaries

| Risk | Impact | Prevention | Detection | Recovery |
|---|---|---|---|---|
| Audit breadth hides an unowned surface | False confidence and an undiscovered defect | Deterministic Phase 000 inventories from source, runtime, generated references, and persistence paths | Missing owner and drift checks fail on additions, removals, duplicates, and count mismatch | Reopen Phase 000, assign ownership, and invalidate affected downstream evidence |
| Historical evidence is stale or contradictory | Incorrect completion claim | Label authoring evidence `OBSERVED`, freeze a new revision, rerun required proof | Count, hash, version, and generated reference reconciliation | Replace stale claims with new evidence and rerun dependent gates |
| Command matrix becomes impractically broad | Destructive gaps or superficial parser only proof | Generate rows, group shared policy proof only where the invariant is identical, and retain domain specific mutation proof | Coverage report identifies unexecuted sources, targets, mutations, and failure classes | Add fixtures and run missing rows before phase exit |
| Security review misses an indirect authority route | Authorization bypass, data leak, or command execution | Trace aliases, bundles, sudo, profiles, GUI, payloads, reflection, mixins, config, recovery, and lifecycle paths | Adversarial tests, source to sink review, runtime audit correlation, independent review | Repair, add regression proof, and rerun all affected security, command, and integration rows |
| Dependency alert cannot be fixed within platform pins | A direct mod-owned critical or high vulnerability remains, or ownership is unproven | Evaluate exact runtime reachability early and separate mod-owned exposure from pinned platform ownership | Resolved graph, packaged class inspection, installed runtime, advisory mapping | Block direct mod-owned exposure and request an owner-authorized platform decision when needed. Record an upstream platform-owned, unreachable alert as not mod resolvable without suppressing it |
| Platform-owned dependency alert is treated as outside the mod | Ownership or reachability is asserted without evidence | Preserve separate candidate graph, mod artifact, installed runtime, reachability, advisory, provenance, and remediation records under `EXT-002` | Compare authoritative NeoForge provenance, installed runtime artifacts, affected APIs, and advisories | Record platform-owned and not mod resolvable only when direct declaration, packaging, and reachability are disproved. Block direct mod-owned exposure |
| macOS or Windows environment is unavailable | A changed or exercised host-specific path remains unproved | Secure `EXT-001` disposable evidence only for the affected path and keep fixtures synthetic | Environment manifest or conditional host-evidence record | Continue portable audit on Linux. Keep the affected row pending and never document the target as unsupported |
| Native writer ABI or identity assumptions differ by operating system | Unsafe object substitution, corrupt audit state, or runtime linkage failure | Use provider-specific opened-object identity and exact pinned runtime APIs, with no path-only fallback | Native success and failure fixtures, runtime linkage inspection, object identity before and after flush, and restart on Linux, macOS, and Windows | Fail the operation closed, preserve prior valid state, repair the provider, and rerun all affected platform evidence |
| Persistence fault testing damages valuable data | Irrecoverable data loss | Use only disposable synthetic snapshots and isolated directories | Fixture identity and path preflight before destructive action | Discard the fixture and recreate it from the retained baseline snapshot |
| Async write or side effect ordering is ambiguous | Duplicate, missing, or corrupt state after crash | Explicit state machine, durable operation id, idempotency, journal, receipt, or compensation | Process interruption and outcome unknown recovery tests | Restore last known good state or resolve the durable outcome before retry |
| UI polish becomes subjective or expands scope | Inconsistent result and schedule drift | Use fixed layout, accessibility, state, privacy, and equivalence criteria across all surfaces | Screenshot, narration, interaction, and state review ledger | Repair only failed criteria and keep new feature concepts in future scope |
| Optional provider fixture is incompatible or unavailable | Advertised integration lacks highest fidelity evidence | Select a compatible target artifact, record provenance, and test present and absent states | Real login, permission mutation, refresh, outage, removal, and fallback matrix | Keep the row blocked and do not claim compatibility until a valid fixture is tested |
| Branch divergence contaminates the audit baseline | Legacy or unrelated changes enter the candidate | Follow `DEC-006`, record exact ancestry, and prohibit silent merge or platform drift | Git ancestry, diff, and artifact manifest checks | Stop, restore the candidate lineage, and rebaseline before continuing |
| Final fixes invalidate earlier proof | Evidence no longer applies | Track invalidation by component, interface, dependency, schema, and generated reference | Final evidence audit compares proof commit with product commit | Rerun affected rows and the complete Phase 006 matrix after the last change |
| Evidence captures secrets or personal data | Privacy breach in logs or artifacts | Synthetic identities, redaction, bounded captures, and evidence review | Secret, address, message, host path, and artifact scans | Quarantine and delete unsafe evidence, rotate any exposed secret through its owner, recreate sanitized proof |

Unknown facts remain failures to prove, not permission to infer success. A mandatory defect found after its owner phase reopens that phase's gate and invalidates downstream evidence that depended on the defective behavior.

## 18. Definition of Done

The plan is complete only when all conditions below hold at one frozen candidate revision and artifact digest:

1. Every mandatory requirement from `SEFAUD-REQ-001` through `SEFAUD-REQ-009` satisfies every acceptance criterion and required evidence item.
2. Every phase from `SEFAUD-PHASE-000` through `SEFAUD-PHASE-007` satisfies its linked execution blueprint, exit gate, integration workflow, and next transition rule.
3. The audit baseline contains no missing, duplicate, stale, or unowned mandatory security, command, UI, persistence, backend, integration, dependency, test, documentation, or artifact surface.
4. Every confirmed in scope defect is repaired and has regression proof at its real failure boundary.
5. Every executable administrator action passes the universal matrix. The sixteen intentionally unavailable families remain explicit, unreachable, side effect free, negatively verified, and absent from capability claims.
6. Every in scope graphical and textual operator UI passes responsive layout, input, accessibility, state, privacy, revocation, and fallback gates, with no known blocking or materially misleading defect.
7. Every durable owner and cross store invariant passes schema, bounds, atomicity, concurrency, interruption, migration, rollback, recovery, lifecycle, retention, and privacy gates, with no known integrity defect.
8. Backend lifecycle, command and GUI convergence, optional providers, revision invalidation, reconnect, dimension, partial failure, shutdown, logical side, and audit correlation pass their required matrices.
9. Every current dependency alert has a candidate-specific disposition. Platform-owned alerts separately record candidate graph, packaged-mod-artifact, installed-runtime-artifact, affected-API reachability, authoritative advisory applicability, provenance, and compatible remediation on the hosts where the runtime is exercised. Alerts proven upstream-owned and unreachable by mod code are recorded as not mod resolvable. No known applicable critical or high exploitable mod-owned dependency or repository vulnerability remains.
10. No known authorization bypass, sensitive data leak, backdoor like authority path, executable administrator command defect, UI blocking defect, persistence integrity defect, or mandatory backend integration defect remains.
11. Clean checkout checks, unit tests, maintained static and coverage gates, generated reference drift, GameTests, dedicated server, native audit writing, save, shutdown, and restart pass at the required fidelity on canonical Linux, while matching enhanced client, command fallback, mixed multiplayer, and UI workflows pass through the Minecraft Java client fixture. The complete provider, packet abuse, recovery, performance, JAR, secret, and diff gates pass through their applicable shared runtime, and any changed or exercised non-client host-specific path passes on macOS or Windows.
12. Documentation, generated references, compatibility claims, security review, test ledger, migration and recovery guidance, and release readiness evidence match the final artifact exactly.
13. No blocked, incomplete, stale, mocked, or lower-fidelity result is represented as passed. Conditional host evidence is required when a changed or exercised path is host-specific. Any unavailable conditional fixture is reported through `EXT-001` without weakening scope or calling Windows or another supported operating system unsupported.
14. `FUT-001`, `FUT-002`, and `FUT-003` remain excluded unless explicitly promoted by the owner. All non goals remain intact.
15. Release readiness is recorded, but no public release, publication, deployment, production mutation, or destructive production verification occurs under this plan.
16. Every security-sensitive writer proves that validation and mutation use the same opened object on Linux and on any changed or exercised macOS or Windows provider path, rejects unsafe link or reparse state and object substitution, fails closed when identity metadata is unavailable, and preserves prior valid state. JNA and JNA Platform remain compile only, are supplied compatibly by the pinned NeoForge runtime, and are not duplicated in the mod artifact.
17. `EXT-001` and `EXT-002` have complete applicable evidence records. Unknown or unavailable conditional host evidence is not a general endpoint blocker when no affected host-specific path changed. A direct mod-owned dependency exposure or an exercised host-specific path without required proof keeps its owning phase incomplete.

Current closure state: NOT COMPLETE. `SEFAUD-PHASE-003` is active and resumes at `P003-TASK-010`. `EXT-001` and `EXT-002` are available in-plan prerequisites, not unresolved external blockers. Their final-candidate evidence is still mandatory at the owning phase gates. Later UI, lifecycle, final-verification, documentation, and endpoint work remains unfinished.

Completion endpoint:

> At one frozen SEF 2 candidate revision and artifact digest, every mandatory audit and remediation matrix passes, all confirmed in-scope defects are repaired, the canonical Linux runtime and Minecraft Java client fixture prove portable behavior, any changed or exercised macOS or Windows non-client host-specific path has direct evidence, EXT-001 and EXT-002 have complete applicable closure packets, documentation matches the artifact, no duplicate native runtime is embedded, and no known mandatory security, command, UI, persistence, backend, integration, or mod-owned dependency defect remains.

## 19. Goal Creator Handoff

```text
Planning subject: Server Essentials Forge 2 final security, administrator-command, UI, persistence, backend-handling, and integration audit with mandatory remediation closure
Mandatory boundary: SEFAUD-REQ-001 through SEFAUD-REQ-009, including remediation and regression proof for every confirmed in-scope defect.
Optional/future disposition: excluded
Locked owner decisions: DEC-001 through DEC-009. DEC-009 keeps Linux, macOS, and Windows as one portable Minecraft Java client contract, makes the owner Linux laptop the canonical shared-server and sole client-fixture host, prohibits any general macOS or Windows Minecraft client evidence requirement, limits those hosts to actually exercised non-client host-specific paths, keeps JNA compile-only from the pinned NeoForge runtime without an embedded duplicate, and makes EXT-001 and EXT-002 available in-plan work rather than unresolved external blockers.
Active phase: SEFAUD-PHASE-003
Active phase plan: phases/plan-phase-003.md.
Next executable action: P003-TASK-010 closes administrator feedback, audit, redaction, and native-writer joins, then execution continues through P003-TASK-015 in dependency order.
Known failing checks: Phase 003 tasks P003-TASK-010 through P003-TASK-015 and all Phase 004 through Phase 007 gates remain unfinished. Historical test and catalog counts require final reconciliation; multiplayer, current LuckPerms, GUI, InvSee, admission, disguise, reconnect, and recovery rows require current evidence; maintained formatter, warning, static-analysis, and risk-based coverage gates remain Phase 006 work; final artifact, dependency, documentation, and cross-matrix audits remain open.
Known external blockers: none
Unavailable feature boundary: the sixteen named Phase 13 families remain explicit unavailable negative contracts and are not implementation scope.
Completion endpoint: At one frozen SEF 2 candidate revision and artifact digest, every mandatory audit and remediation matrix passes, all confirmed in-scope defects are repaired, the canonical Linux runtime and Minecraft Java client fixture prove portable behavior, any changed or exercised macOS or Windows non-client host-specific path has direct evidence, EXT-001 and EXT-002 have complete applicable closure packets, documentation matches the artifact, no duplicate native runtime is embedded, and no known mandatory security, command, UI, persistence, backend, integration, or mod-owned dependency defect remains.
Required evidence gates: complete inventories, EXT-001 canonical Linux host and sole client-fixture manifest, only applicable actually exercised macOS or Windows non-client manifests, provider-specific opened-object identity proof, native runtime loading when exercised, EXT-002 authoritative dependency ownership and reachability, separate advisory dispositions, no duplicate native runtime, security and dependency closure, administrator command matrix, UI and accessibility matrix, persistence fault and recovery matrix, backend integration matrix, diagnostics contract version 2, clean-checkout automated and runtime matrix, final artifact inspection, documentation parity, and final cross-matrix audit.
Execution rule: read this master and every registered phase plan through EOF, execute only the current contiguous phase, preserve the immutable saved goal, treat EXT-001 and EXT-002 as available in-plan work, use no macOS or Windows Minecraft client evidence, and never pass a phase while an owned mandatory evidence row or defect remains unresolved.
```
