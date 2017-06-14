package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;

public interface ReporteDao {
	
	public List<Venta> listarVentas(int mes);
	
	public List<Producto> listarProductos();
}
