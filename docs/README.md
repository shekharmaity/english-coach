# English Reading Coach Documentation

This folder is the long-term engineering memory for English Reading Coach. It is written for human developers, product owners, designers, QA engineers, DevOps engineers, and AI agents that may join the project months after the original decisions were made.

English Reading Coach is a Flutter Web and Android application that helps users improve English speaking confidence by reading sentences with excellent pacing, highlighting, timing, progress tracking, categories, lesson management, statistics, and daily streaks.

Phase 1 intentionally excludes AI features. The first release must prove that the reading experience is polished, reliable, fast, measurable, and pleasant before speech recognition or AI coaching is introduced.

## Document Map

- [PROJECT.md](PROJECT.md): Product scope, users, success metrics, and operating assumptions.
- [VISION.md](VISION.md): Long-term product vision and experience principles.
- [ROADMAP.md](ROADMAP.md): Phase, version, and release progression.
- [ARCHITECTURE.md](ARCHITECTURE.md): System architecture, dependency flow, and package structure.
- [DATABASE.md](DATABASE.md): Production PostgreSQL schema, relationships, indexes, and future-proofing.
- [API_CONTRACT.md](API_CONTRACT.md): REST contract for authentication, lessons, progress, statistics, streaks, and future AI endpoints.
- [CODING_STANDARDS.md](CODING_STANDARDS.md): Engineering standards for Flutter, Java, Quarkus, and shared conventions.
- [UI_GUIDELINES.md](UI_GUIDELINES.md): UX rules for the reading experience and responsive behavior.
- [DESIGN_SYSTEM.md](DESIGN_SYSTEM.md): Material 3 tokens, components, typography, spacing, and accessibility.
- [STATE_MANAGEMENT.md](STATE_MANAGEMENT.md): Riverpod patterns and state ownership.
- [SECURITY.md](SECURITY.md): Authentication, authorization, data protection, and secure delivery.
- [TESTING_STRATEGY.md](TESTING_STRATEGY.md): Unit, widget, integration, API, database, and release testing.
- [DEPLOYMENT.md](DEPLOYMENT.md): Docker and hosting model.
- [GIT_WORKFLOW.md](GIT_WORKFLOW.md): Commit, review, and release workflow.
- [BRANCHING_STRATEGY.md](BRANCHING_STRATEGY.md): Branch naming and promotion rules.
- [CI_CD.md](CI_CD.md): GitHub Actions pipeline design.
- [SPRINT_PLAN.md](SPRINT_PLAN.md): First 10 implementation sprints.
- [BACKLOG.md](BACKLOG.md): Prioritized product and engineering backlog.
- [DECISIONS.md](DECISIONS.md): Architecture Decision Records.
- [CHANGELOG.md](CHANGELOG.md): Human-readable change history.
- [RISKS.md](RISKS.md): Product, technical, operational, and delivery risks.
- [PERFORMANCE.md](PERFORMANCE.md): Performance budgets and optimization strategy.
- [CONTRIBUTING.md](CONTRIBUTING.md): Contribution standards for humans and AI agents.
- [PROMPTS.md](PROMPTS.md): Reusable prompts for specialized AI agent roles.

## Repository Intent

The expected repository layout is:

```text
english_read/
  docs/
  frontend/
    english_reading_coach/
  backend/
    english-reading-coach-api/
  infrastructure/
  .github/
    workflows/
```

The project should be implemented as a monorepo unless a future ADR changes that decision. A monorepo improves traceability across API contracts, database migrations, UI behavior, CI, and documentation.

## Phase 1 Scope

Phase 1 includes:

- Account authentication with JWT.
- Categories and lessons.
- Sentence-based reading flow.
- Word-by-word synchronized highlighting.
- Adjustable reading speed.
- Reading timer.
- Lesson completion and progress tracking.
- Daily streak tracking.
- Reading statistics.
- Responsive Flutter Web.
- Android app packaging.
- Production-grade REST backend.
- PostgreSQL persistence.
- Dockerized backend.
- GitHub Actions checks.

Phase 1 excludes:

- Speech recognition.
- Pronunciation scoring.
- GPT coaching.
- Whisper integration.
- Audio recording.
- Real-time conversational AI.

## Documentation Rules

Every material product or architecture change must update this folder in the same pull request. AI agents must read the relevant documents before editing code. When a decision changes, update [DECISIONS.md](DECISIONS.md) with a new ADR rather than silently rewriting history.

