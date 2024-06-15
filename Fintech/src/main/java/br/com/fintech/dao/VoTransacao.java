package br.com.fintech.dao;

import br.com.fintech.model.Transacao;
import br.com.fintech.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoTransacao {

 
    public void create(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO transacao (IdTransacao, IdUsuario, DataTransacao, TipoTransacao, Valor, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, transacao.getIdTransacao());
            pstmt.setObject(2, transacao.getIdUsuario());
            pstmt.setString(3, transacao.getDataTransacao());
            pstmt.setString(4, transacao.getTipoTransacao());
            pstmt.setDouble(5, transacao.getValor());
            pstmt.setString(6, transacao.getStatus());
            pstmt.executeUpdate();
        }
    }

  
    public Transacao findById(UUID idTransacao) throws SQLException {
        String sql = "SELECT * FROM transacao WHERE IdTransacao = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idTransacao);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractTransacaoFromResultSet(rs);
                }
            }
        }
        return null;
    }

   
    public List<Transacao> findAll() throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM transacao";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Transacao transacao = extractTransacaoFromResultSet(rs);
                transacoes.add(transacao);
            }
        }
        return transacoes;
    }


    public void update(Transacao transacao) throws SQLException {
        String sql = "UPDATE transacao SET IdUsuario = ?, DataTransacao = ?, TipoTransacao = ?, Valor = ?, Status = ? WHERE IdTransacao = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, transacao.getIdUsuario());
            pstmt.setString(2, transacao.getDataTransacao());
            pstmt.setString(3, transacao.getTipoTransacao());
            pstmt.setDouble(4, transacao.getValor());
            pstmt.setString(5, transacao.getStatus());
            pstmt.setObject(6, transacao.getIdTransacao());
            pstmt.executeUpdate();
        }
    }
    
    public List<Transacao> findAllByUsuario(UUID idUsuario) throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM transacao WHERE idUsuario = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transacao transacao = new Transacao();
                    transacao.setIdTransacao(UUID.fromString(rs.getString("idTransacao")));
                    transacao.setIdUsuario(UUID.fromString(rs.getString("idUsuario")));
                    transacao.setDataTransacao(rs.getString("dataTransacao"));
                    transacao.setTipoTransacao(rs.getString("tipoTransacao"));
                    transacao.setValor(rs.getDouble("valor"));
                    transacao.setStatus(rs.getString("status"));
                    transacoes.add(transacao);
                }
            }
        }
        return transacoes;
    }


 
    public void delete(UUID idTransacao) throws SQLException {
        String sql = "DELETE FROM transacao WHERE IdTransacao = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idTransacao);
            pstmt.executeUpdate();
        }
    }

    
    private Transacao extractTransacaoFromResultSet(ResultSet rs) throws SQLException {
        Transacao transacao = new Transacao();
        transacao.setIdTransacao(UUID.fromString(rs.getString("IdTransacao")));
        transacao.setIdUsuario(UUID.fromString(rs.getString("IdUsuario")));
        transacao.setDataTransacao(rs.getString("DataTransacao"));
        transacao.setTipoTransacao(rs.getString("TipoTransacao"));
        transacao.setValor(rs.getDouble("Valor"));
        transacao.setStatus(rs.getString("Status"));
        return transacao;
    }
}
