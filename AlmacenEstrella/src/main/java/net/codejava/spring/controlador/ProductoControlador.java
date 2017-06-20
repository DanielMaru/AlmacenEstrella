package net.codejava.spring.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import net.codejava.spring.dao.ProductoDAO;
import net.codejava.spring.modelo.Categoria;
import net.codejava.spring.modelo.Producto;
import net.codejava.spring.negocio.ProductoNegocio;

@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoNegocio productoNegocio;
	
	@RequestMapping(value="/productos")
	public ModelAndView listaProducto(ModelAndView model) throws IOException{
		Producto nuevoProducto = new Producto();
		model.addObject("producto", nuevoProducto);
		model.setViewName("VistaProducto");
		return model;
	}
	
	
	@RequestMapping(value = "/guardarProducto", method = RequestMethod.POST)	
	public ModelAndView guardarProducto(@ModelAttribute Producto producto, String idCategoria){		
		Categoria categoria=new Categoria();
		categoria.setId(Integer.parseInt(idCategoria));
		producto.setCategoria(categoria);
		
		String mensaje= productoNegocio.guardar(producto);
		
		ModelAndView model= new ModelAndView();
		Producto nuevoProducto = new Producto();
		model.addObject("producto", nuevoProducto);
		model.addObject("alerta", mensaje);
		model.addObject("guardar", "modal");
		model.setViewName("VistaProducto");
		return model;		
		
	}
	
	@RequestMapping(value = "/actualizarProducto", method = RequestMethod.POST)	
	public ModelAndView actualizarProducto(@ModelAttribute Producto producto, String idCategoria){		
		Categoria categoria=new Categoria();
		categoria.setId(Integer.parseInt(idCategoria));
		producto.setCategoria(categoria);		
	
		String mensaje = productoNegocio.actualizar(producto);
		ModelAndView model= new ModelAndView();
		model.addObject("producto", producto);
		model.addObject("alerta", mensaje);
		model.setViewName("VistaProducto");
		return model;
		
		
	}
	
	@RequestMapping(value = "/eliminarProducto", method = RequestMethod.GET)
	public  ModelAndView eliminarProducto(HttpServletRequest request) {
		int idProducto = Integer.parseInt(request.getParameter("id"));
		
		productoNegocio.eliminar(idProducto);
		ModelAndView model= new ModelAndView();
		Producto nuevoProducto = new Producto();
		model.addObject("producto", nuevoProducto);
		model.addObject("alerta", "Eliminado Correctamente");
		model.setViewName("VistaProducto");
		return model;
	}	
	
	
	@RequestMapping(value = "/obtener", method = RequestMethod.GET, produces = "application/json")
	public  @ResponseBody String obtener(HttpServletRequest request) throws JsonProcessingException {
		int idProducto = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoNegocio.obtener(idProducto);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(producto);		
		return json;
	}
	
}