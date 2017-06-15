<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet">
        <script  src="https://code.jquery.com/jquery-3.2.1.min.js"  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="  crossorigin="anonymous"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/productos.js" />"></script>
		<title>Productos</title>
	</head>
	<body>
		<nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href=""><img alt="logo" src="<c:url value="/resources/imagenes/fondo.png" />"></a>
			    </div>
			    <ul class="nav navbar-nav">
			      <li class="active"><a href="#">Inicio</a></li>
			      <li><a href="#">Productos</a></li>
			      <li><a href="#">Ventas</a></li>
			      <li><a href="#">Reportes</a></li>
			    </ul>
			  </div>
		</nav>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<center><h1>Productos</h1></center>
				<div class="margenRow row ">
					<div class="col-md-6 col-md-offset-3">
						<form class="form-inline">
						  <div class="form-group">
						    <label for="id">Buscar:</label>
						    <input type="id" class="form-control" id="idProducto">
						  </div>
						  <button type="button" class="btn btn-default" id="btnBuscar">Buscar</button>
						</form>
					</div>					
				</div>
				<div class="margenRow row">
						<div class="col-md-8 col-md-offset-2">
						<form:form action="guardarProducto" method="post" modelAttribute="producto" class="form-horizontal">
						  <div class="form-group">
						    <label class="control-label col-sm-2" for="nombre">Nombre:</label>
						    <div class="col-sm-6">
						      <Form:input path="nombre" type="nombre" class="form-control" id="nombre" placeholder="Ingrese el nombre">
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-2" for="categoria">Categoria</label>
						    <div class="col-sm-6"> 
						      <select class="form-control" id="categoria" name="categoria">
						        <option value="1">Hogar</option>
						        <option value="2">Tecnologia</option>
						        <option value="3">Moda</option>						        
						      </select>
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-2" for="descripcion">Descripcion:</label>
						    <div class="col-sm-6"> 
						      <input type="text" class="form-control" id="descripcion" placeholder="Ingrese la descripcion">
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-2" for="precio">Precio:</label>
						    <div class="col-sm-6"> 
						      <input type="number" class="form-control" id="precio" placeholder="Ingrese el precio">
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="control-label col-sm-2" for="cantidad">Cantidad:</label>
						    <div class="col-sm-6"> 
						      <input type="number" class="form-control" id="cantidad" placeholder="Ingrese la cantidad">
						    </div>
						  </div>						  
						  <div class="form-group"> 
						    <div class="col-sm-2">
						      <button type="submit" class="btn btn-default">Guardar</button>
						    </div>
						    <div class="col-sm-4">
						      <button type="submit" class="btn btn-default">Eliminar</button>
						    </div>
						  </div>
						</form:form>
						</div>
					</div>		
				</div>
			</div>
		</div>
	</body>
</html>