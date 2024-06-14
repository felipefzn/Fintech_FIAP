package com.mywebapp.servlet;

import com.mywebapp.dao.VoUsuario;
import com.mywebapp.model.TbUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.mywebapp.dao.DaoFactory;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private VoUsuario usuarioDAO;
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    public void init() {
        usuarioDAO = DaoFactory.getUsuario();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pinSeguranca = request.getParameter("pinSeguranca");

        if (email == null || pinSeguranca == null || email.isEmpty() || pinSeguranca.isEmpty()) {
            response.sendRedirect("login.jsp?error=empty");
            return;
        }

        try {
            TbUsuario usuario = usuarioDAO.findByEmail(email);
            if (usuario != null && usuario.getPinSeguranca().equals(pinSeguranca)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", usuario);
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("login.jsp?error=invalid");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Login failed", e);
            response.sendRedirect("login.jsp?error=server");
        }
    }
}
