# Phase 005 Execution Plan

> **Plan ID:** PLAN-PHASE-005
> **Phase ID:** SEFAUD-PHASE-005
> **Owner:** Lifecycle integration boundary
> **Classification:** MANDATORY
> **Master plan:** [plan.md](../plan.md)
> **Phase sequence:** 005 of 007
> **Diagnostics contract:** 2

## Purpose and Ownership

This phase closes `SEFAUD-REQ-007` by verifying and repairing the complete backend lifecycle and every supported cross-channel path at the integrated Phase 004 revision. Completion requires more than successful startup. Construction, manifest preparation, registration, runtime startup, world and player transitions, configuration and mode changes, policy revisions, optional providers, command and enhanced-client channels, persistence boundaries, partial failure, retry, audit correlation, shutdown, and restart must preserve one logical-server authority model and one truthful domain outcome.

The canonical owner is the lifecycle integration boundary. Current repository evidence places that boundary in `ServerEssentialsForge`, `KernelServices`, event handlers, configuration publication, permission refresh, command policy, GUI protocol, storage coordination, audit, automation, server controls, and the stateful services invoked by them. Phase 000 inventories remain authoritative for the complete set of lifecycle hooks, revisions, payloads, providers, transient owners, workers, and durable owners. This file does not replace or narrow those inventories.

Phase 005 may repair confirmed backend and integration defects and add the minimum maintained diagnostics or test support required to prove them. It may not add unrelated features, implement the sixteen intentionally unavailable control families, change platform pins, narrow supported operating systems, publish a release, mutate production, or treat historical or mocked evidence as current proof.

`EXT-001` and `EXT-002` are available in-plan closure work. Phase 005 consumes their integrated upstream evidence, renews the rows affected by this phase, and completes every applicable runtime predicate. They are not permanent external blockers. The Linux laptop is the canonical shared-server and sole Minecraft Java client-fixture host. Portable client behavior has one evidence contract across Linux, macOS, and Windows; no separate macOS or Windows Minecraft client evidence exists. Direct macOS or Windows evidence is required only when Phase 005 changes or exercises a non-client host-specific filesystem, native writer, startup, process-control, dependency-loading, recovery, or packaging path.

## Evidence-Based Entry State

The following are `OBSERVED` starting facts and upstream expectations. They become Phase 005 evidence only after identity and invalidation checks pass at entry.

| Area | Repository evidence | Phase consequence |
|---|---|---|
| Construction and registration | `ServerEssentialsForge` registers configuration, reload, payload, event, command, and lifecycle listeners. `KernelServices` prepares and seals the permission, descriptor, command, shortcut, policy, service, and repository graph. | Reconcile actual registrations against Phase 000 and prove ordering, uniqueness, idempotency, side, and failure state. |
| Startup and shutdown | Server-start handlers activate configuration, storage, player profiles, audit, logging, exports, optional providers, and legacy managers. Stopping handlers clear transient services, close integrations, drain storage, and stop audit/export writers. | Model every predecessor, successor, resource owner, stop condition, timeout, and restart invariant. |
| Runtime revisions | Configuration, features, permissions, command tree, providers, targets, sessions, panels, records, repositories, aliases, bundles, profiles, and policies expose revisions or state identities. | Bind every preview, confirmation, workflow, transfer, queue item, and deferred mutation to all revisions that can invalidate it. |
| Player and world lifecycle | Login, logout, death, respawn, dimension change, world unload, and reconnect affect controls, profiles, sessions, projections, transfers, teleport state, moderation, disguise, vanish, caches, warmups, confirmations, and observations. | Execute the complete transient-owner invalidation and settlement matrix. |
| Enhanced protocol | `SefNetwork`, `SefSessionManager`, `SefGuiServer`, typed payloads, codecs, sequence guards, feature masks, revisions, and client state implement optional enhanced UI. | Prove decode bounds, direction, thread handoff, session and sequence authority, reconnect cleanup, and command fallback. |
| Cross-channel execution | Canonical commands can also be reached through shortcuts, GUI, fallback commands, aliases, bundles, sudo, panels, schedules, profiles, and approved adapters. | Join each route to one canonical action, one current policy decision, one mutation, one persistence outcome, one feedback class, and one audit lifecycle. |
| Optional providers | Runtime-guarded integrations include LuckPerms, FTB Essentials, Curios, FTB teleport import, nickname providers, quota providers, and Fancy Tags group resolution. | Test absent, disabled, delayed, failed, stale, malformed, refreshed, removed, restored, and shutdown states without broadening authority. |
| Persistence and partial failure | Commands and integrations cross game effects, cost, cooldown, escrow, repositories, queues, offline actions, audit, logs, native writes, and external adapters. `AuditService` includes an outcome-unknown state. | Define commit points, operation ids, compensation, retry eligibility, and recovery before injecting every failure cut. |
| Native dependency boundary | JNA and JNA Platform are compile-only, expected from pinned NeoForge. Native audit providers bind writes to an opened descriptor or handle and must fail closed without identity metadata. | Reconcile actual installed-runtime class origin, ABI/load result, provider selection, opened-object identity, and no-duplicate-JNA artifact state. |
| Logical-side boundary | Network handlers enqueue work, server mutation belongs to the logical server, client handlers own presentation, persistence workers consume snapshots, and dedicated-server common paths must not load client classes. | Add static, classloading, thread, snapshot, and runtime assertions across common, server, client, worker, writer, and render ownership. |
| Existing diagnostics | Phase 000 owns bounded `/sef debug on`, `status`, and `off` controls and schema. Existing doctor, storage, provider, configuration, control, and import diagnostics remain component sources. | Reuse and extend the inherited interface through its versioned category registry. Do not create a second debug system. |
| Historical gaps | Current acceptance material records stale or incomplete provider, reconnect, mixed-client, disguise, admission, recovery, and lifecycle evidence. | Rerun exact affected workflows at the Phase 005 revision. Historical results are not completion proof. |

## Phase Contract

### SEFAUD-PHASE-005 — Backend Lifecycle and Cross-Channel Integration Closure

**Objective:** Prove and repair backend lifecycle, state invalidation, channel convergence, provider, failure, thread, native-runtime, shutdown, restart, and cleanup behavior at one integrated revision.
**Owner:** Lifecycle integration boundary
**Dependencies:** SEFAUD-PHASE-004, SEFAUD-REQ-005, DEC-009
**Canonical requirements:** SEFAUD-REQ-007
**Documentation and release impact:** Update affected lifecycle, integration, diagnostics, recovery, compatibility, and operator documentation with verified behavior. Final release verification and publication remain excluded.
**Next transition:** SEFAUD-PHASE-006

At one integrated revision, prove that every Phase 000 lifecycle and transient owner behaves correctly from construction through the next restart; every policy and state revision invalidates dependent work before mutation; all supported execution channels converge on one server-authoritative result; payload and session behavior is bounded and replay-safe; optional providers fail closed without breaking unrelated core behavior; partial failures are truthful and recoverable; common, server, client, worker, and native boundaries load and execute on the correct side and thread; and all owned resources settle during disconnect, reload, shutdown, and restart.

**Dependencies**

- Integrated and signed `SEFAUD-PHASE-004`, including complete security, dependency, persistence, administrator-command, and UI closure inherited from Phases 001 through 004.
- Frozen Phase 000 lifecycle, revision, transient-state, payload, provider, dependency, diagnostics, test, and evidence inventories.
- `DEC-004`, `DEC-005`, `DEC-006`, `DEC-008`, and `DEC-009`.
- Available in-plan `EXT-001` host/runtime evidence and `EXT-002` dependency ownership/provenance evidence.

