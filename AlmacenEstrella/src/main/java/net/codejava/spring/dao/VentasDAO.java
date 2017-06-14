package net.codejava.spring.dao;

import net.codejava.spring.modelo.Venta;

/*
 * Interfaz con los m�todos para realizar operaciones sobre la base de datos
 * @author Luis Fernando Orozco
 * @version 13/6/2017
 * 
 */
public interface VentasDAO {
	
	/*
	 * M�todo para insertar un registro en la tabla ventas de la base de datos
	 * @param venta, objeto con la informaci�n a insertar
	 * @return true si la operaci�n se ejecuta exitosamente, de lo contrario false
	 */
	public boolean guardar(Venta venta) throws Exception;
	
	/*
	 * M�todo para eliminar logicamente una venta de la base de datos
	 * @param id, id de la venta
	 * @return true si la operaci�n se ejecuta exitosamente, de lo contrario false
	 */
	public boolean eliminadoLogico(int id);
	
}
