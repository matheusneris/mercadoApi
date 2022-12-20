package com.api.mercado.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CarrinhoDto {

    private UUID idProduto;
    private int quantidade;

}