**Entry criteria**

- The Phase 004 pull request is merged, its signed tag verifies, `origin/main` or the master-designated integration branch contains the merge, and the Phase 005 branch begins from that exact approved commit.
- The candidate tree, JAR SHA-256 and SHA-512, Java 21, Minecraft 1.21.1, NeoForge 21.1.235, Parchment 2024.11.17, configuration, dependency graph, and generated-reference identities are recorded.
- Upstream completion packets validate and contain no failed or stale prerequisite row used here. A discrepancy reopens its canonical owner before Phase 005 continues.
- All Phase 000 lifecycle, channel, payload, provider, transient-state, worker, writer, revision, host, and test rows have stable ids and owners.
- A fresh restricted evidence root and exact cleanup registry are available. Only disposable synthetic worlds, identities, providers, configuration, and network endpoints are used.
- The Linux laptop desktop, client launcher, isolated client and server runtimes, discrete renderer evidence, per-client audio controls, and private local connection method are discovered before any client workflow. Missing client capability leaves only client-dependent rows failed while independent headless work continues.

**Implementation scope**

- Execute every lifecycle, revision, channel, payload, provider, partial-failure, classloading, thread, transient cleanup, diagnostic, performance, and recovery row owned by `SEFAUD-REQ-007`, and repair every confirmed phase-owned defect.
- Revalidate `EXT-001` and `EXT-002` as authorized, available in-plan evidence under `DEC-009`, using the Linux laptop as canonical shared server and sole client fixture and direct macOS or Windows evidence only for actually exercised non-client host-specific paths.

**Execution order**

- `P005-TASK-001` through `P005-TASK-003` freeze Phase 005 identity and prove construction, registration, startup, native loading, save, shutdown, and restart foundations for `SEFAUD-REQ-007`.
- `P005-TASK-004` through `P005-TASK-010` close revision invalidation, channel convergence, client protocol, provider, partial failure, classloading, thread, and transient lifecycle behavior for `SEFAUD-REQ-007`.
- `P005-TASK-011` through `P005-TASK-014` close performance, diagnostics, documentation, final reruns, repository integration, and the signed phase transition for `SEFAUD-REQ-007`.

**Required evidence**

- `SEFAUD-REQ-007` requires deterministic lifecycle, revision, channel, payload, provider, failure, thread, classloading, transient cleanup, diagnostics, performance, and evidence-invalidation matrices tied to one commit and artifact.
- Canonical Linux laptop server and sole-client-fixture workflows prove portable server/client integration, while `EXT-001` adds direct macOS or Windows evidence only for an actually exercised non-client host-specific path and `EXT-002` proves installed-runtime dependency identity without duplicate JNA content.
- Phase integration evidence includes focused tests, applicable GameTests, build and artifact inspection, runtime and recovery workflows, required checks, review disposition, merge ancestry, signed tag, and complete cleanup.

**Exit criteria**

Phase 005 exits only when all eleven acceptance criteria and all required evidence of `SEFAUD-REQ-007` pass at the merged and tagged revision:

1. Every construction, registration, startup, world, player, tick, reload, mode, provider, stopping, stopped, and restart transition has one owner, verified order, failure state, diagnostic, and cleanup action.
2. Every feature, permission, policy, configuration, command-tree, target, session, panel, record, provider, and persistence revision invalidates all dependent work before stale or unauthorized mutation.
3. Command, shortcut, enhanced GUI, command fallback, alias, bundle, sudo, panel, scheduled, profile, and approved integration routes reach exactly one canonical domain mutation and one correlated audit lifecycle.
4. GUI-disabled, GUI-enabled, matching enhanced, no-SEF fallback, incompatible protocol, reconnect, dimension, server-switch when supported, and mixed-client states preserve command access and clear client-scoped sessions, projections, transfers, drafts, and caches.
5. Every optional provider state preserves its declared fallback, never broadens authority, and never prevents unrelated core startup or operation.
6. Each partial-failure cut records committed, not committed, compensated, or outcome unknown; compensation/recovery occurs exactly once; and unsafe retry is blocked.
7. Common and dedicated-server paths load no client-only class; client code mutates presentation only; network, server, watcher, worker, writer, and render work runs on its declared thread or immutable snapshot boundary.
8. Disconnect, death, respawn, dimension, world unload, module disable, reload, permission loss, provider refresh, target replacement, stopping, stopped, and restart settle or invalidate every transient owner.
9. Diagnostics truthfully expose current component health and next action without secrets, hidden unavailable handlers, false success, unbounded cost, or mutation.
10. No known mandatory Phase 005 backend or integration defect remains.
11. Canonical Linux server and client-fixture workflows pass, including save, reload, reconnect, mixed clients, bounded shutdown, and restart. Every changed or exercised macOS or Windows non-client host-specific path has direct matching-host proof. Installed runtime dependencies match `EXT-002`; the mod embeds no duplicate JNA runtime.

## Scope Boundaries

Included scope is every Phase 000 lifecycle, revision, channel, payload, provider, transient-state, worker, thread, classloading, native-writer, partial-failure, shutdown, restart, diagnostic, and recovery row owned by `SEFAUD-REQ-007`, together with remediation and regression proof for each confirmed integration defect. Excluded scope is new product capability, implementation of the sixteen unavailable control families, platform or protocol upgrades, broad architecture modernization, production mutation, release publication, and final clean-checkout or documentation closure owned by Phases 006 and 007. A defect in an upstream security, dependency, persistence, command, or UI contract reopens that canonical owner; Phase 005 does not silently redefine it.

## Lifecycle, State, and Channel Matrices

### Lifecycle Sequence

Every lifecycle row records `transition_id`, caller/event, bus, logical side, host scope, thread, predecessors, prerequisites, state read, state created, state published, transient state invalidated, durable effect, native resource effect, failure result, diagnostic signal, retry rule, cleanup owner, successor, and evidence route.

The matrix covers construction, manifest preparation, command and payload registration, configuration load, native dependency and provider selection, server starting, server ready, world load/unload, player login, server and player ticks, configuration reload, module publication, runtime mode change, provider refresh, death, respawn, dimension change, logout, server stopping, worker drain, native flush/close, server stopped, and next startup. Duplicate construction or registration, use-before-ready, callback-after-stop, and resource reuse across restarts are explicit failures.

### Revision and Transient-State Invalidation

For each preview, confirmation, workflow, menu, picker, draft, projection, transfer, warmup, cooldown reservation, grant, lease, scheduled job, queue item, offline action, cached provider decision, and deferred persistence action, record all revision dependencies and invalidation events. At minimum include feature, permission/provider, hierarchy, exemption, policy, configuration, command tree, alias, bundle, profile, target, connection, session, panel, workflow, record, repository, and world/dimension identity. Revalidation occurs immediately before mutation. Stale work produces bounded feedback and a correlated rejection without consuming cost, applying cooldown, or partially mutating state.

### Cross-Channel Convergence

For every channel allowed by a canonical action, compare actor, effective actor, source class, action id, normalized target, normalized parameters, feature state, permission, hierarchy, exemption, cost, cooldown, warmup, confirmation, revision set, domain effect count, durable outcome, feedback class, audit class, redaction, correlation id, recovery state, and final semantic state. One route may change presentation, but it may not weaken authority or create a second domain implementation. A client payload, stored command, adapter, or schedule is intent, not authority.

