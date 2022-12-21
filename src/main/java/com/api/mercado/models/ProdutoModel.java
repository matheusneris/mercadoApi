package com.api.mercado.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToMany(mappedBy = "produtos")
    private List<CarrinhoModel> carrinhos = new ArrayList<>();
    @Column(nullable = false, length = 50)
    private String nomeProduto;
    @Column(nullable = false, length = 50)
    private String fabricanteProduto;
    @Column(nullable = false)
    private BigDecimal precoProduto;
    @Column(nullable = false)
    private int quantidadeEstoque;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    @JsonIgnore
    public List<CarrinhoModel> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<CarrinhoModel> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getFabricanteProduto() {
        return fabricanteProduto;
    }

    public void setFabricanteProduto(String fabricanteProduto) {
        this.fabricanteProduto = fabricanteProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}