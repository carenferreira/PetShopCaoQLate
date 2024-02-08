<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetShop Cão Q-late</title>
<link type="text/css" rel="stylesheet" href="resources/css/materialize.css" />
</head>
<body>
<header>
	<nav>
	    <div class="nav-wrapper">
	      <a href="#" class="brand-logo">PetShop Cão Q-late</a>
	    </div>
  	</nav>
</header>

<div class="container">
	<h1>Adicionar Cliente</h1>
	<div class="row">
	  <form class="col s12" action="adicionaCliente" method="post">
	    <div class="row">
	        <div class="input-field col s12">
				<input placeholder="Nome" type="text" name="nome" id="nome" class="validate">
			</div>
			<div class="input-field col s12">
				<input placeholder="CPF" type="text" name="cpf" id="cpf">
			</div>
			<div class="input-field col s12">
				<input placeholder="Data nascimento" type="text" name="datanascimento" id="datanascimento">
			</div>
			<div class="input-field col s12">
				<input placeholder="Email" type="text" name="email" id="email">
			</div>
			<div class="input-field col s12">
				<input placeholder="Telefone" type="text" name="telefone" id="telefone">
			</div>
			<input class="waves-effect waves-light btn red lighten-2" type="submit" value="Adicionar">
		</div>
	</form>
	</div>
</div>
</body>
</html>