package ar.edu.utn.frsf.licenciator.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ar.edu.utn.frsf.licenciator.entidades.Auditoria;

public class DaoAuditoria {
	
	private DaoAuditoria() {
		super();
	}
	
	public static void create(Auditoria auditoria) {
		EntityManager em = EntityManagerManager.getEM();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(auditoria);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		
	}
}
