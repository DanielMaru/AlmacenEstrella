<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="style.css">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
      
      <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Almacenes Estrella     <span class="glyphicon glyphicon-star-empty"></span></a>  
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Productos</a></li>
      <li><a href="#">Ventas</a></li>
      <li><a href="#">Reportes</a></li>
    </ul>
  </div>
</nav>


 
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Reporte Ventas</a></li>
    <li><a data-toggle="tab" href="#menu1">Reporte Productos</a></li>
  </ul>
  
  
  

 <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <h3>Reporte Ventas</h3>
      
       <form align="center" class="form-inline">
		  <div class="form-group">
		    <label >Seleccione el mes:</label>
		    <select class="form-control" id="sel1">
	        <option>Enero</option>
	        <option>Febrero</option>
	        <option>Marzo</option>
	        <option>Abril</option>
	        <option>Mayo</option>
	        <option>Junio</option>
	        <option>Julio</option>
	        <option>Agosto</option>
	        <option>Septiembre</option>
	        <option>Octubre</option>
	        <option>Noviembre</option>
	        <option>Diciembre</option>
	        </select>
		  </div>
		</form>
      
      <div  class="col-md-6 col-md-offset-3" border="3">
	           <table class="table table-bordered table-striped " id="tableDepart">
	        	<th>ID</th>
	        	<th>Cajero</th>
	        	<th>Fecha</th>
	        	<th>Total</th>
	        	
				<c:forEach var="venta" items="${listaVentas}" varStatus="status">
	        	<tr>
	        		<td>${venta.id}</td>
					<td>${venta.cajero}</td>
					<td>${venta.fechasVenta}</td>
		            <td>${venta.total}</td>
										
							
	        	</tr>
				</c:forEach>	        	
			</table>
	   </div>
	        
	     <h3>TOTAL: <span class="label label-default">${sumaTotal}</span></h3>
	      
	        
      
    </div>
    
    
    <div id="menu1" class="tab-pane fade">
      <h3>Menu 1</h3>
      tabla ventas
    </div>
        
  </div>
</div>

 
    </body>
</html>
