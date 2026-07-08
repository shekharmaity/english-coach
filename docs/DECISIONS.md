# Architecture Decision Records

## ADR-001: Use Flutter For Web And Android

Status: Accepted

Context: The product must support responsive Web and Android with a consistent reading experience.

Decision: Use Flutter as the frontend framework.

Consequences:

- One codebase can target Web and Android.
- UI and reading interactions can be shared across platforms.
- The team must pay attention to Web accessibility and browser behavior.

## ADR-002: Use Quarkus For Backend

Status: Accepted

Context: The backend must be lightweight, production-ready, Java-based, and suitable for container deployment.

Decision: Use Java 21 with Quarkus.

Consequences:

- Fast startup and low memory usage are achievable.
- Java ecosystem libraries are available.
- Developers must follow Quarkus conventions for dependency injection, REST, configuration, and testing.

## ADR-003: Use PostgreSQL

Status: Accepted

Context: The product needs reliable relational data for users, lessons, sessions, progress, and statistics.

Decision: Use PostgreSQL as the production database.

Consequences:

- Strong relational integrity protects user progress.
- Indexing and aggregation support statistics.
- Migrations must be managed carefully.

## ADR-004: Use Riverpod

Status: Accepted

Context: Flutter state must be testable, composable, and maintainable across features.

Decision: Use Riverpod for state management.

Consequences:

- State can be tested independently from widgets.
- Providers make dependency flow explicit.
- The team must avoid putting business logic directly in provider declarations when a domain service is more appropriate.

## ADR-005: Use REST

Status: Accepted

Context: Phase 1 APIs are resource-oriented and do not require real-time subscriptions.

Decision: Use REST over HTTPS with JSON.

Consequences:

- API behavior is easy to inspect and test.
- Flutter integration is straightforward.
- Future streaming or realtime features may require additional protocols.

## ADR-006: Exclude AI From Phase 1

Status: Accepted

Context: The project vision includes future AI, but the first release must prove the core reading experience.

Decision: Phase 1 will not include AI features, AI dependencies, speech recognition, Whisper, or GPT coaching.

Consequences:

- Delivery risk is lower.
- Privacy and cost complexity are deferred.
- Architecture must remain extensible without prematurely designing around AI.

## ADR-007: Use Docker For Backend Deployment

Status: Accepted

Context: The backend should deploy consistently across staging and production.

Decision: Package the Quarkus backend as a Docker container.

Consequences:

- Runtime dependencies are explicit.
- CI can build deployable images.
- Container image security scanning should be added before production.

## ADR-008: Use Clean Architecture

Status: Accepted

Context: The product will evolve across reading, speech, AI, content management, and analytics.

Decision: Use Clean Architecture with feature-first organization.

Consequences:

- Business rules stay testable.
- Infrastructure can change without rewriting domain logic.
- Developers and AI agents must respect dependency boundaries.

