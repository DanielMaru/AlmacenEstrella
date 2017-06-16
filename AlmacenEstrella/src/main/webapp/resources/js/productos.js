$( document ).ready(function() {
	
	$("#btnBuscar").click(function(){
	    $.ajax({url: "http://localhost:8080/AlmacenEstrella/obtener?id="+$('#idProducto').val(), success: function(result){	       
	    	   	
	    	var Producto = result;
	    	
	    	$("#id").val(Producto.id);
	    	$("#nombre").val(Producto.nombre);
	    	$("#idCategoria").val(Producto.categoria.id);
	    	$("#descripcion").val(Producto.descripcion);
	    	$("#precio").val(Producto.precio);
	    	$("#cantidad").val(Producto.cantidad);
	        
	    }});
	});
	
	$('#btnGuardar').click(function(){
		$('#producto').submit();
	});
	
	$('#btnEliminar').click(function(){
		alert("dasda");
		$.get("http://localhost:8080/AlmacenEstrella/eliminarProducto?id="+$("#id").val());
	});
	
	
	
	
	
	
//	$('#btnGuardar').click(function(){
//		var Producto = new Object();
//		Producto.id=$('#idProducto').val();
//		Producto.nombre=$('#nombre').val();
//		Producto.fechaIngreso="";
//		Producto.descripcion=$('#descripcion').val();
//		Producto.precio=$('#precio').val();
//		Producto.cantidad=$('#cantidad').val();
//		Producto.estado="";
//		Producto.categoria= new Object();
//		Producto.categoria.id=$('#idCategoria').val();
//		Producto.categoria.nombre="";
//		var json= JSON.stringify(Producto);
//		console.log(json);
//		
//		$.ajax({
//	        url: 'http://localhost:8080/AlmacenEstrella/guardarProducto',
//	        type: 'post',
//	        data: json,
//	        dataType: 'json',
//	        contentType: "application/json; charset=utf-8",	        
//	        success: function (data) {
//	            alert(data);
//	        },
//	        
//	    });
//		
//	});
	
//	<script type="text/javascript" src="<c:url value="/resources/js/productos.js" />"></script>
	
	
	
	
	
	
});


