package ar.edu.utn.frsf.licenciator.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == Contribuyente.class) {
			Contribuyente c = (Contribuyente) obj;
			return ( tipoDoc.equals( c.tipoDoc ) && ( nroDoc == c.nroDoc ) &&
					nombre.equalsIgnoreCase( c.nombre ) &&
					apellido.equalsIgnoreCase( c.apellido ) &&
					fechaNacimiento.get(Calendar.YEAR) == fechaNacimiento.get(Calendar.YEAR) &&
					fechaNacimiento.get(Calendar.DAY_OF_YEAR) == fechaNacimiento.get(Calendar.DAY_OF_YEAR) &&
					domicilio.equalsIgnoreCase( c.domicilio ) &&
					localidad.equalsIgnoreCase( c.localidad ) );
		}
		
		return super.equals(obj);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{ " + tipoDoc + ", " + nombre + ", " + apellido + ", " + fechaNacimiento + ", " + domicilio + localidad + "}";
	}
}