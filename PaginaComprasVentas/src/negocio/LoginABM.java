package negocio;

import dao.LoginDao;
import modelo.Login;

public class LoginABM {
	
	LoginDao dao = new LoginDao();
	
	public int agregar(Login objeto) throws Exception{
		if(objeto != null)
			return dao.agregar(objeto);
		else
			throw new Exception("Objeto nulo");
	}
	
	public Login traerLogin(int id) throws Exception{
		return dao.traerLogin(id);
	}
	
	public Login traerLogin(String usuario) throws Exception{
		return dao.traerLogin(usuario);
	}
	
	
	
	//TODO si obj es null lanzar excepcion
	public void actualizar(Login obj) throws Exception{
		if(obj != null && dao.traerLogin(obj.getUsuario()) != null)
			dao.actualizar(obj);
		else
			throw new Exception("No se puede modificar Login nulo o no registrado");
	}
	//TODO excepcion si no existe Login
	public void borrar(int id) throws Exception{
		if(dao.traerLogin(id) != null)
			dao.borrar(id);
		else
			throw new Exception("No se puede borrar Login inexistente");
	}
	
	

}
