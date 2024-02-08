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
<%@ include file="cabecalho.jsp" %>
<div class="container">
<h1>PetShop Cão Q-Late</h1>
<ul class="collection with-header">
    <li class="collection-header"><h4>Menu</h4></li>
    <li class="collection-item"><div><a href="editarPerfil">Editar Perfil</a></div></li>
    <li class="collection-item"><div><a href="cadastroCao">Cadastrar novo cãozinho</a></div></li>
    <li class="collection-item"><div><a href="agendarServico">Agendar serviço</a></div></li>
	<li class="collection-item"><div><a href="servicosPendentes">Serviços Pendentes</a></div></li>
	<li class="collection-item"><div><a href="servicosPrestados">Serviços Prestados</a></div></li>
</ul>
</div>
</body>
</html>