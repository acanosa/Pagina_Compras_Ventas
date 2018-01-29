package modelo;

public class Imagen {
	
	private long idImagen;
	private String localizacion;
	private Producto producto;
	
	public Imagen(long idImagen, String localizacion, Producto producto) {
		super();
		this.idImagen = idImagen;
		this.localizacion = localizacion;
		this.producto = producto;
	}

	public long getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(long idImagen) {
		this.idImagen = idImagen;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

}
