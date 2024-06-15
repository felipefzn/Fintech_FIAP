package br.com.fintech.model;

import java.util.UUID;

public class Transacao {
    private UUID idTransacao;
    private UUID idUsuario;
    private String dataTransacao;
    private String tipoTransacao;
    private double valor;
    private String status;

  
    public Transacao() {
    }

    
    public Transacao(UUID idTransacao, UUID idUsuario, String dataTransacao, String tipoTransacao, double valor, String status) {
        this.idTransacao = idTransacao;
        this.idUsuario = idUsuario;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.status = status;
    }

    // Getters e Setters
    public UUID getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(UUID idTransacao) {
        this.idTransacao = idTransacao;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    @Override
    public String toString() {
        return "Transacao{" +
                "idTransacao=" + idTransacao +
                ", idUsuario=" + idUsuario +
                ", dataTransacao='" + dataTransacao + '\'' +
                ", tipoTransacao='" + tipoTransacao + '\'' +
                ", valor=" + valor +
                ", status='" + status + '\'' +
                '}';
    }
}
