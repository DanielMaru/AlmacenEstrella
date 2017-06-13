package net.codejava.spring.modelo;

public class Venta{
	
	private int Id;
	private String Cajero;
	private String FechasVenta;
	private int Estado; 
	
	

	public Venta() {
	}
	public Venta(String Cajero, String FechasVenta) {
		this.Cajero = Cajero;
		this.FechasVenta = FechasVenta;

		
	}

	public Venta(String Cajero, String FechasVenta,int Estado) {
		this.Cajero = Cajero;
		this.FechasVenta = FechasVenta;
		this.Estado = Estado;
	
		
		
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getCajero() {
		return Cajero;
	}

	public void setCajero(String Cajero) {
		this.Cajero = Cajero;
	}

	public String getFechasVenta() {
		return FechasVenta;
	}

	public void setFechasVenta(String FechasVenta) {
		this.FechasVenta = FechasVenta;
	}
	
	public int getEstado() {
		return Estado;
	}

	public void setEstado(int Estado) {
		this.Estado = Estado;
	}
	
}
