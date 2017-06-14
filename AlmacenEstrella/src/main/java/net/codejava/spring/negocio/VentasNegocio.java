package net.codejava.spring.negocio;

import java.util.List;
//venta

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import net.codejava.spring.dao.VentasDAOImpl;
import net.codejava.spring.dao.VentasDAO;
import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;

@Service
public class Ventanegocio {
	
	private VentasDAO ventasDAO;
	
	@Autowired
	public Ventanegocio(VentasDAO VentasDAO) {
		this.ventasDAO = VentasDAO;
	}

		
		public boolean validar(int Id) {
				return true;
	}

	
	public boolean guardar(Venta venta) {
		return ventasDAO.guardar(venta);
		
	}

	

	public boolean  eliminadoLogico(int id) {
		return ventasDAO.eliminadoLogico(id);
		
	}
	
	

	
}
