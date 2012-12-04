package ar.edu.utn.frsf.licenciator.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ar.edu.utn.frsf.licenciator.entidades.*;

public class DaoTipoSanguineo {
	
	private DaoTipoSanguineo() {
		super();
	}
	
	public static List<TipoSanguineo> readAll() {
		EntityManager em = EntityManagerManager.getEM();
		
		TypedQuery<TipoSanguineo> query = em.createQuery( "SELECT t FROM TipoSanguineo t", TipoSanguineo.class);
		
		return query.getResultList();
	}
}