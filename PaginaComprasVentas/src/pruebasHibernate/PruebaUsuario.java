package pruebasHibernate;
import modelo.Usuario;
import modelo.Login;
import java.util.*;
import negocio.*;
public class PruebaUsuario {

	public static void main(String[] args) {
		
		//NOTA: uso getters dado que el autoincrementar de la base de datos puede
		//causar interferencias con el testeo
		Login login = new Login(2, "acanosa", "123");
		Usuario usuario = new Usuario(1, "Alejandro", "Canosa", "alecanosa@gmail.com", new GregorianCalendar(1996,0,19), 
				new GregorianCalendar(), login);
		LoginABM abmLogin = new LoginABM();
		UsuarioABM abmUsuario = new UsuarioABM();
		Usuario u;
		//agregar usuario
		abmLogin.agregar(login);
		abmUsuario.agregar(usuario);

		//traerUsuario
		u = abmUsuario.traerUsuario(usuario.getIdUsuario());
		System.out.println(u);
		
		
		//actualizar usuario
		usuario.setNombre("Agustin");
		abmUsuario.actualizar(usuario);
		u = abmUsuario.traerUsuario(usuario.getIdUsuario());
		System.out.println(u);
		
		
		//borrar usuario
		abmUsuario.borrar(u.getIdUsuario());
		System.out.println("Usuario con ID: " + u.getIdUsuario() + " eliminado!");
		
		
		
		
	}

}
