<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/css/materialize.css" />
</head>
<body>
<%@ include file="cabecalhoAdm.jsp" %>
<div class="container">
<h1>PetShop Cão Q-Late</h1>
<ul class="collection with-header">
    <li class="collection-header"><h4>Menu</h4></li>
    <li class="collection-item"><div><a href="cadastroServico">Cadastrar serviço</a></div></li>
    <li class="collection-item"><div><a href="alterarServico">Alterar serviços</a></div></li>
    <li class="collection-item"><div><a href="agendaDeServicos">Agenda de serviços</a></div></li>
	<li class="collection-item"><div><a href="lancarServico">Lançar serviço</a></div></li>
	<li class="collection-item"><div><a href="relatorioDeServicos">Gerar Relatório</a></div></li>
</ul>
</div>
</body>
</html>