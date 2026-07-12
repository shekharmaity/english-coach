import 'package:flutter/material.dart';

import '../../core/localization/app_localizations.dart';
import '../design/app_spacing.dart';

class AppLoadingIndicator extends StatelessWidget {
  const AppLoadingIndicator({super.key});

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);

    return Center(
      child: Semantics(
        label: localizations.loadingLabel,
        child: const SizedBox.square(
          dimension: AppSpacing.xl,
          child: CircularProgressIndicator(),
        ),
      ),
    );
  }
}
