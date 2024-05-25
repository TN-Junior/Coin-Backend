package com.example.coin.controller;

import com.example.coin.model.PlanoContas;
import com.example.coin.service.PlanoContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class PlanoContasController {

    @Autowired
    private PlanoContasService service;

    @PostMapping("/cadastro")
    public List<String> cadastroContas(@RequestBody PlanoContas PlanoContas) {
        return service.cadastroContas(PlanoContas);
    }

    @PutMapping("/editar")
    public List<String> editarDetalhesContas(@RequestBody PlanoContas PlanoContas) {
        return service.editarDetalhesContas(PlanoContas);
    }

    @DeleteMapping("/excluir/{id}")
    public List<String> exclusaoContas(@PathVariable int id) {
        return service.exclusaoContas(id);
    }

    @GetMapping("/visualizar")
    public void visualizarContas() {
        service.visualizarContas();
    }
}