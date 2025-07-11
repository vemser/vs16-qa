package com.vemser.rest.client;

import com.vemser.rest.model.Usuarios;
import com.vemser.rest.spec.BaseSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsuariosClient {

    private static UsuariosClient instance;
    private final String PATH_USUARIOS = "/usuarios";
    private final String PATH_USUARIOS_ID = "/usuarios/{id}";

    private UsuariosClient() {}

    public static UsuariosClient getInstance() {
        if (instance == null) {
            instance = new UsuariosClient();
        }
        return instance;
    }

    public Response cadastrarUsuario(Usuarios usuario) {

        return
            given()
                    .spec(BaseSpec.setUp())
                    .body(usuario)
            .when()
                    .post(PATH_USUARIOS)
            ;
    }

    public Response buscarPorID(String idUsuario) {

        return
                given()
                        .spec(BaseSpec.setUp())
                        .pathParam("id", idUsuario)
                .when()
                        .get(PATH_USUARIOS_ID)
                ;
    }
}
