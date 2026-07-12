import 'package:flutter/material.dart';

import 'router.dart';
import 'theme.dart';

class EnglishReadingCoachApp extends StatelessWidget {
  const EnglishReadingCoachApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      title: 'English Reading Coach',
      debugShowCheckedModeBanner: false,
      theme: buildLightTheme(),
      darkTheme: buildDarkTheme(),
      routerConfig: appRouter,
    );
  }
}
