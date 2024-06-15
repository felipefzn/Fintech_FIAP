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
    <title>Cadastro de Cartão</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
      <%@ include file="menu.jsp" %>    
    <style>
        .form-floating label {
            padding-top: 0.625rem;
            font-size: 0.875rem;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0">Cadastro de Cartão</h4>
                    </div>
                    <div class="card-body">
                        <form id="formCadastroCartao" action="CartaoServlet" method="post">
                            
                            <% String errorMessage = (String) request.getAttribute("errorMessage");
                            if (errorMessage != null && !errorMessage.isEmpty()) { %>
                                <div class="alert alert-danger" role="alert">
                                    <%= errorMessage %>
                                </div>
                            <% } %>

                           
                            <div class="form-group">
                                <label for="tipoCartao">Tipo de Cartão</label>
                                <input type="text" class="form-control" id="tipoCartao" name="tipoCartao" placeholder="Tipo de Cartão" required>
                            </div>

                           
                            <div class="form-group">
                                <label for="numeroCartao">Número do Cartão</label>
                                <input type="text" class="form-control" id="numeroCartao" name="numeroCartao" placeholder="Número do Cartão" required>
                            </div>

                            <div class="form-row">
                                
                                <div class="form-group col-md-6">
                                    <label for="dataValidade">Data de Validade</label>
                                    <input type="text" class="form-control" id="dataValidade" name="dataValidade" placeholder="MM/AAAA" required>
                                </div>
                               
                                <div class="form-group col-md-6">
                                    <label for="cvv">CVV</label>
                                    <input type="text" class="form-control" id="cvv" name="cvv" placeholder="CVV" required>
                                </div>
                            </div>

                            <div class="form-row">
                               
                                <div class="form-group col-md-6">
                                    <label for="limiteCredito">Limite de Crédito</label>
                                    <input type="number" step="0.01" class="form-control" id="limiteCredito" name="limiteCredito" placeholder="Limite de Crédito" required>
                                </div>
                             
                                <div class="form-group col-md-6">
                                    <label for="saldoDebito">Saldo de Débito</label>
                                    <input type="number" step="0.01" class="form-control" id="saldoDebito" name="saldoDebito" placeholder="Saldo de Débito" required>
                                </div>
                            </div>

                         
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS e dependências -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  
    <script>
 
        (function() {
            'use strict';
          
            var forms = document.querySelectorAll('.needs-validation');
            
            Array.prototype.slice.call(forms)
                .forEach(function(form) {
                    form.addEventListener('submit', function(event) {
                        if (!form.checkValidity()) {
                            event.preventDefault();
                            event.stopPropagation();
                        }

                        form.classList.add('was-validated');
                    }, false);
                });
        })();
    </script>
</body>
</html>
