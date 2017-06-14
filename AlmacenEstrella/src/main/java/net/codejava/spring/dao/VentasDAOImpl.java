package net.codejava.spring.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.spring.modelo.Venta;


public class VentasDAOImpl implements VentasDAO{

	private JdbcTemplate jdbcTemplate;
	
	public VentasDAOImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	@Override
	public boolean guardar(Venta venta) {
		boolean retorno = false;
		if(venta!=null){
			Date date = new Date();
			String sql = "INSERT INTO ventas (Cajero, FechaVenta,Total)"
					+"VALUES(?,?,?)";
			jdbcTemplate.update(sql,venta.getCajero(),date,venta.getTotal());
			
			//Insertar Productos
			
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
