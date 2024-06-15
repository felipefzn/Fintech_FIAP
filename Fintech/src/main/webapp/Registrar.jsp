<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário - Fintech</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>   
    <div class="container col-xl-10 col-xxl-8 px-4 py-5">
        <div class="row align-items-center g-lg-5 py-5">
            <div class="col-lg-7 text-center text-lg-start">
                <h1 class="display-4 fw-bold lh-1 text-body-emphasis mb-3">Fintech</h1>
                <p class="col-lg-10 fs-4"></p>
                <a href="index.html" class="btn btn-secondary btn-lg mb-3">Voltar para a Página Inicial</a>
            </div>
            <div class="col-md-10 mx-auto col-lg-5">
                <form action="UsuarioServlet" method="post" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
                    <div class="form-group row mb-3">
                        <div class="col-md-12">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" id="nome" name="nome" placeholder="Seu Nome" required>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <div class="col-md-12">
                            <label for="sobrenome">Sobrenome</label>
                            <input type="text" class="form-control" id="sobrenome" name="sobrenome" placeholder="Seu Sobrenome" required>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <div class="col-md-12">
                            <label for="numero">Telefone</label>
                            <input type="tel" class="form-control" id="numero" name="numero" placeholder="Seu Telefone" required>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <div class="col-md-12">
                            <label for="cpf">CPF</label>
                            <input type="text" class="form-control" id="cpf" name="cpf" placeholder="Seu CPF" required>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <div class="col-md-12">
                            <label for="rg">RG</label>
                            <input type="text" class="form-control" id="rg" name="rg" placeholder="Seu RG">
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <div class="col-md-12">
                            <label for="email">E-mail</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
                        </div>
                    </div>
                    <div class="form-group mb-3">
                        <label for="pinSeguranca">Pin de Segurança</label>
                        <input type="password" class="form-control" id="pinSeguranca" name="pinSeguranca" placeholder="Pin de Segurança" required>
                    </div>
                    <div class="form-check mb-3">
                        <input class="form-check-input" type="checkbox" id="rememberMe" name="rememberMe">
                        <label class="form-check-label" for="rememberMe">
                            Lembrar de mim
                        </label>
                    </div>
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Cadastrar</button>
                    <hr class="my-4">
                    <small class="text-body-secondary">Ao clicar em Cadastrar, você concorda com os termos de uso.</small>
                </form>
            </div>
        </div>
    </div>  
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
