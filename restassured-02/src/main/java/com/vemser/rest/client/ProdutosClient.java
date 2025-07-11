package com.vemser.rest.client;

import com.vemser.rest.model.Produtos;
import com.vemser.rest.spec.BaseSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ProdutosClient {

    private final String PATH_PRODUTOS = "/produtos";
    private final String BEARER = "Bearer ";

    public Response cadastrarProduto(Produtos produto, String token) {

        return
                given()
                        .spec(BaseSpec.setUp())
                        .body(produto)
                        .header("Authorization", token)
                .when()
                        .post(PATH_PRODUTOS)
                ;
    }
}
