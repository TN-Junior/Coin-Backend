package com.example.coin.service;

import com.example.coin.model.PlanoContas;
import com.example.coin.repository.PlanoContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class PlanoContasService {

    @Autowired
    private PlanoContasRepository repository;

    public List<String> cadastroContas(PlanoContas planoContas) {
        repository.save(planoContas);
        return List.of("Conta cadastrada com sucesso");
    }

    public List<String> editarDetalhesContas(PlanoContas planoContas) {
        repository.save(planoContas);
        return List.of("Conta editada com sucesso");
    }

    public List<String> exclusaoContas(Integer idConta) {
        repository.deleteById(idConta);
        return List.of("Conta excluída com sucesso");
    }

    public void visualizarContas() {
        List<PlanoContas> contas = repository.findAll();
        contas.forEach(System.out::println);
    }
}