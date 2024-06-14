<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Recebimento</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Cadastro de Recebimento</h2>
        <form action="recebimento" method="post">
            <div class="form-group">
                <label for="tipoRecebimento">Tipo de Recebimento:</label>
                <select class="form-control" id="tipoRecebimento" name="idTipoRecebimento" required>
                    <option value="1">Tipo A</option>
                    <option value="2">Tipo B</option>
                    <option value="3">Tipo C</option>
                    <!-- Adicione mais opções conforme seus tipos de recebimento -->
                </select>
            </div>
            <div class="form-group">
                <label for="tipoPagamento">Tipo de Pagamento:</label>
                <select class="form-control" id="tipoPagamento" name="idTipoPagamento" required>
                    <option value="1">Pagamento A</option>
                    <option value="2">Pagamento B</option>
                    <option value="3">Pagamento C</option>
                    <!-- Adicione mais opções conforme seus tipos de pagamento -->
                </select>
            </div>
            <div class="form-group">
                <label for="valor">Valor:</label>
                <input type="text" class="form-control" id="valor" name="valorRecebimento" required>
            </div>
            <div class="form-group">
                <label for="documento">Documento Anexado:</label>
                <input type="text" class="form-control" id="documento" name="documentoAnexado" required>
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar Recebimento</button>
        </form>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
