package com.example.coin.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Planejamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String status;
    private String categoria;
    private Double valor;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate vencimento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPagamento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getdescricaoa() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public LocalDate getdataPagamento() {
        return dataPagamento;
    }

    public void setPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
