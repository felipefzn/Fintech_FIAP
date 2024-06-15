package br.com.fintech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
import br.com.fintech.dao.VoRecebimento;
import br.com.fintech.model.Recebimento;

@WebServlet("/RecebimentoServlet")
public class RecebimentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VoRecebimento recebimentoDAO;

    public void init() {
        recebimentoDAO = DaoFactory.getRecebimento();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("idUsuario") == null) {
            response.sendRedirect("pagina_de_erro.jsp");
        } else {
            UUID idUsuario = (UUID) session.getAttribute("idUsuario");
            try {
                List<Recebimento> recebimentos = recebimentoDAO.findAllByUsuario(idUsuario);
                request.setAttribute("recebimentos", recebimentos);
                request.getRequestDispatcher("recebimentos.jsp").forward(request, response);
            } catch (SQLException e) {
                response.sendRedirect("erro.jsp");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UUID idUsuario = (UUID) session.getAttribute("idUsuario");

        String tipoRecebimento = request.getParameter("tipoRecebimento");
        String tipoPagamento = request.getParameter("tipoPagamento");
        String dthrRecebimento = request.getParameter("dthrRecebimento");
        String valorRecebimentoStr = request.getParameter("valorRecebimento");
        String documentoAnexado = request.getParameter("documentoAnexado");

        // Validar se todos os campos foram preenchidos
        if (tipoRecebimento == null || tipoPagamento == null || dthrRecebimento == null || valorRecebimentoStr == null
                || documentoAnexado == null || tipoRecebimento.isEmpty() || tipoPagamento.isEmpty()
                || dthrRecebimento.isEmpty() || valorRecebimentoStr.isEmpty() || documentoAnexado.isEmpty()) {
            response.sendRedirect("erro.jsp");
            return;
        }

        // Validar e converter valorRecebimento para double
        double valorRecebimento;
        try {
            valorRecebimento = Double.parseDouble(valorRecebimentoStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("erro.jsp");
            return;
        }

        // Converter formato de data
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formattedDate;
        try {
            Date date = originalFormat.parse(dthrRecebimento);
            formattedDate = targetFormat.format(date);
        } catch (ParseException e) {
            throw new ServletException("Data de recebimento inválida, use o formato yyyy-MM-dd'T'HH:mm", e);
        }

        Recebimento recebimento = new Recebimento();
        recebimento.setIdRecebimento(UUID.randomUUID());
        recebimento.setIdUsuario(idUsuario);
        recebimento.setTipoRecebimento(tipoRecebimento);
        recebimento.setTipoPagamento(tipoPagamento);
        recebimento.setDthrRecebimento(formattedDate);
        recebimento.setValorRecebimento(valorRecebimento);
        recebimento.setDocumentoAnexado(documentoAnexado);

        try {
            recebimentoDAO.create(recebimento);
            response.sendRedirect("RecebimentoServlet");
        } catch (SQLException e) {
            response.sendRedirect("erro.jsp");
        }
    }
}
