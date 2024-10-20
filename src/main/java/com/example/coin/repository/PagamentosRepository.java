package com.example.coin.repository;

import com.example.coin.model.Pagamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentosRepository extends JpaRepository<Pagamentos, Long> {
    List<Pagamentos> findByTipo(String tipo);
}
