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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == TipoDoc.class) {
			TipoDoc doc = (TipoDoc) obj;
			return (tipo.equalsIgnoreCase(doc.tipo));
		}
		return super.equals(obj);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{ " + tipo + "}";
	}
	
}

