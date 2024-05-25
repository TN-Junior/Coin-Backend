package com.example.coin.controller;

import com.example.coin.model.Empresa;
import com.example.coin.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public Empresa postEmpresa(@RequestBody Empresa empresa) {
        return empresaService.createEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> getEmpresas() {
        return empresaService.retrieveEmpresas();
    }

    @GetMapping("/{id}")
    public Optional<Empresa> getEmpresa(@PathVariable UUID id) {
        return empresaService.retrieveEmpresaById(id);
    }

    @PutMapping
    public Empresa putEmpresa(@RequestBody Empresa empresa) {
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable UUID id) {
        empresaService.deleteEmpresa(id);
    }
}
