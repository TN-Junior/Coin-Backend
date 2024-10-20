package com.example.coin.service;

import com.example.coin.model.Pagamentos;
import com.example.coin.repository.PagamentosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentosService {
    private static final Logger logger = LoggerFactory.getLogger(ContaService.class);

    @Autowired
    private PagamentosRepository pagamentosRepository;

    public List<Pagamentos> getAllPagamentos() {
        return pagamentosRepository.findAll();
    }

    public List<Pagamentos> getPagamentosByTipo(String tipo) {
        return pagamentosRepository.findByTipo(tipo);
    }

    public Pagamentos savePagamento(Pagamentos pagamento) {
        return pagamentosRepository.save(pagamento);
    }
    public void deleteConta(Long id) {
        pagamentosRepository.deleteById(id);
    }

    public Pagamentos findById(Long id) {
        return pagamentosRepository.findById(id).orElse(null);
    }

    public Pagamentos save(Pagamentos pagamento) {
        return pagamentosRepository.save(pagamento);
    }
}
