package com.example.coin.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Planejamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlanejamento;

    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double orcamentoTotal;
    private int idEmpresa;
    private int idUsuarioResponsavel;

    // Getters and Setters
    public int getIdPlanejamento() {
        return idPlanejamento;
    }

    public void setIdPlanejamento(int idPlanejamento) {
        this.idPlanejamento = idPlanejamento;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getOrcamentoTotal() {
        return orcamentoTotal;
    }

    public void setOrcamentoTotal(double orcamentoTotal) {
        this.orcamentoTotal = orcamentoTotal;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdUsuarioResponsavel() {
        return idUsuarioResponsavel;
    }

    public void setIdUsuarioResponsavel(int idUsuarioResponsavel) {
        this.idUsuarioResponsavel = idUsuarioResponsavel;
    }
}
