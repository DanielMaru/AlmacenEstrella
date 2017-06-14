package net.codejava.spring.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.spring.dao.ReporteDao;
import net.codejava.spring.modelo.Venta;

@Service
public class ReporteNegocio {

	private ReporteDao reporteDao;
	
	@Autowired
	public ReporteNegocio(ReporteDao reporteDao) {
		this.reporteDao = reporteDao;
	}

	public List<Venta> listarVentas(int numeroMes) {
		return reporteDao.listarVentas(numeroMes);
	}
	
	public int convertirMes(String mes){
		int numeroMes = 0;
		switch (mes){
			case "Enero": numeroMes = 1;
			break;
			case "Febrero": numeroMes = 2;
			break;
			case "Marzo": numeroMes = 3;
			break;
			case "Abril": numeroMes = 4;
			break;
			case "Mayo": numeroMes = 5;
			break;
			case "Junio": numeroMes = 6;
			break;
			case "Julio": numeroMes = 7;
			break;
			case "Agosto": numeroMes = 8;
			break;
			case "Septiembre": numeroMes = 9;
			break;
			case "Octubre": numeroMes = 10;
			break;
			case "Noviembre": numeroMes = 11;
			break;
			case "Diciembre": numeroMes = 12;
			break;
		}
		return numeroMes;
	}
}
