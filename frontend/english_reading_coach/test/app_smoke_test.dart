import 'package:english_reading_coach/app/app.dart';
import 'package:english_reading_coach/app/router.dart';
import 'package:english_reading_coach/core/config/app_config.dart';
import 'package:english_reading_coach/features/reading/presentation/reading_screen.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

void main() {
  testWidgets('launches into reading demo screen', (WidgetTester tester) async {
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

    expect(find.text('Lesson 5'), findsOneWidget);
    expect(find.text('Daily Conversation'), findsOneWidget);
    expect(find.byType(ReadingScreen), findsOneWidget);
    expect(find.text('Sentence 3 / 20'), findsOneWidget);
  });

  testWidgets('opens reading demo route', (WidgetTester tester) async {
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

    final container = ProviderScope.containerOf(
      tester.element(find.byType(EnglishReadingCoachApp)),
    );
    final router = container.read(appRouterProvider);
    router.go(AppRoute.readingDemo.path);
    await tester.pumpAndSettle();

    expect(find.text('Lesson 5'), findsOneWidget);
    expect(find.text('Daily Conversation'), findsOneWidget);
  });
}
