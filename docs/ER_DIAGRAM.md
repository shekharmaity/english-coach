# Entity Relationship Documentation

This document mirrors the PostgreSQL schema managed by Flyway migrations in `backend/english-reading-coach-api/src/main/resources/db/migration`.

## Diagram

```mermaid
erDiagram
  users ||--o{ refresh_tokens : owns
  users ||--o{ user_lesson_progress : tracks
  users ||--o{ reading_sessions : performs
  users ||--o{ daily_streaks : accumulates
  categories ||--o{ lessons : groups
  lessons ||--o{ sentences : contains
  lessons ||--o{ user_lesson_progress : measured_by
  lessons ||--o{ reading_sessions : read_in
  sentences ||--o{ reading_session_sentence_events : highlighted_in
  reading_sessions ||--o{ reading_session_sentence_events : records

  users {
    uuid id PK
    text email
    text password_hash
    text display_name
    text role
    boolean email_verified
    text preferred_timezone
    timestamptz created_at
    timestamptz updated_at
  }

  refresh_tokens {
    uuid id PK
    uuid user_id FK
    text token_hash
    timestamptz expires_at
    timestamptz revoked_at
    timestamptz created_at
  }

  categories {
    uuid id PK
    text slug
    text title
    text description
    int sort_order
    boolean active
    timestamptz created_at
    timestamptz updated_at
  }

  lessons {
    uuid id PK
    uuid category_id FK
    text slug
    text title
    text description
    text difficulty
    int estimated_seconds
    int default_speed_wpm
    boolean published
    int sort_order
    timestamptz created_at
    timestamptz updated_at
  }

  sentences {
    uuid id PK
    uuid lesson_id FK
    int position
    text content
    int word_count
    timestamptz created_at
    timestamptz updated_at
  }

  user_lesson_progress {
    uuid id PK
    uuid user_id FK
    uuid lesson_id FK
    text status
    numeric completion_percent
    int last_sentence_position
    int last_speed_wpm
    timestamptz started_at
    timestamptz completed_at
    timestamptz updated_at
  }

  reading_sessions {
    uuid id PK
    uuid user_id FK
    uuid lesson_id FK
    text status
    int speed_wpm
    int elapsed_seconds
    int words_read
    timestamptz started_at
    timestamptz completed_at
    text client_platform
  }

  reading_session_sentence_events {
    uuid id PK
    uuid reading_session_id FK
    uuid sentence_id FK
    int sentence_position
    int elapsed_seconds
    int words_read
    timestamptz started_at
    timestamptz completed_at
    timestamptz created_at
  }

  daily_streaks {
    uuid id PK
    uuid user_id FK
    date streak_date
    int sessions_completed
    int words_read
    timestamptz created_at
    timestamptz updated_at
  }
```

## Migration Map

- `V1__foundation.sql`: core user, auth token, catalog, progress, session, and streak tables.
- `V2__reading_session_sentence_events.sql`: sentence-level reading event table and indexes.
- `V3__seed_catalog_content.sql`: starter categories, lessons, and sample sentences.

## Index Summary

- User identity and creation: `users_email_lower_idx`, `users_created_at_idx`.
- Token lookup and expiry: `refresh_tokens_user_id_idx`, `refresh_tokens_expires_at_idx`.
- Catalog browsing: `categories_active_sort_order_idx`, `lessons_category_published_sort_idx`, `lessons_difficulty_idx`, `sentences_lesson_position_idx`.
- Progress and sessions: `user_lesson_progress_user_status_idx`, `user_lesson_progress_lesson_idx`, `reading_sessions_user_started_idx`, `reading_sessions_lesson_idx`, `reading_sessions_status_idx`.
- Sentence events and streaks: `reading_session_sentence_events_session_idx`, `reading_session_sentence_events_sentence_idx`, `reading_session_sentence_events_session_completed_idx`, `daily_streaks_user_date_idx`.
