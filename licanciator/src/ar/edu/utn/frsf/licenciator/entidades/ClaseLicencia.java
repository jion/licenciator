package ar.edu.utn.frsf.licenciator.entidades;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class ClaseLicencia {

	@Id
	private String tipo;
	private String descripcion;
	private int edadMinima;
	
	/* Al no estar implementado el "Calcular costo vigencia, se toma el mismo
	 * costo para toda la clase.
	 */
	private int costo;
	
	public ClaseLicencia ()
	{}

	public ClaseLicencia (String tipo, String desc, int edad, int c1)
	{
		this.tipo = tipo;
		descripcion = desc;
		edadMinima = edad;
		costo = c1;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public int getEdadMinima()
	{
		return edadMinima;
	}
	
	public int getCosto()
	{
		return costo;
	}
	
	@Override
	public String toString() {
		return tipo;
	}

	public boolean equals(ClaseLicencia clas)
	{
		return (tipo.equals(clas.tipo) && descripcion.equalsIgnoreCase(clas.descripcion) && edadMinima==clas.edadMinima && costo==clas.costo);
	}
}
