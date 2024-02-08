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
<%@ include file="cabecalhoAdm.jsp" %>
<div class="container">
	<h1>Relatório de serviços</h1>
	<h4>Informe o intervalo</h4>
	<div class="row">
	    <form class="col s12" action="buscaPorIntervalo" method="post">
	      <div class="row">
		        <div class="input-field col s6">
					<input placeholder="Data inicial" type="text" name="dataInicio" id="dataInicio">
				</div>
				<div class="input-field col s6">
					<input placeholder="Data final" type="text" name="dataFim" id="dataFim">
				</div>
				<div class="input-field col s12">
					<input class="waves-effect waves-light btn red lighten-2" type="submit" value="Pesquisar">
				</div>
			</div>
		</form>
	</div>
	<div class="row">
		<table>
			<tr>
				<th>Cão</th>
				<th>Data</th>
				<th>Servicos</th>
				<th>Valor</th>
			</tr>
			<c:forEach items="${agendamentos}" var="agendamento">
				<tr id="agendamento_${agendamento.id}">
					<td>${agendamento.cao.nome }</td>
					<td><fmt:formatDate value="${agendamento.data.time }" pattern="dd/MM/yyyy"/></td>
					<td>
						<c:forEach items="${agendamento.servicos }" var="servico">
							${servico.tipoServico.tipo }
						</c:forEach>
					</td>
					<td>${agendamento.valor}</td>
				</tr>
			</c:forEach>
		</table>
		<h4>Valor total:</h4>
		<div>R$ ${valotTotal}</div>
	</div>
</div>
</body>
</html>