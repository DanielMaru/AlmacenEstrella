package net.codejava.spring.controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;
import net.codejava.spring.negocio.ReporteNegocio;

@Controller
public class ReporteControlador {
	
	@Autowired
	private ReporteNegocio reporteNegocio;
	
	@RequestMapping(value="/index")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		
		model.setViewName("Index");
		
		return model;
	}
	
	@RequestMapping(value="/reporte")
	public ModelAndView listarVentas(ModelAndView model) throws IOException{
		Calendar fecha = new GregorianCalendar();
		int mes = fecha.get(Calendar.MONTH) + 1;
		System.out.println(mes);
		List<Venta> listaVentas = reporteNegocio.listarVentas(mes);
		int sumaTotal = reporteNegocio.calcularTotal(listaVentas);
		
		List<Producto> listaProducto = reporteNegocio.listarProductos();
		
		model.addObject("listaVentas", listaVentas);
		model.addObject("listaProducto", listaProducto);
		model.addObject("sumaTotal", Integer.toString(sumaTotal));
		model.setViewName("VistaReporte");
		
		return model;
	}
}
