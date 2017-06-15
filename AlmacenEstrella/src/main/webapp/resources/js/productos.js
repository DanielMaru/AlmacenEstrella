$( document ).ready(function() {
	
	$("#btnBuscar").click(function(){
	    $.ajax({url: "http://localhost:8080/AlmacenEstrella/obtener?id="+$('#idProducto').val(), success: function(result){	       
	    	   	
	    	var Producto = result;
	    	$("#nombre").val(Producto.nombre);
	    	//$("#sel1").val(Producto.sel1);
	    	$("#descripcion").val(Producto.descripcion);
	    	$("#precio").val(Producto.precio);
	    	$("#cantidad").val(Producto.cantidad);
	        
	    }});
	});
	
});