### Network and Payload Contract

Every registered C2S and S2C payload has a stable id, direction, codec, maximum encoded and decoded size, field and collection bounds, session requirement, sequence/replay rule, feature/revision requirements, handler side, thread handoff, authoritative validator, mutation owner, response/acknowledgment, disconnect behavior, abuse counter, diagnostic category, and test owner.

C2S payloads are untrusted. Decode rejection, unknown or incompatible type, oversized field, forged sender, stale session, stale revision, duplicate sequence, out-of-order sequence, invalid panel/record/target, revoked permission, cross-dimension target, disconnect, and shutdown must reject before mutation. Handler registration and `enqueueWork` do not alone prove correct logical-thread execution. S2C state is presentation data; client caches never become authority. A matching client may negotiate supported features, a major mismatch is rejected safely, unsupported minor features are omitted, and a no-SEF client retains the command contract.

### Provider and Partial-Failure Contract

Optional providers are tested absent, configuration-disabled, present, delayed, startup-failed, linkage-failed, malformed, oversized, stale, unavailable at runtime, refreshed, removed where supported, restored, logged out, and stopped. Provider failure never grants permission, hierarchy, exemption, quota, identity, or capability. Listener registrations and caches have exact ownership and teardown counts.

For each operation spanning game effect, persistence, cost, cooldown, escrow, mandatory audit, optional observation, queue, offline action, automation, native write, or external adapter, enumerate commit points and inject failure before and after each. Record operation and correlation ids, before/after semantic and file hashes, durable journal or receipt, compensation, retry eligibility, recovery action, and audit result. Mandatory audit and optional command-spy/file-log observation remain separate. An ambiguous non-idempotent effect becomes outcome unknown and blocks blind retry.

## Inputs and Upstream Contracts

### Inputs

| Input | Required state | Validation | Failure behavior |
|---|---|---|---|
| Integrated Phase 004 candidate | Merged, signed, tagged, cleanly reproducible | Commit, ancestry, tree, artifact hashes, tag signature, generated references | Stop before Phase 005 mutation on mismatch. |
| Phase 000 inventories | Complete lifecycle, revision, transient, channel, provider, dependency, test, and host rows | Regenerate drift checks and compare exact identities | Reopen the affected Phase 000 gate for missing or unowned rows. |
| Phase 001 security and `EXT-002` packet | No open security finding; complete dependency ownership/provenance dimensions | Match installed NeoForge runtime, API use, hashes, advisory state, and JAR contents | Reopen Phase 001 for security or direct dependency exposure. |
| Phase 002 persistence packet | Stores, operation ids, recovery, native opened-object, and shutdown contracts closed | Match schemas, writer identities, commit points, and invalidation | Reopen Phase 002 for integrity defects. |
| Phase 003 command matrix | Exact canonical actions and indirect routes closed | Compare route/action ids, policy, effect, persistence, feedback, and audit dimensions | Reopen Phase 003 for action-level command defects. |
| Phase 004 UI matrix | Graphical/textual actions, fallback, states, and client evidence closed | Match UI action ids, payloads, revisions, and presentation states | Reopen Phase 004 for UI-only defects. |
| `EXT-001` | Available in-plan canonical and conditional host evidence | Validate host, fixture, candidate, path reachability, evidence, and cleanup | Fail the applicable row only; never narrow support. |
| Diagnostics v2 | Phase 000 controls, schema, budgets, permission, sanitizer, and support procedure | Run enable/status/off and schema smoke tests before use | Repair through the inherited owner or a compatible Phase 005 category extension. |

## Outputs and Downstream Contracts

Use a fresh approved restricted evidence root outside the repository. Resolve the absolute path at execution and never record the private path in tracked files. Logical routes are stable:

| Logical route | Contents | Consumer |
|---|---|---|
| `phase-005/<attempt-id>/manifest/` | Candidate, artifact, host, fixture, provider, dependency, configuration, and cleanup manifests | Completion packet and Phase 006 |
| `phase-005/<attempt-id>/lifecycle/` | Sequence, order, idempotency, startup, stop, restart, handle, worker, and resource evidence | Phase 006 final runtime matrix |
| `phase-005/<attempt-id>/revision/` | Revision dependency and transient invalidation matrices, stale rejection evidence | Phase 006 regression matrix |
| `phase-005/<attempt-id>/channel/` | Command/UI/indirect convergence, payload/session, matching/fallback/incompatible/mixed-client evidence | Phase 006 and Phase 007 |
| `phase-005/<attempt-id>/provider/` | Optional provider states, listener/cache counts, outage and recovery evidence | Phase 006 compatibility matrix |
| `phase-005/<attempt-id>/failure/` | Commit-point injections, operation ids, compensation, outcome-unknown, retry, recovery, native writer evidence | Phase 006 recovery matrix |
| `phase-005/<attempt-id>/diagnostics/` | Bounded v2 captures, signals, counters, redaction, support procedure, overhead | Phase 006 and operator documentation |
| `phase-005/<attempt-id>/reports/` | Thread/classloading, performance, dependency/JAR, documentation, diff, cleanup, and review reports | Phase completion and Phase 006 |
| `phase-005/final/` | Immutable sanitized completion packet, merged identity, signed tag, invalidation ledger, Phase 006 handoff | Phases 006 and 007 |

Raw logs, worlds, recordings, screenshots, provider data, crash reports, network captures, and runtime directories stay in restricted evidence and are deleted when no longer required. Tracked changes are limited to product repairs, tests, small synthetic fixtures, maintained diagnostics, generated references, and affected documentation.

## Architecture and Implementation Boundaries

The logical server owns authority, lifecycle, revisions, domain mutation, persistence outcomes, provider decisions, and audit correlation. Client code owns presentation only. Network handlers enqueue bounded typed intent for current server-side validation. Workers consume immutable snapshots and publish through their owners. Optional integrations remain runtime guarded and fail closed. Native audit providers retain one opened descriptor or handle through validation, mutation, flush, and close, while the candidate JAR embeds no duplicate JNA runtime.

## Work Packages

Tasks are sequential unless their dependencies state otherwise. Narrow deterministic work within a task may run in parallel only when it uses immutable fixtures and disjoint resources. Tasks 013 and 014 are strictly sequential.

