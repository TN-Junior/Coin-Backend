package com.example.coin.controller;


import com.example.coin.model.Conta;
import com.example.coin.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/contas")
@CrossOrigin(origins = "http://localhost:3000")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping
    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    @PostMapping
    public Conta createConta(@RequestBody Conta conta) {
        conta.setDataCadastro(LocalDate.now());
        return contaRepository.save(conta);
    }
}


