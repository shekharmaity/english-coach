# Coding Standards

## General Standards

- Code must be clear before it is clever.
- Business logic belongs outside UI components and HTTP controllers.
- Every public API should have predictable names, types, and errors.
- Prefer small functions with a single reason to change.
- Avoid duplication across features by extracting shared behavior only after the pattern is proven.
- Use explicit domain language: lesson, sentence, reading session, progress, streak.
- Keep documentation in sync with behavior.

## Flutter Standards

- Use Dart null safety.
- Use feature-first folders.
- Use Riverpod for state management.
- Use GoRouter for navigation.
- Use Material 3 components and theme tokens.
- Keep widgets small and reusable.
- Keep screens responsible for composition, not business decisions.
- Use immutable models.
- Use DTO mappers between API data and domain models.
- Use generated serialization when the project introduces code generation.

Naming:

- Files: `snake_case.dart`
- Classes: `PascalCase`
- Providers: `camelCaseProvider`
- Private members: `_camelCase`
- Tests: `feature_behavior_test.dart`

## Java And Quarkus Standards

- Use Java 21 language features where they improve clarity.
- Use Quarkus REST for HTTP resources.
- Use Hibernate Panache repositories for persistence.
- Use service classes for transactional business operations.
- Use DTOs for requests and responses.
- Use Bean Validation for request validation.
- Keep JPA entities away from API responses.
- Use constructor injection.
- Use package-private helpers when broader visibility is unnecessary.

Naming:

- Resources: `LessonResource`
- Services: `LessonService`
- Repositories: `LessonRepository`
- Request DTOs: `CreateReadingSessionRequest`
- Response DTOs: `LessonResponse`
- Exceptions: `LessonNotFoundException`

## Error Handling

Frontend:

- Map API errors to user-safe messages.
- Preserve technical details in logs, not UI copy.
- Provide retry actions for transient errors.
- Never crash the reading screen for recoverable network issues.

Backend:

- Use domain-specific exceptions.
- Convert exceptions to the standard error envelope.
- Include trace IDs in logs and responses.
- Do not expose stack traces to clients.

## Time Handling

- Store server timestamps in UTC.
- Track streaks by user-local date using the user's preferred time zone.
- Never calculate streaks from device-local time without server validation.

## Security Standards

- Never store plaintext passwords.
- Never log credentials, JWTs, refresh tokens, or password reset tokens.
- Validate all client input.
- Use HTTPS in production.
- Keep secrets outside source control.

## Review Standards

Every pull request must answer:

- Does this preserve Clean Architecture boundaries?
- Are tests proportional to risk?
- Does the change update docs when behavior changes?
- Are error states handled?
- Is the UI accessible and responsive?
- Are migrations backward compatible?

