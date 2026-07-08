# Architecture

## Overview

English Reading Coach uses a feature-first Clean Architecture. The Flutter frontend owns presentation and client-side interaction. The Quarkus backend owns business rules, persistence, authentication, progress calculations, and API contracts. PostgreSQL is the source of truth.

The system is intentionally modular so Phase 2 speech recognition and Phase 3 AI coaching can be added through new domain capabilities and infrastructure adapters.

## High-Level System

```text
Flutter Web / Android
  -> REST over HTTPS
Quarkus API
  -> Hibernate Panache repositories
PostgreSQL
```

## Dependency Rule

Dependencies flow inward:

```text
Presentation -> Application -> Domain
Infrastructure -> Application -> Domain
```

Domain code must not depend on UI frameworks, databases, HTTP, JWT libraries, or cloud services.

## Repository Layout

```text
english_read/
  docs/
  frontend/
    english_reading_coach/
      lib/
        app/
        core/
        features/
        shared/
      test/
      integration_test/
  backend/
    english-reading-coach-api/
      src/main/java/com/englishcoach/
        auth/
        category/
        lesson/
        progress/
        statistics/
        streak/
        shared/
      src/main/resources/
        db/migration/
      src/test/
  infrastructure/
    docker/
    cloudflare/
  .github/workflows/
```

## Flutter Architecture

Flutter uses feature-first organization:

```text
lib/
  app/
    app.dart
    router.dart
    theme.dart
  core/
    config/
    errors/
    http/
    storage/
    time/
  shared/
    widgets/
    layout/
    design/
  features/
    auth/
      data/
      domain/
      presentation/
    lessons/
      data/
      domain/
      presentation/
    reading/
      data/
      domain/
      presentation/
    progress/
      data/
      domain/
      presentation/
    statistics/
      data/
      domain/
      presentation/
```

Each feature follows:

- `domain`: entities, value objects, repository contracts, use cases.
- `data`: DTOs, API clients, repository implementations.
- `presentation`: screens, widgets, Riverpod providers, view models.

UI widgets must not contain business rules. Reading timing calculations belong in domain or application services that can be tested without Flutter rendering.

## Quarkus Architecture

Backend uses packages by feature:

```text
com.englishcoach
  auth/
    api/
    application/
    domain/
    infrastructure/
  lesson/
    api/
    application/
    domain/
    infrastructure/
  progress/
    api/
    application/
    domain/
    infrastructure/
  shared/
    api/
    error/
    security/
    time/
```

Package responsibilities:

- `api`: JAX-RS resources, request DTOs, response DTOs.
- `application`: service layer, use cases, transaction boundaries.
- `domain`: entities, domain rules, value objects.
- `infrastructure`: Panache repositories, persistence mapping, external adapters.

## Backend Rules

- REST resources validate input and delegate to application services.
- Services enforce business rules and transaction boundaries.
- Repositories encapsulate database access.
- DTOs isolate API payloads from persistence models.
- Domain rules must be unit-testable without Quarkus.
- All timestamps are stored in UTC.

## Reading Engine

The reading engine controls:

- Sentence tokenization.
- Word timing.
- Highlight index.
- Pause and resume behavior.
- Speed multiplier.
- Session elapsed time.
- Completion event.

The engine must be deterministic. Given the same sentence, words-per-minute setting, and elapsed time, it should return the same highlighted word index.

## Extensibility For Future AI

Future AI belongs behind backend ports:

```text
ai/
  application/
    PronunciationFeedbackService
    CoachingService
  domain/
    PronunciationAttempt
    CoachingSuggestion
  infrastructure/
    OpenAiPronunciationAdapter
    WhisperTranscriptionAdapter
```

Phase 1 must not introduce AI dependencies, prompts, API keys, audio storage, or AI-specific UI flows.

