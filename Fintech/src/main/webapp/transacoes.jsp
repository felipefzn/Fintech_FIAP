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
    <title>FinTech Solutions - Lista de Transações</title>
   
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="menu.jsp" %>
</head>
<body>
    
    <div class="container mt-5">
        <h2 class="text-center">Lista de Transações</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Data e Hora</th>
                    <th>Tipo de Transação</th>
                    <th>Valor</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
    <c:forEach items="${transacoes}" var="transacao">
        <c:choose>
            <c:when test="${transacao.status eq 'Concluida'}">
                <tr class="table-success">
            </c:when>
            <c:when test="${transacao.status eq 'Pendente'}">
                <tr class="table-warning">
            </c:when>
            <c:otherwise>
                <tr class="table-danger">
            </c:otherwise>
        </c:choose>
            <td>${transacao.dataTransacao}</td>
            <td>${transacao.tipoTransacao}</td>
            <td>${transacao.valor}</td>
            <td>${transacao.status}</td>
        </tr>
    </c:forEach>
</tbody>


        </table>
        <div class="text-center mt-4">
            <a href="cadastro_transacao.jsp" class="btn btn-primary">Nova Transação</a>
        </div>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