| Task ID | Requirements | Dependencies | Inputs | Outputs | Components | Work | Verification |
|---|---|---|---|---|---|---|---|
| `P005-TASK-001` | `SEFAUD-REQ-007` AC1 through AC11, `DEC-009`, `EXT-001`, `EXT-002` | Phase entry criteria | Integrated Phase 004, all upstream packets, Phase 000 inventories, current source/runtime graph | Phase 005 baseline, reconciled owner/host/dependency matrices, discrepancy and invalidation seed | Git/build identity, lifecycle owners, payload registry, providers, transient owners, native/runtime dependencies | Freeze revision and artifacts. Reconcile every lifecycle, revision, channel, payload, provider, worker, diagnostic, host, native writer, dependency, test, and documentation row. Classify each host-specific path as exercised, changed, or `NOT_EXERCISED`. | Exact-set and owner checks pass; upstream digests match; `EXT` rows are in-plan; no OS-specific client row exists; every discrepancy is resolved before Task 002. |
| `P005-TASK-002` | `SEFAUD-REQ-007` AC1, AC8, AC11 | `P005-TASK-001` | Reconciled lifecycle graph, event subscriptions, service/resource owners | Executable lifecycle sequence and resource-ownership model | `ServerEssentialsForge`, `KernelServices`, event handlers, config, storage, audit, logging, exports, managers, native provider | Define construction through next startup with side, thread, predecessor, state, failure, retry, diagnostic, cleanup, and resource reuse rules. Add deterministic assertions for ordering and idempotency. | Missing predecessor, double registration/start/stop, use-before-ready, callback-after-stop, partial startup, close-order, and restart-leak fixtures fail correctly. |
| `P005-TASK-003` | `SEFAUD-REQ-007` AC1, AC7, AC8, AC11 | `P005-TASK-002`, upstream native/dependency contracts | Lifecycle model, Linux runtime, conditional host rows, installed NeoForge runtime | Verified startup/save/stop/restart behavior and focused lifecycle repairs | Server entry, registrations, storage, profiles, audit/export/log services, native provider, worker owners | Execute construction, registration, native loading, server ready, world ownership, save, bounded stop, stopped, and restart. Verify correct provider and no state/handle/worker reuse. Repair defects at their owner. | Unit lifecycle harness, server-only GameTests where needed, canonical laptop server runs, native append/flush/close, failure injection, before/after owner counts, and direct affected-host evidence pass. |
| `P005-TASK-004` | `SEFAUD-REQ-007` AC2, AC8 | `P005-TASK-002`, closed upstream command/UI/persistence contracts | Revision sources, previews, confirmations, workflows, transfers, deferred work | Complete revision dependency graph, invalidation repairs, stale-state regressions | Feature/policy/permission services, config publication, command tree, aliases/bundles/profiles, GUI/session/workflows, repositories | Bind every dependent object to all authority and state revisions. Invalidate on mode/config/provider/permission/target/session/record/world changes and recheck before mutation. | Parameterized stale-revision tests, concurrent update, reload, permission loss, target replacement, and GameTests prove zero stale effect, zero cost/cooldown consumption, bounded feedback, and correlated rejection. |
| `P005-TASK-005` | `SEFAUD-REQ-007` AC3, AC11 | `P005-TASK-003`, `P005-TASK-004`, Phase 003/004 action maps | Canonical action set and all supported channel adapters | Cross-channel convergence manifest, authority/effect equivalence evidence, focused repairs | Command dispatcher, shortcuts, GUI protocol, fallback, aliases, bundles, sudo, panels, schedules, profiles, adapters, domain services, audit | Generate and execute every applicable channel-to-action row. Compare actor, policy, revisions, effect, persistence, feedback, redaction, and audit. Reject stale/forged/disconnected/cross-dimension intent. | Unit adapter and dispatcher tests, domain GameTests, canonical Linux multi-actor workflows, exactly one mutation/audit, identical semantic end state, and no alternate policy path. |
| `P005-TASK-006` | `SEFAUD-REQ-007` AC4, AC7, AC8, AC11 | `P005-TASK-003` through `P005-TASK-005`, Phase 004 client matrix | Payload registry, codecs, sessions, matching/fallback/incompatible client fixtures | Portable client and protocol lifecycle ledger, session/cleanup repairs | `SefNetwork`, `SefSessionManager`, `SefGuiServer`, `SefGuiRuntime`, client protocol state, workflows, projections, transfers | Test GUI off/on, matching enhanced, no-SEF fallback, protocol major mismatch, unsupported minor features, capacity, replay/order, mixed clients, disconnect/reconnect, server switch if supported, dimension, reload, permission/mode change, and shutdown. | Codec/session unit tests plus two-client Linux laptop workflows prove correct join, thread, authority, old-state rejection, fallback access, session/projection/transfer cleanup, and no macOS/Windows client requirement. |
| `P005-TASK-007` | `SEFAUD-REQ-007` AC5, AC9, AC11 | `P005-TASK-003`, `P005-TASK-004`, upstream provider/dependency inventory | Every approved optional provider fixture and adapter | Provider-state matrix, listener/cache ownership, fallback repairs | LuckPerms, FTB Essentials, Curios, FTB import, nickname, quota, Fancy Tags, all Phase 000 optional adapters | Exercise absent, disabled, present, delayed, startup/linkage failure, malformed/oversized, stale, outage, refresh, removal, restoration, logout, reload, reconnect, and shutdown. Keep native audit writer separate as mandatory. | Unit provider tests, real supported provider startup/refresh, cache/listener counts, permission and command-tree refresh, unrelated-core smoke, bounded diagnostics, and fail-closed authority pass. |
| `P005-TASK-008` | `SEFAUD-REQ-007` AC6, AC9, AC11 | `P005-TASK-003` through `P005-TASK-007`, Phase 002 commit/recovery contracts | Multi-boundary operations, fault injectors, journals/receipts, native writer | Partial-failure state machines, retry/recovery evidence, focused exactly-once repairs | Command execution, game effects, persistence, economy/cost, cooldown, escrow, graves, queues, offline actions, automation, audit, logging, native writer, adapters | Inject failure immediately before and after every commit point. Classify outcome, persist recovery, run compensation once, block unsafe retry, and preserve prior valid audit state on native failure. | Unit/integration faults, GameTests, process interruption where required, canonical Linux object-swap/link/metadata/write/flush/close/restart drills, state/file hashes, operation/correlation ids, and affected-host proof pass. |
| `P005-TASK-009` | `SEFAUD-REQ-007` AC7, AC9, AC11, `EXT-002` | `P005-TASK-003`, `P005-TASK-006`, `P005-TASK-008` | Source sets, compiled classes, task graphs, runtime class origins, thread diagnostics, JAR | Logical-side/classloading/thread map, native dependency reconciliation, focused boundary repairs | Common/client packages, network handlers, config watcher, server events, workers, audit writer, renderer, mixins, access transformer, JNA/runtime | Trace and prove client/common/server loading and server/network/watcher/worker/writer/render scheduling. Verify immutable snapshots, native class origin and ABI, opened handle lifetime, and absence of duplicate JNA/native entries. | Static client-reference scan, dedicated-server load trace, Linux client render-side trace, thread assertions, concurrency tests, installed-runtime hashes, and JAR entry scan pass. |
| `P005-TASK-010` | `SEFAUD-REQ-007` AC2, AC4, AC8, AC11 | `P005-TASK-004`, `P005-TASK-006` through `P005-TASK-009` | Phase 000 transient-owner inventory and lifecycle fixtures | Complete transition cleanup matrix, invalidation/settlement repairs | Player/world events, teleport, vanish, GUI/session, policy, automation, controls, moderation, disguise, Fancy Tags, queues/workers | Execute disconnect, replacement login, death, respawn, dimension, world unload, module disable, reload, permission/hierarchy change, provider refresh, target replacement, stopping, stopped, and restart for every transient owner. | Parameterized tests, GameTests, matching/fallback/mixed Linux client workflows, state counts, revisions, rejected stale mutations, no resource leak, bounded shutdown, and restart baseline pass. |
| `P005-TASK-011` | `SEFAUD-REQ-007` AC1, AC5, AC7, AC8, AC9 | Correctness-closed `P005-TASK-003` through `P005-TASK-010` | Phase 000 bounds, performance fixtures, diagnostic counters | Performance/concurrency ledger and narrowly scoped bounded-work repairs | Ticks, joins, refresh, command-tree resend, projections, disguise, queues, scans, snapshots, diagnostics, shutdown | Measure normal and boundary loads. Remove confirmed unbounded scans, lock inversions, per-tick I/O, unsafe iteration, allocation spikes, and log storms without weakening correctness. | Deterministic operation counts, queue/backpressure limits, concurrent transition tests, laptop server and mixed-client profile, no deadlock/concurrent modification, and declared diagnostic overhead pass. |
| `P005-TASK-012` | `SEFAUD-REQ-007` AC9, `DEC-009`, `EXT-001`, `EXT-002` | `P005-TASK-001` through `P005-TASK-011` | Inherited diagnostics v2, final state matrices, docs inventory, generated references | Phase 005 diagnostic categories/signals, truthful operator recovery guidance, updated docs, invalidation/rerun ledger | Shared debug service, doctor/storage/provider/control/config diagnostics, README, technical docs, acceptance/security/performance/compatibility docs, generators | Extend only the versioned category registry as needed. Reconcile disabled, absent, degraded, stale, recovery, outcome-unknown, stopping, stopped, and unavailable states with actual behavior. Update affected documentation and all invalidated evidence routes. | Diagnostic schema/control/redaction/limit/no-mutation tests, operator replay, Linux client presentation when required, generated-reference drift, links, support claims, and invalidation validator pass. |
| `P005-TASK-013` | `SEFAUD-REQ-007` AC1 through AC11 | `P005-TASK-012` | Final source, tests, artifact, matrices, host/dependency packets, invalidation ledger | Final Phase 005 evidence set and completion packet candidate | Entire affected product, build, resources, docs, Linux runtimes, conditional host runtimes | Run the ordered final matrix after the last change, renew all invalidated upstream evidence, inspect artifact/diff/privacy, reconcile `EXT-001` and `EXT-002`, verify cleanup, and assemble the packet. | Every required static, unit, GameTest, build, server, client, mixed, provider, failure, recovery, performance, dependency, JAR, docs, and cleanup row passes at one revision; no downgraded result remains. |
| `P005-TASK-014` | `SEFAUD-REQ-007`, repository phase workflow | `P005-TASK-013` | Ready branch, completion packet, required checks, review capability | Merged/tagged Phase 005, verified candidate, Phase 006 handoff | Git and GitHub phase integration; no publication | Commit and push, open/update the phase pull request, run required checks, obtain one private independent review when supported, resolve findings, merge through GitHub, verify the merge, create/push signed annotated phase tag, synchronize tracking, and hand off. | Signatures, checks, review disposition, merge method/target, remote ancestry, post-merge smoke, packet digests, tag, tracking state, and cleanup all verify. |

