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
		List<Producto> listaProducto = new ArrayList<>();
		Categoria categoria = new Categoria(1,"Hogar");
		Producto producto1 = new Producto(1, "10/10/10","carro de mesa", 10000, 0, 10, "Carrito", categoria);
		listaProducto.add(producto1);
		
		//act
		when(productoDAO.lista()).thenReturn(listaProducto);
		Producto producto2 = new Producto(1, "10/10/10","carro de mesa", 10000, 0, 10, "Carrito", categoria);
		String mensaje = productoNegocio.guardar(producto2);
		
		//assert
		assertEquals("El ID ya existe", mensaje);
	}

}
