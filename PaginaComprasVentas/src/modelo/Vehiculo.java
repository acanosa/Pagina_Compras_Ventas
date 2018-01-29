package modelo;

import java.util.GregorianCalendar;

public class Vehiculo extends Producto{
	
	private long idVehiculo;
	private String tipoVehiculo;
	private int capacidadMaxima;
	private int anio;
	private String modelo;
	
	public Vehiculo(long idProducto, String nombre, float precio, GregorianCalendar fechaPublicacion, int stock,
			String descripcion, String marca, boolean nuevo, Usuario usuario, long idVehiculo, String tipoVehiculo,
			int capacidadMaxima, int anio, String modelo) {
		super(idProducto, nombre, precio, fechaPublicacion, stock, descripcion, marca, nuevo, usuario);
		this.idVehiculo = idVehiculo;
		this.tipoVehiculo = tipoVehiculo;
		this.capacidadMaxima = capacidadMaxima;
		this.anio = anio;
		this.modelo = modelo;
	}

	public long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
