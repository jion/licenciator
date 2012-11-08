package ar.edu.utn.frsf.licenciator.entidades;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class ClaseLicencia {
	
	@Id
	private String tipo;
	private String descripcion;
	private int edadMinima;
	private int[] costo = new int[10];
	
	public ClaseLicencia ()
	{}

	public ClaseLicencia (String tipo, String desc, int edad, int c1, int c2, int c3, int c4)
	{
		this.tipo = tipo;
		descripcion = desc;
		edadMinima = edad;
		costo[0] = c1;
		costo[1] = c2;
		costo[2] = c3;
		costo[3] = c4;
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
	
	public int[] getCosto()
	{
		return costo;
	}
	
	public boolean equals(ClaseLicencia clas)
	{
		return (tipo.equals(clas.tipo) && descripcion.equalsIgnoreCase(clas.descripcion) && edadMinima==clas.edadMinima && costo[0]==clas.costo[0] && costo[1]==clas.costo[1] && costo[2]==clas.costo[2] && costo[3]==clas.costo[3]);
	}
}
