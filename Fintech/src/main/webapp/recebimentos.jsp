<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Lista de Recebimentos</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Lista de Recebimentos</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tipo de Recebimento</th>
                    <th>Tipo de Pagamento</th>
                    <th>Data e Hora do Recebimento</th>
                    <th>Valor</th>
                    <th>Documento Anexado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="recebimento" items="${recebimentos}">
                    <tr>
                        <td>${recebimento.idRecebimento}</td>
                        <td>${recebimento.idTipoRecebimento}</td>
                        <td>${recebimento.idTipoPagamento}</td>
                        <td>${recebimento.dthrRecebimento}</td>
                        <td>${recebimento.valorRecebimento}</td>
                        <td>${recebimento.documentoAnexado}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
