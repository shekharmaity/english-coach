# Sprint Plan

Each sprint is planned as a two-week increment. The sequence prioritizes architecture, vertical slices, and early validation of the reading experience.

## Sprint 1: Workspace And Foundations

Goal: Establish the monorepo, project skeletons, tooling, and baseline CI.

Stories:

- Create Flutter project under `frontend/`.
- Create Quarkus project under `backend/`.
- Add shared documentation and contribution workflow.
- Configure baseline GitHub Actions.
- Add Docker Compose for local PostgreSQL.

Acceptance Criteria:

- Flutter app boots locally.
- Quarkus app boots locally.
- PostgreSQL runs locally.
- CI validates formatting and tests.
- Documentation is discoverable from `docs/README.md`.

Deliverables:

- Repository structure.
- Empty app shell.
- Backend health endpoint.
- Local development instructions.

Definition of Done:

- CI passes.
- Docs reflect actual commands.
- No generated secrets committed.

## Sprint 2: Design System And Navigation

Goal: Build the visual foundation and app navigation.

Stories:

- Implement Material 3 theme.
- Add light and dark theme support.
- Configure GoRouter.
- Create responsive shell layout.
- Build reusable buttons, empty states, error banners, and loading states.

Acceptance Criteria:

- App navigates between Home, Lessons, Statistics, and Profile.
- Layout adapts across mobile, tablet, and desktop.
- Theme tokens are centralized.

Deliverables:

- App shell.
- Theme configuration.
- Shared UI component library.

Definition of Done:

- Widget tests cover navigation and shared states.
- UI aligns with design system docs.

## Sprint 3: Authentication

Goal: Implement secure registration, login, token refresh, and logout.

Stories:

- Add users and refresh token schema.
- Implement register endpoint.
- Implement login endpoint.
- Implement token refresh.
- Implement logout.
- Build Flutter auth screens.
- Persist auth state securely.

Acceptance Criteria:

- User can register and sign in.
- Access token protects authenticated endpoints.
- Refresh token rotation works.
- Logout revokes refresh token.

Deliverables:

- Auth API.
- Auth UI.
- Auth Riverpod state.
- Auth tests.

Definition of Done:

- Passwords are hashed.
- Unauthorized requests return standard error envelope.
- API and UI tests pass.

## Sprint 4: Categories And Lesson Catalog

Goal: Let users browse published categories and lessons.

Stories:

- Add categories, lessons, and sentences schema.
- Seed starter content.
- Implement category list endpoint.
- Implement lesson list and detail endpoints.
- Build category and lesson browsing UI.
- Show authenticated user progress status when progress data exists.

Acceptance Criteria:

- Published lessons appear by category.
- Lesson details load correctly.
- Unpublished lessons are hidden from users.

Deliverables:

- Catalog API.
- Lesson browsing UI.
- Seed data migration.

Definition of Done:

- Repository and API tests cover filtering.
- Responsive UI verified.

## Sprint 5: Reading Engine

Goal: Build deterministic word-by-word reading behavior.

Stories:

- Implement sentence tokenization.
- Implement timing engine based on WPM.
- Implement pause, resume, restart, and speed changes.
- Build reading screen.
- Add active word highlighting.

Acceptance Criteria:

- Active word changes according to speed.
- Pause freezes elapsed time and highlight.
- Resume continues from the same position.
- Speed changes apply predictably.

Deliverables:

- Reading domain engine.
- Reading screen UI.
- Unit and widget tests.

Definition of Done:

- Timing engine has deterministic unit tests.
- Reading screen is usable on mobile and desktop.

## Sprint 6: Reading Sessions And Progress

Goal: Persist reading attempts and lesson progress.

Stories:

- Add reading session schema.
- Add progress schema.
- Implement session start endpoint.
- Implement session update endpoint.
- Update lesson progress on completion.
- Connect Flutter reading screen to backend.

Acceptance Criteria:

- Starting a lesson creates a session.
- Completing a lesson updates progress.
- Progress survives logout and device change.

Deliverables:

- Reading session API.
- Progress update logic.
- Integrated reading completion flow.

Definition of Done:

- Backend service tests cover completion rules.
- Flutter integration test completes a lesson.

## Sprint 7: Daily Streak

Goal: Track daily reading habit correctly across time zones.

Stories:

- Add daily streak schema.
- Implement streak calculation service.
- Update streak on completed sessions.
- Build streak summary UI.
- Handle user preferred time zone.

Acceptance Criteria:

- Completing a session updates today's practice date.
- Current and longest streak values are correct.
- Missed days reset current streak without deleting history.

Deliverables:

- Streak API.
- Streak domain service.
- Streak UI component.

Definition of Done:

- Unit tests cover timezone boundaries.
- Statistics and dashboard display streak consistently.

## Sprint 8: Statistics

Goal: Give users clear insight into reading activity.

Stories:

- Implement statistics summary endpoint.
- Implement daily statistics endpoint.
- Build statistics screen.
- Show words read, time read, speed, completed lessons, and streaks.
- Add empty state for new users.

Acceptance Criteria:

- Statistics match persisted sessions.
- Charts are readable on mobile and desktop.
- Empty states guide users to start reading.

Deliverables:

- Statistics API.
- Statistics UI.
- Tests for aggregation logic.

Definition of Done:

- API tests cover date ranges.
- UI tests cover empty and populated states.

## Sprint 9: Polish, Accessibility, And Performance

Goal: Refine the experience before release hardening.

Stories:

- Improve loading and error states.
- Audit accessibility.
- Optimize reading screen rendering.
- Add responsive visual checks.
- Add performance budgets to CI where feasible.

Acceptance Criteria:

- Reading screen remains smooth.
- Text scaling does not break core screens.
- Keyboard navigation works on Web.
- Common errors are recoverable.

Deliverables:

- Accessibility fixes.
- Performance improvements.
- QA checklist results.

Definition of Done:

- Manual QA checklist completed.
- Performance risks documented.

## Sprint 10: Release Candidate

Goal: Prepare Version 1.0 release candidate.

Stories:

- Finalize Docker deployment.
- Finalize Cloudflare Pages deployment.
- Add production configuration documentation.
- Run full regression testing.
- Update changelog.
- Tag release candidate.

Acceptance Criteria:

- Staging deployment is successful.
- Smoke tests pass.
- Release notes are accurate.
- Known issues are documented.

Deliverables:

- Version 1.0 release candidate.
- Deployment runbook.
- Updated docs.

Definition of Done:

- CI passes on release branch.
- Product owner accepts release candidate.
- Rollback path is documented.
