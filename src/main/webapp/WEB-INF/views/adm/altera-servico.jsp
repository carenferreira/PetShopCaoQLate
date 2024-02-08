<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>Tabela de Serviços</h1>
	<table>
		<tr>
			<th>Serviço</th>
			<th>Valor</th>
			<th>Alterar</th>
		</tr>
		<c:forEach items="${servicos}" var="servico">
			<tr id="servico_${servico.id }">
				<td>${servico.tipo }</td>
				<td>${servico.preco }</td>
				<td> <a href="mostraServico?id=${servico.id }">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>