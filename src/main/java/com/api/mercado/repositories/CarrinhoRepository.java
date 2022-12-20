package com.api.mercado.repositories;

import com.api.mercado.models.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoModel, UUID> {



}
