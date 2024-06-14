<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Inserir Cartão</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Inserir Novo Cartão</h2>
        <form action="<%= request.getContextPath() %>/cartoes" method="post">
            <div class="form-group">
                <label for="tipoCartao">Tipo de Cartão:</label>
                <input type="text" class="form-control" id="tipoCartao" name="tipoCartao" required>
            </div>
            <div class="form-group">
                <label for="numeroCartao">Número do Cartão:</label>
                <input type="text" class="form-control" id="numeroCartao" name="numeroCartao" required>
            </div>
            <div class="form-group">
                <label for="dataValidade">Data de Validade:</label>
                <input type="text" class="form-control" id="dataValidade" name="dataValidade" placeholder="MM/AAAA" required>
            </div>
            <div class="form-group">
                <label for="cvv">CVV:</label>
                <input type="text" class="form-control" id="cvv" name="cvv" required>
            </div>
            <div class="form-group">
                <label for="limiteCredito">Limite de Crédito:</label>
                <input type="text" class="form-control" id="limiteCredito" name="limiteCredito" required>
            </div>
            <div class="form-group">
                <label for="saldoDebito">Saldo Debito:</label>
                <input type="text" class="form-control" id="saldoDebito" name="saldoDebito" required>
            </div>
            <button type="submit" class="btn btn-primary">Inserir Cartão</button>
        </form>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
