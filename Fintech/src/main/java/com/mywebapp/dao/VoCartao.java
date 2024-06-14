package com.mywebapp.dao;

import com.mywebapp.model.TbCartao;
import com.mywebapp.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoCartao {

    public void create(TbCartao cartao) throws SQLException {
        String sql = "INSERT INTO Cartao (IdCartao, IdUsuario, tipoCartao, numeroCartao, dataValidade, cvv, limiteCredito, saldoDebito) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, cartao.getIdCartao());
            pstmt.setObject(2, cartao.getIdUsuario());
            pstmt.setString(3, cartao.getTipoCartao());
            pstmt.setString(4, cartao.getNumeroCartao());
            pstmt.setString(5, cartao.getDataValidade());
            pstmt.setString(6, cartao.getCvv());
            pstmt.setFloat(7, cartao.getLimiteCredito());
            pstmt.setFloat(8, cartao.getSaldoDebito());
            pstmt.executeUpdate();
        }
    }

    public TbCartao findById(UUID idCartao) throws SQLException {
        String sql = "SELECT * FROM Cartao WHERE IdCartao = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idCartao);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	TbCartao cartao = new TbCartao();
                    cartao.setIdCartao(UUID.fromString(rs.getString("IdCartao")));
                    cartao.setIdUsuario(UUID.fromString(rs.getString("IdUsuario")));
                    cartao.setTipoCartao(rs.getString("tipoCartao"));
                    cartao.setNumeroCartao(rs.getString("numeroCartao"));
                    cartao.setDataValidade(rs.getString("dataValidade"));
                    cartao.setCvv(rs.getString("cvv"));
                    cartao.setLimiteCredito(rs.getFloat("limiteCredito"));
                    cartao.setSaldoDebito(rs.getFloat("saldoDebito"));
                    return cartao;
                }
            }
        }
        return null;
    }

    public List<TbCartao> findAll() throws SQLException {
        List<TbCartao> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM Cartao";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	TbCartao cartao = new TbCartao();
                cartao.setIdCartao(UUID.fromString(rs.getString("IdCartao")));
                cartao.setIdUsuario(UUID.fromString(rs.getString("IdUsuario")));
                cartao.setTipoCartao(rs.getString("tipoCartao"));
                cartao.setNumeroCartao(rs.getString("numeroCartao"));
                cartao.setDataValidade(rs.getString("dataValidade"));
                cartao.setCvv(rs.getString("cvv"));
                cartao.setLimiteCredito(rs.getFloat("limiteCredito"));
                cartao.setSaldoDebito(rs.getFloat("saldoDebito"));
                cartoes.add(cartao);
            }
        }
        return cartoes;
    }

    public void update(TbCartao cartao) throws SQLException {
        String sql = "UPDATE Cartao SET IdUsuario = ?, tipoCartao = ?, numeroCartao = ?, dataValidade = ?, cvv = ?, limiteCredito = ?, saldoDebito = ? WHERE IdCartao = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, cartao.getIdUsuario());
            pstmt.setString(2, cartao.getTipoCartao());
            pstmt.setString(3, cartao.getNumeroCartao());
            pstmt.setString(4, cartao.getDataValidade());
            pstmt.setString(5, cartao.getCvv());
            pstmt.setFloat(6, cartao.getLimiteCredito());
            pstmt.setFloat(7, cartao.getSaldoDebito());
            pstmt.setObject(8, cartao.getIdCartao());
            pstmt.executeUpdate();
        }
    }

    public void delete(UUID idCartao) throws SQLException {
        String sql = "DELETE FROM Cartao WHERE IdCartao = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idCartao);
            pstmt.executeUpdate();
        }
    }
}
