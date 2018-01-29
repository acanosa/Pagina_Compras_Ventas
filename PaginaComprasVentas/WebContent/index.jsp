<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- primero JQuery, SIEMPRE -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<script type="text/javascript" src="js/bootstrap.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inicio</title>
</head>
<body>
	<div class="navbar navbar-expand bg-dark navbar-dark text-white">
		<a class="navbar-brand" href="#">CompraVenta</a>
		<ul class="navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href="#">Registro</a>
			</li>
			<li class="nav-item active">
				<a class="nav-link" href="#">Contacto</a>
			</li>
		
		</ul>
	</div>

	<div class="container border border-dark bg-light h-100 justify-contents-center align-items-center text-align-center" style="width: 35%; margin-top: 3%; margin-bottom:5%;">
		<h1>Iniciar sesi&oacute;n</h1>
		<form>
			<div class="form-group" >
				<label for="usuario">Usuario: </label>
				<input class="form-control" type="text" name="usuario" id="usuario" required/>
				
			</div>
			<div class="form-group" style="margin-top: 2%;">
				<label for="clave">Clave: </label>
				<input class="form-control" type="password" name="clave" id="clave"/>
			</div>
			<div class="form-check">
				<label class="form-check-label">
					<input type="checkbox" class="form-check-input"/>Recordarme
				</label>
				
			</div>
			<div class="row">
				<a href="#" class="col">¿Olvidaste tu clave?</a>
				<a href="registro.jsp" class="col">¿No tienes una cuenta?</a>
			</div>
			<br>
			<input style="margin-bottom: 2%" align="center" type="button" class="btn btn-primary" id="loguear" value="Ingresar" onclick="this.preventDefault();"/>
		<!-- 
			<div class="row " >
				<span class="col"></span>
				<label for="usuario">Usuario: </label>
				<input class="col-6" type="text" name="usuario" id="usuario" required/>
				<span class="col"></span>
			</div>
			<div class="row" style="text-align: center;margin-top: 3%;">
				<span class="col"></span>
				<label for="clave">Clave: </label>
				<input class="col-6" type="password" name="clave" id="clave"/>
				<span class="col"></span>
			</div>
		 -->
		</form>
	</div>
>	
</body>
</html>