# English Reading Coach

English Reading Coach is a Flutter Web + Android and Java 21 Quarkus project for guided English reading practice. This repository currently contains the initial engineering foundation only. Business features are intentionally not implemented yet.

## Repository Layout

```text
docs/                         Long-term project documentation
frontend/english_reading_coach Flutter Web and Android app
backend/english-reading-coach-api Java 21 Quarkus API
infrastructure/               Docker and deployment support
scripts/                      Local launch and verification scripts
.github/workflows/            CI workflows
```

## Prerequisites

- Flutter stable channel
- Java 21 for backend builds
- Maven 3.9+
- Docker

The current backend is configured for Java 21. If the local machine has only Java 17, use the Docker build path until Java 21 is installed locally.

## Local Setup

Copy environment files:

```sh
cp .env.example .env
cp backend/english-reading-coach-api/.env.example backend/english-reading-coach-api/.env
cp frontend/english_reading_coach/.env.example frontend/english_reading_coach/.env
```

Start PostgreSQL:

```sh
docker compose up -d postgres
```

Run the backend:

```sh
./scripts/run_backend.sh
```

Run the frontend:

```sh
./scripts/run_frontend.sh
```

Run checks:

```sh
./scripts/check_all.sh
```

## Foundation Endpoints

- Backend app health: `GET http://localhost:8080/api/v1/health`
- Quarkus health: `GET http://localhost:8080/q/health`

## Documentation

Start with [docs/README.md](docs/README.md). The implementation must continue to follow the architecture, coding, testing, deployment, and Phase 1 no-AI boundaries documented there.

