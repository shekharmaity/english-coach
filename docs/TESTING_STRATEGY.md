# Testing Strategy

## Testing Goals

- Protect the reading experience.
- Prevent progress and streak regressions.
- Keep API behavior stable.
- Make refactoring safe.
- Catch responsive and accessibility issues before release.

## Frontend Tests

### Unit Tests

Cover:

- Reading timing calculations.
- Word tokenization.
- Speed changes.
- Progress percentage calculations.
- Streak display formatting.
- DTO mapping.

### Widget Tests

Cover:

- Reading sentence rendering.
- Active word highlighting.
- Pause and resume controls.
- Speed control behavior.
- Empty states.
- Error states.
- Lesson cards and category filters.

### Integration Tests

Cover:

- Register or login.
- Browse lessons.
- Start lesson.
- Complete reading session.
- View updated progress and streak.

## Backend Tests

### Unit Tests

Cover:

- Service-layer business rules.
- Streak calculation.
- Progress update logic.
- Validation edge cases.
- Domain exceptions.

### API Tests

Cover:

- Auth flows.
- Category listing.
- Lesson listing and details.
- Session creation and completion.
- Progress and statistics endpoints.
- Unauthorized and forbidden access.

### Database Tests

Use test containers or an equivalent PostgreSQL-backed test strategy.

Cover:

- Flyway migrations.
- Repository queries.
- Constraints.
- Unique indexes.
- Transaction behavior.

## Manual QA

Before each release:

- Test Web on Chrome, Safari, Firefox, and Edge.
- Test Android on a small phone and a large phone.
- Test light and dark theme.
- Test slow network behavior.
- Test text scaling.
- Test sign out and token expiry.
- Test streak behavior across time zone boundaries.

## Definition Of Done For Tests

A story is not complete unless:

- Relevant automated tests pass.
- New domain rules have unit tests.
- API changes have contract tests.
- UI changes have widget or integration coverage when behavior matters.
- Manual QA notes are recorded for release candidates.

