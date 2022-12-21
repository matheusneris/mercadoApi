package com.api.mercado.models;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.*;

@Entity(name = "TB_CARRINHO")
public class CarrinhoModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToMany
    @JoinTable(name = "PRODUTOS_CARRINHOS",
                joinColumns = @JoinColumn(name = "carrinho_id"),
                inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<ProdutoModel> produtos = new ArrayList<>();
    @Column(nullable = false)
    private BigDecimal valorTotalCarrinho;
    @Column(nullable = false)
    private boolean carrinhoFechado;

    public UUID getId() {
        return id;
    }

    public List<ProdutoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoModel> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getValorTotalCarrinho() {
        return valorTotalCarrinho;
    }

    public void setValorTotalCarrinho(BigDecimal valorTotalCarrinho) {
        this.valorTotalCarrinho = valorTotalCarrinho;
    }

    public boolean isCarrinhoFechado() {
        return carrinhoFechado;
    }

    public void setCarrinhoFechado(boolean carrinhoFechado) {
        this.carrinhoFechado = carrinhoFechado;
    }

    public void adicionarProduto(ProdutoModel produtoModel, int quantidade){

        ProdutoModel produtoModelBanco = new ProdutoModel();
        BeanUtils.copyProperties(produtoModel, produtoModelBanco);
        produtoModelBanco.setQuantidadeEstoque(quantidade);
        produtos.add(produtoModelBanco);
        valorTotalCarrinho = valorTotalCarrinho.add(produtoModelBanco.getPrecoProduto().multiply(BigDecimal.valueOf(quantidade)));

    }
}
