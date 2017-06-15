<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
                
        
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    </head>
    <body >
      
	<script>
		function myFunction() {
  		// Declare variables 
  			var input, filter, table, tr, td, i;
  		
  			var x = document.getElementById("sel1").selectedIndex;
  		    var y = document.getElementById("sel1").options;
  		    
  		    
  			input = document.getElementById("id");
  			var numeroMes = y[x].index ;
  			
  			if(numeroMes==0){
  				filter="";
  			}
  			else{
  		        if(numeroMes < 10){
  	  			filter = "-0"+ numeroMes +"-";

  		        }
  			   else{
  	  			filter = "-"+ numeroMes +"-";
  			   }
		}	
  			//alert(filter);
  			table = document.getElementById("tablaReporte");
  			tr = table.getElementsByTagName("tr");

  			// Loop through all table rows, and hide those who don't match the search query
  			for (i = 0; i < tr.length; i++) {
    			td = tr[i].getElementsByTagName("td")[2];
    			if (td) {
    	  			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        				tr[i].style.display = "";
      				} else {
        				tr[i].style.display = "none";
      				}
   				} 
  			}
  			
  			var tabla = document.getElementById("tablaReporte");
  			var total = 0;
  			
  			for(var i = 1; tabla.rows[i]; i++){
  				if(tabla.rows[i].style.display == ""){
  			total += Number(tabla.rows[i].cells[3].innerHTML);
  			
  			}
  			}
  			document.getElementById("suma").innerHTML = total;


		}
		
		
	
	    
		
	</script>
      
    <nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="index"><img alt="logo" src="<c:url value="/resources/imagenes/fondo.png" />"></a>
			    </div>
			    <ul class="nav navbar-nav">
			      <li ><a href="index">Inicio</a></li>
			      <li><a href="productos">Productos</a></li>
			      <li><a href="ventas">Ventas</a></li>
			      <li class="active"><a href="reporte">Reportes</a></li>
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
		    <select class="form-control" id="sel1"  onchange="myFunction()">
		    <option> Ver Todos</option>
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
      <br><br>
      <div  class="col-md-6 col-md-offset-3" border="3">
	           <table class="table table-bordered table-striped " id="tablaReporte">
	        	<th>ID</th>
	        	<th>Cajero</th>
	        	<th>Fecha</th>
	        	<th>Total</th>
	        	
				<c:forEach var="venta" items="${listaVentas}" varStatus="status">
	        	<tr>
	        		<td>${venta.id}</td>
					<td>${venta.cajero}</td>
					<td>${venta.fechasVenta}</td>
		            <td id="total">${venta.total}</td>
										
							
	        	</tr>
				</c:forEach>	        	
			</table>
	   </div>
	        
	     <h3>TOTAL: <span class="label label-default" id="suma">${sumaTotal}</span></h3>
	      
	        
      
    </div>
    
    
    <div id="menu1" class="tab-pane fade">
    
    <h3>Reporte Productos</h3>
      
          
      <div  class="col-md-6 col-md-offset-3" border="3">
       <dt>Aqui podras ver los productos que estan escasos.</dt>
       <dd>En rojo los productos agotados.</dd> <br>
	           <table class="table table-bordered  " >
	           <tr class="active">
	        	<th>ID</th>
	        	<th>Nombre</th>
	        	<th>Cantidad</th>
	        	
				<tr>
				<c:forEach var="producto" items="${listaProducto}" varStatus="status">
				<c:choose>
				
				 <c:when test="${producto.cantidad=='0'}"> 
				 
				 
	        	<tr  class="danger">
	        		<td>${producto.id}</td>
					<td>${producto.nombre}</td>
					<td>${producto.cantidad}</td>
		          									
	        	</tr>
	        	</c:when>
	        	
	        	 <c:otherwise > 
				 
				 
	        	<tr>
	        		<td>${producto.id}</td>
					<td>${producto.nombre}</td>
					<td>${producto.cantidad}</td>
		          									
	        	</tr>
	        	</c:otherwise>
	        	
	        	</c:choose>
	        	
				</c:forEach>	        	    	
			</table>
	   </div>
	        
	      
	        
      
    </div>
    
     
     
     
    </div>
        
  </div>
</div>

 
    </body>
</html>
