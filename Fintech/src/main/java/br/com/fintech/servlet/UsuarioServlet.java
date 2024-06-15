package br.com.fintech.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.dao.DaoFactory;
import br.com.fintech.dao.VoUsuario;
import br.com.fintech.model.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VoUsuario usuario;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() {
    	usuario = DaoFactory.getUsuario();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String numero = request.getParameter("numero");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String email = request.getParameter("email");
        String pinSeguranca = request.getParameter("pinSeguranca");

        Usuario Tbusuario = new Usuario();
        Tbusuario.setIdUsuario(UUID.randomUUID());
        Tbusuario.setNome(nome);
        Tbusuario.setSobrenome(sobrenome);
        Tbusuario.setNumero(numero);
        Tbusuario.setCpf(cpf);
        Tbusuario.setRg(rg);
        Tbusuario.setEmail(email);
        Tbusuario.setPinSeguranca(pinSeguranca);

        try {
            usuario.create(Tbusuario);
            response.sendRedirect("Home.jsp");
        } catch (SQLException e) {
        	response.sendRedirect("erro.jsp");
        }
    }

}
