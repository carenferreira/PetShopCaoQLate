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
<script type="text/javascript" src="resources/js/jquery-3.7.1.js"></script>
</head>
<body>
<jsp:useBean id="usuario" class="cfs.petshop.caoqlate.dao.UsuarioDAO"/>
<jsp:useBean id="agendamentos" class="cfs.petshop.caoqlate.dao.AgendamentosDAO"/>
<%@ include file="cabecalho.jsp" %>
<div class="container">
	<h4>Lista de serviços prestados</h4>
	<table>
		<tr>
			<th>Cão</th>
			<th>Data</th>
			<th>Servicos</th>
			<th>Valor</th>
		</tr>
		<c:forEach items="${agendamentos.buscaAgendamentosRealizados(usuario.buscaCliente(usuarioLogado.login))}" var="agendamento">
			<tr id="agendamento_${agendamento.id}">
				<td>${agendamento.cao.nome }</td>
				<td><fmt:formatDate value="${agendamento.data.time }" pattern="dd/MM/yyyy"/></td>
				<td>
					<c:forEach items="${agendamento.servicos }" var="servico">
						${servico.tipoServico.tipo }
					</c:forEach>
				</td>
				<td>R$ ${agendamento.valor}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>