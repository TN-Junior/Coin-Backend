package com.example.coin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coin.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}

