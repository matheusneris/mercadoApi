package com.api.mercado.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTO")
@Data
public class ProdutoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 50)
    private String nomeProduto;
    @Column(nullable = false, length = 50)
    private String fabricanteProduto;
    @Column(nullable = false)
    private double precoProduto;
    @Column(nullable = false)
    private int quantidadeEstoque;

}