import 'package:flutter/material.dart';

import '../../../../shared/design/app_spacing.dart';
import 'reading_word.dart';

class ReadingSentenceView extends StatelessWidget {
  const ReadingSentenceView({
    required this.sentence,
    required this.words,
    required this.activeWordIndex,
    required this.fontSize,
    super.key,
  });

  final String sentence;
  final List<String> words;
  final int activeWordIndex;
  final double fontSize;

  @override
  Widget build(BuildContext context) {
    final colorScheme = Theme.of(context).colorScheme;

    return Semantics(
      label: sentence,
      child: DecoratedBox(
        decoration: BoxDecoration(
          color: colorScheme.surface,
          borderRadius: BorderRadius.circular(8),
        ),
        child: Padding(
          padding: const EdgeInsets.symmetric(
            horizontal: AppSpacing.sm,
            vertical: AppSpacing.lg,
          ),
          child: Center(
            child: ConstrainedBox(
              constraints: const BoxConstraints(maxWidth: 760),
              child: Wrap(
                alignment: WrapAlignment.start,
                spacing: AppSpacing.xs,
                runSpacing: AppSpacing.sm,
                children: [
                  for (final entry in words.indexed)
                    ReadingWord(
                      word: entry.$2,
                      isActive: entry.$1 == activeWordIndex,
                      fontSize: fontSize,
                    ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
