package br.com.fintech.dao;

public class DaoFactory {

    public static VoUsuario getUsuario() {
        return new VoUsuario();
    }
    
    public static VoCartao getCartao() {
        return new VoCartao();
    }
    
    public static VoRecebimento getRecebimento() {
        return new VoRecebimento();
    }
    
    public static VoTransacao getTransacao() {
        return new VoTransacao();
    }
   
}
