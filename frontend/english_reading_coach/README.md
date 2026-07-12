# English Reading Coach Frontend

Flutter Web and Android foundation app for English Reading Coach.

## Run

```sh
flutter run -d chrome --dart-define=API_BASE_URL=http://localhost:8080/api/v1 --dart-define=APP_ENV=local
```

## Check

```sh
dart format --set-exit-if-changed lib test
flutter analyze
flutter test
```
