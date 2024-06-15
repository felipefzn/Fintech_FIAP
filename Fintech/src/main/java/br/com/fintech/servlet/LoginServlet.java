package br.com.fintech.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.dao.DaoFactory;
import br.com.fintech.dao.VoUsuario;
import br.com.fintech.model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VoUsuario voUsuario;

    public LoginServlet() {
        super();
    }

    public void init() {
        voUsuario = DaoFactory.getUsuario();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pinSeguranca = request.getParameter("pinSeguranca");

        // Validando campos obrigatórios
        if (email == null || email.isEmpty() || pinSeguranca == null || pinSeguranca.isEmpty()) {
            request.setAttribute("error", "Por favor, preencha todos os campos.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
        }

        try {
            Usuario usuario = voUsuario.findByEmail(email);

            if (usuario != null && usuario.getPinSeguranca().equals(pinSeguranca)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", usuario);
                session.setAttribute("idUsuario", usuario.getIdUsuario());
                response.sendRedirect("Home.jsp");
            } else {
                request.setAttribute("error", "Usuário ou PIN de segurança incorretos.");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Erro no servidor. Por favor, tente novamente mais tarde.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}
