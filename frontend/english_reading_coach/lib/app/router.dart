import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';

import '../shared/widgets/app_route_error_screen.dart';
import '../shared/widgets/foundation_home_screen.dart';

enum AppRoute {
  home(name: 'home', path: '/');

  const AppRoute({required this.name, required this.path});

  final String name;
  final String path;
}

final Provider<GoRouter> appRouterProvider = Provider<GoRouter>((ref) {
  return GoRouter(
    initialLocation: AppRoute.home.path,
    routes: [
      GoRoute(
        path: AppRoute.home.path,
        name: AppRoute.home.name,
        builder: (BuildContext context, GoRouterState state) {
          return const FoundationHomeScreen();
        },
      ),
    ],
    errorBuilder: (BuildContext context, GoRouterState state) {
      return AppRouteErrorScreen(error: state.error);
    },
  );
});
