package com.vemser.rest.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class OlaMundoTest {

    @Test
    public void testBuscarUsuarioPorIDComSucesso() {

        baseURI = "https://reqres.in/api";

        given()
                .log().all()
                .header("x-api-key","reqres-free-v1")
        .when()
                .get("/users/2")
        .then()
                .log().all()
                .statusCode(200)
        ;

    }
}
