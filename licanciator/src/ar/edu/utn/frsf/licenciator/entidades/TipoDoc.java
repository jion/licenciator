package ar.edu.utn.frsf.licenciator.entidades;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class TipoDoc {
	
	@Id
	private String tipo;
	private String descripcion;
	
	public TipoDoc()
	{}
	
	public TipoDoc (String tipo, String desc)
	{
		this.tipo = tipo;
		descripcion = desc;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public boolean equals(TipoDoc doc)
	{
		return (tipo.equals(doc.tipo) && descripcion.equalsIgnoreCase(doc.descripcion));
	}
}

