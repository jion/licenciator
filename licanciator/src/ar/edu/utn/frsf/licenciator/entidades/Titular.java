package ar.edu.utn.frsf.licenciator.entidades;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
 
public class Titular {
	
	private TipoDoc tipoDoc;
	@Id
	private long nroDoc;
	private String nombre;
	private String apellido;
	private Calendar fechaNacimiento;
	private String domicilio;
	private String localidad;
	private ClaseLicencia clase;
	private TipoSanguineo tipoFactor; 
	private boolean donante;
	
	public Titular()
	{}
	
	public Titular (TipoDoc tipo, long nro, String nom, String ap, Calendar nac, String dom, String loc, ClaseLicencia clas, TipoSanguineo tipoS, boolean donante)
	{
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
		
	}
	
	public long getNroDoc()
	{
		return nroDoc;
	}
	
	public TipoDoc getTipoDoc()
	{
		return tipoDoc;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getApellido()
	{
		return apellido;
	}
	
	public Calendar getFechaNac()
	{
		return fechaNacimiento;
	}
	
	public String getDomicilio()
	{
		return domicilio;
	}
	
	public String getLocalidad()
	{
		return localidad;
	}
	
	public ClaseLicencia getClaseLicencia()
	{
		return clase;
	}
	
	public TipoSanguineo getTipoSanguineo()
	{
		return tipoFactor;
	}
	
	public boolean getDonante()
	{
		return donante;
	}
	
	public boolean equals(Titular tit)
	{
		return (tipoDoc.equals(tit.tipoDoc) && (nroDoc==tit.nroDoc) && nombre.equalsIgnoreCase(tit.nombre) && apellido.equalsIgnoreCase(tit.apellido) && fechaNacimiento.equals(tit.fechaNacimiento) && domicilio.equalsIgnoreCase(tit.domicilio) && localidad.equalsIgnoreCase(tit.localidad) && clase.equals(tit.clase) && tipoFactor.equals(tit.tipoFactor) && (donante==tit.donante));
	}
}
