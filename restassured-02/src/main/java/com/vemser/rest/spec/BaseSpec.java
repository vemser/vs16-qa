package com.vemser.rest.spec;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseSpec {

    private BaseSpec() {}

    public static RequestSpecification setUp() {

        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(3000)
                .setContentType(ContentType.JSON)
                .setConfig(RestAssured.config().logConfig(
                        LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .build();
    }
}
