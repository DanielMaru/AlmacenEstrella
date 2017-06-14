package net.codejava.spring.modelo;

import java.util.List;

public class Venta{
	
	private int id;
	private String cajero;
	private String fechasVenta;
	private int estado; 
	private int total;
	private List<Producto> listaProductos;
	
	

	public Venta() {
	}
	public Venta(String cajero, String fechasVenta,List<Producto> listaProductos) {
		this.cajero = cajero;
		this.fechasVenta = fechasVenta;
		this.listaProductos= listaProductos;

		
	}

	public Venta(String cajero, String fechasVenta,int estado,int total,List<Producto> listaProductos) {
		this.cajero = cajero;
		this.fechasVenta = fechasVenta;
		this.estado = estado;
		this.listaProductos= listaProductos;
			
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCajero() {
		return cajero;
	}
	public void setCajero(String cajero) {
		this.cajero = cajero;
	}
	public String getFechasVenta() {
		return fechasVenta;
	}
	public void setFechasVenta(String fechasVenta) {
		this.fechasVenta = fechasVenta;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
}
