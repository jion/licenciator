package ar.edu.utn.frsf.licenciator.entidades;

import java.util.Calendar;
import java.util.Collections;
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
public class Titular {

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
	@OneToOne
	private ClaseLicencia clase;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="titular", fetch = FetchType.LAZY)
	private List<Licencia> licencias;

	@OneToOne
	private TipoSanguineo tipoFactor;
	private Boolean donante;

	public Titular() {
	}

	public Titular( TipoDoc tipo, long nro, String nom, String ap, Calendar nac, String dom, String loc, ClaseLicencia clas, TipoSanguineo tipoS, Boolean donante ) {
		tipoDoc = tipo;
		nroDoc = nro;
		nombre = nom;
		apellido = ap;
		fechaNacimiento = nac;
		domicilio = dom;
		localidad = loc;
		clase = clas;
		tipoFactor = tipoS;
		this.donante = donante;
		licencias = Collections.emptyList();
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

	public ClaseLicencia getClaseLicencia() {
		return clase;
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoFactor;
	}

	public Boolean getDonante() {
		return donante;
	}
	
	public List<Licencia> getLicencias() {
		return licencias;
	}

	public boolean equals( Titular tit ) {
		return ( tipoDoc.equals( tit.tipoDoc ) && ( nroDoc == tit.nroDoc ) && nombre.equalsIgnoreCase( tit.nombre ) && apellido.equalsIgnoreCase( tit.apellido ) && fechaNacimiento.equals( tit.fechaNacimiento ) && domicilio.equalsIgnoreCase( tit.domicilio ) && localidad.equalsIgnoreCase( tit.localidad ) && clase.equals( tit.clase ) && tipoFactor.equals( tit.tipoFactor ) && ( donante == tit.donante ) );
	}
}