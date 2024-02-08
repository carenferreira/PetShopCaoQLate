<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetShop Cão Q-Late</title>
<link type="text/css" rel="stylesheet" href="resources/css/materialize.css" />
</head>
<body>
<header>
<nav class="nav-extended">
    <div class="nav-wrapper">
      <a href="menu" class="brand-logo">PetShop Cão Q-late</a>
      <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="logout">Sair</a></li>
      </ul>
    </div>
    <div class="nav-content">
      <ul class="tabs tabs-transparent">
      	<li class="tab"><a href="menu">Página inicial</a></li>
        <li class="tab"><a href="editarPerfil">Editar Perfil</a></li>
        <li class="tab"><a href="cadastroCao">Cadastrar novo cãozinho</a></li>
        <li class="tab"><a href="agendarServico">Agendar serviço</a></li>
        <li class="tab"><a href="servicosPendentes">Serviços Pendentes</a></li>
        <li class="tab"><a href="servicosPrestados">Serviços Prestados</a></li>
      </ul>
    </div>
  </nav>
</header>
</body>
</html>