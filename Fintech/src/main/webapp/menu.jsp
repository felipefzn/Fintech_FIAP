<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Minha Aplicação</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">          
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="Home.jsp" class="nav-link" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="Dashboard.jsp" class="nav-link" aria-current="page">Dashboard</a></li>
                <li class="nav-item"><a href="RecebimentoServlet" class="nav-link">Recebimentos</a></li>
                <li class="nav-item"><a href="TransacaoServlet" class="nav-link">Transações</a></li>
                <li class="nav-item"><a href="CartaoServlet" class="nav-link">Cartões</a></li>                
                <a href="index.html" id="logoutLink">
    			<button type="button" class="btn btn-outline-danger me-2">Sair</button>
				</a>
            </ul>
        </header>
    </div>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

<script>
    document.getElementById('logoutLink').addEventListener('click', function() {
        // Limpa a sessão do usuário
        sessionStorage.removeItem('user');
        sessionStorage.removeItem('idUsuario');
      	sessionStorage.clear(); 
    });
</script>

</html>
