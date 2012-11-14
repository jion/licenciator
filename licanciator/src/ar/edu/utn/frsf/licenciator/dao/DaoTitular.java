package ar.edu.utn.frsf.licenciator.dao;
import ar.edu.utn.frsf.licenciator.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class DaoTitular {
	public static Titular read(TipoDoc tipoD, long nroD) {
		EntityManager em = EntityManagerManager.getEM();
		Titular titular=null;
		
		TypedQuery<Titular> query =
				em.createQuery("SELECT t FROM Titular t WHERE t.tipoDoc = :tipoD AND t.nroDoc = :nroD",
						Titular.class);
		query.setParameter("tipoD", tipoD);
		query.setParameter("nroD", nroD);

		if(query.getResultList().size() == 1)
			titular = query.getSingleResult();
		
		return titular;
	}
}
