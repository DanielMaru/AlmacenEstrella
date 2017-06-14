package net.codejava.spring.modelo;

public class Producto {

	private int id;
	private String nombre;
	private int fechaIngreso;
	private String descripcion;
	private int precio;
	private int estado;
	private int cantidad;
	private Categoria categoria;
	
	public Producto()
	{
		
	}	

	public Producto(int id, int fechaIngreso, String descripcion, int precio, int estado, int cantidad,
			String nombre, Categoria categoria) {
		
		this.id = id;
		this.fechaIngreso = fechaIngreso;
		this.descripcion = descripcion;
		this.precio = precio;
		this.estado = estado;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.categoria= categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(int fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	

}
