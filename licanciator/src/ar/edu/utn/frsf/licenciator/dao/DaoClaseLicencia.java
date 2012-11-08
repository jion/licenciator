package ar.edu.utn.frsf.licenciator.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ar.edu.utn.frsf.licenciator.entidades.*;

public class DaoClaseLicencia {
	public static ClaseLicencia read(String tipoL) {
		EntityManager em = EntityFactory.getEMFactory().createEntityManager();
		ClaseLicencia licencia = null;
		
		TypedQuery<ClaseLicencia> query =
				em.createQuery("SELECT l FROM ClaseLicencia l WHERE l.tipo = :tipoL",
						ClaseLicencia.class);
		query.setParameter("tipoL", tipoL);

		if(query.getResultList().size() == 1)
			licencia = query.getSingleResult();
		em.close();
		
		return licencia;
	}
}
