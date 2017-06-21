import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.codejava.spring.dao.ProductoDAO;
import net.codejava.spring.modelo.Categoria;
import net.codejava.spring.modelo.Producto;
import net.codejava.spring.negocio.ProductoNegocio;

@RunWith(MockitoJUnitRunner.class)
public class ProductoTest {
	
	private ProductoNegocio productoNegocio;
	
	@Mock
	private ProductoDAO productoDAO;
	
	@Before
	public void preparar(){
		productoNegocio= new ProductoNegocio(productoDAO);
	}

	@Test
	public void verificarSiElIdDelProductoYaExiste() {
		
		//arrange
		
		Categoria categoria = new Categoria(1,"Hogar");
		Producto producto1 = new Producto(1, "10/10/10","carro de mesa", 10000, 0, 10, "Carrito", categoria);
		
		
		//act
		when(productoDAO.validarPorId(producto1.getId())).thenReturn(false);
		when(productoDAO.validarPorIdEliminado(producto1.getId())).thenReturn(true);
		String mensaje = productoNegocio.guardar(producto1);
		
		//assert
		assertEquals("El ID ya existe y esta en uso", mensaje);
	}
	
	@Test
	public void verificarSiElNombreYaExiste(){
		
		//arrange
		
		Categoria categoria = new Categoria(2, "Tecnologia");
		Producto producto1 = new Producto(2, "03/05/2017", "Portatil", 300000, 0, 7, "PC", categoria);
		
		//act
		when(productoDAO.validarPorNombre(producto1.getNombre())).thenReturn(false);
		when(productoDAO.validarPorId(producto1.getId())).thenReturn(true);
		
		
		String mensaje = productoNegocio.guardar(producto1);
		//assert
		assertEquals("El nombre ya existe", mensaje);
	}
	

}
