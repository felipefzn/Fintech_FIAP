<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FinTech Solutions - Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="index.css" rel="stylesheet">
</head>

<body>
    <div class="container-fluid">
        <div class="row d-flex align-items-center justify-content-center vh-100">
            <div class="col-md-4 m-auto col-lg-3">
                <form action="login" method="post">
                    <p class="lead text-center">FinTech<span class="text-primary">Solutions</span></p>
                    <h1 class="h3 mb-3 fw-normal text-center">Login</h1>

                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="floatingInput" name="email" placeholder="name@example.com" required>
                        <label for="floatingInput">Email</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" minlength="4" maxlength="4" class="form-control" id="floatingPassword" name="pinSeguranca" placeholder="PIN de Segurança" required>
                        <label for="floatingPassword">PIN de Segurança</label>
                    </div>

                    <div class="form-check text-start my-3">
                        <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                            Lembrar de mim
                        </label>
                    </div>
                    <%-- Verifica se há mensagem de erro na request --%>
           			 <% if (request.getAttribute("error") != null) { %>
               			<div class="alert alert-danger">
                    <%= request.getAttribute("error") %>
               			 </div>
           			 <% } %>
                    <button type="submit" class="btn btn-primary w-100 py-2">Entrar</button>
                    <p class="mt-5 mb-3 text-body-secondary text-center">&copy;2023 FinTech Solutions</p>
                </form>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>

</html>
