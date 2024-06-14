package com.mywebapp.model;

import java.util.UUID;
import java.util.Date;

public class TbCartao {
    private UUID idCartao;
    private UUID idUsuario;
    private String tipoCartao;
    private String numeroCartao;
    private String dataValidade;
    private String cvv;
    private float limiteCredito;
    private float saldoDebito;

    // Getters e Setters
    public UUID getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(UUID idCartao) {
        this.idCartao = idCartao;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade2) {
        this.dataValidade = dataValidade2;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito2) {
        this.limiteCredito = (float) limiteCredito2;
    }

    public float getSaldoDebito() {
        return saldoDebito;
    }

    public void setSaldoDebito(double saldoDebito2) {
        this.saldoDebito = (float) saldoDebito2;
    }
}
