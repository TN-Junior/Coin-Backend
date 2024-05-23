package com.example.coin.Model;
import java.util.List;
import java.util.ArrayList;

public class planoContas {

private int idConta;
private String conta;
private String tipo;
private String descricao;
private List<Boleto> boletos;
private Empresa empresa;


public planoContas(int idConta, String conta, String tipo, String descricao, List<Boleto> boletos, Empresa empresa) {

this.idConta = idConta;
this.conta = conta;
this.tipo = tipo;
this.descricao = descricao;
this.boletos = boletos;
this.empresa = empresa;

}

public int getidConta() {
    return idConta;
}

public void setidConta(int idConta) {
    this.idConta = idConta;
}

public String getConta() {
    return conta;
}

public void setConta(String conta) {
    this.conta = conta;
}

public String getTipo() {
    return tipo;
}

public void setTipo(String tipo) {
    this.tipo = tipo;
}

public String getDescricao() {
    return descricao;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}

public List<Boleto> getBoletos() {
    return boletos;
}

public void setBoletos(List<Boleto> boletos) {
    this.boletos = boletos;
}

}