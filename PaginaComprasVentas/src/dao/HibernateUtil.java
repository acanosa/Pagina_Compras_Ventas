package dao;
import java.util.Properties;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import modelo.Login;
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		try{
			if (sessionFactory == null) {
				Configuration configuration = new Configuration().configure();
				sessionFactory = configuration.buildSessionFactory();
			}
			
		} catch (HibernateException he) { System.err.println("ERROR en la inicialización de la SessionFactory: " + he);
					he.printStackTrace();
					throw new ExceptionInInitializerError(he);
		}
		return sessionFactory;
	}
	
	
	
	/*
	private static SessionFactory sessionFactory;
	private static Session session;
	public static Session getSession() {
		try{
			if (session == null) {
				Configuration configuracion = new Configuration().configure("hibernate.cfg.xml");
				//configuracion.addAnnotatedClass(Login.class);
				sessionFactory = configuracion.buildSessionFactory();
				session = sessionFactory.openSession();
			}
		} catch (HibernateException he) { 
			System.err.println("ERROR en la inicialización de la SessionFactory: " + he);
			he.printStackTrace();
			throw new ExceptionInInitializerError(he);
		}
		return session;
	}
	*/

}
