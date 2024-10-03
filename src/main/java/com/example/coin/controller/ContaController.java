package com.example.coin.controller;

import com.example.coin.model.Conta;
import com.example.coin.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping
    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    @PostMapping
    public Conta adicionarConta(@RequestBody Conta conta) {
        return contaRepository.save(conta);
    }
}
