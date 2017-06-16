
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.codejava.spring.dao.ReporteDao;
import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;
import net.codejava.spring.negocio.ReporteNegocio;

@RunWith(MockitoJUnitRunner.class)
public class ReportePruebas {

	private ReporteNegocio reporteNegocio;
	
	@Mock
	private ReporteDao reporteDao;
	
	@Before
	public void preparar(){
		reporteNegocio = new ReporteNegocio(reporteDao);
	}
	
	@Test
	public void consultarVentas() {
		//arrange
		List<Venta> listaVenta = new ArrayList<>();
		Venta venta1 = new Venta("Juanito", "2017-02-27 11:09", null);
		Venta venta2 = new Venta("Juanito", "2017-02-27 11:15", null);
		listaVenta.add(venta1);
		listaVenta.add(venta2);
		int mes = 2;
		
		//act
		when(reporteDao.listarVentas(mes)).thenReturn(listaVenta);
		List<Venta> lista = reporteNegocio.listarVentas(mes);
		
		//assert
		assertThat(lista, is(listaVenta));
	}
	
	@Test
	public void consultarProductosMenoresDeCien() {
		//arrange
		List<Producto> listaProductos = new ArrayList<>();
		Producto producto1 = new Producto(1, "2017-03-09", "producto comestible", 500, 0, 56, "gomitas", null);
		Producto producto2 = new Producto(1, "2017-03-11", "producto comestible", 1500, 0, 99, "panela", null);
		Producto producto3 = new Producto(1, "2017-03-34", "producto comestible", 3000, 0, 0, "arroz", null);
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		
		//act
		when(reporteDao.listarProductos()).thenReturn(listaProductos);
		List<Producto> lista = reporteNegocio.listarProductos();
		
		//assert
		assertThat(lista, is(listaProductos));
	}
	
	@Test
	public void calcularElTotalDeVentas(){
		//Arrange
		List<Venta> listaVenta = new ArrayList<>();
		Venta venta1 = new Venta();
		venta1.setId(1);
		venta1.setCajero("Juan");
		venta1.setFechasVenta("2017-02-27 11:15");
		venta1.setTotal(300);
		venta1.setEstado(0);
		
		Venta venta2 = new Venta();
		venta2.setId(2);
		venta2.setCajero("Juan");
		venta2.setFechasVenta("2017-02-27 11:15");
		venta2.setTotal(500);
		venta2.setEstado(0);
		
		listaVenta.add(venta1);
		listaVenta.add(venta2);
		
		int valorEsperado = 800;
		
		//Act
		int resultado = reporteNegocio.calcularTotal(listaVenta);
		
		//Assert
		assertEquals(valorEsperado, resultado);
	}

}
