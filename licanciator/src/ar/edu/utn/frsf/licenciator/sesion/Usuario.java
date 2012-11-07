package ar.edu.utn.frsf.licenciator.sesion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	@Column(unique=true)
	private String nombre;
	private String password;
	private boolean superuser;
	
	/* Constructores */
	protected Usuario() { super(); }

	public Usuario(String nombre, String password, boolean superuser) {
		super();
		
	}

	/* Metodos de instancia */
	public boolean changePassword(Usuario responsable, String new_password) {
		return false;
	}
	
	/* Getters */
	
	public String getNombre() {
		return nombre;
	}
	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	public boolean isSuperuser() {
		return superuser;
	}
	
	/* Overrides */
	@Override
	public boolean equals(Object arg0) {
		if(arg0.getClass() == Usuario.class) {
			return ((Usuario) arg0).getNombre().equals(getNombre());
		}
		return super.equals(arg0);
	}
	
}
