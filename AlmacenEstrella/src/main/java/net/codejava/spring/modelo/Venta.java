package net.codejava.spring.modelo;

public class Venta{
	
	private int id;
	private String cajero;
	private String fechasVenta;
	private int estado; 
	private int total;
	
	

	public Venta() {
	}
	public Venta(String cajero, String fechasVenta) {
		this.cajero = cajero;
		this.fechasVenta = fechasVenta;

		
	}

	public Venta(String cajero, String fechasVenta,int estado,int total) {
		this.cajero = cajero;
		this.fechasVenta = fechasVenta;
		this.estado = estado;
			
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
	
	
}
