package com.example.coin.controller;

import com.example.coin.model.PlanoConta;
import com.example.coin.service.PlanoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planocontas")
@CrossOrigin(origins = "http://localhost:3000")
public class PlanoContaController {

    @Autowired
    private PlanoContaService service;

    @GetMapping
    public List<PlanoConta> getAllPlanoContas() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PlanoConta getPlanoContaById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public PlanoConta createPlanoConta(@RequestBody PlanoConta planoConta) {
        return service.save(planoConta);
    }

    @PutMapping("/{id}")
    public PlanoConta updatePlanoConta(@PathVariable Long id, @RequestBody PlanoConta planoConta) {
        PlanoConta existingPlanoConta = service.findById(id).orElse(null);
        if (existingPlanoConta != null) {
            existingPlanoConta.setConta(planoConta.getConta());
            existingPlanoConta.setStatus(planoConta.getStatus());
            existingPlanoConta.setCategoria(planoConta.getCategoria());
            existingPlanoConta.setValor(planoConta.getValor());
            existingPlanoConta.setVencimento(planoConta.getVencimento());
            return service.save(existingPlanoConta);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePlanoConta(@PathVariable Long id) {
        service.deleteById(id);
    }
}

