package ar.edu.utn.frsf.licenciator.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;
import ar.edu.utn.frsf.licenciator.entidades.Titular;

public class DaoTipoDoc {
	public static TipoDoc read(String tipoD) {
		EntityManager em = EntityFactory.getEMFactory().createEntityManager();
		TipoDoc tipoDoc=null;
		
		TypedQuery<TipoDoc> query =
				em.createQuery("SELECT t FROM TipoDoc t WHERE t.tipo = :tipoD",
						TipoDoc.class);
		query.setParameter("tipoD", tipoD);

		if(query.getResultList().size() == 1)
			tipoDoc = query.getSingleResult();
		em.close();
		
		return tipoDoc;
	}
}
