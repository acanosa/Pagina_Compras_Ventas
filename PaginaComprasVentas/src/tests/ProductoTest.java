package tests;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import funciones.Funciones;
import modelo.Producto;
public class ProductoTest {

	Producto producto;
	
	@Before
	public void setUp() throws Exception {
		producto = new Producto(1, "Producto", 35.00f, new GregorianCalendar(), 0, "Producto a vender", 
				"AVON", true,null);
	}

	@Test
	public void restarStockInvalidoTest() {
		try {
			producto.restarStock();
			fail("Fallo, logro restar stock");
		} catch (Exception e) {
			assertTrue("Fallo - parece que hay un problema con la condicion", producto.getStock() == 0);
		}
		
	}
	
	@Test
	public void mostrarPrecioTest() {
		String precioMostrar = "35,00";
		String precioFormateado = Funciones.formatearFloat(producto.getPrecio());
		assertEquals("Fallo - no formateo correctamente", precioMostrar,precioFormateado);
	}
	

}
