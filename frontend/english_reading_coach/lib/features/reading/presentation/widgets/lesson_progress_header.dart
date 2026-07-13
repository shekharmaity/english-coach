import 'package:flutter/material.dart';

import '../../../../shared/design/app_spacing.dart';

class LessonProgressHeader extends StatelessWidget {
  const LessonProgressHeader({
    required this.currentSentenceNumber,
    required this.totalSentences,
    required this.completionPercent,
    super.key,
  });

  final int currentSentenceNumber;
  final int totalSentences;
  final double completionPercent;

  @override
  Widget build(BuildContext context) {
    final textTheme = Theme.of(context).textTheme;
    final colorScheme = Theme.of(context).colorScheme;
    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Center(
          child: Text(
            'Sentence $currentSentenceNumber / $totalSentences',
            style: textTheme.titleMedium?.copyWith(
              color: colorScheme.onSurface,
              fontWeight: FontWeight.w800,
            ),
          ),
        ),
        const SizedBox(height: AppSpacing.md),
        Semantics(
          label: 'Sentence progress $currentSentenceNumber of $totalSentences',
          child: LinearProgressIndicator(
            minHeight: 10,
            borderRadius: BorderRadius.circular(999),
            value: completionPercent,
          ),
        ),
      ],
    );
  }
}
