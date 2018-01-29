package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import funciones.Funciones;

import java.util.GregorianCalendar;
public class FuncionesTest {
	GregorianCalendar fecha;
	float convertir;
	String fechaTexto;
	@Before
	public void setUp() throws Exception {
		fecha = new GregorianCalendar(2017,11,15);
		convertir = 3.50f;
		fechaTexto = "19/01/1996";
	}

	@Test
	public void fechaFormatoABarrasTest() {
		String fechaFinal = "15/12/2017";
		assertEquals("Fallo - se convirtio mal la fecha", fechaFinal, Funciones.fechaAFormatoBarras(fecha));
	}
	
	@Test
	public void formatearFloatTest(){
		String floatFinal = "3,50";
		assertEquals("Fallo - no formateo correctamente", floatFinal, Funciones.formatearFloat(convertir));
	}
	
	@Test
	public void booleanoATextoTest() {
		String textoFinal = "Si";
		assertEquals("Fallo - no convirtio correctamente a texto", textoFinal, Funciones.booleanoATexto(true));
		//en vez de desglosar este caso en 2 , simplemente invierto los valores
		textoFinal = "No";
		assertEquals("Fallo - no convirtio correctamente a texto", textoFinal, Funciones.booleanoATexto(false));
	}
	
	@Test
	public void textoAFechaTest() {
		assertTrue("Error - no se pudo convertir correctamente"
				, new GregorianCalendar(1996,0,19).equals(Funciones.textoAFecha(fechaTexto)));
	}
}
