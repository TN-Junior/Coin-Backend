package com.example.coin.repository;

import com.example.coin.model.PlanoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {
}

