# Contributing

## Before You Start

Read:

- [PROJECT.md](PROJECT.md)
- [ARCHITECTURE.md](ARCHITECTURE.md)
- [CODING_STANDARDS.md](CODING_STANDARDS.md)
- Relevant feature documents for the change.

## Development Setup

Expected local tools:

- Flutter stable channel.
- Java 21.
- Docker.
- PostgreSQL or Docker Compose.
- GitHub CLI if working with pull requests.

## Contribution Rules

- Keep work scoped to one feature or fix.
- Add tests for behavior changes.
- Update docs when architecture, API, database, deployment, or user behavior changes.
- Do not introduce AI features in Phase 1.
- Do not commit secrets.
- Do not bypass architecture boundaries for speed.

## Pull Request Checklist

- Code builds locally.
- Tests pass.
- Formatting and static analysis pass.
- API changes are documented.
- Database changes include migrations.
- UI changes include screenshots.
- Security implications are considered.
- Documentation is updated.

## AI Agent Instructions

AI agents contributing to this repository must:

- Inspect existing files before editing.
- Preserve user changes.
- Use small, focused edits.
- Avoid inventing dependencies when existing patterns solve the problem.
- Provide verification results in the final response.
- Avoid incomplete filler in committed documentation.
