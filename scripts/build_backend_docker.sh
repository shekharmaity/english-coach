#!/usr/bin/env sh
set -eu

docker build \
  -f infrastructure/docker/backend.Dockerfile \
  -t english-reading-coach-api:local \
  backend/english-reading-coach-api

