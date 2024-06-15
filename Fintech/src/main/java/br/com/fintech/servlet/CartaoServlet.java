package br.com.fintech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.DaoFactory;
import br.com.fintech.dao.VoCartao;
import br.com.fintech.model.Cartao;

@WebServlet("/CartaoServlet")
public class CartaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VoCartao cartaoDAO;

    public CartaoServlet() {
        super();
    }

    public void init() {
        cartaoDAO = DaoFactory.getCartao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("idUsuario") == null) {
            response.sendRedirect("pagina_de_erro.jsp");
        } else {
            UUID idUsuario = (UUID) session.getAttribute("idUsuario");
            try {
                List<Cartao> cartoes = cartaoDAO.findAllByUsuario(idUsuario);
                request.setAttribute("cartoes", cartoes);
                request.getRequestDispatcher("cartoes.jsp").forward(request, response);
            } catch (SQLException e) {
                response.sendRedirect("erro.jsp");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipoCartao = request.getParameter("tipoCartao");
        String numeroCartao = request.getParameter("numeroCartao");
        String dataValidade = request.getParameter("dataValidade");
        String cvv = request.getParameter("cvv");
        double limiteCredito = Double.parseDouble(request.getParameter("limiteCredito"));
        double saldoDebito = Double.parseDouble(request.getParameter("saldoDebito"));
        UUID idUsuario = (UUID) request.getSession().getAttribute("idUsuario");

        // Verifica se há campos vazios
        if (tipoCartao == null || numeroCartao == null || dataValidade == null || cvv == null
                || tipoCartao.isEmpty() || numeroCartao.isEmpty() || dataValidade.isEmpty() || cvv.isEmpty()) {
            request.setAttribute("error", "Por favor, preencha todos os campos.");
            request.getRequestDispatcher("cadastro_cartao.jsp").forward(request, response);
            return;
        }

        // Verifica se o número do cartão já existe
        try {
            Cartao existingCartao = cartaoDAO.findByNumeroCartao(numeroCartao);
            if (existingCartao != null) {
                request.setAttribute("error", "Número de cartão já cadastrado.");
                request.getRequestDispatcher("cadastro_cartao.jsp").forward(request, response);
                return;
            }
        } catch (SQLException e) {
        	response.sendRedirect("erro.jsp");
        }

        // Cria um novo objeto Cartao
        Cartao cartao = new Cartao();
        cartao.setIdCartao(UUID.randomUUID());
        cartao.setIdUsuario(idUsuario);
        cartao.setTipoCartao(tipoCartao);
        cartao.setNumeroCartao(numeroCartao);
        cartao.setDataValidade(dataValidade);
        cartao.setCvv(cvv);
        cartao.setLimiteCredito(limiteCredito);
        cartao.setSaldoDebito(saldoDebito);

        // Insere o cartão no banco de dados
        try {
            cartaoDAO.create(cartao);
            response.sendRedirect("CartaoServlet");
        } catch (SQLException e) {
        	response.sendRedirect("erro.jsp");
        }
    }
    
    

}
