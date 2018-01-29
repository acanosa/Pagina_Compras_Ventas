package modelo;

import java.util.GregorianCalendar;

public class Ropa extends Producto{
	
	private long idRopa;
	private String estacion;
	private String material;
	private String colores;
	
	public Ropa(long idProducto, String nombre, float precio, GregorianCalendar fechaPublicacion, int stock,
			String descripcion, String marca, boolean nuevo, Usuario usuario, long idRopa, String estacion,
			String material, String colores) {
		super(idProducto, nombre, precio, fechaPublicacion, stock, descripcion, marca, nuevo, usuario);
		this.idRopa = idRopa;
		this.estacion = estacion;
		this.material = material;
		this.colores = colores;
	}

	public long getIdRopa() {
		return idRopa;
	}

	public void setIdRopa(long idRopa) {
		this.idRopa = idRopa;
	}

	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColores() {
		return colores;
	}

	public void setColores(String colores) {
		this.colores = colores;
	}
	
	

}
