package net.codejava.spring.negocio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.spring.dao.ProductoDAO;
import net.codejava.spring.dao.ProductoDAOImpl;
import net.codejava.spring.dao.VentasDAO;
import net.codejava.spring.dao.VentasDAOImpl;
import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;

@RunWith(MockitoJUnitRunner.class)
public class VentasNegocioTest {

	
	VentasNegocio ventasNegocio;
	
	@Mock
	ProductoDAO productoDAO;
	@Mock
	VentasDAO ventasDAO;
	
	@Before
	public void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/estrella");
		datasource.setUsername("root");
		datasource.setPassword("");
		
		
		ventasNegocio = new VentasNegocio(ventasDAO, productoDAO);
		
	}


	@Test
	public void testValidar() {
		Producto producto = new Producto();
		producto.setCantidad(10);
		producto.setDescripcion("producto1");
		producto.setEstado(0);
		producto.setId(1);
		producto.setPrecio(5000);
		try {
			
			when(productoDAO.obtener(1)).thenReturn(producto);
			assertTrue(ventasNegocio.validar(1, 1)!=null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidarProductoNoExistente() {
		try {
			
			when(productoDAO.obtener(1)).thenReturn(null);
			assertTrue(!(ventasNegocio.validar(1, 1)!=null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGuardar() {
		Venta venta = new Venta();
		venta.setCajero("Prueba");
		venta.setTotal(25000);
		
		List<Producto> lista = new ArrayList<Producto>();
		
		Producto producto = new Producto();
		producto.setCantidad(10);
		lista.add(producto);
		
		producto = new Producto();
		producto.setCantidad(20);
		lista.add(producto);
		
		venta.setListaProductos(lista);
		
		when(ventasDAO.guardar(venta)).thenReturn(true);
		assertTrue(ventasNegocio.guardar(venta));
	}

	@Test
	public void testEliminadoLogico() {
		int id=1;
		when(ventasDAO.eliminadoLogico(id)).thenReturn(true);
		assertTrue(ventasNegocio.eliminadoLogico(id));
	}

}
