package ar.edu.utn.frsf.licenciator.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class TipoDoc {
	
	@Id
	@GeneratedValue
	private int id;
	private String tipo;
	private String descripcion;
	
	public TipoDoc()
	{}
	
	public TipoDoc (int id, String tipo, String desc)
	{
		this.id = id;
		this.tipo = tipo;
		descripcion = desc;
	}
	
	protected int getId() {
		return id;
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

