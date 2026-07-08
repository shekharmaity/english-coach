# State Management

## Library

Flutter state management uses Riverpod.

## State Categories

### App State

Examples:

- Authentication state.
- Current user profile.
- Theme preference.
- API configuration.

Use long-lived providers with clear invalidation rules.

### Server State

Examples:

- Categories.
- Lessons.
- Sentences.
- Progress.
- Statistics.

Server state should be fetched through repositories and exposed through Riverpod providers. Cache only when it improves experience and does not risk stale progress.

### Screen State

Examples:

- Selected category filter.
- Current page index.
- Form input.
- Loading and error state.

Use scoped providers or widget state depending on reuse and testability.

### Reading Session State

Reading session state includes:

- Current lesson.
- Current sentence index.
- Active word index.
- Speed WPM.
- Elapsed time.
- Pause state.
- Completion state.
- Pending save state.

This state must be deterministic and testable. Timing logic should live in a controller or use case that can be unit tested without rendering widgets.

## Provider Naming

- `authStateProvider`
- `categoryListProvider`
- `lessonDetailProvider`
- `readingSessionControllerProvider`
- `statisticsSummaryProvider`

## Riverpod Rules

- Providers may depend on repository contracts, not concrete API clients directly.
- Avoid placing large business decisions inside widget `build` methods.
- Keep provider invalidation explicit after mutations.
- Separate query providers from mutation controllers.
- Prefer `AsyncValue` handling that covers loading, data, and error.

## Offline And Retry Behavior

Phase 1 does not require full offline mode. The reading screen should preserve in-memory progress during transient network failures and retry session completion when possible.

## Persistence

Local persistence may store:

- Access token and refresh token using secure storage where available.
- Theme preference.
- Last selected speed.
- Last opened lesson for convenience.

Local persistence must not be treated as the source of truth for completed progress.

