package com.vemser.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produtos {

    private String nome;
    private Integer preco;
    private String descricao;
    private Integer quantidade;

}
