package com.mywebapp.model;

import java.util.UUID;
import java.util.Date;

public class TbRecebimento {
    private UUID idRecebimento;
    private UUID idUsuario;
    private UUID idTipoRecebimento;
    private UUID idTipoPagamento;
    private Date dthrRecebimento;
    private float valorRecebimento;
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

    public UUID getIdTipoRecebimento() {
        return idTipoRecebimento;
    }

    public void setIdTipoRecebimento(UUID idTipoRecebimento) {
        this.idTipoRecebimento = idTipoRecebimento;
    }

    public UUID getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(UUID idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public Date getDthrRecebimento() {
        return dthrRecebimento;
    }

    public void setDthrRecebimento(Date dthrRecebimento) {
        this.dthrRecebimento = dthrRecebimento;
    }

    public float getValorRecebimento() {
        return valorRecebimento;
    }

    public void setValorRecebimento(float valorRecebimento) {
        this.valorRecebimento = valorRecebimento;
    }

    public String getDocumentoAnexado() {
        return documentoAnexado;
    }

    public void setDocumentoAnexado(String documentoAnexado) {
        this.documentoAnexado = documentoAnexado;
    }
}
