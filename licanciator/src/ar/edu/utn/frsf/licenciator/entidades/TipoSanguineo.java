package ar.edu.utn.frsf.licenciator.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoSanguineo {
	
	@Id
	private int id;
	private String grupo;
	private char factor;
	
	public TipoSanguineo()
	{}
	
	public TipoSanguineo (String gr, char fac)
	{
		grupo = gr;
		factor = fac;
	}
	
	public String getGrupo()
	{
		return grupo;
	}
	
	public char getFactor()
	{
		return factor;
	}
	
	public boolean equals(TipoSanguineo tip)
	{
		return (grupo.equals(tip.grupo) && factor==tip.factor);
	}
}
