<!DOCTYPE html>
<html>
<head>
    <title>Meus Cartões</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Meus Cartões</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tipo</th>
                    <th>Número</th>
                    <th>Data de Validade</th>
                    <th>CVV</th>
                    <th>Limite de Crédito</th>
                    <th>Saldo Debito</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cartao" items="${cartoes}">
                    <tr>
                        <td>${cartao.idCartao}</td>
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
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
