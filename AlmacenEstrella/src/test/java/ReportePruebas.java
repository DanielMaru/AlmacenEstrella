import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.codejava.spring.dao.ReporteDao;
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
	public void test() {
		//prueba
	}

}
