import 'package:flutter/material.dart';

import '../design/app_spacing.dart';

class BaseScreen extends StatelessWidget {
  const BaseScreen({
    required this.body,
    this.title,
    this.maxWidth = 960,
    this.actions,
    super.key,
  });

  final Widget body;
  final String? title;
  final double maxWidth;
  final List<Widget>? actions;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: title == null
          ? null
          : AppBar(title: Text(title!), actions: actions),
      body: SafeArea(
        child: Align(
          alignment: Alignment.topCenter,
          child: ConstrainedBox(
            constraints: BoxConstraints(maxWidth: maxWidth),
            child: Padding(
              padding: const EdgeInsets.all(AppSpacing.lg),
              child: body,
            ),
          ),
        ),
      ),
    );
  }
}
