package com.api.mercado.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProdutoDto {

    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String fabricanteProduto;
    private double precoProduto;
    private int quantidadeEstoque;

}
