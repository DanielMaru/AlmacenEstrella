$( document ).ready(function() {
	
	$("#btnBuscar").click(function(){
	    $.ajax({url: "http://localhost:8080/AlmacenEstrella/obtener?id="+$('#idProducto').val(), success: function(result){	       
	    	   	
	    	var Producto = result;	        
	        
	    }});
	});
	
});

