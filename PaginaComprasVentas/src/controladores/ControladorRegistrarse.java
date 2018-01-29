package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;
import negocio.LoginABM;
import negocio.UsuarioABM;

import java.util.*;
import funciones.Funciones;
public class ControladorRegistrarse extends HttpServlet {
	
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		procesarPeticion(request, response);
	}
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{
		procesarPeticion(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{
		procesarPeticion(request,response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		LoginABM abmLogin = new LoginABM();
		UsuarioABM abmUsuario = new UsuarioABM();
		
		String nombre = (String) request.getAttribute("nombre");
		String apellido = (String) request.getAttribute("apellido");
		String email = (String) request.getAttribute("email");
		String diaNac = (String) request.getAttribute("dia");
		String mesNac = (String) request.getAttribute("mes"); //OJO, recibo los meses con su rango real (1 al 12)
		String anioNac = (String) request.getAttribute("anio");
		GregorianCalendar fechaNac = new GregorianCalendar(Integer.parseInt(anioNac),(Integer.parseInt(mesNac) - 1), Integer.parseInt(diaNac));
		String usuario = (String) request.getAttribute("usuario");
		String clave = (String) request.getAttribute("clave");
		
		Login login = new Login(usuario,clave);
		Usuario u = new Usuario(nombre, apellido, email, fechaNac, login);
		String codigoDesbloqueo;
		//si no existe usuario agrego
		try {
			if(abmLogin.traerLogin(usuario)==null) {
				abmLogin.agregar(login);
				abmUsuario.agregar(u);
				String textoExito = "Usuario registrado, ya puede iniciar sesión";
				request.setAttribute("textoExito", textoExito);
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}else{
				String usuarioError="Ya hay una persona con ese nombre de usuario";
				request.setAttribute("usuarioError", usuarioError);
				request.getRequestDispatcher("Registro.jsp").forward(request, response);
			}
			//si existe redirijo a registro con mensaje de error
		}catch(Exception e) {
			response.sendError(500, e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
