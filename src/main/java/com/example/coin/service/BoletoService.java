package com.example.coin.service;

import com.example.coin.model.Boleto;
import com.example.coin.repository.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletoService {
    private final BoletoRepository boletoRepository;

    @Autowired
    public BoletoService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public Boleto createBoleto(Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    public List<Boleto> retrieveBoletos() {
        return boletoRepository.findAll();
    }

    public Optional<Boleto> retrieveBoletoById(int id) {
        return boletoRepository.findById(id);
    }

    public Boleto updateBoleto(Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    public void deleteBoleto(int id) {
        boletoRepository.deleteById(id);
    }

    public List<String> cadastroBoletos(Boleto boleto) {
        boletoRepository.save(boleto);
        return List.of("Boleto cadastrado com sucesso");
    }

    public List<String> editarDetalhesBoletos(Boleto boleto) {
        boletoRepository.save(boleto);
        return List.of("Boleto editado com sucesso");
    }

    public List<String> exclusaoBoletos(int idBoleto) {
        boletoRepository.deleteById(idBoleto);
        return List.of("Boleto excluído com sucesso");
    }

    public void visualizarBoletos() {
        List<Boleto> boletos = boletoRepository.findAll();
        boletos.forEach(System.out::println);
    }
}