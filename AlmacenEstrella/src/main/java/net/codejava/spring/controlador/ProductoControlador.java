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

@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoDAO productoDAO;
	
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
		producto.setCategoria(categoria);;
		if(producto.getId() > 0){			
			productoDAO.guardarOActualizar(producto);
			return new ModelAndView("redirect:/productos");
		}
		else{
			if(!productoDAO.validarPorId(producto.getId())){
				ModelAndView model= new ModelAndView();
				Producto nuevoProducto = new Producto();
				model.addObject("producto", nuevoProducto);
				model.addObject("error", "El ID ya existe");
				model.setViewName("FormularioProducto");
				return model;	
			}
			else if(!productoDAO.validarPorNombre(producto.getNombre())){
				ModelAndView model= new ModelAndView();
				Producto nuevoProducto = new Producto();
				model.addObject("producto", nuevoProducto);
				model.addObject("error", "El Nombre ya existe");
				model.setViewName("FormularioProducto");
				return model;	
			}
			else if(producto.getNombre()=="" || producto.getDescripcion()=="" || producto.getPrecio() < 0 || producto.getCantidad() < 0){
				ModelAndView model= new ModelAndView();
				Producto nuevoProducto = new Producto();
				model.addObject("producto", nuevoProducto);
				model.addObject("error", "Los campos no pueden estar vacios");
				model.setViewName("FormularioProducto");
				return model;
			}
			else{
				productoDAO.guardarOActualizar(producto);		
				return new ModelAndView("redirect:/productos");
			}
		}
	}
	@RequestMapping(value = "/eliminarProducto", method = RequestMethod.GET)
	public  ModelAndView eliminarProducto(HttpServletRequest request) {
		int idProducto = Integer.parseInt(request.getParameter("id"));		
		productoDAO.eliminar(idProducto);
		return new ModelAndView("redirect:/productos");
	}
	
	@RequestMapping(value = "/editarProducto", method = RequestMethod.GET)
	public ModelAndView editarProducto(HttpServletRequest request) {
		int idProducto = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoDAO.obtener(idProducto);
		ModelAndView model = new ModelAndView("FormularioProducto");
		model.addObject("producto", producto);
		
		return model;
	}
	
	@RequestMapping(value = "/obtener", method = RequestMethod.GET, produces = "application/json")
	public  @ResponseBody String obtener(HttpServletRequest request) throws JsonProcessingException {
		int idProducto = Integer.parseInt(request.getParameter("id"));
		Producto producto = productoDAO.obtener(idProducto);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(producto);		
		return json;
	}
	
}