package pruebasHibernate;

import modelo.Login;
import negocio.LoginABM;

public class PruebaLogin {

	public static void main(String[] args) {
		Login l = new Login("acanosa", "123");
		LoginABM abm = new LoginABM();
		abm.agregar(l);
		Login pruebaId = abm.traerLogin(1);
		Login pruebaUsuario = abm.traerLogin("acanosa");
		System.out.println("Clave anterior: " + l.getClave());
		l.setClave("clave");
		System.out.println("Nueva clave: " + l.getClave());
		abm.actualizar(l);;
		//abm.borrar(1);
		System.out.println(l);

	}

}
