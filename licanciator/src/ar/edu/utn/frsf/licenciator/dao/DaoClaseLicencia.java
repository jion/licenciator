package ar.edu.utn.frsf.licenciator.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ar.edu.utn.frsf.licenciator.entidades.*;

public class DaoClaseLicencia {
	
	private DaoClaseLicencia() {
		super();
	}

	
	public static ClaseLicencia read(String tipoL) {
		EntityManager em = EntityManagerManager.getEM();
		ClaseLicencia licencia = null;
		
		TypedQuery<ClaseLicencia> query =
				em.createQuery("SELECT l FROM ClaseLicencia l WHERE l.tipo = :tipoL",
						ClaseLicencia.class);
		query.setParameter("tipoL", tipoL);

		if(query.getResultList().size() == 1)
			licencia = query.getSingleResult();
		
		return licencia;
	}
	
	public static List<ClaseLicencia> readAll() {
		EntityManager em = EntityManagerManager.getEM();
		
		TypedQuery<ClaseLicencia> query =
				em.createQuery("SELECT l FROM ClaseLicencia l",
						ClaseLicencia.class);
		
		return query.getResultList();
	}
}
