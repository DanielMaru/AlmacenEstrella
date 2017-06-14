package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.modelo.Producto;

public interface ProductoDAO {
	
	public void guardarOActualizar(Producto producto);
	
	public void eliminar(int producto);
	
	public Producto obtener(int producto);
	
	public boolean validarPorId(int id);
	
	public boolean validarPorNombre(String nombre);
	
	public List<Producto> lista();

}
