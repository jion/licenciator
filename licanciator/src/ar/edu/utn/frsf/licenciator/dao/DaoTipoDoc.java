package ar.edu.utn.frsf.licenciator.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ar.edu.utn.frsf.licenciator.entidades.TipoDoc;

public class DaoTipoDoc {
	
	private DaoTipoDoc() {
		super();
	}
	
	public static TipoDoc read(String tipoD) {
		EntityManager em = EntityManagerManager.getEM();
		TipoDoc tipoDoc=null;
		
		TypedQuery<TipoDoc> query =
				em.createQuery("SELECT t FROM TipoDoc t WHERE t.tipo = :tipoD",
						TipoDoc.class);
		query.setParameter("tipoD", tipoD);

		if(query.getResultList().size() == 1)
			tipoDoc = query.getSingleResult();
		
		return tipoDoc;
	}
	
	public static List<TipoDoc> readAll() {
		EntityManager em = EntityManagerManager.getEM();
		
		TypedQuery<TipoDoc> query =
				em.createQuery("SELECT t FROM TipoDoc t",
						TipoDoc.class);

		return query.getResultList();
	}
}
