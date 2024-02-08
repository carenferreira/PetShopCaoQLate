<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetShop Cão Q-Late</title>
<link type="text/css" rel="stylesheet" href="resources/css/materialize.css" />
</head>
<body>
<jsp:useBean id="usuario" class="cfs.petshop.caoqlate.dao.UsuarioDAO"/>
<%@ include file="cabecalho.jsp" %>
<div class="container">
	<h1>Editar informações</h1>
	<div class="row">
    	<form class="col s12" action="alterarPerfil" method="post">
      		<div class="row">
        		<div class="input-field col s6">
					<input type="text" name="nome" id="nome" class="validate"
					value="${usuario.buscaCliente(usuarioLogado.login).getNome()}" readonly>
				</div>
        		<div class="input-field col s6">
					<input type="text" name="cpf" id="cpf" class="validate"
					value="${usuario.buscaCliente(usuarioLogado.login).getCpf()}" readonly>
				</div>
				<div class="input-field col s12">
					<input type="text" name="datanascimento" id="datanascimento" class="validate"
					value='<fmt:formatDate value="${usuario.buscaCliente(usuarioLogado.login).getDatanascimento().time}" 
					pattern="dd/MM/yyyy"/>' readonly> 
				</div>
				<div class="input-field col s12">
					<input type="text" name="email" id="email" class="validate"
					value="${usuario.buscaCliente(usuarioLogado.login).getEmail()}" readonly>
				</div>
				<div class="input-field col s12">
					<input type="text" name="telefone" id="telefone" class="validate"
					value="${usuario.buscaCliente(usuarioLogado.login).getTelefone()}">
				</div>
					<input class="waves-effect waves-light btn red lighten-2" type="submit" value="Atualizar">
					<input type="hidden" name="id" value="${usuario.buscaCliente(usuarioLogado.login).getId()}">
			</div>
		</form>
	</div>
	
	<h1>Trocar senha</h1>
	<div class="row">
    	<form class="col s12" action="trocarSenha" method="post">
      		<div class="row">
        		<div class="input-field col s6">
					<input type="text" name="login" id="login"
					value="${usuarioLogado.login}" readonly>
				</div>
				<div class="input-field col s6">
					<input placeholder="Senha" type="password" name="senha" id="senha">
				</div>
					<input class="waves-effect waves-light btn red lighten-2" type="submit" value="Alterar">
					<input type="hidden" name="id" value="${usuarioLogado.id}">
					<input type="hidden" name="tipo" value="${usuarioLogado.tipo}">
			</div>
		</form>
	</div>
</div>
</body>
</html>