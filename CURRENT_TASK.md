# Current Task

## Sprint

Sprint 1: Workspace And Foundations

## Goal

Establish the initial repository foundation only. Do not implement business features.

## Scope Checklist

- [x] Flutter application scaffold under `frontend/english_reading_coach`
- [x] Quarkus backend scaffold under `backend/english-reading-coach-api`
- [x] Docker backend image setup
- [x] Docker Compose setup
- [x] PostgreSQL local configuration
- [x] Environment configuration examples
- [x] GitHub Actions workflows
- [x] Linting configuration
- [x] Formatting configuration
- [x] Logging foundation
- [x] Exception handling foundation
- [x] Backend Clean Architecture package foundation
- [x] Backend DTOs, domain entities, and repository ports
- [x] Backend Panache repository implementations
- [x] Backend BaseResponse, validation mapper, REST configuration, OpenAPI, and health check
- [x] Backend foundation database migration
- [x] Flutter feature-first architecture folder structure
- [x] Flutter Riverpod, GoRouter, Material 3, theme, typography, localization, and navigation foundation
- [x] Flutter shared widgets, base screen, responsive layout, loading state, and error handling
- [x] Flutter network layer foundation
- [x] Project folder structure
- [x] README update
- [x] Launch and verification scripts

## Verification

- [x] Read documentation under `docs/`
- [x] `mvn -B test`
- [x] `flutter analyze`
- [x] `flutter test`
- [x] `./scripts/check_all.sh`
- [x] `flutter build web --release --dart-define=APP_ENV=ci --dart-define=API_BASE_URL=http://localhost:8080/api/v1`
- [x] `mvn -B package -DskipTests`
- [x] `docker compose config`
- [x] `docker build -f infrastructure/docker/backend.Dockerfile -t english-reading-coach-api:verify backend/english-reading-coach-api`
- [ ] `flutter build apk --debug --dart-define=APP_ENV=ci --dart-define=API_BASE_URL=http://localhost:8080/api/v1`

## Current Status

Flutter and backend infrastructure foundations are complete and verified. Foundation scope remains complete and verified except for the Android APK build, which is blocked by the host machine having insufficient disk space. The Android build progressed past project configuration after pinning the valid local NDK version and then failed in the Gradle cache with `No space left on device`.

## Notes

- Business features are intentionally not implemented.
- Backend foundation intentionally adds no business REST APIs.
- Flutter foundation intentionally adds no business screens.
- Backend tooling was adjusted so local verification works on the current Java 25 machine while preserving Java 21 compilation.
- Android is pinned to the valid local NDK `27.1.12297006` because the default NDK path `26.3.11579264` is incomplete on this machine.
