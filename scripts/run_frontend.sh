#!/usr/bin/env sh
set -eu

cd "$(dirname "$0")/../frontend/english_reading_coach"

API_BASE_URL="${API_BASE_URL:-http://localhost:8080/api/v1}"
APP_ENV="${APP_ENV:-local}"
FRONTEND_PORT="${FRONTEND_PORT:-5173}"

flutter run -d chrome --web-port "$FRONTEND_PORT" \
  --dart-define "API_BASE_URL=$API_BASE_URL" \
  --dart-define "APP_ENV=$APP_ENV"