## Diagnostics and Debugging

**Requirement IDs:** `SEFAUD-REQ-007`
**Task IDs:** `P005-TASK-002`, `P005-TASK-005`, `P005-TASK-006`, `P005-TASK-007`, `P005-TASK-008`, `P005-TASK-009`, `P005-TASK-010`, `P005-TASK-011`, `P005-TASK-012`, `P005-TASK-013`
**Controls:** Reuse `/sef debug on <category> [target] [seconds] [sample_limit]`, `/sef debug status`, and `/sef debug off` from Phase 000; permit the dedicated server console and `sef.commands.sef.debug`, reject unknown categories and unauthorized or absent targets, keep `off` idempotent, and use the versioned categories `lifecycle`, `revision`, `channel`, `protocol`, `provider`, `persistence`, `worker`, and `audit` rather than adding another control tree.
**Signals:** Capture typed lifecycle transition and component states, previous/next revisions, session and payload sequence, canonical action/channel, actor and effective actor pseudonyms, provider state, operation and correlation ids, commit outcome, compensation/retry state, side/thread, payload bytes, queue depth, writer/opened-object state, audit result, duration, drops, truncations, and expiry.
**Collection procedure:** Follow the numbered Phase 005 procedure below for each normal or failing lifecycle stimulus; bind one capture to the exact candidate, host, fixture, before/after semantic state, server/client/provider evidence, recovery result, and cleanup record.
**Headless verification:** After inspecting the task graph to prove no client or renderer starts, use focused unit and integration tests, server-only GameTests, and no-GUI dedicated-server fixtures on `node-1` or the laptop to prove lifecycle ordering, revision invalidation, provider and partial-failure state machines, server authority, thread handoff, classloading, bounds, redaction, and cleanup. Headless proof never closes client receipt, reconnect, input, render-side state, or mixed-client gates.
**Client verification:** Use only the Linux laptop Minecraft Java client fixture for matching enhanced, no-SEF fallback, incompatible protocol, two-client mixed mode, session negotiation, actual payload receipt, input, GUI/fallback convergence, disconnect/reconnect, dimension change, server switch where supported, and client-state cleanup. No macOS or Windows Minecraft client runs or evidence are required.
**Client audio isolation:** Before launch, set and read back the disposable instance master audio as zero. Bind the exact owned Hyprland window address, class, title, and PID with `hyprctl clients -j`; correlate only that process tree to its PipeWire or PulseAudio application stream; mute with `wpctl` or `pactl`; and verify the stream reports muted before assertions. Monitor every stream recreation and mute each replacement. Teardown stops the watcher and client and removes only owned temporary audio state. Never mute default or system-wide audio.
**Budgets and privacy:** Inherit the 60-second default, 300-second maximum, 1,000-event default, 10,000-event maximum, 4 MiB output maximum, and 100-event-per-second capture cap; keep diagnostics off by default and allocation/I/O-free on disabled hot paths; redact credentials, tokens, private messages, raw addresses, hidden identities, restricted arguments, artwork bytes, provider-private metadata, and private absolute paths; stop safely and report counters at every bound.
**Regression and support:** Require enable/status/off, permission denial, invalid/removed target, timeout/reload/restart/disconnect reset, rate/size/drop/truncation, redaction, correlation, disabled and enabled overhead, thread ownership, no-mutation, and behavior-equivalence tests. Update `DOCUMENTATION.md` and affected generated references with the exact lifecycle support packet and recovery procedure.

The shared diagnostics system is observation-only and cannot grant permission, revive stale state, change scheduling, retry an operation, or alter the behavior being measured. Phase 005 category extensions must remain schema-compatible and centrally sanitized.

| Signal | Source and unit | Expected observation | Failure indicator |
|---|---|---|---|
| `transition_id`, `previous_state`, `next_state` | Lifecycle owner; stable ids/enums | One legal ordered transition with one owner | Missing, duplicate, reversed, or post-stop transition |
| `expected_revision`, `observed_revision`, `decision` | Policy/session/config/store owner; integer/string and enum | Current work allowed; stale work rejected before mutation | Stale allowed or current incorrectly rejected |
| `channel`, `action_id`, `correlation_id`, `mutation_count` | Command/GUI/adapter and audit boundary | All equivalent routes join one action and exactly one mutation/audit | Alternate action, duplicate effect, missing audit join |
| `payload_id`, `direction`, `sequence`, `payload_bytes`, `protocol_state` | Network codec/session; identifiers, integer, bytes, enum | Bounded, ordered, negotiated, correct handler side | Oversize accepted, replay allowed, wrong-side mutation |
| `provider_id`, `provider_state`, `provider_revision`, `reason_code` | Optional adapter | Accurate absent/ready/degraded/recovered state without authority broadening | False ready, stale grant, hidden failure |
| `operation_id`, `commit_state`, `compensation_state`, `retry_state` | Multi-boundary operation owner | Truthful terminal state and exactly-once recovery | Blind retry, double compensation, false success |
| `side`, `thread`, `queue_depth`, `duration_ms` | Server/client/worker/writer owner | Declared side and thread, bounded queue and duration | Client class on server, mutable off-thread access, unbounded work |
| `writer_state`, `opened_object_id`, `audit_result` | Native writer and audit service | Same opened object through flush and truthful audit result | Reopened/path-only write, identity change, audit loss |
| `dropped_events`, `truncated_events`, `expired` | Diagnostic service | Truthful zero or bounded-limit result and prompt stop | Silent loss or capture survives reset |

