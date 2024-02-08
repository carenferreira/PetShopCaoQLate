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
<h1>Criar conta</h1>
	<div class="row">
	  <form class="col s12" action="emailConfirmacao" method="post">
	    <div class="row">
	        <div class="input-field col s12">
	          	<input placeholder="Login" type="text" name="login" id="login" class="validate">
	        </div>
	       <div class="input-field col s12">
	         <input placeholder="Senha" type="password" name="senha" id="senha" class="validate">
	       </div>
	      </div>
	      <input class="waves-effect waves-light btn red lighten-2" type="submit" name="Entrar" value="Cadastrar">
	    </form>
	 </div>
</div>
</body>
</html>