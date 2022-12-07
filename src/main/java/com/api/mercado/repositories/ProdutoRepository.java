package com.api.mercado.repositories;

import com.api.mercado.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoModel, UUID> {

    boolean existsByNomeProdutoAndFabricanteProduto(String nomeProduto, String fabricanteProduto);

}
