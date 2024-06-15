package br.com.fintech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.DaoFactory;
import br.com.fintech.dao.VoTransacao;
import br.com.fintech.model.Transacao;

@WebServlet("/TransacaoServlet")
public class TransacaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VoTransacao transacaoDAO;

    public void init() {
        transacaoDAO = DaoFactory.getTransacao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("idUsuario") == null) {
            response.sendRedirect("pagina_de_erro.jsp");
        } else {
            UUID idUsuario = (UUID) session.getAttribute("idUsuario");
            try {
                List<Transacao> transacoes = transacaoDAO.findAllByUsuario(idUsuario);
                request.setAttribute("transacoes", transacoes);
                request.getRequestDispatcher("transacoes.jsp").forward(request, response);
            } catch (SQLException e) {
                response.sendRedirect("erro.jsp");
            }
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UUID idUsuario = (UUID) session.getAttribute("idUsuario");

        String tipoTransacao = request.getParameter("tipoTransacao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        String status = request.getParameter("status");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataTransacao = sdf.format(new Date());

        Transacao transacao = new Transacao();
        transacao.setIdTransacao(UUID.randomUUID());
        transacao.setIdUsuario(idUsuario);
        transacao.setDataTransacao(dataTransacao);
        transacao.setTipoTransacao(tipoTransacao);
        transacao.setValor(valor);
        transacao.setStatus(status);

        try {
            transacaoDAO.create(transacao);
            response.sendRedirect("TransacaoServlet");
        } catch (SQLException e) {
            response.sendRedirect("erro.jsp");
        }
    }
}
