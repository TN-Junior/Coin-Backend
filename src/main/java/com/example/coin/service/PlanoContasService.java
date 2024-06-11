package com.example.coin.service;

import com.example.coin.model.PlanoContas;
import com.example.coin.repository.PlanoContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoContasService {

    @Autowired
    private PlanoContasRepository repository;

    public List<PlanoContas> getAllContas() {
        return repository.findAll();
    }

    public PlanoContas addConta(PlanoContas conta) {
        return repository.save(conta);
    }
    public void deleteConta(Long id) {
        repository.deleteById(id);
    }

}