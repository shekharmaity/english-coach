package com.englishcoach.shared.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class HealthResourceTest {
  @Test
  void healthReturnsOk() {
    given()
        .when()
        .get("/api/v1/health")
        .then()
        .statusCode(200)
        .body("status", equalTo("ok"))
        .body("service", equalTo("english-reading-coach-api"));
  }
}
