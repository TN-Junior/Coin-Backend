package com.example.coin.controller;

import com.example.coin.model.Empresa;
import com.example.coin.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://localhost:5173") // Permite o acesso do front-end React
public class EmpresaController {

@Autowired
private EmpresaService empresaService;

@GetMapping
public List<Empresa> getAllEmpresas() {
        return empresaService.getAllEmpresas();
        }

@GetMapping("/{id}")
public Optional<Empresa> getEmpresaById(@PathVariable Long id) {
        return empresaService.getEmpresaById(id);
}
@PostMapping
public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        if (empresa.getCnpj() == null || empresa.getNome() == null || empresa.getSituacaoCadastral() == null) {
                        return ResponseEntity.badRequest().body(null);
                }
                Empresa novaEmpresa = empresaService.saveEmpresa(empresa);
                return ResponseEntity.ok(novaEmpresa);
        }

@PutMapping("/{id}")
public Empresa updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        Optional<Empresa> existingEmpresa = empresaService.getEmpresaById(id);
        if (existingEmpresa.isPresent()) {
        empresa.setId(id);
        return empresaService.saveEmpresa(empresa);
        } else {
        throw new RuntimeException("Empresa com o ID " + id + " não encontrada.");
        }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteEmpresa(@PathVariable Long id) {
                Optional<Empresa> existingEmpresa = empresaService.getEmpresaById(id);
                if (existingEmpresa.isPresent()) {
                        empresaService.deleteEmpresa(id);
                        return ResponseEntity.ok("Empresa deletada com sucesso.");
                } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa com ID " + id + " não encontrada.");
                }
        }
}