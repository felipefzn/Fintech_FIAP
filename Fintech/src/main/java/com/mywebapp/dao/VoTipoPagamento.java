package com.mywebapp.dao;

import com.mywebapp.model.TbTipoPagamento;
import com.mywebapp.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoTipoPagamento {

    public void create(TbTipoPagamento tipoPagamento) throws SQLException {
        String sql = "INSERT INTO TipoPagamento (IdTipoPagamento, tipo) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, tipoPagamento.getIdTipoPagamento());
            pstmt.setString(2, tipoPagamento.getTipo());
            pstmt.executeUpdate();
        }
    }

    public TbTipoPagamento findById(UUID idTipoPagamento) throws SQLException {
        String sql = "SELECT * FROM TipoPagamento WHERE IdTipoPagamento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idTipoPagamento);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	TbTipoPagamento tipoPagamento = new TbTipoPagamento();
                    tipoPagamento.setIdTipoPagamento(UUID.fromString(rs.getString("IdTipoPagamento")));
                    tipoPagamento.setTipo(rs.getString("tipo"));
                    return tipoPagamento;
                }
            }
        }
        return null;
    }

    public List<TbTipoPagamento> findAll() throws SQLException {
        List<TbTipoPagamento> tipos = new ArrayList<>();
        String sql = "SELECT * FROM TipoPagamento";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	TbTipoPagamento tipoPagamento = new TbTipoPagamento();
                tipoPagamento.setIdTipoPagamento(UUID.fromString(rs.getString("IdTipoPagamento")));
                tipoPagamento.setTipo(rs.getString("tipo"));
                tipos.add(tipoPagamento);
            }
        }
        return tipos;
    }

    public void update(TbTipoPagamento tipoPagamento) throws SQLException {
        String sql = "UPDATE TipoPagamento SET tipo = ? WHERE IdTipoPagamento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoPagamento.getTipo());
            pstmt.setObject(2, tipoPagamento.getIdTipoPagamento());
            pstmt.executeUpdate();
        }
    }

    public void delete(UUID idTipoPagamento) throws SQLException {
        String sql = "DELETE FROM TipoPagamento WHERE IdTipoPagamento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idTipoPagamento);
            pstmt.executeUpdate();
        }
    }
}
