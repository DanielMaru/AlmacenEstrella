package net.codejava.spring.controlador;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;

@Controller
public class VentasControlador {
	private Venta venta;
	private List<Producto> productos;
	private boolean error = false;
	private String mensaje="";
	
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
		System.out.println(codigo);
		System.out.println(cantidad);
		
		Producto producto = new Producto();
		producto.setCantidad(Integer.parseInt(cantidad));
		producto.setId(Integer.parseInt(codigo));
		producto.setNombre("Producto1");
		producto.setPrecio(2500);
		
		venta.setTotal(venta.getTotal()+(producto.getPrecio()*producto.getCantidad()));
		
		productos.add(producto);
	
		
		return getVista();
		
	}
	
	@RequestMapping(value="/eliminarProducto",method = RequestMethod.POST)
	public ModelAndView eliminarProducto(String index){
		Producto producto = productos.remove(Integer.parseInt(index));
		venta.setTotal(venta.getTotal()-(producto.getPrecio()*producto.getCantidad()));
		return getVista();
		
	}
	
	@RequestMapping(value="realizarVenta",method = RequestMethod.POST)
	public ModelAndView realizarVenta(String cajero){
		venta.setListaProductos(productos);
		productos.clear();
		venta.setCajero("");
		venta.setListaProductos(null);
		venta.setTotal(0);
		return new ModelAndView("redirect:/ventas");
	}
	
	@RequestMapping(value="eliminarVenta",method = RequestMethod.POST)
	public ModelAndView eliminarVentas(String venta){
		error=true;
		mensaje="Venta eliminada";
		return new ModelAndView("redirect:/ventas");
	}
	
	public ModelAndView getVista(){
		ModelAndView modelo =new  ModelAndView("ventas");
		modelo.addObject("productos",productos);
		modelo.addObject("total",venta.getTotal());
		modelo.addObject("error",error);
		modelo.addObject("mensaje",mensaje);
		error = false;
		return modelo;
	}
	
	

}
