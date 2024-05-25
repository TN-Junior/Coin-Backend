package com.example.coin.repository;

import com.example.coin.model.PlanoDeContas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoDeContasRepository extends JpaRepository<PlanoDeContas, Integer> {
}