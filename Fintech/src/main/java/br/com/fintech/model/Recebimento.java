package br.com.fintech.model;

import java.util.UUID;

public class Recebimento {
    private UUID idRecebimento;
    private UUID idUsuario;
    private String tipoRecebimento;
    private String tipoPagamento;
    private String dthrRecebimento;
    private double valorRecebimento;
    private String documentoAnexado;

    // Getters e Setters
    public UUID getIdRecebimento() {
        return idRecebimento;
    }

    public void setIdRecebimento(UUID idRecebimento) {
        this.idRecebimento = idRecebimento;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoRecebimento() {
        return tipoRecebimento;
    }

    public void setTipoRecebimento(String tipoRecebimento) {
        this.tipoRecebimento = tipoRecebimento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getDthrRecebimento() {
        return dthrRecebimento;
    }

    public void setDthrRecebimento(String dthrRecebimento) {
        this.dthrRecebimento = dthrRecebimento;
    }

    public double getValorRecebimento() {
        return valorRecebimento;
    }

    public void setValorRecebimento(double valorRecebimento) {
        this.valorRecebimento = valorRecebimento;
    }

    public String getDocumentoAnexado() {
        return documentoAnexado;
    }

    public void setDocumentoAnexado(String documentoAnexado) {
        this.documentoAnexado = documentoAnexado;
    }
}
