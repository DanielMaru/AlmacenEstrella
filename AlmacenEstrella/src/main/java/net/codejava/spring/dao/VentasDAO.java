package net.codejava.spring.dao;

import net.codejava.spring.modelo.Venta;

/*
 * Interfaz con los métodos para realizar operaciones sobre la base de datos
 * @author Luis Fernando Orozco
 * @version 13/6/2017
 * 
 */
public interface VentasDAO {
	
	/*
	 * Método para insertar un registro en la tabla ventas de la base de datos
	 * @param venta, objeto con la información a insertar
	 * @return true si la operación se ejecuta exitosamente, de lo contrario false
	 */
	public boolean guardar(Venta venta) throws Exception;
	
	/*
	 * Método para eliminar logicamente una venta de la base de datos
	 * @param id, id de la venta
	 * @return true si la operación se ejecuta exitosamente, de lo contrario false
	 */
	public boolean eliminadoLogico(int id);
	
}
