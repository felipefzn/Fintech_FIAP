package br.com.fintech.model;

import java.util.UUID;

public class Usuario {
	private UUID idUsuario;
    private String nome;
    private String sobrenome;
    private String numero;
    private String cpf;
    private String rg;
    private String email;
    private String pinSeguranca;

    // Getters e Setters
    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPinSeguranca() {
        return pinSeguranca;
    }

    public void setPinSeguranca(String pinSeguranca) {
        this.pinSeguranca = pinSeguranca;
    }
}
