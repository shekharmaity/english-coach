#!/usr/bin/env sh
set -eu

cd "$(dirname "$0")/../backend/english-reading-coach-api"

export DATABASE_URL="${DATABASE_URL:-jdbc:postgresql://localhost:5432/english_reading_coach}"
export DATABASE_USERNAME="${DATABASE_USERNAME:-english_coach}"
export DATABASE_PASSWORD="${DATABASE_PASSWORD:-english_coach_password}"
export JWT_ISSUER="${JWT_ISSUER:-english-reading-coach-local}"
export JWT_SIGNING_KEY="${JWT_SIGNING_KEY:-local-development-signing-key-change-before-production}"
export CORS_ALLOWED_ORIGINS="${CORS_ALLOWED_ORIGINS:-http://localhost:5173,http://localhost:3000}"
export LOG_LEVEL="${LOG_LEVEL:-INFO}"

mvn quarkus:dev

