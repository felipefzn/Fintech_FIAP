<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${empty sessionScope.user}">
    <% response.sendRedirect("pagina_de_erro.jsp"); %>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bem-vindo ao Sistema Fintech</title>
<%@ include file="menu.jsp" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    .card-custom {
        background-color: #f8f9fa;
        border-radius: 10px;
        padding: 20px;
        margin-bottom: 20px;
    }
    .section-header {
        margin-top: 20px;
        margin-bottom: 10px;
        font-weight: bold;
    }
    .container-custom {
        padding-top: 40px;
    }
    .teacher-only {
        background-color: #f0f0f0;
        padding: 15px;
        border: 2px dashed #ccc;
        margin-top: 20px;
    }
</style>
</head>
<body>
<div class="container container-custom">
    <h1 class="text-center mb-4">Bem-vindo ao Sistema Fintech</h1>
    <div class="card shadow card-custom">
        <div class="card-body">
            <h2 class="text-center">Sobre o Sistema</h2>
            <p>Nosso sistema Fintech é projetado para ajudar usuários a gerenciar suas finanças de maneira eficiente e intuitiva. Com funcionalidades robustas, o sistema oferece suporte para o gerenciamento de cartões, recebimentos e pagamentos, proporcionando uma visão clara e detalhada das transações financeiras.</p>
            
            <div class="section-header">Funcionalidades</div>
            <ul class="list-group mb-3">
                <li class="list-group-item"><strong>Gerenciamento de Cartões:</strong> Permite que os usuários cadastrem e visualizem seus cartões de crédito e débito. As informações dos cartões incluem o tipo, número, data de validade, CVV, limite de crédito e saldo de débito.</li>
                <li class="list-group-item"><strong>Gerenciamento de Recebimentos:</strong> Usuários podem registrar e visualizar recebimentos financeiros. Cada recebimento inclui informações como tipo de recebimento, tipo de pagamento, data e hora, valor e documento anexado.</li>
                <li class="list-group-item"><strong>Relatórios Financeiros:</strong> Geração de relatórios detalhados sobre transações, ajudando na análise e planejamento financeiro.</li>
                <li class="list-group-item"><strong>Alertas e Notificações:</strong> Envio de alertas e notificações sobre vencimento de faturas, limites de crédito, e outras informações importantes.</li>
                <li class="list-group-item"><strong>Exportação de Dados:</strong> Exportação de dados financeiros para formatos como CSV e PDF, facilitando a integração com outros sistemas e análises externas.</li>
            </ul>

            <div class="section-header">Benefícios do Sistema</div>
            <ul class="list-group mb-3">
                <li class="list-group-item"><strong>Facilidade de Uso:</strong> Interface intuitiva e amigável que torna o gerenciamento financeiro simples para usuários de todos os níveis.</li>
                <li class="list-group-item"><strong>Segurança:</strong> Múltiplos níveis de segurança para garantir que as informações financeiras dos usuários estejam sempre protegidas.</li>
                <li class="list-group-item"><strong>Mobilidade:</strong> Acesso ao sistema de qualquer dispositivo com conexão à internet, permitindo gerenciamento financeiro em movimento.</li>
                <li class="list-group-item"><strong>Personalização:</strong> Possibilidade de personalizar a experiência de uso de acordo com as preferências individuais de cada usuário.</li>
                <li class="list-group-item"><strong>Suporte ao Cliente:</strong> Suporte técnico disponível para ajudar os usuários com qualquer dúvida ou problema que possam encontrar.</li>
            </ul>

            <div class="section-header">Detalhes Técnicos (Somente Para Professores)</div>
            <div class="teacher-only">
                <ul class="list-group mb-3">
                    <li class="list-group-item"><strong>Java Servlets:</strong> Utilizados para processar requisições HTTP e gerenciar a lógica do servidor.</li>
                    <li class="list-group-item"><strong>JSP (JavaServer Pages):</strong> Usado para criar páginas dinâmicas e renderizar conteúdo no lado do servidor.</li>
                    <li class="list-group-item"><strong>Bootstrap:</strong> Utilizado para estilização e design responsivo.</li>
                    <li class="list-group-item"><strong>JSTL (JavaServer Pages Standard Tag Library):</strong> Biblioteca de tags usadas para facilitar o desenvolvimento de páginas JSP.</li>
                    <li class="list-group-item"><strong>Banco de Dados:</strong> Usa SQL Server para armazenar e gerenciar dados do usuário.</li>
                </ul>

                <div class="section-header">Estrutura do Banco de Dados</div>
                <div class="row">
                    <div class="col-md-6">
                        <p><strong>Tabela Cartão:</strong></p>
                        <ul class="list-group mb-3">
                            <li class="list-group-item"><strong>IdCartao:</strong> Identificador único do cartão (UUID).</li>
                            <li class="list-group-item"><strong>IdUsuario:</strong> Identificador do usuário (UUID).</li>
                            <li class="list-group-item"><strong>TipoCartao:</strong> Tipo de cartão (Crédito/Débito).</li>
                            <li class="list-group-item"><strong>NumeroCartao:</strong> Número do cartão.</li>
                            <li class="list-group-item"><strong>DataValidade:</strong> Data de validade do cartão.</li>
                            <li class="list-group-item"><strong>CVV:</strong> Código de segurança do cartão.</li>
                            <li class="list-group-item"><strong>LimiteCredito:</strong> Limite de crédito disponível.</li>
                            <li class="list-group-item"><strong>SaldoDebito:</strong> Saldo disponível em conta corrente.</li>
                        </ul>
                    </div>
                    <div class="col-md-6">
                        <p><strong>Tabela Recebimento:</strong></p>
                        <ul class="list-group mb-3">
                            <li class="list-group-item"><strong>IdRecebimento:</strong> Identificador único do recebimento (UUID).</li>
                            <li class="list-group-item"><strong>IdUsuario:</strong> Identificador do usuário (UUID).</li>
                            <li class="list-group-item"><strong>TipoRecebimento:</strong> Tipo de recebimento (Salário, Bônus, etc.).</li>
                            <li class="list-group-item"><strong>TipoPagamento:</strong> Método de pagamento (Transferência, Cheque, etc.).</li>
                            <li class="list-group-item"><strong>DthrRecebimento:</strong> Data e hora do recebimento.</li>
                            <li class="list-group-item"><strong>ValorRecebimento:</strong> Valor recebido.</li>
                            <li class="list-group-item"><strong>DocumentoAnexado:</strong> Documento anexado ao recebimento.</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
