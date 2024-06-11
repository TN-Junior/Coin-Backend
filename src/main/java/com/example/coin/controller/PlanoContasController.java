package com.example.coin.controller;

import com.example.coin.model.PlanoContas;
import com.example.coin.service.PlanoContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planocontas")
@CrossOrigin(origins = "http://localhost:3000")  // Permitir requisições do frontend React
public class PlanoContasController {

    @Autowired
    private PlanoContasService service;

    @GetMapping
    public List<PlanoContas> getAllContas() {
        return service.getAllContas();
    }

    @PostMapping
    public PlanoContas addConta(@RequestBody PlanoContas conta) {
        return service.addConta(conta);
    }
}