package com.example.coin.controller;

import com.example.coin.model.Pagamentos;
import com.example.coin.service.PagamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
@CrossOrigin(origins = "http://localhost:5173") // Permite o CORS para o front-end
public class PagamentosController {

    @Autowired
    private PagamentosService pagamentosService;

    @GetMapping
    public List<Pagamentos> getAllPagamentos() {
        return pagamentosService.getAllPagamentos();
    }

    @GetMapping("/{tipo}")
    public List<Pagamentos> getPagamentosByTipo(@PathVariable String tipo) {
        return pagamentosService.getPagamentosByTipo(tipo.toUpperCase());
    }

    @PostMapping
    public Pagamentos addPagamento(@RequestBody Pagamentos pagamento) {
        return pagamentosService.savePagamento(pagamento);
    }
    @DeleteMapping("/{id}")
    public void deleteConta(@PathVariable Long id) {
        pagamentosService.deleteConta(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamentos> updatePagamento(@PathVariable Long id, @RequestBody Pagamentos pagamentoAtualizado) {
        Pagamentos pagamentoExistente = pagamentosService.findById(id);
        if (pagamentoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        pagamentoExistente.setDescricao(pagamentoAtualizado.getDescricao());
        pagamentoExistente.setValor(pagamentoAtualizado.getValor());
        pagamentoExistente.setData(pagamentoAtualizado.getData());

        Pagamentos pagamentoSalvo = pagamentosService.save(pagamentoExistente);
        return ResponseEntity.ok(pagamentoSalvo);
    }
}
