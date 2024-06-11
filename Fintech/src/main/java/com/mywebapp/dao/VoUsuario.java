package com.mywebapp.dao;

import com.mywebapp.model.TbUsuario;
import com.mywebapp.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoUsuario {

    public void create(TbUsuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuario (IdUsuario, nome, sobrenome, numero, cpf, rg, email, pinSeguranca) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, usuario.getIdUsuario());
            pstmt.setString(2, usuario.getNome());
            pstmt.setString(3, usuario.getSobrenome());
            pstmt.setString(4, usuario.getNumero());
            pstmt.setString(5, usuario.getCpf());
            pstmt.setString(6, usuario.getRg());
            pstmt.setString(7, usuario.getEmail());
            pstmt.setString(8, usuario.getPinSeguranca());
            pstmt.executeUpdate();
        }
    }

    public TbUsuario findById(UUID idUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE IdUsuario = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	TbUsuario usuario = new TbUsuario();
                    usuario.setIdUsuario(UUID.fromString(rs.getString("IdUsuario")));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setSobrenome(rs.getString("sobrenome"));
                    usuario.setNumero(rs.getString("numero"));
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setRg(rs.getString("rg"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setPinSeguranca(rs.getString("pinSeguranca"));
                    return usuario;
                }
            }
        }
        return null;
    }

    public List<TbUsuario> findAll() throws SQLException {
        List<TbUsuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	TbUsuario usuario = new TbUsuario();
                usuario.setIdUsuario(UUID.fromString(rs.getString("IdUsuario")));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setNumero(rs.getString("numero"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setRg(rs.getString("rg"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPinSeguranca(rs.getString("pinSeguranca"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public void update(TbUsuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET nome = ?, sobrenome = ?, numero = ?, cpf = ?, rg = ?, email = ?, pinSeguranca = ? WHERE IdUsuario = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getSobrenome());
            pstmt.setString(3, usuario.getNumero());
            pstmt.setString(4, usuario.getCpf());
            pstmt.setString(5, usuario.getRg());
            pstmt.setString(6, usuario.getEmail());
            pstmt.setString(7, usuario.getPinSeguranca());
            pstmt.setObject(8, usuario.getIdUsuario());
            pstmt.executeUpdate();
        }
    }

    public void delete(UUID idUsuario) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE IdUsuario = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, idUsuario);
            pstmt.executeUpdate();
        }
    }
}
