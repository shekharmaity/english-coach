import 'package:flutter/material.dart';

import '../../../../shared/design/app_spacing.dart';

class ReadingPreferences extends StatelessWidget {
  const ReadingPreferences({
    required this.speedWpm,
    required this.fontSize,
    required this.estimatedTimeLabel,
    required this.onSpeedChanged,
    required this.onDecreaseFontSize,
    required this.onIncreaseFontSize,
    super.key,
  });

  final double speedWpm;
  final double fontSize;
  final String estimatedTimeLabel;
  final ValueChanged<double> onSpeedChanged;
  final VoidCallback onDecreaseFontSize;
  final VoidCallback onIncreaseFontSize;

  @override
  Widget build(BuildContext context) {
    final speedLabel = '${speedWpm.round()} WPM';

    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        _EstimatedTime(label: estimatedTimeLabel),
        const SizedBox(height: AppSpacing.md),
        _SpeedControl(
          speedLabel: speedLabel,
          speedWpm: speedWpm,
          onSpeedChanged: onSpeedChanged,
        ),
        const SizedBox(height: AppSpacing.md),
        Center(
          child: _FontSizeControl(
            onDecreaseFontSize: onDecreaseFontSize,
            onIncreaseFontSize: onIncreaseFontSize,
          ),
        ),
      ],
    );
  }
}

class _EstimatedTime extends StatelessWidget {
  const _EstimatedTime({required this.label});

  final String label;

  @override
  Widget build(BuildContext context) {
    final textTheme = Theme.of(context).textTheme;
    final colorScheme = Theme.of(context).colorScheme;

    return Column(
      children: [
        Text(
          'Estimated time',
          style: textTheme.labelLarge?.copyWith(
            color: colorScheme.onSurfaceVariant,
            fontWeight: FontWeight.w700,
          ),
        ),
        const SizedBox(height: AppSpacing.xs),
        Text(
          label,
          style: textTheme.titleLarge?.copyWith(fontWeight: FontWeight.w800),
        ),
      ],
    );
  }
}

class _SpeedControl extends StatelessWidget {
  const _SpeedControl({
    required this.speedLabel,
    required this.speedWpm,
    required this.onSpeedChanged,
  });

  final String speedLabel;
  final double speedWpm;
  final ValueChanged<double> onSpeedChanged;

  @override
  Widget build(BuildContext context) {
    final textTheme = Theme.of(context).textTheme;
    final colorScheme = Theme.of(context).colorScheme;

    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              speedLabel,
              key: const ValueKey<String>('reading-speed-label'),
              style: textTheme.labelLarge?.copyWith(
                color: colorScheme.onSurface,
                fontWeight: FontWeight.w800,
              ),
            ),
          ],
        ),
        Slider(
          key: const ValueKey<String>('reading-speed-slider'),
          value: speedWpm,
          min: 80,
          max: 220,
          divisions: 14,
          label: speedLabel,
          semanticFormatterCallback: (double value) {
            return '${value.round()} words per minute';
          },
          onChanged: onSpeedChanged,
        ),
      ],
    );
  }
}

class _FontSizeControl extends StatelessWidget {
  const _FontSizeControl({
    required this.onDecreaseFontSize,
    required this.onIncreaseFontSize,
  });

  final VoidCallback onDecreaseFontSize;
  final VoidCallback onIncreaseFontSize;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisSize: MainAxisSize.min,
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        IconButton.outlined(
          key: const ValueKey<String>('decrease-font-size-button'),
          tooltip: 'Decrease font size',
          onPressed: onDecreaseFontSize,
          icon: const Text('A-'),
        ),
        const SizedBox(width: AppSpacing.lg),
        IconButton.outlined(
          key: const ValueKey<String>('increase-font-size-button'),
          tooltip: 'Increase font size',
          onPressed: onIncreaseFontSize,
          icon: const Text('A+'),
        ),
      ],
    );
  }
}
