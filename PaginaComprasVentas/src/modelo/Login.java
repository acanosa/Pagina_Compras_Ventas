package modelo;

import java.util.GregorianCalendar;
import funciones.Funciones;
import org.hibernate.*;
//import org.hibernate.annotations; 
import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLogin")
	private long idLogin;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="clave")
	private String clave;
	
	@Column(name="ultimoInicio")
	private GregorianCalendar ultimoInicio;
	
	@Column(name="bloqueado")
	private boolean bloqueado;
	
	@Column(name="codigoDesbloqueo")
	private String codigoDesbloqueo;
	
	public Login() {}
	
	public Login(long idLogin, String usuario, String clave) {
		super();
		this.idLogin = idLogin;
		this.usuario = usuario;
		this.clave = clave;
		this.ultimoInicio = new GregorianCalendar();
		this.bloqueado = false;
	}
	
	public Login(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.ultimoInicio = new GregorianCalendar();
		this.bloqueado = false;
	}

	public long getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(long idLogin) {
		this.idLogin = idLogin;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public GregorianCalendar getUltimoInicio() {
		return ultimoInicio;
	}

	public void setUltimoInicio(GregorianCalendar ultimoInicio) {
		this.ultimoInicio = ultimoInicio;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	public String getCodigoDesbloqueo() {
		return codigoDesbloqueo;
	}

	public void setCodigoDesbloqueo(String codigoDesbloqueo) {
		this.codigoDesbloqueo = codigoDesbloqueo;
	}
	
	//si se ingreso correctamente True
	public boolean desbloquearCuenta(String codigo){
		boolean resultado = codigo.equals(codigoDesbloqueo);
		if (!resultado)
			return false;
		else
			this.setBloqueado(resultado);
			return true;
	}

	@Override
	public String toString() {
		return "Datos de Login: " + usuario + ", fecha de ultimo inicio de sesion: " + Funciones.fechaAFormatoBarras(this.ultimoInicio);
	}
	
	

}
