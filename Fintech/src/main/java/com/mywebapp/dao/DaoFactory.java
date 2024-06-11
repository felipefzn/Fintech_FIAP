package com.mywebapp.dao;

public class DaoFactory {

    public static VoUsuario getUsuario() {
        return new VoUsuario();
    }

    public static VoCartao getCartao() {
        return new VoCartao();
    }

    public static VoTipoPagamento getTipoPagamento() {
        return new VoTipoPagamento();
    }

    public static VoTipoRecebimento getTipoRecebimento() {
        return new VoTipoRecebimento();
    }

    public static VoRecebimento getRecebimento() {
        return new VoRecebimento();
    }
}
