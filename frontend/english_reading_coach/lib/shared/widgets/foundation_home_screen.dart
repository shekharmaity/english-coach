import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import '../../core/config/app_config.dart';
import '../../core/localization/app_localizations.dart';
import '../design/app_spacing.dart';
import '../layout/base_screen.dart';
import '../layout/responsive_layout.dart';

class FoundationHomeScreen extends ConsumerWidget {
  const FoundationHomeScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final config = ref.watch(appConfigProvider);
    final localizations = AppLocalizations.of(context);
    final textTheme = Theme.of(context).textTheme;

    return BaseScreen(
      title: localizations.appTitle,
      body: ResponsiveLayout(
        compact: _FoundationContent(
          title: localizations.foundationTitle,
          body: localizations.foundationBody,
          textTheme: textTheme,
          config: config,
        ),
        medium: Center(
          child: _FoundationContent(
            title: localizations.foundationTitle,
            body: localizations.foundationBody,
            textTheme: textTheme,
            config: config,
          ),
        ),
      ),
    );
  }
}

class _FoundationContent extends StatelessWidget {
  const _FoundationContent({
    required this.title,
    required this.body,
    required this.textTheme,
    required this.config,
  });

  final String title;
  final String body;
  final TextTheme textTheme;
  final AppConfig config;

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);

    return Column(
      mainAxisSize: MainAxisSize.min,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(title, style: textTheme.headlineMedium),
        const SizedBox(height: AppSpacing.md),
        Text(body, style: textTheme.bodyLarge),
        const SizedBox(height: AppSpacing.lg),
        Card(
          child: Padding(
            padding: const EdgeInsets.all(AppSpacing.md),
            child: Column(
              children: [
                _ConfigRow(
                  label: localizations.environmentLabel,
                  value: config.environment,
                ),
                const SizedBox(height: AppSpacing.sm),
                _ConfigRow(
                  label: localizations.apiLabel,
                  value: config.apiBaseUrl,
                ),
              ],
            ),
          ),
        ),
      ],
    );
  }
}

class _ConfigRow extends StatelessWidget {
  const _ConfigRow({required this.label, required this.value});

  final String label;
  final String value;

  @override
  Widget build(BuildContext context) {
    final colorScheme = Theme.of(context).colorScheme;

    return DecoratedBox(
      decoration: BoxDecoration(
        border: Border.all(color: colorScheme.outlineVariant),
        borderRadius: BorderRadius.circular(8),
      ),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 12, vertical: 10),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            SizedBox(
              width: 120,
              child: Text(
                label,
                style: TextStyle(
                  color: colorScheme.onSurfaceVariant,
                  fontWeight: FontWeight.w600,
                ),
              ),
            ),
            Expanded(child: SelectableText(value)),
          ],
        ),
      ),
    );
  }
}
