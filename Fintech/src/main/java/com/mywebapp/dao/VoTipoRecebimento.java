package com.mywebapp.dao;

import com.mywebapp.model.TbTipoRecebimento;
import com.mywebapp.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoTipoRecebimento {

    public void create(TbTipoRecebimento tipoRecebimento) throws SQLException {
        String sql = "INSERT INTO TipoRecebimento (IdTipoRecebimento, tipo) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, tipoRecebimento.getIdTipoRecebimento());
            pstmt.setString(2, tipoRecebimento.getTipo());
            pstmt.executeUpdate();
        }
    }

    public TbTipoRecebimento findById(UUID idTipoRecebimento) throws SQLException {
        String sql = "SELECT * FROM TipoRecebimento WHERE IdTipoRecebimento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idTipoRecebimento);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	TbTipoRecebimento tipoRecebimento = new TbTipoRecebimento();
                    tipoRecebimento.setIdTipoRecebimento(UUID.fromString(rs.getString("IdTipoRecebimento")));
                    tipoRecebimento.setTipo(rs.getString("tipo"));
                    return tipoRecebimento;
                }
            }
        }
        return null;
    }

    public List<TbTipoRecebimento> findAll() throws SQLException {
        List<TbTipoRecebimento> tipos = new ArrayList<>();
        String sql = "SELECT * FROM TipoRecebimento";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	TbTipoRecebimento tipoRecebimento = new TbTipoRecebimento();
                tipoRecebimento.setIdTipoRecebimento(UUID.fromString(rs.getString("IdTipoRecebimento")));
                tipoRecebimento.setTipo(rs.getString("tipo"));
                tipos.add(tipoRecebimento);
            }
        }
        return tipos;
    }

    public void update(TbTipoRecebimento tipoRecebimento) throws SQLException {
        String sql = "UPDATE TipoRecebimento SET tipo = ? WHERE IdTipoRecebimento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipoRecebimento.getTipo());
            pstmt.setObject(2, tipoRecebimento.getIdTipoRecebimento());
            pstmt.executeUpdate();
        }
    }

    public void delete(UUID idTipoRecebimento) throws SQLException {
        String sql = "DELETE FROM TipoRecebimento WHERE IdTipoRecebimento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idTipoRecebimento);
            pstmt.executeUpdate();
        }
    }
}
