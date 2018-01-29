package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import funciones.Funciones;

import java.util.GregorianCalendar;
import modelo.Login;

public class LoginTest {
	//implementacion de TDD, clase: Login
	
	Login login;
	
	@Before
	public void setUp() throws Exception {
		login = new Login("acanosa", "1234");
		login.setCodigoDesbloqueo("A321Bk");
	}
	
	@Test
	public void loguearseCorrectamenteTest() {
		String usuario = "acanosa";
		String password = "1234";
		assertTrue("Fallo - usuario o clave incorrectas o bloqueado de sistema", 
				(login.getUsuario().equals(usuario) && login.getClave().equals(password) && !login.isBloqueado()));
	}
	
	@Test
	public void desbloquearCuenta(){
		String codigoIngresado = "A321Bk";
		assertTrue("Fallo - codigo incorrecto.", login.desbloquearCuenta(codigoIngresado));
	}
	
	@Test
	public void toStringTest() {
		String mensaje = "Datos de Login: acanosa, fecha de ultimo inicio de sesion: 15/12/2017"; 
		assertEquals("Fallo - mensaje incorrecto: " + login.toString(), mensaje, login.toString());	
	}
	
	

}
