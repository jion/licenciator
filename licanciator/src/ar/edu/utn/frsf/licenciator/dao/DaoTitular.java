package ar.edu.utn.frsf.licenciator.dao;

import ar.edu.utn.frsf.licenciator.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DaoTitular {
	
	public static Titular read( TipoDoc tipoD, long nroD ) {
		EntityManager em = EntityManagerManager.getEM();
		
		Titular titular = null;
		
		TypedQuery<Titular> query = em.createQuery( "SELECT t FROM Titular t WHERE t.tipoDoc = :tipoD AND t.nroDoc = :nroD", Titular.class );
		query.setParameter( "tipoD", tipoD );
		query.setParameter( "nroD", nroD );

		if( query.getResultList().size() == 1 )
			titular = query.getSingleResult();
		
		return titular;
	}
	
	public static boolean create( Titular titular ) {
		EntityManager em = EntityManagerManager.getEM();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
			em.persist( titular );
			tx.commit();
			
			return true;
		} catch( Exception e ) {
			tx.rollback();
		}
		
		return false;
	}
	
	public static Titular update( Titular titular ) {
		EntityManager em = EntityManagerManager.getEM();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
			em.merge(titular);
			tx.commit();
		} catch( Exception e ) {
			tx.rollback();
		}
		
		return read( titular.getTipoDoc(), titular.getNroDoc() );
	}
	
	public static void delete( Titular titular ) {
		EntityManager em = EntityManagerManager.getEM();
		
		EntityTransaction tx = em.getTransaction();
		
		titular = em.find( Titular.class, titular.getId() );
		
		tx.begin();
		
		em.remove( titular );
		
		tx.commit();
	}
}