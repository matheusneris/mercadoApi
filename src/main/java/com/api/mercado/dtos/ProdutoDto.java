package com.api.mercado.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDto {

    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String fabricanteProduto;
    private BigDecimal precoProduto;
    private int quantidadeEstoque;

}
