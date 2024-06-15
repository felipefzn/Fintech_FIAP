package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.fintech.model.Cartao;
import br.com.fintech.util.ConnectionManager;

public class VoCartao {

    public void create(Cartao cartao) throws SQLException {
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

    public Cartao findById(UUID idCartao) throws SQLException {
        String sql = "SELECT * FROM Cartao WHERE IdCartao = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idCartao);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	Cartao cartao = new Cartao();
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

    public List<Cartao> findAll() throws SQLException {
        List<Cartao> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM Cartao";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	Cartao cartao = new Cartao();
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

    public void update(Cartao cartao) throws SQLException {
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

    public Cartao findByNumeroCartao(String numeroCartao) throws SQLException {
        Cartao cartao = null;
        String sql = "SELECT * FROM Cartao WHERE numeroCartao = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numeroCartao);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cartao = extractCartaoFromResultSet(rs);
                }
            }
        }

        return cartao;
    }
    
    public List<Cartao> findAllByUsuario(UUID idUsuario) throws SQLException {
        List<Cartao> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM cartao WHERE idUsuario = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cartao cartao = new Cartao();
                    cartao.setIdCartao(UUID.fromString(rs.getString("idCartao")));
                    cartao.setIdUsuario(UUID.fromString(rs.getString("idUsuario")));
                    cartao.setTipoCartao(rs.getString("tipoCartao"));
                    cartao.setNumeroCartao(rs.getString("numeroCartao"));
                    cartao.setDataValidade(rs.getString("dataValidade"));
                    cartao.setCvv(rs.getString("cvv"));
                    cartao.setLimiteCredito(rs.getDouble("limiteCredito"));
                    cartao.setSaldoDebito(rs.getDouble("saldoDebito"));
                    cartoes.add(cartao);
                }
            }
        }
        return cartoes;
    }  
    

  
    private Cartao extractCartaoFromResultSet(ResultSet rs) throws SQLException {
        Cartao cartao = new Cartao();
        cartao.setIdCartao(UUID.fromString(rs.getString("id_cartao")));
        cartao.setIdUsuario(UUID.fromString(rs.getString("id_usuario")));
        cartao.setTipoCartao(rs.getString("tipo_cartao"));
        cartao.setNumeroCartao(rs.getString("numero_cartao"));
        cartao.setDataValidade(rs.getString("data_validade"));
        cartao.setCvv(rs.getString("cvv"));
        cartao.setLimiteCredito(rs.getDouble("limite_credito"));
        cartao.setSaldoDebito(rs.getDouble("saldo_debito"));
        return cartao;
    }
}
