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
    <title>FinTech Solutions - Lista de Recebimentos</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="menu.jsp" %>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Lista de Recebimentos</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Tipo de Recebimento</th>
                    <th>Tipo de Pagamento</th>
                    <th>Data e Hora do Recebimento</th>
                    <th>Valor do Recebimento</th>
                    <th>Documento Anexado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="recebimento" items="${recebimentos}">
                    <tr>
                        <td>${recebimento.tipoRecebimento}</td>
                        <td>${recebimento.tipoPagamento}</td>
                        <td>${recebimento.dthrRecebimento}</td>
                        <td>${recebimento.valorRecebimento}</td>
                        <td>${recebimento.documentoAnexado}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="text-center">
            <a href="cadastro_recebimento.jsp" class="btn btn-primary">Novo Recebimento</a>
        </div>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