### Diagnostic Collection Procedure

1. Select one requirement row and stimulus. Create a unique disposable attempt, register exact cleanup resources, and record candidate/JAR hashes, configuration, host, client/provider set, synthetic actors, expected lifecycle and semantic state, category, target, duration, and sample limit. For a server runtime, create or correct `eula.txt` and read back effective `eula=true`.
2. Start only the required fixtures, prove exact candidate identity and server readiness, and complete all laptop renderer and silent-audio gates before any client action. Confirm intended clients joined the correct disposable world when the scenario needs them.
3. Enable the smallest category and target from the server console or an authorized synthetic actor. Record `capture_id`, scope, expiry, remaining events/bytes/rate, and output route. Prove unauthorized enable and invalid target rejection.
4. Execute the real transition or route without bypassing its authority. Record authoritative state before and after. For failure cases, inject one named cut immediately before or after its commit point and run the declared compensation or recovery.
5. Run status and join server, client, provider, storage, audit, and native evidence by capture and correlation ids. Verify field types, units, ordering, revisions, sequence, side/thread, result, redaction, counters, and one-mutation invariant.
6. Disable twice and prove idempotence, no later matching event, and reset after timeout, reload, disconnect, server stop, and restart as applicable. Retain a bounded sanitized failure packet when any assertion fails.
7. Store only the sanitized support packet and required targeted visuals at their logical evidence routes. Do not upload externally or retain raw credentials, addresses, chat, unrelated player state, or full logs.
8. Stop exact owned clients, audio watchers, server, providers, workers, routes, and captures; wait for exit; remove registered disposable data; verify streams/processes/paths are gone on every host; and record test and cleanup outcomes separately.

## Runtime Hosts, Client Audio, and Cleanup

### Host Matrix

| Host | Authorized Phase 005 work | Required evidence | Prohibited work |
|---|---|---|---|
| Owner Linux laptop | Canonical shared server; sole matching, fallback, incompatible, and mixed Minecraft Java client fixtures; rendering/input/reconnect/dimension/UI/fallback evidence | Discovered runtime paths, same commit and artifact hashes, active Hyprland desktop, process-bound discrete NVIDIA renderer, exact windows/PIDs, per-client muted streams, server readiness, joined identities/world, results, cleanup | Personal instances/worlds, audible client, system-wide mute, unverified renderer, unrelated process control, retained disposable runtime |
| `node-1` | Build, unit/integration tests, artifact/dependency inspection, proven server-only GameTests, and independent no-GUI dedicated-server checks | Exact checkout/artifact, inspected task graph, no client/renderer/display, owned process ids, reports, cleanup | Minecraft client, graphical acceptance, virtual display, VNC, X11 forwarding, offscreen/software rendering, or canonical evidence substitution |
| macOS | Direct non-client evidence only for a macOS-specific path changed or actually exercised by Phase 005 | Host/path reachability, exact candidate/artifact/runtime, provider/process/filesystem result, sanitization, cleanup | Minecraft client, duplicate portable Java matrix, mocked OS, speculative testing |
| Windows | Direct non-client evidence only for a Windows-specific path changed or actually exercised by Phase 005 | Host/path reachability, exact candidate/artifact/runtime, handle/reparse/process result, sanitization, cleanup | Minecraft client, duplicate portable Java matrix, mocked OS, unsupported-platform disposition |

### Canonical Linux Multiplayer Procedure

1. Discover the actual laptop checkout, isolated server runtime, launcher, matching enhanced client instance, no-SEF fallback instance, controlled incompatible-protocol fixture, Java 21 binaries, and supported direct-connect or desktop-control method. Verify all required artifacts, configuration, dependencies, commit, SHA-256, and SHA-512 identities. Do not invent paths or universal launch flags.
2. Register teardown for server, console, clients, windows, audio streams/watchers, temporary route, ports, providers, evidence, and disposable state. Configure and read back `eula=true` in the exact server runtime. Start the no-GUI laptop server and verify the expected candidate reaches ready state, not merely that a port opened.
3. For each client instance, inspect only its disposable `options.txt`, locate the pinned-version master sound setting, set zero, and read it back before launch. Never modify a personal or shared profile.
4. Launch one owned client at a time. Use `hyprctl clients -j` to bind exact address, class, title, and PID to the newly launched process. Prove the process uses the discrete NVIDIA renderer from process-bound game renderer evidence; hardware inventory alone is insufficient.
5. Correlate each verified PID and descendants with only its PipeWire or PulseAudio playback node. Mute with `wpctl set-mute <discovered-node-id> 1` or `pactl set-sink-input-mute <discovered-input-id> 1`, query the same stream, and verify it reports muted before assertions. Maintain one bounded watcher per owned client and remute every recreated stream after resource reload, device change, reconnect, or restart.
6. Connect automatically through the launcher's verified supported mechanism or authorized desktop controls without altering the personal server list. Verify server-side join identity and client-side entry into the exact world. For mixed mode, run at least one matching enhanced client and one no-SEF fallback client concurrently, each with separate identity and verified mute.
7. Use the server console for deterministic fixture setup and server assertions, but do not grant authority or bypass the interaction under test. Perform the required client input, disconnect, reconnect, dimension, fallback, and presentation actions on the owned clients. Correlate both sides without assuming synchronized clocks.
8. On any lost window/PID/stream correlation, unverified mute, wrong renderer, wrong artifact, or wrong world, stop that exact client and fail only its dependent rows. Do not move a client to `node-1`, use singleplayer as fallback, mute the default sink, or weaken authentication/network boundaries.
9. After the final consumer, stop each client and watcher, then the server and providers. Verify processes, playback streams, ports, workers, and native handles are gone. Retain only required sanitized evidence and delete the exact registered disposable runtimes and temporary audio/network state.

Singleplayer is allowed only for a newly identified defect that inherently requires the integrated-server path. The finding must name the exact requirement, reproduction reason, and retained multiplayer regression. Missing connectivity or control is not a singleplayer exception.

### Mandatory Cleanup

Every unit, integration, GameTest, build verification, server, client, provider, fault, performance, security, and audit attempt registers teardown before execution. Prefer a uniquely named disposable root. In reused directories, record pre-existing content and remove only verified test-created paths. Stop only owned processes after rechecking identity; never use broad kills, blanket `git clean`, broad globs, a repository/workspace/home target, or symlink traversal. Retain scratch only until its last required comparison. Delete disposable worlds, EULA files, logs, crashes, configs, temporary databases, providers, downloads, captures, routes, reports, coverage, bytecode, screenshots, and audio state after the final consumer. Preserve source changes, tracked fixtures, requested sanitized evidence, shared caches, personal instances, saves, and unrelated processes.

Cleanup is a separate gate. Verify owned processes, workers, handles, ports, streams, watchers, and paths are absent on every used host. If cleanup fails, record the exact leftover and do not start another attempt until it is reconciled. A passing behavior assertion with incomplete cleanup does not complete the workflow.

## Verification Matrix

### Ordered Final Verification

After the last Phase 005 implementation or documentation change:

