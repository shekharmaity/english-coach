# Git Workflow

## Principles

- Keep changes small and reviewable.
- Every branch should have a clear purpose.
- Documentation changes travel with code changes.
- Never mix unrelated refactors with feature work.
- CI must pass before merge.

## Commit Messages

Use conventional commit style:

```text
type(scope): concise description
```

Examples:

- `feat(reading): add word timing engine`
- `fix(streak): handle user timezone boundary`
- `docs(api): define reading session contract`
- `test(lesson): cover category filtering`

Types:

- `feat`
- `fix`
- `docs`
- `test`
- `refactor`
- `perf`
- `build`
- `ci`
- `chore`

## Pull Requests

Each pull request should include:

- Problem summary.
- Solution summary.
- Screenshots for UI changes.
- API examples for contract changes.
- Migration notes for database changes.
- Test evidence.
- Documentation updates.

## Review Expectations

Reviewers check:

- Correctness.
- Architecture boundaries.
- Error handling.
- Security implications.
- Test coverage.
- Performance risk.
- Documentation accuracy.

## AI Agent Workflow

AI agents must:

- Read relevant docs before editing code.
- Preserve existing user changes.
- Keep edits scoped.
- Explain verification performed.
- Update docs when behavior or architecture changes.

