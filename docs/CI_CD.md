# CI/CD

## CI Goals

- Catch broken builds quickly.
- Run tests consistently.
- Validate formatting and static analysis.
- Build deployable artifacts.
- Keep frontend and backend contracts aligned.

## GitHub Actions Workflows

Recommended workflows:

- `frontend-ci.yml`
- `backend-ci.yml`
- `docs-ci.yml`
- `release.yml`

## Frontend CI

Steps:

1. Set up Flutter.
2. Install dependencies.
3. Verify formatting.
4. Run static analysis.
5. Run unit and widget tests.
6. Build Web.
7. Build Android artifact on release branches.

## Backend CI

Steps:

1. Set up Java 21.
2. Cache build dependencies.
3. Run formatting or style checks.
4. Run unit tests.
5. Run integration tests with PostgreSQL.
6. Build Quarkus app.
7. Build Docker image on release branches.

## Docs CI

Steps:

1. Check Markdown links where possible.
2. Search for incomplete markers and dummy copy.
3. Validate API examples as JSON when feasible.

## Release CD

Release workflow:

1. Build frontend.
2. Deploy frontend to Cloudflare Pages.
3. Build backend container.
4. Push backend image.
5. Deploy backend container.
6. Run smoke tests.
7. Create release notes from changelog.

## Required Checks

Before merge:

- Flutter analyze.
- Flutter tests.
- Backend tests.
- Docker build for backend when backend changes.
- Documentation completeness check.
