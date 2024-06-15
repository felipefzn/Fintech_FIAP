<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empty sessionScope.idUsuario}">
    <% response.sendRedirect("pagina_de_erro.jsp"); %>
</c:if>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Recebimento</title>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <%@ include file="menu.jsp" %>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Cadastro de Recebimento</h2>
        <form id="formRecebimento" action="RecebimentoServlet" method="post">
            <input type="hidden" name="idUsuario" value="${sessionScope.user.idUsuario}">            
            <div class="form-group">
    <label for="tipoRecebimento">Tipo de Recebimento:</label>
    <select class="form-control" id="tipoRecebimento" name="tipoRecebimento" required>
        <option value="">Selecione o Tipo de Recebimento</option>
        <option value="Salário">Salário</option>
        <option value="Freelancer">Freelancer</option>
        <option value="Venda de Produto">Venda de Produto</option>
        <option value="Serviços Prestados">Serviços Prestados</option>
        <option value="Outro">Outro</option>
    </select>
</div>

<div class="form-group">
    <label for="tipoPagamento">Tipo de Pagamento:</label>
    <select class="form-control" id="tipoPagamento" name="tipoPagamento" required>
        <option value="">Selecione o Tipo de Pagamento</option>
        <option value="Débito">Débito</option>
        <option value="Crédito">Crédito</option>
        <option value="Transferência Bancária">Transferência Bancária</option>
        <option value="Dinheiro">Dinheiro</option>
        <option value="Boleto">Boleto</option>
    </select>
</div>

            <div class="form-group">
                <label for="dthrRecebimento">Data e Hora do Recebimento:</label>
                <input type="datetime-local" class="form-control" id="dthrRecebimento" name="dthrRecebimento" required>
            </div>
            <div class="form-group">
                <label for="valorRecebimento">Valor do Recebimento:</label>
                <input type="number" step="0.01" class="form-control" id="valorRecebimento" name="valorRecebimento" required>
            </div>
            <div class="form-group">
                <label for="documentoAnexado">Documento Anexado:</label>
                <input type="text" class="form-control" id="documentoAnexado" name="documentoAnexado" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
        </form>
    </div>

 
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        
        document.getElementById('formRecebimento').addEventListener('submit', function(event) {
            
            var tipoRecebimento = document.getElementById('tipoRecebimento').value.trim();
            var tipoPagamento = document.getElementById('tipoPagamento').value.trim();
            var dthrRecebimento = document.getElementById('dthrRecebimento').value.trim();
            var valorRecebimento = document.getElementById('valorRecebimento').value.trim();
            var documentoAnexado = document.getElementById('documentoAnexado').value.trim();

            if (!tipoRecebimento || !tipoPagamento || !dthrRecebimento || !valorRecebimento || !documentoAnexado) {
                alert('Por favor, preencha todos os campos.');
                event.preventDefault();
            }
        });
    </script>
</body>
</html>
