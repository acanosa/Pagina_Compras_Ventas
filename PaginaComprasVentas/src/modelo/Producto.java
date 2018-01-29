package modelo;

import java.util.GregorianCalendar;

import funciones.Funciones;
import org.hibernate.*;
//import org.hibernate.annotations; 
import javax.persistence.*;
@Entity
@Table(name="producto")
public class Producto {
	
	private long idProducto;
	private String nombre;
	private float precio;
	private GregorianCalendar fechaPublicacion;
	private int stock;
	private String descripcion;
	private String marca;
	private boolean nuevo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
	private Usuario usuario;
	
	public Producto(long idProducto, String nombre, float precio, GregorianCalendar fechaPublicacion, int stock,
			String descripcion, String marca, boolean nuevo, Usuario usuario) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
		this.stock = stock;
		this.descripcion = descripcion;
		this.marca = marca;
		this.nuevo = nuevo;
		this.usuario = usuario;
	}
	
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public GregorianCalendar getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(GregorianCalendar fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public boolean isNuevo() {
		return nuevo;
	}
	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//descuenta 1 al stock actual
	public void restarStock() throws Exception{
		if(this.stock == 0) {
			throw new Exception("No hay stock disponible");
		}else
			setStock(this.stock-1);
	}
	
	@Override
	public String toString() {
		return "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + Funciones.formatearFloat(precio)
				+ ", fechaPublicacion=" + Funciones.fechaAFormatoBarras(fechaPublicacion) + ", stock=" + stock + ", descripcion=" + descripcion
				+ ", marca=" + marca + ", nuevo=" + Funciones.booleanoATexto(nuevo) + ", usuario=" + usuario.getLogin().getUsuario();
	}
	
	
	
	
	
	

}
