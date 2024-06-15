<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empty sessionScope.idUsuario}">
    <% response.sendRedirect("pagina_de_erro.jsp"); %>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FinTech Solutions - Cadastro de Transação</title>
  
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="menu.jsp" %>
</head>
<body>
   
    <div class="container mt-5">
        <h2 class="text-center">Cadastro de Transação</h2>
        <form action="TransacaoServlet" method="post">
            <input type="hidden" name="idUsuario" value="${sessionScope.idUsuario}">
            
            <div class="form-group">
                <label for="tipoTransacao">Tipo de Transação:</label>
                <select class="form-control" id="tipoTransacao" name="tipoTransacao" required>
                    <option value="">Selecione o Tipo</option>
                    <option value="Débito">Débito</option>
                    <option value="Crédito">Crédito</option>
                </select>
            </div>
            <div class="form-group">
                <label for="valor">Valor:</label>
                <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
            </div>
            <div class="form-group">
                <label for="status">Status:</label>
                <select class="form-control" id="status" name="status" required>
                    <option value="">Selecione o Status</option>
                    <option value="Concluída">Concluida</option>
                    <option value="Pendente">Pendente</option>
                    <option value="Cancelada">Cancelada</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
        
        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3" role="alert">
                ${error}
            </div>
        </c:if>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
