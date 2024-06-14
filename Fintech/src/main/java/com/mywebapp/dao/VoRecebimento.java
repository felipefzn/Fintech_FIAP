package com.mywebapp.dao;

import com.mywebapp.model.TbRecebimento;
import com.mywebapp.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoRecebimento {

    public void create(TbRecebimento recebimento) throws SQLException {
        String sql = "INSERT INTO Recebimento (IdRecebimento, IdUsuario, IdTipoRecebimento, IdTipoPagamento, DthrRecebimento, valorRecebimento, documentoAnexado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, recebimento.getIdRecebimento());
            pstmt.setObject(2, recebimento.getIdUsuario());
            pstmt.setObject(3, recebimento.getIdTipoRecebimento());
            pstmt.setObject(4, recebimento.getIdTipoPagamento());
            pstmt.setString(5, recebimento.getDthrRecebimento());
            pstmt.setFloat(6, recebimento.getValorRecebimento());
            pstmt.setString(7, recebimento.getDocumentoAnexado());
            pstmt.executeUpdate();
        }
    }

    public TbRecebimento findById(UUID idRecebimento) throws SQLException {
        String sql = "SELECT * FROM Recebimento WHERE IdRecebimento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idRecebimento);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	TbRecebimento recebimento = new TbRecebimento();
                    recebimento.setIdRecebimento(UUID.fromString(rs.getString("IdRecebimento")));
                    recebimento.setIdUsuario(UUID.fromString(rs.getString("IdUsuario")));
                    recebimento.setIdTipoRecebimento(UUID.fromString(rs.getString("IdTipoRecebimento")));
                    recebimento.setIdTipoPagamento(UUID.fromString(rs.getString("IdTipoPagamento")));
                    recebimento.setDthrRecebimento(rs.getString("DthrRecebimento"));
                    recebimento.setValorRecebimento(rs.getFloat("valorRecebimento"));
                    recebimento.setDocumentoAnexado(rs.getString("documentoAnexado"));
                    return recebimento;
                }
            }
        }
        return null;
    }

    public List<TbRecebimento> findAll() throws SQLException {
        List<TbRecebimento> recebimentos = new ArrayList<>();
        String sql = "SELECT * FROM Recebimento";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	TbRecebimento recebimento = new TbRecebimento();
                recebimento.setIdRecebimento(UUID.fromString(rs.getString("IdRecebimento")));
                recebimento.setIdUsuario(UUID.fromString(rs.getString("IdUsuario")));
                recebimento.setIdTipoRecebimento(UUID.fromString(rs.getString("IdTipoRecebimento")));
                recebimento.setIdTipoPagamento(UUID.fromString(rs.getString("IdTipoPagamento")));
                recebimento.setDthrRecebimento(rs.getString("DthrRecebimento"));
                recebimento.setValorRecebimento(rs.getFloat("valorRecebimento"));
                recebimento.setDocumentoAnexado(rs.getString("documentoAnexado"));
                recebimentos.add(recebimento);
            }
        }
        return recebimentos;
    }

    public void update(TbRecebimento recebimento) throws SQLException {
        String sql = "UPDATE Recebimento SET IdUsuario = ?, IdTipoRecebimento = ?, IdTipoPagamento = ?, DthrRecebimento = ?, valorRecebimento = ?, documentoAnexado = ? WHERE IdRecebimento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, recebimento.getIdUsuario());
            pstmt.setObject(2, recebimento.getIdTipoRecebimento());
            pstmt.setObject(3, recebimento.getIdTipoPagamento());
            pstmt.setString(4, recebimento.getDthrRecebimento());
            pstmt.setFloat(5, recebimento.getValorRecebimento());
            pstmt.setString(6, recebimento.getDocumentoAnexado());
            pstmt.setObject(7, recebimento.getIdRecebimento());
            pstmt.executeUpdate();
        }
    }

    public void delete(UUID idRecebimento) throws SQLException {
        String sql = "DELETE FROM Recebimento WHERE IdRecebimento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idRecebimento);
            pstmt.executeUpdate();
        }
    }
}
