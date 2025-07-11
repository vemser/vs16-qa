package com.vemser.rest.tests;

import com.vemser.rest.client.UsuariosClient;
import com.vemser.rest.data.factory.UsuariosDataFactory;
import com.vemser.rest.dto.UsuariosResponse;
import com.vemser.rest.model.Usuarios;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsuariosTest {

    private UsuariosClient usuariosClient = UsuariosClient.getInstance();

    @Test
    public void testDeveCadastrarUsuarioComSucesso() {

        Usuarios usuario = UsuariosDataFactory.usuarioValido();

        usuariosClient.cadastrarUsuario(usuario)
        .then()
                .statusCode(201)
                .body("message", Matchers.equalTo("Cadastro realizado com sucesso"))
                .body("_id", Matchers.notNullValue())
        ;
    }

    @Test
    public void testNaoDeveCadastrarUsuarioComNomeEmBranco() {

        Usuarios usuario = UsuariosDataFactory.usuarioComNomeEmBranco();

        usuariosClient.cadastrarUsuario(usuario)
        .then()
                .statusCode(400)
        ;
    }

    @Test
    public void testDeveBuscarUsuarioPorIDComSucesso() {

        String idUsuario = "0MwHOKkT6gbagbPO";

        UsuariosResponse response = usuariosClient.buscarPorID(idUsuario)
        .then()
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

        String idUsuario = "0MwHOKkT6gbagbPO";

        usuariosClient.buscarPorID(idUsuario)
        .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .time(Matchers.lessThan(2000L))
                .body("nome", Matchers.equalTo("Luiz Henrique de Castro Ramos"))
                .body("email", Matchers.equalTo("Santiago.Bashirian@hotmail.com"))
        ;
    }

    @Test
    public void testSchemaDeveBuscarUsuarioPorIDComSucesso() {

        String idUsuario = "0MwHOKkT6gbagbPO";

        usuariosClient.buscarPorID(idUsuario)
        .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/usuario_por_id.json"))
        ;
    }
}
