package net.codejava.spring.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.modelo.Venta;
import net.codejava.spring.negocio.ReporteNegocio;

@Controller
public class ReporteControlador {
	
	@Autowired
	private ReporteNegocio reporteNegocio;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		
		model.setViewName("Index");
		
		return model;
	}
	
	@RequestMapping(value="/reporte", method = RequestMethod.GET)
	public ModelAndView listar(HttpServletRequest request) throws IOException{
		String mes = request.getParameter("mes");
		List<Venta> listaVentas = reporteNegocio.listarVentas(mes);
		ModelAndView model = new ModelAndView("Reporte");
		model.addObject("listaVentas", listaVentas);
		model.setViewName("VistaReporte");
		
		return model;
	}
}
