package com.example.coin.service;


import com.example.coin.model.Conta;
import com.example.coin.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    public Optional<Conta> getContaById(Long id) {
        return contaRepository.findById(id);
    }

    public Conta saveConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public void deleteConta(Long id) {
        contaRepository.deleteById(id);
    }
}



