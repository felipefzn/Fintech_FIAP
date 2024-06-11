package com.mywebapp.model;

import java.util.UUID;

public class TbTipoPagamento {
    private UUID idTipoPagamento;
    private String tipo;

    // Getters e Setters
    public UUID getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(UUID idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
