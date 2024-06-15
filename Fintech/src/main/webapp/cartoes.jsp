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
    <title>FinTech Solutions - Lista de Cartões</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="menu.jsp" %>
</head>
<body>
    <!-- Conteúdo da página -->
    <div class="container mt-5">
        <h2 class="text-center">Lista de Cartões</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Tipo de Cartão</th>
                    <th>Número do Cartão</th>
                    <th>Data de Validade</th>
                    <th>CVV</th>
                    <th>Limite de Crédito</th>
                    <th>Saldo Débito</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cartoes}" var="cartao">
                    <tr>
                        <td>${cartao.tipoCartao}</td>
                        <td>${cartao.numeroCartao}</td>
                        <td>${cartao.dataValidade}</td>
                        <td>${cartao.cvv}</td>
                        <td>${cartao.limiteCredito}</td>
                        <td>${cartao.saldoDebito}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="text-center mt-4">
            <a href="cadastro_cartao.jsp" class="btn btn-primary">Adicionar Cartão</a>
        </div>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
