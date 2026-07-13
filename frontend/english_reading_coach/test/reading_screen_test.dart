import 'package:english_reading_coach/app/theme.dart';
import 'package:english_reading_coach/features/reading/presentation/reading_screen.dart';
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  Future<void> pumpReadingScreen(
    WidgetTester tester, {
    Size? surfaceSize,
  }) async {
    addTearDown(() async {
      tester.view.resetPhysicalSize();
      tester.view.resetDevicePixelRatio();
    });

    if (surfaceSize != null) {
      tester.view.physicalSize = surfaceSize;
      tester.view.devicePixelRatio = 1;
    }

    await tester.pumpWidget(
      MaterialApp(
        theme: buildLightTheme(),
        darkTheme: buildDarkTheme(),
        home: const ReadingScreen(),
      ),
    );
    await tester.pumpAndSettle();
  }

  testWidgets('displays lesson title and sample sentence', (
    WidgetTester tester,
  ) async {
    await pumpReadingScreen(tester);

    expect(find.text('Lesson 5'), findsOneWidget);
    expect(find.text('Daily Conversation'), findsOneWidget);
    for (final word in ['Every', 'day', 'learn,', 'confident.']) {
      expect(find.text(word), findsOneWidget);
    }
    expect(find.text('opportunity'), findsNWidgets(2));
  });

  testWidgets('marks the demo active word with active styling', (
    WidgetTester tester,
  ) async {
    await pumpReadingScreen(tester);

    final activeWordFinder = find.byKey(
      const ValueKey<String>('active-reading-word'),
    );

    expect(activeWordFinder, findsOneWidget);

    final activeWord = tester.widget<DecoratedBox>(activeWordFinder);
    final decoration = activeWord.decoration as BoxDecoration;

    expect(decoration.color, isNot(Colors.transparent));
    expect(
      find.descendant(of: activeWordFinder, matching: find.text('opportunity')),
      findsOneWidget,
    );
  });

  testWidgets('displays progress information', (WidgetTester tester) async {
    await pumpReadingScreen(tester);

    expect(find.text('Sentence 3 / 20'), findsOneWidget);
    expect(find.text('Estimated time'), findsOneWidget);
    expect(find.text('2 min'), findsOneWidget);
    expect(find.text('120 WPM'), findsOneWidget);
  });

  testWidgets('font size can be increased and decreased', (
    WidgetTester tester,
  ) async {
    await pumpReadingScreen(tester);

    Text everyWord = tester.widget<Text>(find.text('Every'));
    expect(everyWord.style?.fontSize, 34);

    final increaseButton = find.byKey(
      const ValueKey<String>('increase-font-size-button'),
    );
    final decreaseButton = find.byKey(
      const ValueKey<String>('decrease-font-size-button'),
    );

    await tester.ensureVisible(increaseButton);
    await tester.pumpAndSettle();
    await tester.tap(increaseButton);
    await tester.pumpAndSettle();
    everyWord = tester.widget<Text>(find.text('Every'));
    expect(everyWord.style?.fontSize, 36);

    await tester.ensureVisible(decreaseButton);
    await tester.pumpAndSettle();
    await tester.tap(decreaseButton);
    await tester.pumpAndSettle();
    everyWord = tester.widget<Text>(find.text('Every'));
    expect(everyWord.style?.fontSize, 34);
  });

  testWidgets('reading speed changes when slider moves', (
    WidgetTester tester,
  ) async {
    await pumpReadingScreen(tester);

    expect(find.text('120 WPM'), findsOneWidget);

    final speedSlider = find.byKey(
      const ValueKey<String>('reading-speed-slider'),
    );

    await tester.ensureVisible(speedSlider);
    await tester.pumpAndSettle();
    await tester.drag(speedSlider, const Offset(120, 0));
    await tester.pumpAndSettle();

    expect(find.text('120 WPM'), findsNothing);
  });

  testWidgets('renders without overflow at a narrow mobile size', (
    WidgetTester tester,
  ) async {
    await pumpReadingScreen(tester, surfaceSize: const Size(390, 844));

    expect(find.byType(ReadingScreen), findsOneWidget);
    expect(tester.takeException(), isNull);
  });

  testWidgets('renders without overflow at a desktop size', (
    WidgetTester tester,
  ) async {
    await pumpReadingScreen(tester, surfaceSize: const Size(1440, 900));

    expect(find.byType(ReadingScreen), findsOneWidget);
    expect(tester.takeException(), isNull);
  });
}
