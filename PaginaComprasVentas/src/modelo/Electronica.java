package modelo;

import java.util.GregorianCalendar;

public class Electronica extends Producto{
	
	private long idElectronica;
	private String fines;
	private String consumo;
	
	public Electronica(long idProducto, String nombre, float precio, GregorianCalendar fechaPublicacion, int stock,
			String descripcion, String marca, boolean nuevo, Usuario usuario, long idElectronica, String fines,
			String consumo) {
		super(idProducto, nombre, precio, fechaPublicacion, stock, descripcion, marca, nuevo, usuario);
		this.idElectronica = idElectronica;
		this.fines = fines;
		this.consumo = consumo;
	}

	public long getIdElectronica() {
		return idElectronica;
	}

	public void setIdElectronica(long idElectronica) {
		this.idElectronica = idElectronica;
	}

	public String getFines() {
		return fines;
	}

	public void setFines(String fines) {
		this.fines = fines;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}
	
	

}
