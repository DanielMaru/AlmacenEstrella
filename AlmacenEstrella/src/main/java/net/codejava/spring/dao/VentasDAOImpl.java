package net.codejava.spring.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.jdbc.PreparedStatement;

import net.codejava.spring.modelo.Producto;
import net.codejava.spring.modelo.Venta;

import java.sql.Connection;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;




public class VentasDAOImpl implements VentasDAO{

	private JdbcTemplate jdbcTemplate;
	
	
	private ProductoDAO productoDAO;
	
	
	public VentasDAOImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
		productoDAO = new ProductoDAOImpl(datasource);
	}
	
	@Transactional
	@Override
	public boolean guardar(Venta venta) {
		boolean retorno = false;
		long result = 0;
		if(venta!=null){
			
			
			Date date = new Date();
			String sql = "INSERT INTO ventas (Cajero,Total)"
					+"VALUES(?,?)";

			
			KeyHolder holder = new GeneratedKeyHolder();

			jdbcTemplate.update(new PreparedStatementCreator() {           

			                @Override
			                public PreparedStatement createPreparedStatement(Connection connection)
			                        throws SQLException {
			                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			                    ps.setString(1, venta.getCajero());
			                    ps.setInt(2, venta.getTotal());
			                    return ps;
			                }
			            }, holder);

			Long ventaId = holder.getKey().longValue();
			
			
			//Insertar productos
			venta.getListaProductos().forEach((producto) -> {
				String sqlProducto = "INSERT INTO productosventas(IdProducto,IdVenta,cantidad) VALUES(?,?,?)";
				jdbcTemplate.update(sqlProducto,producto.getId(),ventaId,producto.getCantidad());
				
				Producto productoBd = productoDAO.obtener(producto.getId());
				productoBd.setCantidad(productoBd.getCantidad()-producto.getCantidad());
				productoDAO.guardarOActualizar(productoBd);
			});
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean eliminadoLogico(int id) {
		boolean retorno = false;
		if(id>0){
			Venta venta;
			String sql = "SELECT * FROM ventas WHERE id="+id;
			venta = jdbcTemplate.query(sql, new ResultSetExtractor<Venta>(){

				@Override
				public Venta extractData(ResultSet rs) throws SQLException, DataAccessException {
					if(rs.next()){
						Venta venta = new Venta();
						venta.setCajero(rs.getString("Cajero"));
						venta.setEstado(rs.getInt("Estado"));
						venta.setFechasVenta(rs.getString("FechaVenta"));
						venta.setId(rs.getInt("Id"));
						venta.setTotal(rs.getInt("Total"));
						return venta;
					}
					return null;
				}
				
				
			});
			
			if(venta!=null){
				
				venta.setEstado(1);
				retorno = this.modificar(venta);
			}
		}
		return retorno;
	}

	@Override
	public boolean modificar(Venta venta) {
		boolean retorno = false;
		if(venta!=null){
			String sql = "UPDATE ventas set Cajero=?,FechaVenta=?,Total=?,Estado=? WHERE Id=?";
			try{
				jdbcTemplate.update(sql,venta.getCajero(),venta.getFechasVenta(),venta.getTotal(),venta.getEstado(),venta.getId());
				retorno=true;
			}catch(Exception e){
				retorno=false;
			}
			
		}
		return retorno;
	}
	
	
	
	


}
