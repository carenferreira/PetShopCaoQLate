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
<%@ include file="cabecalhoAdm.jsp" %>
<div class="container">
	<h1>Cadastro serviço</h1>
	<div class="row">
	    <form class="col s12" action="adicionaServico" method="get">
	      <div class="row">
	        <div class="input-field col s6">
				<input placeholder="Serviço" type="text" name="tipo" id="tipo">
			</div>
        	<div class="input-field col s6">
				<input placeholder="Valor" type="text" name="preco" id="preco">
			</div>
			<div class="input-field col s12">
				<input class="waves-effect waves-light btn red lighten-2" type="submit" value="Cadastrar">
			</div>
	      </div>
		</form>
	</div>
</div>
</body>
</html>