1. Validate Phase 000 inventory drift and all upstream completion-packet identities.
2. Run formatting/static checks that exist, focused unit tests for changed lifecycle, revision, protocol, provider, failure, side/thread, diagnostics, and cleanup behavior, then the complete unit suite.
3. Regenerate command, permission, configuration, test, storage, UI, dependency, and audit references affected by this phase; require zero unexplained drift.
4. Run applicable server-only GameTests after confirming their task graph starts no client or renderer.
5. Run `./gradlew build`, `generateAuditInventory`, and `generateAuditDependencyManifest` from the exact candidate, then inspect the JAR for client/common boundaries, duplicate JNA/native content, metadata, and unexpected resources.
6. Run canonical laptop server construction, ready, save, reload, mode change, native audit append/flush, bounded stop, stopped, and restart workflows.
7. Run Linux matching enhanced, no-SEF fallback, controlled incompatible protocol, reconnect, dimension, and two-client mixed workflows under the silent-client procedure.
8. Run provider absent/present/failure/outage/refresh/restoration/shutdown workflows with real supported fixtures where required.
9. Run every declared partial-failure and recovery cut, including native opened-object identity, object substitution, missing metadata, append, flush, close, interruption, outcome unknown, and retry.
10. Run transient cleanup, concurrency, boundary-load, classloading, side/thread, diagnostics overhead, and shutdown-drain checks.
11. Execute matching-host macOS or Windows non-client evidence only for changed or exercised host-specific paths; otherwise validate their `NOT_EXERCISED` reachability rows.
12. Reconcile installed runtime dependency origins and hashes with `EXT-002`, repeat artifact and advisory disposition checks, and ensure no direct mod-owned exposure remains.
13. Run documentation links/support claims, secret/privacy/private-path scans, complete diff and generated-file audit, evidence invalidation audit, and cleanup audit.
14. Assemble the completion packet, obtain required review, integrate, then rerun the required post-merge smoke and identity checks before tagging.

### Evidence Matrix

| Requirement slice | Static/unit proof | Integration/GameTest proof | Real workflow proof | Negative/failure proof |
|---|---|---|---|---|
| AC1 lifecycle order | Registration/sequence/idempotency tests | Event-to-service and world lifecycle | Laptop server ready/save/stop/restart | Partial startup, duplicate start, close timeout, next-start leak |
| AC2 revision invalidation | Parameterized revision graph | Deferred mutation and concurrent-update GameTests | Reload, permission/provider/target change | Stale mutation, cost/cooldown consumption, reused confirmation |
| AC3 channel convergence | Adapter-to-action set comparison | Dispatcher/domain effect equivalence | Matching/fallback/mixed Linux clients | Forged, stale, duplicate, disconnected, cross-dimension intent |
| AC4 client modes | Codec/session/cache tests | Server session lifecycle | GUI off/on, matching, fallback, incompatible, reconnect, dimension, mixed | Replay, sequence gap, feature mismatch, disconnect mid-transfer |
| AC5 providers | Parser/cache/listener/fallback tests | Provider refresh and command-tree projection | Real supported provider stack and outage | Missing/linkage/malformed/oversized/stale/removed provider |
| AC6 partial failure | State-machine/idempotency tests | Commit-point and recovery integration | Native writer, process interruption, restart | Every before/after cut, compensation failure, outcome unknown, retry |
| AC7 side/thread | Source/class/JAR scans and scheduler tests | Network enqueue and immutable snapshot assertions | Dedicated server and Linux client traces | Client class on server, wrong-thread mutation, callback after stop |
| AC8 transient cleanup | Owner/state-count tests | Death/respawn/dimension/logout GameTests | Disconnect/reconnect/reload/shutdown/mixed clients | Replacement connection, simultaneous request/transition, leak |
| AC9 diagnostics | Schema/control/redaction/budget tests | State-to-signal joins | Operator capture and recovery replay | Unauthorized target, false ready, leaked data, capture survives reset |
| AC10 defect closure | Finding-ledger validation | Every regression at real boundary | Affected end-to-end rerun | Any known mandatory defect remains open |
| AC11 runtime | Dependency/class origin and artifact scans | Complete server/client/provider integration | Canonical Linux plus conditional matching-host non-client paths | Wrong artifact/runtime, duplicate JNA, lower-fidelity substitution |

## Failure, Recovery, and Edge Cases

| Failure | Required behavior | Recovery | Evidence invalidated |
|---|---|---|---|
| Upstream inventory or packet mismatch | Stop dependent work and reopen canonical owner | Repair upstream evidence and re-enter from a new baseline | All dependent Phase 005 rows |
| Construction or registration runs twice/out of order | Fail startup or affected capability safely with truthful state | Repair ownership/guard/order and restart disposable fixture | Lifecycle, registration, resource, restart evidence |
| Partial startup leaves resources alive | Stop accepting work and report component states | Close owned resources in reverse dependency order, verify counts, retry fresh | Startup, worker, provider, audit, cleanup evidence |
| Revision changes during pending work | Reject before mutation and invalidate the pending object | Recreate from current authority and state | Revision and channel row for that operation |
| Channels produce different effects | Fail convergence and preserve both traces | Remove alternate policy/mutation path and rerun all routes | Action, UI, persistence, feedback, audit evidence |
| Forged/replayed/oversized payload reaches mutation | Treat as security regression and stop affected protocol testing | Repair codec/session/validator, reopen Phase 001 if trust boundary changed | Security, protocol, command/UI, integration evidence |
| Provider outage grants or blocks unrelated core | Fail provider row and revoke stale decisions | Restore fail-closed fallback, clear caches/listeners, retest recovery | Provider, permission, command tree, UI evidence |
| Partial outcome is ambiguous | Record outcome unknown and block blind retry | Reconcile journal/receipt and execute declared recovery | Operation, persistence, audit, retry evidence |
| Mandatory audit fails after effect | Never report fully audited success | Apply declared compensation or outcome-unknown recovery | Effect, persistence, audit, operator-feedback evidence |
| Wrong side/thread or client class on server | Stop affected workflow; dedicated-server gate fails | Isolate client code or schedule through correct owner | Classloading, thread, protocol, artifact evidence |
| Native runtime class origin or ABI mismatches `EXT-002` | Fail native capability closed | Restore pinned compatible runtime or repair direct declaration without embedding duplicate | Dependency, native writer, startup, artifact evidence |
| Client renderer/window/stream/mute cannot be proved | Stop exact client immediately | Restore correct isolated laptop capability and rerun client rows | Only dependent client evidence |
| Exercised host-specific path lacks direct matching-host evidence | Fail that in-plan row while preserving support | Run and clean the exact workflow on matching host | Affected native/filesystem/process/dependency/recovery evidence |
| Diagnostic capture changes behavior or leaks data | Disable, quarantine, and fail diagnostics | Repair central schema/sanitizer/bounds, recreate evidence | Diagnostic and all derived rows |
| Cleanup is incomplete | Mark workflow incomplete | Reconcile exact owned leftover before another attempt | Entire attempt runtime packet |
| Final repair intersects earlier proof | Mark intersecting evidence stale immediately | Rerun from earliest affected layer through final matrix | All rows named by invalidation graph |
| Required check/review/merge/tag fails | Do not begin Phase 006 | Correct through approved repository workflow without bypass | Integration and downstream handoff |

Any change to lifecycle registration, service construction, configuration, dependency, native provider, opened-object behavior, protocol, payload, permission, policy, command tree, adapter, state schema, persistence, diagnostics, test harness, generated references, or fixture identity invalidates every intersecting row. Documentation-only corrections require link and claim checks unless they reveal a product or evidence discrepancy.

