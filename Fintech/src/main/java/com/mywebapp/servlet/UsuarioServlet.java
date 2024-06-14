package com.mywebapp.servlet;

import com.mywebapp.dao.VoUsuario;
import com.mywebapp.model.TbUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mywebapp.dao.DaoFactory;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    private VoUsuario usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = DaoFactory.getUsuario();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<TbUsuario> usuarios = usuarioDAO.findAll();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String numero = request.getParameter("numero");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String email = request.getParameter("email");
        String pinSeguranca = request.getParameter("pinSeguranca");

        TbUsuario usuario = new TbUsuario();
        usuario.setIdUsuario(UUID.randomUUID());
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);
        usuario.setNumero(numero);
        usuario.setCpf(cpf);
        usuario.setRg(rg);
        usuario.setEmail(email);
        usuario.setPinSeguranca(pinSeguranca);

        try {
            usuarioDAO.create(usuario);
            response.sendRedirect("usuarios");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
