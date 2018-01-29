package negocio;
import modelo.Usuario;
import dao.UsuarioDao;
public class UsuarioABM {
	
	UsuarioDao dao = new UsuarioDao();
	
	//TODO excepciones
	public int agregar(Usuario usuario) throws Exception{
		if(usuario != null)
			return dao.agregar(usuario);
		else
			throw new Exception("No se puede agregar usuario nulo");
	}
	
	public Usuario traerUsuario(long id) {
		return dao.traerUsuario(id);
	}
	
	public void actualizar(Usuario usuario) throws Exception{
		if(usuario == null)
			dao.actualizar(usuario);
		else
			throw new Exception("No se puede actualizar usuario nulo");
	}
	
	public void borrar(long id) throws Exception{
		if(dao.traerUsuario(id) != null) {
			dao.borrar(id);
		}else
			throw new Exception("No se puede borrar usuario nulo");
		
	}

}
