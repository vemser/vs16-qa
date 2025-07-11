package com.vemser.rest.data.factory;

import com.vemser.rest.model.Login;
import com.vemser.rest.spec.BaseSpec;
import com.vemser.rest.utils.Manipulation;

import static io.restassured.RestAssured.given;

public class LoginDataFactory {

    public static Login loginValido() {
        Login login = new Login();
        login.setEmail(Manipulation.getProp().getProperty("email.admin"));
        login.setPassword(Manipulation.getProp().getProperty("password.admin"));

        return login;
    }

    public static String tokenAdmin() {
        return
            given()
                .spec(BaseSpec.setUp())
                .body(loginValido())
            .when()
                .post("/login")
            .then()
                .extract().path("authorization")
        ;
    }
}
