package com.englishcoach.shared.time;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.Clock;

@ApplicationScoped
public class ClockProvider {
  public Clock utcClock() {
    return Clock.systemUTC();
  }
}
