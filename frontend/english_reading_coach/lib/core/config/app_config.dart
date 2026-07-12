import 'package:flutter_riverpod/flutter_riverpod.dart';

final Provider<AppConfig> appConfigProvider = Provider<AppConfig>((ref) {
  return const AppConfig.fromEnvironment();
});

class AppConfig {
  const AppConfig({required this.apiBaseUrl, required this.environment});

  const AppConfig.fromEnvironment()
    : apiBaseUrl = const String.fromEnvironment(
        'API_BASE_URL',
        defaultValue: 'http://localhost:8080/api/v1',
      ),
      environment = const String.fromEnvironment(
        'APP_ENV',
        defaultValue: 'local',
      );

  final String apiBaseUrl;
  final String environment;
}
