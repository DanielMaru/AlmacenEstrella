package net.codejava.spring.negocio;

import java.util.List;
//venta

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import net.codejava.spring.dao.VentasDAOImpl;
import net.codejava.spring.dao.ProductoDAO;
import net.codejava.spring.dao.VentasDAO;
import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;

@Service
public class VentasNegocio {
	
	private VentasDAO ventasDAO;
	private ProductoDAO productoDAO;
	
	@Autowired
	public VentasNegocio(VentasDAO VentasDAO,ProductoDAO productoDAO) {
		this.ventasDAO = VentasDAO;
		this.productoDAO = productoDAO;
	}

	
	/*
	 * Verifica si un producto es valido
	 * @param id del producto
	 * @return Producto en caso de que sea valido, de lo contrario null
	 */
	public Producto validar(int Id,int cantidad) throws Exception {
		Producto producto = null;
		try{
			producto = productoDAO.obtener(Id);
			if(producto==null){
				throw new Exception("El producto no existe");
			}
		}catch(Exception e){
			throw new Exception("Id no valido");
		}
		
		if(!(producto.getCantidad()>=cantidad)){
			throw new Exception("Solo hay "+producto.getCantidad()+" unidades de este producto");
		}
		
		
		return producto;
	}

	
	public boolean guardar(Venta venta) {
		return ventasDAO.guardar(venta);
		
	}

	

	public boolean  eliminadoLogico(int id) {
		System.out.println(id);
		return ventasDAO.eliminadoLogico(id);
		
	}
	
	

	
}
