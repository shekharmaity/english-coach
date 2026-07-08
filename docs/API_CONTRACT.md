# API Contract

## Principles

- REST over HTTPS.
- JSON request and response bodies.
- JWT access tokens.
- Refresh tokens with rotation.
- Stable resource names.
- Explicit pagination.
- UTC timestamps in ISO 8601 format.
- Error responses use a consistent envelope.

## Base URL

Production:

```text
https://api.englishreadingcoach.com/api/v1
```

Local:

```text
http://localhost:8080/api/v1
```

## Error Envelope

```json
{
  "code": "LESSON_NOT_FOUND",
  "message": "The requested lesson was not found.",
  "details": {
    "lessonId": "2d5790b5-67e0-4d40-8a97-1c24a7b8c2d4"
  },
  "traceId": "req-20260708-001"
}
```

## Authentication

### POST /auth/register

Request:

```json
{
  "email": "learner@example.com",
  "password": "StrongPassword123!",
  "displayName": "Asha",
  "preferredTimezone": "Asia/Kolkata"
}
```

Response `201`:

```json
{
  "user": {
    "id": "uuid",
    "email": "learner@example.com",
    "displayName": "Asha",
    "preferredTimezone": "Asia/Kolkata"
  },
  "accessToken": "jwt",
  "refreshToken": "opaque-refresh-token"
}
```

### POST /auth/login

Request:

```json
{
  "email": "learner@example.com",
  "password": "StrongPassword123!"
}
```

Response `200`: same as registration.

### POST /auth/refresh

Request:

```json
{
  "refreshToken": "opaque-refresh-token"
}
```

Response `200`:

```json
{
  "accessToken": "jwt",
  "refreshToken": "rotated-refresh-token"
}
```

### POST /auth/logout

Revokes the current refresh token.

## Categories

### GET /categories

Returns active categories.

Response:

```json
{
  "items": [
    {
      "id": "uuid",
      "slug": "daily-conversation",
      "title": "Daily Conversation",
      "description": "Short sentences for everyday speaking.",
      "lessonCount": 12,
      "sortOrder": 1
    }
  ]
}
```

## Lessons

### GET /lessons

Query parameters:

- `categoryId`
- `difficulty`
- `page`
- `size`

Response:

```json
{
  "items": [
    {
      "id": "uuid",
      "categoryId": "uuid",
      "slug": "morning-routine",
      "title": "Morning Routine",
      "description": "Practice simple sentences about daily habits.",
      "difficulty": "BEGINNER",
      "estimatedSeconds": 180,
      "defaultSpeedWpm": 140,
      "progress": {
        "status": "IN_PROGRESS",
        "completionPercent": 45.0
      }
    }
  ],
  "page": 0,
  "size": 20,
  "totalItems": 1,
  "totalPages": 1
}
```

### GET /lessons/{lessonId}

Returns lesson details without sentences.

### GET /lessons/{lessonId}/sentences

Response:

```json
{
  "lessonId": "uuid",
  "items": [
    {
      "id": "uuid",
      "position": 1,
      "content": "I wake up early every morning.",
      "wordCount": 6
    }
  ]
}
```

## Reading Sessions

### POST /reading-sessions

Starts a reading session.

Request:

```json
{
  "lessonId": "uuid",
  "speedWpm": 140,
  "clientPlatform": "WEB"
}
```

Response `201`:

```json
{
  "id": "uuid",
  "lessonId": "uuid",
  "status": "ACTIVE",
  "speedWpm": 140,
  "startedAt": "2026-07-08T10:00:00Z"
}
```

### PATCH /reading-sessions/{sessionId}

Updates session state.

Request:

```json
{
  "status": "COMPLETED",
  "elapsedSeconds": 182,
  "wordsRead": 430,
  "lastSentencePosition": 14,
  "speedWpm": 150
}
```

Response:

```json
{
  "id": "uuid",
  "status": "COMPLETED",
  "elapsedSeconds": 182,
  "wordsRead": 430,
  "completedAt": "2026-07-08T10:03:02Z"
}
```

## Progress

### GET /progress

Returns current user progress.

Response:

```json
{
  "completedLessons": 4,
  "inProgressLessons": 2,
  "totalWordsRead": 2400,
  "totalSecondsRead": 1260
}
```

### GET /progress/lessons/{lessonId}

Returns progress for one lesson.

## Statistics

### GET /statistics/summary

Response:

```json
{
  "totalReadingSeconds": 1260,
  "totalWordsRead": 2400,
  "averageSpeedWpm": 137,
  "completedLessons": 4,
  "currentStreakDays": 3,
  "longestStreakDays": 8
}
```

### GET /statistics/daily

Query parameters:

- `from`
- `to`

Response:

```json
{
  "items": [
    {
      "date": "2026-07-08",
      "secondsRead": 300,
      "wordsRead": 700,
      "sessionsCompleted": 2
    }
  ]
}
```

## Daily Streak

### GET /streak

Response:

```json
{
  "currentDays": 3,
  "longestDays": 8,
  "lastPracticeDate": "2026-07-08",
  "timezone": "Asia/Kolkata"
}
```

## Future AI APIs

Future endpoints must be added under `/ai` or `/speech` and protected by feature flags.

Planned examples:

- `POST /speech/attempts`
- `GET /speech/attempts/{attemptId}`
- `POST /ai/pronunciation-feedback`
- `POST /ai/coaching-suggestions`

These endpoints must not be implemented in Phase 1.

