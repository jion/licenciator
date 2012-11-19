package ar.edu.utn.frsf.licenciator.dao;
import ar.edu.utn.frsf.licenciator.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DaoLicencia {
	public static Licencia read(String nro) {
		EntityManager em = EntityManagerManager.getEM();
		Licencia licencia=null;
		
		TypedQuery<Licencia> query =
				em.createQuery("SELECT l FROM Licencia l WHERE l.nroLicencia = :nro",
						Licencia.class);
		query.setParameter("nro", nro);
		
		if(query.getResultList().size() == 1)
			licencia = query.getSingleResult();
		em.close();
		
		return licencia;
	}
	/*modificarla para licencia
	 * public static Usuario create(Usuario usuario) {
		EntityManager em = EntityFactory.getEMFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			em.persist(usuario);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		
		em.close();
		
		return read(usuario.getNombre());
	}*/
	
	/*Trae todas las licencias asociadas a un Titular*/
	public static List<Licencia> read(Titular titular) {
		List<Licencia> licencias = new List();
		EntityManager em = EntityManagerManager.getEM();
		
		TypedQuery<Licencia> query =
				em.createQuery("SELECT l FROM Licencia l WHERE l.Titular = :titular",
						Licencia.class);
		query.setParameter("titular", titular);
		
		if(query.getResultList().size())
			licencias = query.getResultList();
		em.close();
		
		return licencias;
	}
}