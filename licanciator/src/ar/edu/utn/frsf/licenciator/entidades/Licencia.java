package ar.edu.utn.frsf.licenciator.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Licencia {
	
	@ManyToOne
	private Titular titular;
	@ManyToOne
	private ClaseLicencia clase;
	@Id
	@GeneratedValue
	private String nroLicencia;
	private Calendar fechaEmision;
	private Calendar fechaVencimiento;
	private String observaciones;
	
	public Licencia ()
	{}
	
	public Licencia (Titular tit, ClaseLicencia clas, String nro, Calendar emision, Calendar venc, String obs)
	{
		titular = tit;
		clase = clas;
		nroLicencia = nro;
		fechaEmision = emision;
		fechaVencimiento = venc;
		observaciones = obs;
	} 
	
	public Titular getTitular()
	{
		return titular;
	}
	
	public ClaseLicencia getClaseLicencia()
	{
		return clase;
	}

	public String getNrolicencia()
	{
		return nroLicencia;
	}
	
	public Calendar getFechaEmision()
	{
		return fechaEmision;
	}
	
	public Calendar getFechaVencimiento()
	{
		return fechaVencimiento;
	}
	
	public String getObservaciones()
	{
		return observaciones;
	}
	
	public boolean equals(Licencia l)
	{
		return (titular.equals(l.titular) && clase.equals(l.clase)	&&	nroLicencia.equals(l.nroLicencia) && fechaEmision.equals(l.fechaEmision) && fechaVencimiento.equals(l.fechaVencimiento) &&  observaciones.equals(l.observaciones));
	}
	
	/*public boolean equals(Licencia l)
	{
		return (this.observaciones.equals(l.observaciones));}*/
} 

