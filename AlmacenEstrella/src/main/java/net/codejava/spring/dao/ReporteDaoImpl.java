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
		String sql = "SELECT * FROM ventas where Estado=0 ";
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
		String sql = "SELECT * FROM productos WHERE cantidad < 100 AND Estado=0";
		List<Producto> listaProductos = jdbcTemplate.query(sql, new RowMapper<Producto>() {

			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto producto = new Producto();
	
				producto.setId(rs.getInt("Id"));
				producto.setNombre(rs.getString("Nombre"));
				producto.setCantidad(rs.getInt("Cantidad"));
				
				return producto;
			}
			
		});
		return listaProductos;
	}

}
