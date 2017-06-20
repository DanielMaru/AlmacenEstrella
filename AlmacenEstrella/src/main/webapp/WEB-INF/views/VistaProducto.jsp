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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/productos.js" />"></script>
		<title>Productos</title>
	</head>
	<body>
		<c:if test="${alerta!=null}"><script>$(function() {  $("#myModal").modal();  });</script></c:if>
		<nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="index"><img alt="logo" src="<c:url value="/resources/imagenes/fondo.png" />"></a>
			    </div>
			    <ul class="nav navbar-nav">
			      <li><a href="index">Inicio</a></li>
			      <li class="active"><a href="productos">Productos</a></li>
			      <li><a href="ventas">Ventas</a></li>
			      <li><a href="reporte">Reportes</a></li>
			    </ul>
			  </div>
		</nav>
		<ul class="nav nav-tabs">
		<c:choose><c:when test="${guardar==null}">    
			<li class="active"><a data-toggle="tab" href="#tabBuscar">Buscar</a></li>
		    <li><a data-toggle="tab" href="#tabAgregar">Agregar</a></li>		
		</c:when><c:otherwise>    
			<li><a data-toggle="tab" href="#tabBuscar">Buscar</a></li>
		    <li class="active"><a data-toggle="tab" href="#tabAgregar">Agregar</a></li>		
		</c:otherwise></c:choose>
		    
		</ul>
		
		<div class="tab-content">
			<c:choose><c:when test="${guardar==null}"><div id="tabBuscar" class="tab-pane fade in active"></c:when><c:otherwise><div id="tabBuscar" class="tab-pane fade"></c:otherwise></c:choose>
		    
		    
		    <div class="row">
				<div class="col-md-6 col-md-offset-3">
					<center><h1>Buscar Productos</h1></center>
					<div class="margenRow row ">
						<div class="col-md-6 col-md-offset-3">
							<form class="form-inline">
							  <div class="form-group">
							    <label for="id">Buscar por ID:</label>
							    <input type="number" class="form-control" id="idProducto">
							  </div>
							  <button type="button" class="btn btn-default" id="btnBuscar">Buscar</button>
							</form>
						</div>					
					</div>
					<div class="margenRow row">
							<div class="col-md-8 col-md-offset-2">
								<form  action="actualizarProducto" method="post" id="formularioBuscar" class="form-horizontal">
								
								<div class="form-group">
								    <label class="control-label col-sm-2" for="nombre">Id:</label>
								    <div class="col-sm-6">
								      <input path="id" type="number" name="id" class="form-control" id="idBuscar" placeholder="Ingrese el Id" readonly/>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="nombre">Nombre:</label>
								    <div class="col-sm-6">
								      <input path="nombre" type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el nombre" required/>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="categoria">Categoria</label>
								    <div class="col-sm-6"> 
								      <select class="form-control" name="idCategoria" name="idCategoria" id="idCategoria" path="idCategoria" >
								        <option value="1" label="Hogar"/>
								        <option value="2" label="Tecnologia"/>
								        <option value="3" label="Moda"/>					        
								      </select>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="descripcion">Descripcion:</label>
								    <div class="col-sm-6"> 
								      <input path="descripcion" type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripcion" required/>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="precio">Precio:</label>
								    <div class="col-sm-6"> 
								      <input path="precio" type="number" class="form-control" name="precio" id="precio" placeholder="Ingrese el precio" required/>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="cantidad">Cantidad:</label>
								    <div class="col-sm-6"> 
								      <input path="cantidad" type="number" class="form-control" name="cantidad" id="cantidad" placeholder="Ingrese la cantidad" required/>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="cantidad">Fecha de Ingreso:</label>
								    <div class="col-sm-6"> 
								      <input type="text" class="form-control" id="fecha" placeholder="Fecha de Ingreso" readonly/>
								    </div>
								  </div>
								  						  
								  <div class="form-group"> 
								    <div class="col-sm-3">
								      <button type="submit" class="btn btn-default" id="btnActualizar">Actualizar</button>
								    </div>
								    <div class="col-sm-3">
								      <button type="button" class="btn btn-default" id="btnEliminar">Eliminar</button>
								    </div>
								  </div>								  
								</form>
							</div>
						</div>		
					</div>
				</div>		      
			</div>
			<c:choose><c:when test="${guardar==null}"><div id="tabAgregar" class="tab-pane fade"></c:when><c:otherwise><div id="tabAgregar" class="tab-pane fade  in active"></c:otherwise></c:choose>
		      <div class="row">
				<div class="col-md-6 col-md-offset-3">
					<center><h1>Nuevo producto</h1></center>					
					<div class="margenRow row">
							<div class="col-md-8 col-md-offset-2">
								<form  action="guardarProducto" method="post" class="form-horizontal">
								
								<div class="form-group">
								    <label class="control-label col-sm-2" for="nombre">Id:</label>
								    <div class="col-sm-6">
								      <input path="id" type="number" class="form-control" name="id" id="id" placeholder="Ingrese el Id" required/>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="nombre">Nombre:</label>
								    <div class="col-sm-6">
								      <input path="nombre" type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el nombre" required/>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="categoria">Categoria</label>
								    <div class="col-sm-6"> 
								      <select class="form-control" name="idCategoria" id="idCategoria"  required>
								        <option value="1" label="Hogar"/>
								        <option value="2" label="Tecnologia"/>
								        <option value="3" label="Moda"/>					        
								      </select>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="descripcion">Descripcion:</label>
								    <div class="col-sm-6"> 
								      <input path="descripcion" type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripcion" required/>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="precio">Precio:</label>
								    <div class="col-sm-6"> 
								      <input path="precio" type="number" class="form-control" name="precio" id="precio" placeholder="Ingrese el precio" required/>
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-2" for="cantidad">Cantidad:</label>
								    <div class="col-sm-6"> 
								      <input path="cantidad" type="number" class="form-control" name="cantidad" id="cantidad" placeholder="Ingrese la cantidad" required/>
								    </div>
								  </div>						  
								  <div class="form-group"> 
								    <div class="col-sm-2">
								      <button type="submit" class="btn btn-default" id="btnGuardar">Guardar</button>
								    </div>
								  </div>
								</form>
							</div>
						</div>		
					</div>
				</div>	
		 </div>
	</div>
	
	
<!-- Modal -->
			<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Alerta</h4>
			      </div>
			      <div class="modal-body">
			        <p id="modalTexto">${alerta}</p>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			
			  </div>
			  </div> 
		
		
	</body>
</html>