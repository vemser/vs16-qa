package com.vemser.rest.tests;

import com.vemser.rest.client.ProdutosClient;
import com.vemser.rest.data.factory.LoginDataFactory;
import com.vemser.rest.data.factory.ProdutoDataFactory;
import com.vemser.rest.model.Produtos;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


public class ProdutoTest {

    private final ProdutosClient produtosClient = new ProdutosClient();

    @Test
    public void testDeveCadastrarProdutoComSucesso() {
        Produtos produto = ProdutoDataFactory.produtoValido();

        produtosClient.cadastrarProduto(produto, LoginDataFactory.tokenAdmin())
                .then()
                    .statusCode(201)
                    .body("message", Matchers.equalTo("Cadastro realizado com sucesso"))
                    .extract().path("message")
        ;
    }

}
