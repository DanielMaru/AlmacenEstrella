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
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Ventas</title>

</head>
<body>

	<c:if test="${error=='true'}"><script>$(function() {  $("#myModal").modal();  });</script></c:if>
	<h1>Agregar ventas</h1>
	<form action="agregarProducto" method="post">
		<label>Ingrese codigo del producto</label>
		<input type="text" id="codigo" name="codigo" required/>
		<label>Ingrese cantidad</label>
		<input type="text" id="cantidad" name="cantidad" required/>
		<input type="submit" value="Agregar Producto"/>
	</form>
	<table border="1px">
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
		<td>${producto.precio }</td>
		<td><a href="eliminarProducto?index=${status.index}">x</a></td>
		</tr>
		</c:forEach>
	</table>
	<label>Total: ${total }</label>
	
	
	<form action="realizarVenta" method="post">
		<label>Cajero:</label> <input type="text" name="cajero" id="cajero" required/>
		<input type="submit" value="Registrar Venta"/>
	</form>
	
	<h1>Eliminar Venta</h1>
	<form action="eliminarVenta" method="post">
		<label>Id de la venta</label>
		<input type="text" name="id" id="id"/>
		<input type="submit" value="Eliminar Venta"/>
	</form>
	
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
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
  </div>
  
	
</body>
</html>