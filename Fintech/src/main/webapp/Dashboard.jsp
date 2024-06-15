<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empty sessionScope.idUsuario}">
    <% response.sendRedirect("pagina_de_erro.jsp"); %>
</c:if>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FinTech Solutions - Dashboard</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="index.css" rel="stylesheet">
    <%@ include file="menu.jsp" %>
</head>

<body>   
    <div class="container mt-5">
        <h2 class="text-center mb-4">Dashboard</h2>
        
        <div class="row">
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card text-white bg-primary">
                    <div class="card-body">
                        <h5 class="card-title">Total Recebimentos</h5>
                        <p class="card-text" id="totalRecebimentos">R$ 0,00</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card text-white bg-success">
                    <div class="card-body">
                        <h5 class="card-title">Total Gastos</h5>
                        <p class="card-text" id="totalGastos">R$ 0,00</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card text-white bg-warning">
                    <div class="card-body">
                        <h5 class="card-title">Saldo Atual</h5>
                        <p class="card-text" id="saldoAtual">R$ 0,00</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="card text-white bg-danger">
                    <div class="card-body">
                        <h5 class="card-title">Limite de CrÃ©dito</h5>
                        <p class="card-text" id="limiteCredito">R$ 0,00</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <canvas id="recebimentosChart"></canvas>
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-qA6OBU8I8B1F/NfYHfjwncmthXDWAE2nQEEGqk9CE5C89U2S7RaEr/4tUGhHmejE"
        crossorigin="anonymous"></script>
    
  
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    
    
    <script>
        document.addEventListener('DOMContentLoaded', (event) => {
            // Sample data, replace with actual data
            const totalRecebimentos = 12345.67;
            const totalGastos = 4567.89;
            const saldoAtual = totalRecebimentos - totalGastos;
            const limiteCredito = 10000.00;

            document.getElementById('totalRecebimentos').innerText = `R$ ${totalRecebimentos.toFixed(2)}`;
            document.getElementById('totalGastos').innerText = `R$ ${totalGastos.toFixed(2)}`;
            document.getElementById('saldoAtual').innerText = `R$ ${saldoAtual.toFixed(2)}`;
            document.getElementById('limiteCredito').innerText = `R$ ${limiteCredito.toFixed(2)}`;

            const ctx = document.getElementById('recebimentosChart').getContext('2d');
            const recebimentosChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: ['January', 'February', 'March', 'April', 'May', 'June'],
                    datasets: [{
                        label: 'Recebimentos',
                        data: [1200, 1500, 1800, 1700, 1900, 2100],
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        });
    </script>
</body>

</html>
