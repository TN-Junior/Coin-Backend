package com.example.coin.service;

import com.example.coin.model.PlanoConta;
import com.example.coin.repository.PlanoContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoContaService {

    @Autowired
    private PlanoContaRepository repository;

    public List<PlanoConta> findAll() {
        return repository.findAll();
    }

    public Optional<PlanoConta> findById(Long id) {
        return repository.findById(id);
    }

    public PlanoConta save(PlanoConta planoConta) {
        return repository.save(planoConta);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
