package ar.edu.utn.frsf.licenciator.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Auditoria {
	@Id
	@GeneratedValue
	int id;
	@Temporal(TemporalType.TIMESTAMP)
	Calendar fecha;
	String usuario;
	String accion;
	
	protected Auditoria() {
		super();
	}
	
	public Auditoria(String usuario, String accion) {
		super();
		fecha = Calendar.getInstance();
		this.usuario = usuario;
		this.accion = accion;
	}
	/**
	 * @return the fecha
	 */
	protected Calendar getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	protected void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the usuario
	 */
	protected String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	protected void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the accion
	 */
	protected String getAccion() {
		return accion;
	}
	/**
	 * @param accion the accion to set
	 */
	protected void setAccion(String accion) {
		this.accion = accion;
	}
	/**
	 * @return the id
	 */
	protected int getId() {
		return id;
	}
	
}
