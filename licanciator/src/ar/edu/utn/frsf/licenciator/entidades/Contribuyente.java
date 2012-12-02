package ar.edu.utn.frsf.licenciator.entidades;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contribuyente {

	@Id
	@GeneratedValue
	private int id;

	@OneToOne
	private TipoDoc tipoDoc;

	private long nroDoc;

	private String nombre;
	private String apellido;

	@Temporal(TemporalType.DATE)
	private Calendar fechaNacimiento;

	private String domicilio;
	private String localidad;

	public Contribuyente() {
	}

	public Contribuyente( TipoDoc tipo, long nro, String nom, String ap, Calendar nac, String dom, String loc, TipoSanguineo tipoS, Boolean donante ) {
		tipoDoc = tipo;
		nroDoc = nro;
		nombre = nom;
		apellido = ap;
		fechaNacimiento = nac;
		domicilio = dom;
		localidad = loc;
	}

	public int getId() {
		return id;
	}

	public long getNroDoc() {
		return nroDoc;
	}

	public TipoDoc getTipoDoc() {
		return tipoDoc;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Calendar getFechaNac() {
		return fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public boolean equals( Contribuyente tit ) {
		return ( tipoDoc.equals( tit.tipoDoc ) && ( nroDoc == tit.nroDoc ) &&
				nombre.equalsIgnoreCase( tit.nombre ) &&
				apellido.equalsIgnoreCase( tit.apellido ) &&
				fechaNacimiento.equals( tit.fechaNacimiento ) &&
				domicilio.equalsIgnoreCase( tit.domicilio ) &&
				localidad.equalsIgnoreCase( tit.localidad ) );
	}
}