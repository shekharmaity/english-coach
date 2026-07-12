import 'package:flutter_riverpod/flutter_riverpod.dart';

final Provider<AppClock> appClockProvider = Provider<AppClock>((ref) {
  return const SystemAppClock();
});

abstract interface class AppClock {
  DateTime nowUtc();
}

class SystemAppClock implements AppClock {
  const SystemAppClock();

  @override
  DateTime nowUtc() {
    return DateTime.now().toUtc();
  }
}
