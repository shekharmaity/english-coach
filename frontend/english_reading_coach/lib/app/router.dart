import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

import '../shared/widgets/foundation_home_screen.dart';

final GoRouter appRouter = GoRouter(
  initialLocation: '/',
  routes: [
    GoRoute(
      path: '/',
      name: 'home',
      builder: (BuildContext context, GoRouterState state) {
        return const FoundationHomeScreen();
      },
    ),
  ],
);
