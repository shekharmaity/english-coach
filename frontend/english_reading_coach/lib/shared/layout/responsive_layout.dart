import 'package:flutter/widgets.dart';

import '../design/app_breakpoints.dart';

enum WindowClass { compact, medium, expanded }

class ResponsiveLayout extends StatelessWidget {
  const ResponsiveLayout({
    required this.compact,
    this.medium,
    this.expanded,
    super.key,
  });

  final Widget compact;
  final Widget? medium;
  final Widget? expanded;

  static WindowClass windowClassOf(BuildContext context) {
    final width = MediaQuery.sizeOf(context).width;
    if (width >= AppBreakpoints.expanded) {
      return WindowClass.expanded;
    }
    if (width >= AppBreakpoints.compact) {
      return WindowClass.medium;
    }
    return WindowClass.compact;
  }

  @override
  Widget build(BuildContext context) {
    final windowClass = windowClassOf(context);

    return switch (windowClass) {
      WindowClass.expanded => expanded ?? medium ?? compact,
      WindowClass.medium => medium ?? compact,
      WindowClass.compact => compact,
    };
  }
}
