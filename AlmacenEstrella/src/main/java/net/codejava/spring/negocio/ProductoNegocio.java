package net.codejava.spring.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.ProductoDAO;
import net.codejava.spring.modelo.Producto;

@Service
public class ProductoNegocio {
	
	private ProductoDAO productoDAO;
	
	@Autowired
	public ProductoNegocio(ProductoDAO productoDAO) {
		
		this.productoDAO = productoDAO;
	}
	
	public List<Producto> lista(){
		return productoDAO.lista();
	}
	
	public String guardar(Producto producto){
		String mensaje="";
		
		if(!productoDAO.validarPorId(producto.getId())){			
			mensaje="El ID ya existe";
			return mensaje;
		}
		else if(!productoDAO.validarPorNombre(producto.getNombre())){
			
			mensaje="El nombre ya existe";
			return mensaje;
		}
		else{
			productoDAO.guardar(producto);
			mensaje="Almacenado correctamente";
			return mensaje;
		}
	}
	
	public String actualizar(Producto producto){
		
		String mensaje="";			
		productoDAO.actualizar(producto);
		mensaje="Almacenado correctamente";
		return mensaje;
		
	}
	public void eliminar(int idProducto ){
		productoDAO.eliminar(idProducto);
	}
	public Producto obtener(int idProducto){
		return productoDAO.obtener(idProducto);
	}
}
