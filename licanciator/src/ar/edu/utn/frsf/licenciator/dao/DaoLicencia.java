package ar.edu.utn.frsf.licenciator.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import ar.edu.utn.frsf.licenciator.entidades.Licencia;

public class DaoLicencia {
	
	private DaoLicencia() {
		super();
	}
	
	public static Licencia read(String nro) {
		EntityManager em = EntityManagerManager.getEM();
		Licencia licencia=null;
		
		TypedQuery<Licencia> query =
				em.createQuery("SELECT l FROM Licencia l WHERE l.nroLicencia = :nro",
						Licencia.class);
		query.setParameter("nro", nro);
		
		if(query.getResultList().size() == 1)
			licencia = query.getSingleResult();
		
		return licencia;
	}
	
	// crea una licencia en la tabla licencias
	public static void create(Licencia licencia) {
		EntityManager em = EntityManagerManager.getEM();
		EntityTransaction tx = em.getTransaction();
		
		
		//try {
			tx.begin();
			em.persist(licencia);
			tx.commit();
		//} catch(Exception e) {
		//	tx.rollback();
		//}
		
	}
}