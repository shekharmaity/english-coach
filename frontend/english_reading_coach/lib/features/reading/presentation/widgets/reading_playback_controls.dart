import 'package:flutter/material.dart';

import '../../../../shared/design/app_spacing.dart';

class ReadingPlaybackControls extends StatelessWidget {
  const ReadingPlaybackControls({
    required this.isPlaying,
    required this.onPlayPausePressed,
    required this.onPreviousPressed,
    super.key,
  });

  final bool isPlaying;
  final VoidCallback onPlayPausePressed;
  final VoidCallback? onPreviousPressed;

  @override
  Widget build(BuildContext context) {
    return FocusTraversalGroup(
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          _ControlButton(
            label: 'Previous sentence',
            icon: Icons.chevron_left,
            onPressed: onPreviousPressed,
          ),
          const SizedBox(width: AppSpacing.xl),
          Semantics(
            button: true,
            label: isPlaying ? 'Pause reading' : 'Play reading',
            child: IconButton.filled(
              onPressed: onPlayPausePressed,
              icon: Icon(isPlaying ? Icons.pause : Icons.play_arrow),
              tooltip: isPlaying ? 'Pause reading' : 'Play reading',
              style: IconButton.styleFrom(minimumSize: const Size.square(56)),
            ),
          ),
        ],
      ),
    );
  }
}

class _ControlButton extends StatelessWidget {
  const _ControlButton({
    required this.label,
    required this.icon,
    required this.onPressed,
  });

  final String label;
  final IconData icon;
  final VoidCallback? onPressed;

  @override
  Widget build(BuildContext context) {
    return IconButton.filledTonal(
      tooltip: label,
      icon: Icon(icon),
      onPressed: onPressed,
      style: IconButton.styleFrom(minimumSize: const Size.square(52)),
    );
  }
}
