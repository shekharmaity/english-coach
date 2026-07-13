import 'package:flutter/material.dart';

import '../../../shared/design/app_spacing.dart';
import '../../../shared/layout/responsive_layout.dart';
import 'reading_demo_model.dart';
import 'widgets/lesson_progress_header.dart';
import 'widgets/reading_app_bar.dart';
import 'widgets/reading_playback_controls.dart';
import 'widgets/reading_preferences.dart';
import 'widgets/reading_sentence_view.dart';

class ReadingScreen extends StatefulWidget {
  const ReadingScreen({super.key});

  @override
  State<ReadingScreen> createState() => _ReadingScreenState();
}

class _ReadingScreenState extends State<ReadingScreen> {
  ReadingDemoModel _model = demoReadingModel;
  bool _isPlaying = false;

  @override
  Widget build(BuildContext context) {
    final windowClass = ResponsiveLayout.windowClassOf(context);
    final isCompact = windowClass == WindowClass.compact;

    return Scaffold(
      appBar: const ReadingAppBar(),
      body: SafeArea(
        child: CustomScrollView(
          slivers: [
            SliverPadding(
              padding: EdgeInsets.symmetric(
                horizontal: isCompact ? AppSpacing.md : AppSpacing.xl,
                vertical: isCompact ? AppSpacing.md : AppSpacing.lg,
              ),
              sliver: SliverToBoxAdapter(
                child: Align(
                  alignment: Alignment.topCenter,
                  child: ConstrainedBox(
                    constraints: const BoxConstraints(maxWidth: 680),
                    child: _ReadingScreenContent(
                      model: _model,
                      isPlaying: _isPlaying,
                      isCompact: isCompact,
                      onPlayPausePressed: () {
                        setState(() {
                          _isPlaying = !_isPlaying;
                        });
                      },
                      onSpeedChanged: (double value) {
                        setState(() {
                          _model = _model.copyWith(readingSpeedWpm: value);
                        });
                      },
                      onDecreaseFontSize: () {
                        setState(() {
                          _model = _model.copyWith(
                            fontSize: (_model.fontSize - 2).clamp(22, 42),
                          );
                        });
                      },
                      onIncreaseFontSize: () {
                        setState(() {
                          _model = _model.copyWith(
                            fontSize: (_model.fontSize + 2).clamp(22, 42),
                          );
                        });
                      },
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _ReadingScreenContent extends StatelessWidget {
  const _ReadingScreenContent({
    required this.model,
    required this.isPlaying,
    required this.isCompact,
    required this.onPlayPausePressed,
    required this.onSpeedChanged,
    required this.onDecreaseFontSize,
    required this.onIncreaseFontSize,
  });

  final ReadingDemoModel model;
  final bool isPlaying;
  final bool isCompact;
  final VoidCallback onPlayPausePressed;
  final ValueChanged<double> onSpeedChanged;
  final VoidCallback onDecreaseFontSize;
  final VoidCallback onIncreaseFontSize;

  @override
  Widget build(BuildContext context) {
    final spacing = isCompact ? AppSpacing.md : AppSpacing.lg;
    final activeWord = model.words[model.activeWordIndex];

    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        _LessonHeader(model: model),
        SizedBox(height: spacing),
        const _ReadingDivider(),
        SizedBox(height: spacing),
        ReadingSentenceView(
          sentence: model.sentenceText,
          words: model.words,
          activeWordIndex: model.activeWordIndex,
          fontSize: model.fontSize,
        ),
        SizedBox(height: spacing),
        const _ReadingDivider(),
        SizedBox(height: spacing),
        _CurrentWordPanel(word: activeWord.replaceAll(RegExp(r'[^\w-]'), '')),
        SizedBox(height: spacing),
        const _ReadingDivider(),
        SizedBox(height: spacing),
        ReadingPlaybackControls(
          isPlaying: isPlaying,
          onPlayPausePressed: onPlayPausePressed,
          onPreviousPressed: null,
        ),
        SizedBox(height: spacing),
        const _ReadingDivider(),
        SizedBox(height: spacing),
        LessonProgressHeader(
          currentSentenceNumber: model.currentSentenceNumber,
          totalSentences: model.totalSentences,
          completionPercent: model.completionPercent,
        ),
        SizedBox(height: isCompact ? AppSpacing.md : AppSpacing.lg),
        ReadingPreferences(
          speedWpm: model.readingSpeedWpm,
          fontSize: model.fontSize,
          estimatedTimeLabel: model.estimatedTimeLabel,
          onSpeedChanged: onSpeedChanged,
          onDecreaseFontSize: onDecreaseFontSize,
          onIncreaseFontSize: onIncreaseFontSize,
        ),
      ],
    );
  }
}

class _LessonHeader extends StatelessWidget {
  const _LessonHeader({required this.model});

  final ReadingDemoModel model;

  @override
  Widget build(BuildContext context) {
    final textTheme = Theme.of(context).textTheme;
    final colorScheme = Theme.of(context).colorScheme;

    return Column(
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Text(
          model.lessonTitle,
          style: textTheme.headlineSmall?.copyWith(fontWeight: FontWeight.w800),
        ),
        const SizedBox(height: AppSpacing.xs),
        Text(
          model.categoryTitle,
          style: textTheme.titleMedium?.copyWith(
            color: colorScheme.onSurfaceVariant,
            fontWeight: FontWeight.w600,
          ),
        ),
      ],
    );
  }
}

class _CurrentWordPanel extends StatelessWidget {
  const _CurrentWordPanel({required this.word});

  final String word;

  @override
  Widget build(BuildContext context) {
    final textTheme = Theme.of(context).textTheme;
    final colorScheme = Theme.of(context).colorScheme;

    return Column(
      children: [
        Text(
          'Current Word',
          style: textTheme.labelLarge?.copyWith(
            color: colorScheme.onSurfaceVariant,
            fontWeight: FontWeight.w700,
          ),
        ),
        const SizedBox(height: AppSpacing.sm),
        Text(
          word,
          style: textTheme.headlineSmall?.copyWith(
            color: colorScheme.primary,
            fontWeight: FontWeight.w800,
          ),
        ),
      ],
    );
  }
}

class _ReadingDivider extends StatelessWidget {
  const _ReadingDivider();

  @override
  Widget build(BuildContext context) {
    return Divider(color: Theme.of(context).colorScheme.outlineVariant);
  }
}
