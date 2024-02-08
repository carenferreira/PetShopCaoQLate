<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetShop Cão Q-Late</title>
<link type="text/css" rel="stylesheet" href="resources/css/materialize.css" />
</head>
<body>
<%@ include file="cabecalho.jsp" %>
<jsp:useBean id="cliente" class="cfs.petshop.caoqlate.dao.ClienteDAO"/>
<jsp:useBean id="usuario" class="cfs.petshop.caoqlate.dao.UsuarioDAO"/>
<div class="container">
	<h1>Agendar um servico</h1>
	<div class="row">
		<form class="col s12" action="realizaAgendamento" method="post">
			<div class="input-field col s12">
			    <input placeholder="Data" type="text" name="data" id="data">
			 </div>
			 
			
			<label for="selectedServicos">Serviço(os):</label><br>
			    <c:forEach items="${servicos}" var="servico">
			    	<label>
			        <input type="checkbox" class="filled-in" name="selectedServicos" value="${servico.id}">
			        <span>${servico.tipo}</span>
			        </label><br>
			    </c:forEach>
		    
		 
			<label for="selectedCao">Cão:</label>
	    		<select class="browser-default" name="selectedCao">
		        <c:forEach items="${cliente.buscaCaesPorCliente(usuario.buscaCliente(usuarioLogado.login).getId())}" var="cao" varStatus="id">
		            <option value="${cao.id}">${cao.nome}</option>
		        </c:forEach>
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