## Documentation, Operations, and Release Boundaries

1. Update `README.md` when verified public setup, compatibility, commands, modes, integrations, or limitations change. Update `DOCUMENTATION.md` for lifecycle order, revisions, channel convergence, payload/session behavior, provider states, partial failure, diagnostics, thread ownership, recovery, and shutdown.
2. Update `test.md`, `docs/SEF2_ACCEPTANCE.md`, `docs/COMPATIBILITY_MATRIX.md`, `docs/SECURITY_REVIEW.md`, `docs/PERFORMANCE_REPORT.md`, `docs/RELEASE_WORKFLOW.md`, troubleshooting and recovery guidance, and generated references only where Phase 005 evidence changes a current fact or procedure.
3. Document exact verified commands, launch discovery, expected state, failure interpretation, recovery, evidence route, and cleanup. Do not claim unsupported launcher flags or ask an operator to supply a full raw log, home directory, production world, credential, or private address.
4. State Linux, macOS, and Windows support consistently. The Linux client fixture proves one portable Minecraft Java client contract. Do not request or document separate macOS or Windows client evidence. Document matching-host checks only for changed or exercised non-client paths.
5. Record `EXT-001` and `EXT-002` as authorized, available in-plan work with the exact Phase 005 result. Do not convert an unexercised host path into unsupported status or a platform-owned alert into a dismissed finding.
6. Preserve the sixteen unavailable control families as unavailable, unreachable, side-effect-free, and absent from feature claims. Diagnostics must show their truthful unavailable state.
7. Release readiness may advance, but this phase does not publish, deploy, change marketplace state, expose a port publicly, modify production, or use production credentials/data.

## Risks and Evidence Invalidation

| Risk | Prevention | Detection | Recovery |
|---|---|---|---|
| Lifecycle breadth leaves an untested transition | Generate from Phase 000 rows and require predecessor/successor coverage | Completeness and orphan validators | Add row and rerun dependent sequences |
| Revision matrix misses a dependency | Trace every deferred object to all read authority/state | Stale-state mutation injection | Add binding/invalidation and rerun channel matrix |
| Equivalent channels diverge | One canonical action and shared policy/domain execution | Semantic before/after and audit comparison | Remove alternate path, rerun every adapter |
| Protocol testing validates codec but not thread/authority | Require real handler, session, and logical-server proof | Side/thread and mutation assertions | Repair enqueue/validator ownership, rerun client workflow |
| Provider failure broadens authority | Fail-closed defaults and revisioned caches | Outage/malformed/stale provider fixtures | Revoke stale state, restore fallback, retest recovery |
| Partial failure duplicates irreversible work | Explicit commit points, operation ids, receipts, idempotency | Before/after fault injection and restart | Compensate once or resolve outcome unknown before retry |
| Shutdown loses or leaks work | Reverse-order ownership and bounded drain | Worker/handle/session counts before next startup | Preserve incomplete markers, recover, rerun restart |
| Diagnostics perturb timing or leak protected data | Default-off lazy capture, bounds, central sanitizer | Paired capture-off/on and privacy tests | Disable, repair, invalidate captures |
| Client workflow becomes audible or uses wrong process | Two-layer mute and exact Hyprland/PID/stream binding | Pre-action mute and renderer checks, stream watcher | Stop exact client, correct fixture, rerun affected row |
| Host-specific proof expands into duplicate client testing | Reachability gate and one portable client contract | Reject OS-specific client rows | Restore canonical Linux client routing |
| Dependency ownership hides a reachable alert | Separate graph/artifact/runtime/API/advisory/remedy evidence | `EXT-002` reconciliation and JAR/class-origin scans | Restore finding and remediate direct exposure |
| Late fix makes evidence stale | Component-to-evidence invalidation graph | Final commit/artifact digest audit | Rerun earliest affected layer and final matrix |

## Phase Completion Packet

The immutable sanitized packet under `phase-005/final/` contains:

1. Phase 004 input commit/tag, Phase 005 branch head, merge commit, signed Phase 005 tag, ancestry, tree, artifact hashes, dirty-state classification, and preservation record.
2. Java, Minecraft, NeoForge, Parchment, wrapper, mod version, configuration, generated-reference, dependency graph, provider, source-set, and fixture manifests.
3. Canonical Linux laptop server and all matching, fallback, incompatible, reconnect, dimension, and mixed-client fixture records, including per-client window/PID/renderer/mute proof and cleanup. No macOS or Windows client record exists.
4. Conditional macOS or Windows non-client host packets only for changed or exercised paths, plus `NOT_EXERCISED` reachability records for other host-specific paths.
5. Complete lifecycle sequence, registration, resource ownership, revision dependency, transient invalidation, cross-channel convergence, network/payload, provider-state, partial-failure, retry/recovery, side/thread/classloading, and performance matrices.
6. Before/after semantic and file hashes, operation/correlation ids, journals/receipts, compensation outcomes, audit results, and restart proof for every required fault cut.
7. Diagnostics v2 category/schema changes, bounded captures, control and permission results, counters, overhead, redaction, behavior-equivalence, reset, and support-procedure evidence.
8. `EXT-001` canonical Linux and applicable matching-host results, and `EXT-002` installed-runtime origins, coordinates, versions, hashes, licenses, API reachability, advisory dispositions, ABI/load results, and no-duplicate-runtime artifact inspection.
9. Targeted and complete unit, integration, GameTest, build, generated-reference, server, client, provider, failure, recovery, performance, JAR, privacy, diff, and cleanup results with exact commands/workflows and decisive output.
10. Stable defect ledger with root cause, owner, remediation commit, regression proof, invalidated rows, rerun results, and zero open mandatory Phase 005 defect.
11. Documentation changes or evidence-based no-change disposition for every affected required document, plus zero-drift, link, and support-claim results.
12. Evidence invalidation ledger showing every affected Phase 001 through 005 row rerun successfully. No failed, stale, partial, mocked, unavailable, or lower-fidelity result is marked passed.
13. Pull request, issue, milestone, Project, required checks, private independent-review capability/result disposition, merge, post-merge verification, signed tag, and rollback statement.
14. Phase 006 handoff naming the exact integrated commit and artifacts, canonical Linux fixture, applicable non-client host packets, dependency/native evidence, client/provider fixtures, residual allowed limitations, invalidation rules, and first entry action.

Raw evidence is referenced through sanitized relative ids and digests. The packet contains no private absolute host paths, credentials, personal data, production data, unbounded logs, whole runtime directories, or publication action.

## Next Transition

After every Phase 005 exit criterion and packet item passes, merge the approved phase pull request through GitHub, fetch the remote, verify the resulting integration commit contains the reviewed work and descends from the Phase 004 merge, run the required post-merge smoke at that exact commit, create and push the signed annotated Phase 005 tag, and verify its signature and packet binding.

Only then may `SEFAUD-PHASE-006` begin. Its first action reads the registered Phase 006 blueprint through EOF and freezes the clean-checkout post-change verification baseline from the tagged Phase 005 integration commit. Phase 006 cannot start while Phase 005 is unmerged, checks or review remain unresolved, cleanup is incomplete, an applicable `EXT-001` row failed, installed runtime evidence conflicts with `EXT-002`, a direct mod-owned dependency exposure remains, or any mandatory backend-integration defect is open. A conditional unexercised host path does not block the transition when its `NOT_EXERCISED` reachability proof is valid, and it never narrows Linux, macOS, or Windows support.
