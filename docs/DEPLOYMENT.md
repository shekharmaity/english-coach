# Deployment

## Deployment Model

- Flutter Web deploys to Cloudflare Pages.
- Android builds are produced from the Flutter project.
- Quarkus backend runs as a small Docker container.
- PostgreSQL runs as a managed database in production.

## Environments

### Local

- Flutter dev server.
- Quarkus dev mode.
- Local PostgreSQL or Docker Compose PostgreSQL.

### Staging

- Cloudflare Pages preview or staging project.
- Backend staging container.
- Staging PostgreSQL.
- Test secrets.

### Production

- Cloudflare Pages production site.
- Backend production container.
- Managed PostgreSQL with backups.
- Production secrets.

## Backend Container

Container requirements:

- Java 21 runtime or Quarkus native image if later adopted.
- Health endpoint.
- Readiness endpoint.
- Environment-based configuration.
- Non-root runtime user where supported.

## Configuration

Required backend environment variables:

- `DATABASE_URL`
- `DATABASE_USERNAME`
- `DATABASE_PASSWORD`
- `JWT_ISSUER`
- `JWT_SIGNING_KEY`
- `CORS_ALLOWED_ORIGINS`
- `LOG_LEVEL`

Required frontend build variables:

- `API_BASE_URL`
- `APP_ENV`

## Release Procedure

1. Merge release branch after CI passes.
2. Apply backend migrations in staging.
3. Deploy backend staging.
4. Deploy frontend staging.
5. Run smoke tests.
6. Promote backend to production.
7. Promote frontend to production.
8. Verify health checks, auth, lesson browsing, and reading completion.
9. Update changelog.

## Rollback

Frontend rollback:

- Promote previous Cloudflare Pages deployment.

Backend rollback:

- Redeploy previous container image when database migration compatibility allows it.
- Migrations must be designed so rollback risk is understood before release.

Database rollback:

- Prefer forward-fix migrations.
- Use backups for severe data corruption events.

