package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Usuario;

public class UsuarioDao {
	
	private static Session sesion;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException{
		sesion = HibernateUtil.getSessionFactory().openSession();
		//sesion = HibernateUtil.getSession();
		tx = sesion.beginTransaction();
	}
	
	private void manejarExcepcion(HibernateException he){
		tx.rollback();
		he.printStackTrace();
		System.out.println("ERROR EN LA TRANSACCION DE HIBERNATE");
	}

	public int agregar(Usuario objeto) {
		int agregar = 0;
		try {
			iniciaOperacion();
			agregar = Integer.parseInt(sesion.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejarExcepcion(he);
		}finally {
			sesion.close();
		}
		return agregar;
	}
	
	public Usuario traerUsuario(long id) {
		Usuario obj = null;
		try {
			iniciaOperacion();
			String hql = "from Usuario where idUsuario=" + id;
			obj = (Usuario) sesion.createQuery(hql).uniqueResult();
		}catch(HibernateException he) {
			manejarExcepcion(he);
		}finally {
			sesion.close();
		}
		return obj;
	}


	public void actualizar(Usuario obj) {
		try {
			iniciaOperacion();
			sesion.update(obj);
			tx.commit();
		}catch(HibernateException he) {
			manejarExcepcion(he);
		}finally {
			sesion.close();
		}
	}
	
	public void borrar(long id) {
		Usuario obj = null;
		try {
			iniciaOperacion();
			String hql = "from Usuario where idUsuario=" + id;
			obj = (Usuario) sesion.createQuery(hql).uniqueResult();
			sesion.delete(obj);
			tx.commit();
		}catch(HibernateException he) {
			manejarExcepcion(he);
		}finally {
			sesion.close();
		}
	}
}
