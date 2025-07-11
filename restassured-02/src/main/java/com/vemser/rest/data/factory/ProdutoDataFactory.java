package com.vemser.rest.data.factory;

import com.vemser.rest.model.Produtos;

public class ProdutoDataFactory {

    public static Produtos produtoValido() {
        String timestamp = String.valueOf(System.currentTimeMillis());

        Produtos produtoValido = new Produtos();
        produtoValido.setNome("Logitech MX Vertical Version " + timestamp);
        produtoValido.setPreco(470);
        produtoValido.setDescricao("Mouse");
        produtoValido.setQuantidade(100);

        return produtoValido;
    }
}
