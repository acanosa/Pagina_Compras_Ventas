package tests;

import static org.junit.Assert.*;
import modelo.Usuario;

import org.junit.Before;
import org.junit.Test;
import java.util.*
;
public class UsuarioTest {

	Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario(1,"Alejandro", "Canosa", "alecanosa@gmail.com", new GregorianCalendar(1996,0,19), new GregorianCalendar(2016,5,20), null);
	}

	@Test
	public void testGetEdad() {
		int edad = usuario.getEdad();
		assertTrue("Fallo - fechas incorrectas", edad == 21);
	}

}
