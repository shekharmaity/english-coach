import 'package:flutter/material.dart';

class ReadingWord extends StatelessWidget {
  const ReadingWord({
    required this.word,
    required this.isActive,
    required this.fontSize,
    super.key,
  });

  final String word;
  final bool isActive;
  final double fontSize;

  @override
  Widget build(BuildContext context) {
    final colorScheme = Theme.of(context).colorScheme;
    final baseStyle = Theme.of(context).textTheme.headlineMedium;

    return DecoratedBox(
      key: isActive ? const ValueKey<String>('active-reading-word') : null,
      decoration: BoxDecoration(
        color: isActive ? colorScheme.primaryContainer : Colors.transparent,
        borderRadius: BorderRadius.circular(6),
      ),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 4, vertical: 3),
        child: Text(
          word,
          style: baseStyle?.copyWith(
            color: isActive
                ? colorScheme.onPrimaryContainer
                : colorScheme.onSurface,
            fontSize: fontSize,
            height: 1.35,
            fontWeight: isActive ? FontWeight.w800 : FontWeight.w600,
          ),
        ),
      ),
    );
  }
}
