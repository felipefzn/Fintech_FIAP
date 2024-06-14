package com.mywebapp.servlet;

import com.mywebapp.dao.VoCartao;
import com.mywebapp.model.TbCartao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mywebapp.dao.DaoFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@WebServlet("/cartoes")
public class CartoesServlet extends HttpServlet {

    private VoCartao cartaoDAO;

    @Override
    public void init() {
        cartaoDAO = DaoFactory.getCartao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoCartao = request.getParameter("tipoCartao");
        String numeroCartao = request.getParameter("numeroCartao");
        String dataValidade = request.getParameter("dataValidade");
        String cvv = request.getParameter("cvv");
        double limiteCredito = Double.parseDouble(request.getParameter("limiteCredito"));
        double saldoDebito = Double.parseDouble(request.getParameter("saldoDebito"));

        TbCartao cartao = new TbCartao();
        cartao.setIdCartao(UUID.randomUUID());
        cartao.setTipoCartao(tipoCartao);
        cartao.setNumeroCartao(numeroCartao);
        cartao.setDataValidade(dataValidade);
        cartao.setCvv(cvv);
        cartao.setLimiteCredito(limiteCredito);
        cartao.setSaldoDebito(saldoDebito);

        try {
            cartaoDAO.create(cartao);
            response.sendRedirect("cartoes");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
