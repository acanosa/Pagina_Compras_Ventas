package modelo;

import java.util.Calendar;

import java.util.GregorianCalendar;
import javax.persistence.*;
import org.hibernate.*;

import funciones.Funciones;
@Entity
@Table(name="usuario")
public class Usuario {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private long idUsuario;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="email")
	private String email;
	
	@Column(name="fechaNacimiento")
	private GregorianCalendar fechaNacimiento;
	
	@Column(name="miembroDesde")
	private GregorianCalendar miembroDesde;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idLogin")
	private Login login;
	
	public Usuario() {}
	

	public Usuario(String nombre, String apellido, String email, GregorianCalendar fechaNacimiento, Login login) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.miembroDesde = new GregorianCalendar();
		this.login = login;
	}
	
	public Usuario(long idUsuario, String nombre, String apellido, String email, GregorianCalendar fechaNacimiento,
			GregorianCalendar miembroDesde, Login login) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.miembroDesde = miembroDesde;
		this.login = login;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public GregorianCalendar getMiembroDesde() {
		return miembroDesde;
	}

	public void setMiembroDesde(GregorianCalendar miembroDesde) {
		this.miembroDesde = miembroDesde;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	//calculo la edad del usuario
	public int getEdad(){
		GregorianCalendar fechaActual = new GregorianCalendar();
		int edad = 0;
		//si el mes de cumple ya paso
		if(this.fechaNacimiento.get(Calendar.MONTH) < fechaActual.get(Calendar.MONTH)) {
			
			edad = fechaActual.get(Calendar.YEAR) - this.fechaNacimiento.get(Calendar.YEAR);
		//si el mes de cumple no paso	
		}else if(this.fechaNacimiento.get(Calendar.MONTH) > fechaActual.get(Calendar.MONTH)) {
			
			edad = fechaActual.get(Calendar.DAY_OF_MONTH) - this.fechaNacimiento.get(Calendar.DAY_OF_MONTH) - 1;
		//si el mes de cumple es el actual me fijo si el dia ya paso
		}else if(this.fechaNacimiento.get(Calendar.MONTH) == fechaActual.get(Calendar.MONTH)) {
			//si el dia ya paso o es igual
			if(this.fechaNacimiento.get(Calendar.DAY_OF_MONTH) <= fechaActual.get(Calendar.DAY_OF_MONTH)) {
				
				edad = edad = fechaActual.get(Calendar.YEAR) - this.fechaNacimiento.get(Calendar.YEAR);
			//si la fecha de cumpleanios aun no paso
			}else if(this.fechaNacimiento.get(Calendar.DAY_OF_MONTH) > fechaActual.get(Calendar.DAY_OF_MONTH)) {
				
				edad = edad = fechaActual.get(Calendar.YEAR) - this.fechaNacimiento.get(Calendar.YEAR) - 1;
				
			}
		}
		return edad;
	}
	
	@Override
	public String toString() {
		return "Nombre completo: " + this.nombre + " " + this.apellido + "\n" + "Edad: " + this.getEdad() + "\n"
				+ "Miembro desde el: " + Funciones.fechaAFormatoBarras(miembroDesde);
	}
	
	
	
	
}
