$( document ).ready(function() {
	
	//$('#idBuscar').attr('readonly', true);
	
	$('#formularioBuscar').hide();
	
	$("#btnBuscar").click(obtenerProducto);
	
	$('#idProducto').keypress(function (e) {
		  if (e.which == 13) {
		    obtenerProducto();
		    return false;    //<---- Add this line
		  }
		});
	
//	$('#btnGuardar').click(function(){
//		$('#producto').submit();
//	});
	
	$('#btnEliminar').click(function(){
		$('#formularioBuscar').attr('action', 'eliminarProducto');
		$('#formularioBuscar').attr('method', 'get');
		$('#formularioBuscar').submit();
//		alert($("#id").val());
//		$.get("http://localhost:8080/AlmacenEstrella/eliminarProducto?id="+$("#idBuscar").val());
	});
		
});

function obtenerProducto(){
	 $.ajax({url: "http://localhost:8080/AlmacenEstrella/obtener?id="+$('#idProducto').val(), success: function(result){	       
 	   	
	    	var Producto = result;
	    	
	    	if(!Producto){
	    		$('#modalTexto').html("No existe ningun producto con este ID");
	    		$("#myModal").modal();
	    	}
	    	else{
	    		$("#idBuscar").val(Producto.id);
		    	$("#nombre").val(Producto.nombre);
		    	$("#idCategoria").val(Producto.categoria.id);
		    	$("#descripcion").val(Producto.descripcion);
		    	$("#precio").val(Producto.precio);
		    	$("#cantidad").val(Producto.cantidad);
		    	$("#fecha").val(Producto.fechaIngreso);
		    	$('#formularioBuscar').show();
	    	}
	    		
	    	
	    	
	        
	    }});
}


