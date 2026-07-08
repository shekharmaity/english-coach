# Branching Strategy

## Branches

### main

`main` represents production-ready code. It must always pass CI.

### develop

`develop` may be used while the project is pre-1.0 to collect integrated work before release branches. If the team prefers trunk-based development, this branch can be removed by ADR.

### feature/*

Used for new product functionality.

Example:

```text
feature/reading-session-engine
```

### fix/*

Used for defects.

Example:

```text
fix/streak-timezone-boundary
```

### docs/*

Used for documentation-only work.

Example:

```text
docs/api-contract-progress
```

### release/*

Used to stabilize a version.

Example:

```text
release/1.0.0
```

### hotfix/*

Used for urgent production fixes.

Example:

```text
hotfix/login-token-refresh
```

## Merge Rules

- Pull requests are required for `main`.
- CI must pass.
- At least one review is required once multiple contributors exist.
- Release branches merge back into `main` and `develop` when `develop` is used.

## Version Tags

Use semantic version tags:

```text
v1.0.0
v1.0.1
v1.1.0
```

