# Performance

## Performance Goals

- Reading screen remains smooth at 60 frames per second on modern Android devices and desktop browsers.
- Common API requests complete under 300 ms p95 for early production traffic.
- Flutter Web first meaningful interaction remains fast enough for daily use.
- Database queries for lesson browsing, progress, and statistics use indexes effectively.

## Frontend Budgets

Reading screen:

- Avoid unnecessary rebuilds during highlighting.
- Keep active word updates localized.
- Do not perform network calls on every word change.
- Persist progress at session milestones rather than every tick.

Web:

- Keep initial route lightweight.
- Lazy-load heavy screens if needed.
- Compress assets.
- Avoid oversized images in Phase 1.

Android:

- Test on lower-memory devices.
- Avoid expensive layout recalculation during timer updates.
- Use const widgets where appropriate.

## Backend Budgets

Targets:

- Auth endpoints p95 below 500 ms.
- Lesson list p95 below 300 ms.
- Lesson sentences p95 below 300 ms.
- Reading session completion p95 below 500 ms.
- Statistics summary p95 below 700 ms.

## Database Performance

Critical queries:

- List published lessons by category.
- Load sentences by lesson position.
- Fetch user progress by lesson.
- Aggregate reading sessions by user and date.
- Calculate streaks from daily records.

Indexing is defined in [DATABASE.md](DATABASE.md). Any new query added to a hot path must be reviewed for index coverage.

## Measurement

Frontend:

- Flutter DevTools performance profiling.
- Browser Lighthouse checks for Web.
- Manual reading screen smoothness checks.

Backend:

- Request timing logs.
- Database query logs in non-production debugging.
- Load tests before public launch.

## Performance Anti-Patterns

- Rebuilding the full reading screen on every timer tick.
- Saving progress after every highlighted word.
- Loading all lessons and sentences for all categories at startup.
- Returning JPA entities directly from APIs.
- Calculating all statistics client-side from raw session history.

