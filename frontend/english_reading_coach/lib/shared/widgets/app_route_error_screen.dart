import 'package:flutter/material.dart';

import '../../core/errors/app_exception.dart';
import '../../core/localization/app_localizations.dart';
import '../layout/base_screen.dart';
import 'app_error_view.dart';

class AppRouteErrorScreen extends StatelessWidget {
  const AppRouteErrorScreen({this.error, super.key});

  final Exception? error;

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);

    return BaseScreen(
      title: localizations.appTitle,
      body: AppErrorView(
        error: AppException(
          code: 'ROUTE_NOT_FOUND',
          message: localizations.pageNotFoundBody,
        ),
      ),
    );
  }
}
