# Roadmap

## Phase 1: Reading Foundation

Goal: Build the best non-AI reading practice experience.

Scope:

- Flutter Web and Android app.
- Material 3 responsive UI.
- Authentication with JWT.
- Category and lesson browsing.
- Sentence reading screen.
- Word-by-word synchronized highlighting.
- Adjustable reading speed.
- Timer, pause, resume, restart, and completion.
- User progress tracking.
- Daily streak.
- Reading statistics.
- Quarkus REST backend.
- PostgreSQL schema and migrations.
- Dockerized backend.
- GitHub Actions validation.

Exit Criteria:

- Users can register, sign in, browse lessons, complete reading sessions, and see progress.
- Web and Android builds pass release checks.
- API contract, migrations, and tests are stable.
- Documentation reflects implemented behavior.

## Phase 2: Speech Practice

Goal: Add voice-based practice while preserving the Phase 1 reading flow.

Scope:

- Microphone permission flow.
- Local recording state management.
- Speech recognition integration behind a domain port.
- Pronunciation attempt records.
- Basic pronunciation status such as attempted, skipped, needs review, and passed.
- User-controlled deletion of recordings if audio is stored.
- Privacy-first settings.

Exit Criteria:

- Users can read aloud and receive non-AI speech recognition feedback.
- Speech features are optional and do not block reading-only use.
- Data retention is explicit and secure.

## Phase 3: AI Coaching

Goal: Provide personalized coaching using AI services through isolated backend adapters.

Scope:

- GPT-based reading tips.
- Whisper-based transcription where appropriate.
- Pronunciation feedback summaries.
- Personalized lesson recommendations.
- AI usage metering and cost controls.
- Prompt versioning and evaluation sets.

Exit Criteria:

- AI feedback is useful, auditable, and safe.
- Cost, latency, and privacy risks are controlled.
- AI features can be disabled without breaking the core app.

## Version 1.0

Version 1.0 is the first production release of Phase 1.

Required:

- Complete reading experience.
- Stable authentication.
- Lesson catalog.
- Progress and streaks.
- Responsive Web and Android.
- Production deployment pipeline.
- Monitoring-ready backend logs.
- Documentation aligned with release behavior.

## Version 2.0

Version 2.0 expands beyond reading-only practice.

Target capabilities:

- Voice practice.
- AI coaching.
- Personalized lesson recommendations.
- Improved analytics.
- Teacher or group-ready data model.
- Stronger content management workflows.

