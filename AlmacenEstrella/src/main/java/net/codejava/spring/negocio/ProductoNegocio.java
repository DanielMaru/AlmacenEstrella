package net.codejava.spring.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public String guardarOActualizar(Producto producto){
		String mensaje="";
		if(producto.getId() > 0){
			productoDAO.guardarOActualizar(producto);
		}
		else{
			productoDAO.guardarOActualizar(producto);
		}
		return mensaje;
	}
	public void eliminar(int idProducto ){
		productoDAO.eliminar(idProducto);
	}
	public Producto obtener(int idProducto){
		return productoDAO.obtener(idProducto);
	}
}
