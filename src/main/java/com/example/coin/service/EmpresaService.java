package com.example.coin.service;

import com.example.coin.model.Empresa;
import com.example.coin.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> retrieveEmpresas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> retrieveEmpresaById(UUID id) {
        return empresaRepository.findById(id);
    }

    public Empresa updateEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresa(UUID id) {
        empresaRepository.deleteById(id);
    }
}
