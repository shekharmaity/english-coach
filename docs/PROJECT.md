# Project

## Name

English Reading Coach

## Product Summary

English Reading Coach helps learners practice spoken English by reading well-structured sentences at a comfortable pace. The application guides the user through text with synchronized word highlighting, speed control, timers, lesson progress, daily streaks, and statistics.

The product is not a flashcard app, grammar workbook, or AI tutor in Phase 1. It is a high-quality reading practice tool focused on rhythm, consistency, comprehension, and confidence.

## Primary Users

- Beginner and intermediate English learners who want regular speaking practice.
- Learners preparing for interviews, school, travel, or workplace conversations.
- Users who prefer guided reading practice over open-ended speaking exercises.
- Teachers or coaches who may later assign lessons to students.

## User Problems

- Learners often read too quickly or too slowly and lose rhythm.
- Many reading apps do not provide clear pacing feedback.
- Learners need visible progress to keep daily motivation.
- Lessons are often not organized by speaking context or difficulty.
- Mobile and web experiences are frequently inconsistent.

## Product Goals

- Make reading practice calm, beautiful, and focused.
- Help users complete short daily reading sessions.
- Make progress visible without making the app feel like a game first.
- Keep the architecture extensible for speech and AI features later.
- Provide a production-ready backend that can support real user accounts.

## Non-Goals For Phase 1

- Do not implement AI pronunciation feedback.
- Do not record, upload, or analyze voice.
- Do not build teacher dashboards.
- Do not build payments or subscriptions.
- Do not optimize for social sharing before retention is proven.

## Success Metrics

- A new user can start a reading lesson within 60 seconds of registration.
- At least 90% of users can complete the first lesson without confusion in usability testing.
- Reading screen remains smooth at 60 frames per second on modern Android phones and desktop browsers.
- Lesson progress persists correctly across Web and Android.
- Streak count is correct across time zones and missed days.
- Backend p95 API latency for common reads remains below 300 ms under expected early traffic.

## Platforms

- Flutter Web, hosted through Cloudflare Pages.
- Android app, built from the same Flutter codebase.
- Java 21 Quarkus backend in a small Docker container.
- PostgreSQL database.

## Delivery Principles

- Ship vertical slices that include UI, API, database, tests, and documentation.
- Prefer simple domain concepts over clever abstractions.
- Keep Phase 1 clean and focused so Phase 2 can add speech features without rework.
- Make every important decision visible in documentation.
- Treat automated tests, migrations, and API contracts as product assets.

