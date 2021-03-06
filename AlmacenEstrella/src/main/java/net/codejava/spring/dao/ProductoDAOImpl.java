	package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.modelo.Categoria;
import net.codejava.spring.modelo.Producto;

public class ProductoDAOImpl implements ProductoDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ProductoDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	   
	
	@Override
	public void guardar(Producto producto) {		
			
		String sql = "INSERT INTO productos (Id, Nombre, FechaIngreso, Descripcion, Precio, Estado, Cantidad, IdCategoria) VALUES (?, ?, NOW(), ?, ?, 0, ?, ?)";
		jdbcTemplate.update(sql, producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getCantidad(), producto.getCategoria().getId());
					
	}
	@Override
	public void actualizar(Producto producto) {				
		
		String sql = "UPDATE productos SET Nombre=?, Descripcion=?, Precio=?, Cantidad=?, IdCategoria=? WHERE Id=?";
		jdbcTemplate.update(sql, producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getCantidad(), producto.getCategoria().getId(),producto.getId());
			
	}

	@Override
	public void eliminar(int idProducto) {
		
		String sql = "UPDATE productos SET Estado=1 WHERE Id=?";
		jdbcTemplate.update(sql, idProducto);
	
		
	}

	@Override
	public Producto obtener(int idProducto) {
		String sql = "SELECT p.Id, p.Nombre, p.FechaIngreso,p.Descripcion,p.Precio,p.Estado,p.Cantidad,p.IdCategoria,c.Nombre NombreCategoria FROM productos p INNER JOIN categorias c ON p.IdCategoria=c.Id WHERE p.Estado=0 AND p.Id="+ idProducto;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Producto>() {

			@Override
			public Producto extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Producto producto = new Producto();
					Categoria categoria = new Categoria();
					producto.setId(rs.getInt("Id"));
					producto.setNombre(rs.getString("Nombre"));
					producto.setFechaIngreso(rs.getString("FechaIngreso"));
					producto.setDescripcion(rs.getString("Descripcion"));
					producto.setPrecio(rs.getInt("Precio"));
					producto.setEstado(rs.getInt("Estado"));
					producto.setCantidad(rs.getInt("Cantidad"));
					categoria.setId(rs.getInt("IdCategoria"));
					categoria.setNombre(rs.getString("NombreCategoria"));
					producto.setCategoria(categoria);					
					
					return producto;
				}
				
				return null;
			}
			
		});
	}

	@Override
	public boolean validarPorId(int id) {
		
		String sqlValidarId = "select count(Id) cantidad FROM productos where id=?" ;
		
		String cantidadDeIds = (String)jdbcTemplate.queryForObject(sqlValidarId, new Object[] { id }, String.class);
		
		
		if(cantidadDeIds.equals("1")){
			return false;	
		}
		else{
			return true;
		}		
	}
	@Override
	public boolean validarPorIdEliminado(int id) {
		
		String sqlValidarId = "select count(Id) cantidad FROM productos where id=? and estado='1'" ;
		
		String cantidadDeIds = (String)jdbcTemplate.queryForObject(sqlValidarId, new Object[] { id }, String.class);
		
		
		if(cantidadDeIds.equals("1")){
			return false;	
		}
		else{
			return true;
		}		
	}
	
	@Override
	public boolean validarPorNombre(String nombre) {
		
		String sqlValidarNombre = "select count(Id) cantidad FROM productos where Nombre=? and estado='0'" ;
		

		String cantidadDeNombres = (String)jdbcTemplate.queryForObject(sqlValidarNombre, new Object[] { nombre }, String.class);
		
		
		if(cantidadDeNombres.equals("1")){
			return false;	
		}
		else{
			return true;
		}		
	}
	
	@Override
	public void restablecer(Producto producto) {
		
		String sql = "UPDATE productos SET Nombre=?, Descripcion=?, Precio=?,Estado=0, Cantidad=?, IdCategoria=? WHERE Id=?";
		jdbcTemplate.update(sql, producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getCantidad(), producto.getCategoria().getId(),producto.getId());
	}
	

	@Override
	public List<Producto> lista() {
		
		String sql = "SELECT p.Id, p.Nombre, p.FechaIngreso,p.Descripcion,p.Precio,p.Estado,p.Cantidad,p.IdCategoria,c.Nombre NombreCategoria FROM productos p INNER JOIN categorias c ON p.IdCategoria=c.Id WHERE p.Estado=0";
		List<Producto> listaProductos = jdbcTemplate.query(sql, new RowMapper<Producto>() {

			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto aProducto = new Producto();
				Categoria aCategoria = new Categoria();
				
				aProducto.setId(rs.getInt("Id"));
				aProducto.setNombre(rs.getString("Nombre"));
				aProducto.setFechaIngreso(rs.getString("FechaIngreso"));
				aProducto.setDescripcion(rs.getString("Descripcion"));
				aProducto.setPrecio(rs.getInt("Precio"));
				aProducto.setEstado(rs.getInt("Estado"));
				aProducto.setCantidad(rs.getInt("Cantidad"));
				aCategoria.setId(rs.getInt("IdCategoria"));
				aCategoria.setNombre(rs.getString("NombreCategoria"));
				aProducto.setCategoria(aCategoria);
				
				return aProducto;
			}
			
		});
		
		return listaProductos;
		
		
	}

	
	
	
	
}
