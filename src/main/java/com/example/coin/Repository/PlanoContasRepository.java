package com.example.coin.repository;

import com.example.coin.model.PlanoContas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoContasRepository extends JpaRepository<PlanoContas, Integer> {
}