<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetShop Cão Q-Late</title>
<script type="text/javascript" src="resources/js/jquery-3.7.1.js"></script>
<link type="text/css" rel="stylesheet" href="resources/css/materialize.css" />
</head>
<body>
<%@ include file="cabecalho.jsp" %>
<jsp:useBean id="usuario" class="cfs.petshop.caoqlate.dao.UsuarioDAO"/>
<div class="container">
	<h1>Adicionar cão</h1>
	<div class="row">
		<form class="col s12" action="adicionaCao" method="post">
			<div class="input-field col s12"> 
				<input placeholder="Nome" type="text" name="nome" id="nome" class="validate">
			</div>
			<div class="input-field col s12">
				<input placeholder="Raça" type="text" name="raca" id="raca">
			</div>
			<label for="porte">Porte</label>
			<select class="browser-default" name="porte" id="porte">
				<option value="pequeno">Pequeno</option>
				<option value="medio">Médio</option>
				<option value="grande">Grande</option>
			</select>
			
			<div class="input-field col s12">
				<input class="waves-effect waves-light btn red lighten-2" type="submit" value="Adicionar">
			</div>
			
			<input type="hidden" name="cliente" value="${usuario.buscaCliente(usuarioLogado.login).getId()}">
		</form>
	</div>
</div>
</body>
</html>