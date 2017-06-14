package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;

public class ReporteDaoImpl implements ReporteDao{

	private JdbcTemplate jdbcTemplate;
	
	public ReporteDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Venta> listarVentas(int mes) {
		String sql = "SELECT * FROM ventas WHERE month(FechaVenta) = "+mes;
		List<Venta> listaVentas = jdbcTemplate.query(sql, new RowMapper<Venta>() {

			@Override
			public Venta mapRow(ResultSet rs, int rowNum) throws SQLException {
				Venta venta = new Venta();
	
				venta.setId(rs.getInt("Id"));
				venta.setCajero(rs.getString("Cajero"));
				venta.setFechasVenta(rs.getString("FechaVenta"));
				venta.setTotal(rs.getInt("Total"));
				venta.setEstado(rs.getInt("Estado"));
				
				return venta;
			}
			
		});
		return listaVentas;
	}

	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return null;
	}

}
