package com.mywebapp.servlet;

import com.mywebapp.dao.VoRecebimento;
import com.mywebapp.model.TbRecebimento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet("/recebimentos")
public class RecebimentoServlet extends HttpServlet {

    private VoRecebimento recebimentoDAO;

    @Override
    public void init() {
        recebimentoDAO = new VoRecebimento(); // Obtém uma instância do DAO de recebimento
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperar os parâmetros do formulário
        UUID idUsuario = (UUID) request.getSession().getAttribute("user_id"); // Supondo que você tenha um id de usuário na sessão
        UUID idTipoRecebimento = UUID.fromString(request.getParameter("idTipoRecebimento"));
        UUID idTipoPagamento = UUID.fromString(request.getParameter("idTipoPagamento"));
        double valorRecebimento = Double.parseDouble(request.getParameter("valorRecebimento"));
        String documentoAnexado = request.getParameter("documentoAnexado");
        String dthrRecebimento = request.getParameter("dthrRecebimento"); // Captura a data de recebimento do formulário

        // Criar objeto de recebimento
        TbRecebimento recebimento = new TbRecebimento();
        recebimento.setIdRecebimento(UUID.randomUUID());
        recebimento.setIdUsuario(idUsuario);
        recebimento.setIdTipoRecebimento(idTipoRecebimento);
        recebimento.setIdTipoPagamento(idTipoPagamento);
        recebimento.setValorRecebimento(valorRecebimento);
        recebimento.setDocumentoAnexado(documentoAnexado);
        recebimento.setDthrRecebimento(dthrRecebimento); // Define a data de recebimento conforme fornecido pelo usuário

        try {
            // Salvar o recebimento no banco de dados
            recebimentoDAO.create(recebimento);
            response.sendRedirect("recebimentos"); // Redirecionar para a página de listagem de recebimentos
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<TbRecebimento> recebimentos = recebimentoDAO.findAll(); // Recupera todos os recebimentos do banco de dados
            request.setAttribute("recebimentos", recebimentos);
            request.getRequestDispatcher("recebimentos.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
