package com.api.mercado.services;

import com.api.mercado.models.ProdutoModel;
import com.api.mercado.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoModel salvarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(UUID id){
        return produtoRepository.findById(id);
    }

    @Transactional
    public Optional<ProdutoModel> deletarProduto(UUID id){
        Optional produtoDeletado = produtoRepository.findById(id);
        produtoRepository.deleteById(id);
        return produtoDeletado;
    }

    public boolean existsByNomeProdutoAndFabricanteProduto(String nomeProduto, String fabricanteProduto){
        return produtoRepository.existsByNomeProdutoAndFabricanteProduto(nomeProduto, fabricanteProduto);
    }
}
