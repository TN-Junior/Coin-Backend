package com.example.coin.service;


import com.example.coin.model.Conta;
import com.example.coin.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    private static final Logger logger = LoggerFactory.getLogger(ContaService.class);

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    public Optional<Conta> getContaById(Long id) {
        return contaRepository.findById(id);
    }

    public Conta saveConta(Conta conta) {
        logger.info("Salvando conta: {}", conta);
        return contaRepository.save(conta);
    }

    public void deleteConta(Long id) {
        contaRepository.deleteById(id);
    }
    public List<Conta> getContasByCategoria(String categoria) {
        return contaRepository.findByCategoria(categoria);
    }
}



