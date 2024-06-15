package br.com.fintech.dao;

import br.com.fintech.model.Recebimento;
import br.com.fintech.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoRecebimento {

	public void create(Recebimento recebimento) throws SQLException {
        String sql = "INSERT INTO Recebimento (IdRecebimento, IdUsuario, tipoRecebimento, tipoPagamento, DthrRecebimento, valorRecebimento, documentoAnexado) " +
                     "VALUES (?, ?, ?, ?, CONVERT(DATETIME, ?, 104), ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, recebimento.getIdRecebimento());
            pstmt.setObject(2, recebimento.getIdUsuario());
            pstmt.setString(3, recebimento.getTipoRecebimento());
            pstmt.setString(4, recebimento.getTipoPagamento());
            pstmt.setString(5, recebimento.getDthrRecebimento());
            pstmt.setDouble(6, recebimento.getValorRecebimento());
            pstmt.setString(7, recebimento.getDocumentoAnexado());
            pstmt.executeUpdate();
        }
    }

    public Recebimento findById(UUID idRecebimento) throws SQLException {
        String sql = "SELECT * FROM Recebimento WHERE IdRecebimento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idRecebimento);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	Recebimento recebimento = new Recebimento();
                    recebimento.setIdRecebimento(UUID.fromString(rs.getString("IdRecebimento")));
                    recebimento.setIdUsuario(UUID.fromString(rs.getString("IdUsuario")));
                    recebimento.setTipoRecebimento(rs.getString("TipoRecebimento"));
                    recebimento.setTipoPagamento(rs.getString("TipoPagamento"));
                    recebimento.setDthrRecebimento(rs.getString("DthrRecebimento"));
                    recebimento.setValorRecebimento(rs.getFloat("valorRecebimento"));
                    recebimento.setDocumentoAnexado(rs.getString("documentoAnexado"));
                    return recebimento;
                }
            }
        }
        return null;
    }

    public List<Recebimento> findAll() throws SQLException {
        List<Recebimento> recebimentos = new ArrayList<>();
        String sql = "SELECT * FROM Recebimento";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	Recebimento recebimento = new Recebimento();
                recebimento.setIdRecebimento(UUID.fromString(rs.getString("IdRecebimento")));
                recebimento.setIdUsuario(UUID.fromString(rs.getString("IdUsuario")));
                recebimento.setTipoRecebimento(rs.getString("TipoRecebimento"));
                recebimento.setTipoPagamento(rs.getString("TipoPagamento"));
                recebimento.setDthrRecebimento(rs.getString("DthrRecebimento"));
                recebimento.setValorRecebimento(rs.getFloat("valorRecebimento"));
                recebimento.setDocumentoAnexado(rs.getString("documentoAnexado"));
                recebimentos.add(recebimento);
            }
        }
        return recebimentos;
    }
    
    public List<Recebimento> findAllByUsuario(UUID idUsuario) throws SQLException {
        List<Recebimento> recebimentos = new ArrayList<>();
        String sql = "SELECT * FROM recebimento WHERE idUsuario = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Recebimento recebimento = new Recebimento();
                    recebimento.setIdRecebimento(UUID.fromString(rs.getString("idRecebimento")));
                    recebimento.setIdUsuario(UUID.fromString(rs.getString("idUsuario")));
                    recebimento.setTipoRecebimento(rs.getString("tipoRecebimento"));
                    recebimento.setTipoPagamento(rs.getString("tipoPagamento"));
                    recebimento.setDthrRecebimento(rs.getString("dthrRecebimento"));
                    recebimento.setValorRecebimento(rs.getDouble("valorRecebimento"));
                    recebimento.setDocumentoAnexado(rs.getString("documentoAnexado"));
                    recebimentos.add(recebimento);
                }
            }
        }
        return recebimentos;
    }


    public void update(Recebimento recebimento) throws SQLException {
        String sql = "UPDATE Recebimento SET IdUsuario = ?, tipoRecebimento = ?, tipoPagamento = ?, DthrRecebimento = ?, valorRecebimento = ?, documentoAnexado = ? WHERE IdRecebimento = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, recebimento.getIdUsuario());
            pstmt.setObject(2, recebimento.getTipoRecebimento());
            pstmt.setObject(3, recebimento.getTipoPagamento());
            pstmt.setString(4, recebimento.getDthrRecebimento());
            pstmt.setFloat(5, (float) recebimento.getValorRecebimento());
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
