# Risks

## Product Risks

### Reading Experience Is Not Differentiated

Impact: Users may not return if the reading flow feels ordinary.

Mitigation:

- Prioritize reading screen polish early.
- Test word highlighting with real learners.
- Keep controls simple and satisfying.

### Scope Creep Into AI Too Early

Impact: Phase 1 delivery slows and architecture becomes overcomplicated.

Mitigation:

- Enforce ADR-006.
- Keep future AI APIs documented but unimplemented.
- Evaluate AI only after reading retention is validated.

## Technical Risks

### Timing Drift In Reading Highlight

Impact: Highlighting may feel inaccurate or distracting.

Mitigation:

- Make timing engine deterministic.
- Unit test speed changes, pause, resume, and elapsed time.
- Avoid frame-dependent business logic.

### Streak Incorrect Across Time Zones

Impact: Users lose trust if streaks are wrong.

Mitigation:

- Store preferred time zone.
- Calculate practice date server-side.
- Add boundary tests.

### Flutter Web Performance Issues

Impact: Desktop users may see jank or slow first load.

Mitigation:

- Keep initial bundle lean.
- Avoid unnecessary rebuilds.
- Use performance budgets.

## Security Risks

### Token Theft In Web Context

Impact: Unauthorized access to user progress.

Mitigation:

- Use short-lived access tokens.
- Rotate refresh tokens.
- Consider HTTP-only cookies for production.
- Harden against XSS.

### Future Voice Data Sensitivity

Impact: Privacy and compliance risk in later phases.

Mitigation:

- Do not collect voice in Phase 1.
- Add consent and retention policy before Phase 2.

## Delivery Risks

### Documentation Becomes Stale

Impact: AI agents and developers make incorrect assumptions.

Mitigation:

- Require docs updates in pull requests.
- Keep ADRs append-only for decision history.
- Add docs checks in CI.

