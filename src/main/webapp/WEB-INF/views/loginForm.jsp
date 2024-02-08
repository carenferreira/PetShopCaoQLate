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
<header>
	<nav>
	    <div class="nav-wrapper">
	      <a href="#" class="brand-logo">PetShop Cão Q-late</a>
	    </div>
  	</nav>
</header>
<div class="container">
<h1>PetShop Cão Q-Late</h1>
<h4>Bem vindo!</h4>
<div class="row">
  <form class="col s12" action="efetuaLogin" method="post">
    <div class="row">
        <div class="input-field col s12">
          	<input placeholder="Login" type="text" name="login" class="validate">
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input placeholder="Senha" id="password" type="password" name="senha" class="validate">
        </div>
      </div>
      <input class="waves-effect waves-light btn red lighten-2" type="submit" name="Entrar" value="Entrar">
    </form>
 </div>
 <div class="row">
	 <div class="input-field col s12">
	 	<form action="cadastroCliente">
			<input class="waves-effect waves-light btn red lighten-2" type="submit" value="Criar conta">
		</form>
	</div>
 </div>
</div>

</body>
</html>