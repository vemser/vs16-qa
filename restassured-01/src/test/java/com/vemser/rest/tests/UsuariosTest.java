package com.vemser.rest.tests;

import com.vemser.rest.dto.UsuariosRequest;
import com.vemser.rest.dto.UsuariosResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static io.restassured.RestAssured.*;

public class UsuariosTest {

    private Faker faker = new Faker(new Locale("PT-BR"));

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testDeveCadastrarUsuarioComSucesso() {

        // Arrange
        UsuariosRequest usuario = new UsuariosRequest();
        usuario.setNome(faker.name().firstName() + " " + faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador("true");

        // Act
        given()
                .log().all()
                .body(usuario)
                .contentType(ContentType.JSON)
        .when()
                .post("/usuarios")
        .then()
                // Assert
                .log().all()
                .statusCode(201)
        ;

    }

    @Test
    public void testNaoDeveCadastrarUsuarioComNomeEmBranco() {

        // Arrange (corpo da requisição)
        UsuariosRequest usuario = new UsuariosRequest();
        usuario.setNome("");
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador("true");

        // Act
        given()
                .log().all()
                .body(usuario)
                .contentType(ContentType.JSON)
        .when()
                .post("/usuarios")
        .then()
                // Assert
                .log().all()
                .statusCode(400)
        ;
    }

    @Test
    public void testDeveBuscarUsuarioPorIDComSucesso() {

        // Arrange
        String idUsuario = "0MwHOKkT6gbagbPO";

        UsuariosResponse response =
        // Act
        given()
                .pathParam("id", idUsuario)
        .when()
                .get("/usuarios/{id}")
        .then()
        // Assert
                .statusCode(200)
                .extract()
                    .as(UsuariosResponse.class)
        ;

        Assertions.assertAll("response",
                () -> Assertions.assertEquals("Luiz Henrique de Castro Ramos", response.getNome()),
                () -> Assertions.assertEquals("Santiago.Bashirian@hotmail.com", response.getEmail())
        );
    }

    @Test
    public void testDeveBuscarUsuarioPorIDComSucessoComHamcrest() {

        // Arrange
        String idUsuario = "0MwHOKkT6gbagbPO";

        // Act
        given()
                .pathParam("id", idUsuario)
        .when()
                .get("/usuarios/{id}")
        .then()
                 // Assert
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .time(Matchers.lessThan(2000L))
                .body("nome", Matchers.equalTo("Luiz Henrique de Castro Ramos"))
                .body("email", Matchers.equalTo("Santiago.Bashirian@hotmail.com"))
        ;
    }
}
