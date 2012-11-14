package ar.edu.utn.frsf.licenciator.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerManager {
	static EntityManagerFactory emf;
	static EntityManager em;
	
	private EntityManagerManager() { super(); }

	public static EntityManager getEM() {
		if(emf==null) {
			emf= Persistence.createEntityManagerFactory("licenciator");
			em = emf.createEntityManager();
		}
		
		return em;
	}
	
	public static void closeEntityManager() {
		em.flush();
		em.close();
		emf.close();
		em=null;
		emf=null;
	}
}
