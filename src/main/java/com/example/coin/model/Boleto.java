package com.example.coin.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBoleto;

    private double valor;
    private LocalDate dataVencimento;
    private String status;
    private int idTransacaoAssociada;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "planoDeContas_id")
    private PlanoDeContas planoDeContas;

    // Getters and setters
    public int getBoleto() {
        return idBoleto;
    }

    public void setBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdTransacaoAssociada() {
        return idTransacaoAssociada;
    }

    public void setIdTransacaoAssociada(int idTransacaoAssociada) {
        this.idTransacaoAssociada = idTransacaoAssociada;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public PlanoDeContas getPlanoDeContas() {
        return planoDeContas;
    }

    public void setPlanoDeContas(PlanoDeContas planoDeContas) {
        this.planoDeContas = planoDeContas;
    }

}