package ar.edu.utn.frsf.licenciator.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import ar.edu.utn.frsf.licenciator.dao.DaoUsuarios;

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
		this.nombre = nombre;
		this.password = password; //TODO: Guardar MD5 del password
		this.superuser = superuser;
	}

	/* Metodos de instancia */
	public boolean changePassword(Usuario responsable, String new_password) {
		if(this.equals(responsable) ||
				(responsable != null && responsable.isSuperuser())) {
			this.password = new_password;
			DaoUsuarios.update(this);
		}
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
