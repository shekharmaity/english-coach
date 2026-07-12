import 'package:english_reading_coach/app/app.dart';
import 'package:english_reading_coach/core/config/app_config.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

void main() {
  testWidgets('renders foundation app shell', (WidgetTester tester) async {
    await tester.pumpWidget(
      ProviderScope(
        overrides: [
          appConfigProvider.overrideWithValue(
            const AppConfig(
              apiBaseUrl: 'http://localhost:8080/api/v1',
              environment: 'test',
            ),
          ),
        ],
        child: const EnglishReadingCoachApp(),
      ),
    );

    expect(find.text('English Reading Coach'), findsOneWidget);
    expect(find.text('Foundation Ready'), findsOneWidget);
    expect(find.text('test'), findsOneWidget);
  });
}
