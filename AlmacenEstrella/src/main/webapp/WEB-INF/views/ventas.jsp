<%@page import="net.codejava.spring.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Ventas</title>
 <link href="https://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet">

</head>
<body onload="myFunction1()">
		<nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="index"><img alt="logo" src="<c:url value="/resources/imagenes/fondo.png" />"></a>
			    </div>
			    <ul class="nav navbar-nav">
			      <li><a href="index">Inicio</a></li>
			      <li><a href="productos">Productos</a></li>
			      <li class="active"><a href="ventas">Ventas</a></li>
			      <li><a href="reporte">Reportes</a></li>
			    </ul>
			  </div>
			</nav>
			
			<ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#realizarVenta">Realizar Venta</a></li>
    <li><a data-toggle="tab" href="#eliminarVenta">Eliminar Venta</a></li>
  </ul>
	<c:if test="${error=='true'}"><script>$(function() {  $("#myModal").modal();  });</script></c:if>

	<div class="tab-content">
	<div id="realizarVenta" class="tab-pane fade in active" style="padding:0% 10% 10% 10%">
		<center><h1 class="title">Realizar Venta</h1></center><br><br>
	
	<form action="agregarProducto" method="post" class="form-inline">
	  	
		<!-- <label>Ingrese codigo del producto</label>-->
		<input type="text"   id="codigo"  name="codigo" placeholder="Id del producto"   class="form-control" required >
		<!-- <label>Ingrese cantidad</label>-->
		<input type="text"  id="cantidad"  name="cantidad" placeholder="Ingrese cantidad"  class="form-control"  required >
		
		<input class="btn" type="submit" value="Agregar Producto" />
		
	</form>
		 
		<div>
		<c:if test="${cantidad>0 }">
		<div class="table-responsive" style="padding-top: 3%" >
		
 		 <table class="table table-striped">
 		
		<th>id</th>
		<th>Nombre</th>
		<th>Cantidad</th>
		<th>Precio</th>	
		<th>Acciones</th>
	
		<c:forEach var="producto" items="${productos }" varStatus="status">
		<tr>
		<td>${producto.id }</td>
		<td>${producto.nombre }</td>
		<th>${producto.cantidad }</th>
		<td>$${producto.precio }</td>
		<td><a href="eliminar?index=${status.index}">x</a></td>
		</tr>
		<tr>
		</tr>
		</c:forEach>
		
		
	</table>
	
	</div>
	
	<label>Total: $${total }</label>
	</c:if>
	</div>
	
	<form action="realizarVenta" method="post" class="form-inline" style="padding-top: 5%">
		<div class="form-group">
		 <input type="text" name="cajero" id="cajero" class="form-control"  placeholder="Nombre del cajero"required/>
		 </div>
		 <div class="form-group">
		<input class="btn" type="submit" value="Registrar Venta" form-control/>
		</div>
	</form>
	</div>
	
	<div class="tab-pane fade" id="eliminarVenta">
	<div style="padding: 0% 10% 10% 10%">
	<center><h1 class="title">Eliminar Venta</h1></center>
	<form action="eliminarVenta" method="post" class="form-inline">
		<div class="form-group">
		<input type="text" name="id" id="id" placeholder="Ingrese el id de la venta" class="form-control"  required/>
		</div>
		<div class="form-group">
		<input class="btn" type="submit" value="Eliminar Venta"/>
		</div>
	</form>
	</div>
	</div>
	<!-- Modal -->
			<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Error</h4>
			      </div>
			      <div class="modal-body">
			        <p>${mensaje }</p>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			
			  </div>
			  </div>
  
	</div>
</body>
</html>