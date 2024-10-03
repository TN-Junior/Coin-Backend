package com.example.coin.controller;

import com.example.coin.model.Conta;
import com.example.coin.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    @PutMapping("/{id}")
    public Conta atualizarConta(@PathVariable Long id, @RequestBody Conta conta) {
        return contaRepository.findById(id)
                .map(contaExistente -> {
                    contaExistente.setConta(conta.getConta());
                    contaExistente.setStatus(conta.getStatus());
                    contaExistente.setCategoria(conta.getCategoria());
                    contaExistente.setValor(conta.getValor());
                    contaExistente.setVencimento(conta.getVencimento());
                    return contaRepository.save(contaExistente);
                })
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void excluirConta(@PathVariable Long id) {
        contaRepository.deleteById(id);
    }
}

