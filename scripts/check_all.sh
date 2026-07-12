#!/usr/bin/env sh
set -eu

ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"

cd "$ROOT_DIR/frontend/english_reading_coach"
dart format --set-exit-if-changed lib test
flutter analyze
flutter test

cd "$ROOT_DIR/backend/english-reading-coach-api"
mvn -B spotless:check test
