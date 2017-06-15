package net.codejava.spring.controlador;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;
import net.codejava.spring.negocio.VentasNegocio;

@Controller
public class VentasControlador {
	private Venta venta;
	private List<Producto> productos;
	private boolean error = false;
	private String mensaje="";
	
	@Autowired
	private VentasNegocio ventasNegocio;
	
	public VentasControlador(){
		venta = new Venta();
		productos = new ArrayList<Producto>();
	}
	
	@RequestMapping(value="/ventas")
	public ModelAndView iniciarVenta(){
		return getVista();
		
	}
	
	@RequestMapping(value="/agregarProducto",method = RequestMethod.POST)
	public ModelAndView agregarProducto(String codigo,String cantidad){
//		System.out.println(codigo);
//		System.out.println(cantidad);
		
		boolean insertar=true;
		
		try{
			Producto producto = ventasNegocio.validar(Integer.parseInt(codigo), Integer.parseInt(cantidad));
			producto.setCantidad(Integer.parseInt(cantidad));
			for (Producto productoTemp : productos) {
				if(productoTemp.getId()==producto.getId()){
					insertar=false;
					error=true;
					mensaje="El producto ya esta insertado";
					break;
				}
			}
			
			if(insertar){
				productos.add(producto);
				venta.setTotal(venta.getTotal()+(producto.getPrecio()*producto.getCantidad()));
			}
			
		}catch(Exception e){
			error=true;
			mensaje = e.getMessage();
			
			
		}
	
		
		return getVista();
		
	}
	
	@RequestMapping(value="/eliminar",method = RequestMethod.GET)
	public ModelAndView eliminarProducto(String index){
		Producto producto = productos.remove(Integer.parseInt(index));
		venta.setTotal(venta.getTotal()-(producto.getPrecio()*producto.getCantidad()));
		return getVista();
		
	}
	
	@RequestMapping(value="realizarVenta",method = RequestMethod.POST)
	public ModelAndView realizarVenta(String cajero){
		venta.setListaProductos(productos);
		venta.setCajero(cajero);
		try{
			if(!venta.getListaProductos().isEmpty()){
				if(ventasNegocio.guardar(venta)){
					error=true;
					mensaje="Venta insertada con éxito";
				}else{
					error=true;
					mensaje="La venta no ha sido registrada";
				}
			}else{
				error=true;
				mensaje="Debe ingresar al menos un producto";
			}
			
		}catch(Exception e){
			error=true;
			mensaje="Ha ocurrido un error, por favor intenta de nuevo";
		}
		productos.clear();
		venta.setCajero("");
		venta.setListaProductos(null);
		venta.setTotal(0);
		return new ModelAndView("redirect:/ventas");
	}
	
	@RequestMapping(value="eliminarVenta",method = RequestMethod.POST)
	public ModelAndView eliminarVentas(String id){
		System.out.println(id);
		try{
			if(ventasNegocio.eliminadoLogico(Integer.parseInt(id))){
				error=true;
				mensaje="Venta eliminada con éxito";
			}else{
				error=true;
				mensaje= "La venta no pudo ser eliminada";
			}
		
		}catch(Exception e){
			error=true;
			mensaje="La venta no pudo ser eliminada *";
		}
		
		return new ModelAndView("redirect:/ventas");
	}
	
	public ModelAndView getVista(){
		ModelAndView modelo =new  ModelAndView("ventas");
		modelo.addObject("productos",productos);
		modelo.addObject("total",venta.getTotal());
		modelo.addObject("error",error);
		modelo.addObject("mensaje",mensaje);
		modelo.addObject("cantidad",productos.size());
		error = false;
		return modelo;
	}
	
	

}
