<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Bem-vindo à sua página inicial</h2>
        <p>Olá, ${user.nome}! Você está logado com sucesso.</p>
        <p>Aqui você pode adicionar o conteúdo e funcionalidades que desejar para a página inicial.</p>
        <a href="/logout" class="btn btn-danger">Sair</a>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
