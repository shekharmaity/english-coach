# Cloudflare Pages

Flutter Web will be deployed to Cloudflare Pages in a later release task.

Recommended production build command:

```sh
cd frontend/english_reading_coach
flutter build web --release --dart-define=APP_ENV=production --dart-define=API_BASE_URL=https://api.englishreadingcoach.com/api/v1
```

Recommended output directory:

```text
frontend/english_reading_coach/build/web
```

