package com.mywebapp.model;

import java.util.UUID;

public class TbTipoRecebimento {
    private UUID idTipoRecebimento;
    private String tipo;

    // Getters e Setters
    public UUID getIdTipoRecebimento() {
        return idTipoRecebimento;
    }

    public void setIdTipoRecebimento(UUID idTipoRecebimento) {
        this.idTipoRecebimento = idTipoRecebimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
