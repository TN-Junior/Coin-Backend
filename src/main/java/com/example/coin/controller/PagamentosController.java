package com.example.coin.controller;

import com.example.coin.model.Pagamentos;
import com.example.coin.service.PagamentosService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
