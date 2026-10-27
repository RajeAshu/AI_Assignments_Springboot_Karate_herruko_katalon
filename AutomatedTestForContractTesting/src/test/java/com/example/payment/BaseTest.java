package com.example.payment;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    @BeforeEach
    public void setup() {
        String apikey = System.getenv("RC_API_KEY");
        if (apikey == null || apikey.trim().isBlank()) {
            throw new IllegalStateException("Set the RC_API_KEY environment variable");
        }

        RestAssured.baseURI = "https://api.restcountries.com";

        RestAssured.config = RestAssuredConfig.config().headerConfig(
                HeaderConfig.headerConfig().overwriteHeadersWithName("Authorization")
        );

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + apikey.trim())
                .build();
    }
}
