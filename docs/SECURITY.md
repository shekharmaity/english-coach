# Security

## Security Goals

- Protect user accounts.
- Protect progress and reading history.
- Prevent unauthorized access to private data.
- Keep deployment secrets out of source control.
- Build a foundation suitable for future voice and AI data.

## Authentication

- Use email and password in Phase 1.
- Hash passwords with a strong adaptive algorithm such as Argon2id or bcrypt.
- Issue short-lived JWT access tokens.
- Use refresh token rotation.
- Store refresh token hashes in the database.
- Revoke refresh tokens on logout.

## Authorization

Roles:

- `USER`: reads published lessons and manages own progress.
- `ADMIN`: manages content and can view operational data.

Rules:

- Users can only access their own progress, sessions, statistics, and streaks.
- Public lesson metadata may be accessible without authentication only if product requirements later allow guest browsing.
- Administrative APIs must require admin role and audit logging.

## Token Storage

Flutter Web token storage is sensitive. Prefer secure, HTTP-only cookie flows if the backend and hosting model support it. If bearer token storage is used, minimize token lifetime, rotate refresh tokens, and reduce XSS risk through strict frontend hygiene.

Android should use secure storage for refresh tokens.

## Input Validation

Validate:

- Email format.
- Password length and complexity.
- UUID path parameters.
- Enum values.
- Pagination bounds.
- Reading speed range.
- Time and progress counters.

## Secrets

Secrets must be managed through deployment platform secret stores:

- Database URL.
- Database credentials.
- JWT signing key.
- Password hashing parameters if externally configured.
- Future AI provider keys.

Secrets must never appear in code, docs examples with real values, logs, screenshots, or issue comments.

## Logging

Log:

- Request trace ID.
- Auth failures without credential values.
- API latency.
- Server errors.
- Migration and startup events.

Do not log:

- Passwords.
- Tokens.
- Authorization headers.
- Full user profiles when unnecessary.
- Future audio transcripts unless explicitly approved.

## Future Voice And AI Privacy

Before Phase 2 or Phase 3:

- Add clear consent for microphone use.
- Define audio retention policy.
- Allow deletion of voice attempts.
- Review third-party AI provider data handling.
- Add cost and abuse controls.

