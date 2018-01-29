package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Login;

public class LoginDao {
	
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
	
	public int agregar(Login objeto) {
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
	
	public Login traerLogin(long id) {
		Login obj = null;
		try {
			iniciaOperacion();
			String hql = "from Login where idLogin=" + id;
			obj = (Login) sesion.createQuery(hql).uniqueResult();
		}catch(HibernateException he) {
			manejarExcepcion(he);
		}finally {
			sesion.close();
		}
		return obj;
	}
	
	public Login traerLogin(String usuario) {
		Login obj = null;
		try {
			iniciaOperacion();
			String hql = "from Login where usuario= \'" + usuario+ "\'";
			obj = (Login) sesion.createQuery(hql).uniqueResult();
		}catch(HibernateException he) {
			manejarExcepcion(he);
		}finally {
			sesion.close();
		}
		return obj;
	}

	public void actualizar(Login obj) {
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
		Login obj = null;
		try {
			iniciaOperacion();
			String hql = "from Login where idLogin=" + id;
			obj = (Login) sesion.createQuery(hql).uniqueResult();
			sesion.delete(obj);
			tx.commit();
		}catch(HibernateException he) {
			manejarExcepcion(he);
		}finally {
			sesion.close();
		}
	}
	
	
	
}
