import 'dart:developer' as developer;

class AppLogger {
  const AppLogger._();

  static late String _environment;

  static void configure(String environment) {
    _environment = environment;
    info('Flutter app configured for $_environment');
  }

  static void info(String message) {
    developer.log(message, name: 'EnglishReadingCoach');
  }

  static void error(String message, Object error, StackTrace stackTrace) {
    developer.log(
      message,
      name: 'EnglishReadingCoach',
      error: error,
      stackTrace: stackTrace,
      level: 1000,
    );
  }
}
