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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == TipoSanguineo.class) {
			TipoSanguineo ts = (TipoSanguineo) obj;
			return ( grupo.equalsIgnoreCase(ts.grupo) &&
					factor==ts.factor );
		}
		
		return super.equals(obj);
	}
}
