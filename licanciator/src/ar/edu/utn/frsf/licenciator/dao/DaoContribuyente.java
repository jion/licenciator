package ar.edu.utn.frsf.licenciator.dao;

import ar.edu.utn.frsf.licenciator.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DaoContribuyente {
	
	public static Contribuyente read( TipoDoc tipoD, long nroD ) {
		EntityManager em = EntityManagerManager.getEM();
		
		Contribuyente contribuyente = null;
		
		TypedQuery<Contribuyente> query = em.createQuery( "SELECT t FROM Contribuyente t WHERE t.tipoDoc = :tipoD AND t.nroDoc = :nroD", Contribuyente.class );
		query.setParameter( "tipoD", tipoD );
		query.setParameter( "nroD", nroD );

		if( query.getResultList().size() == 1 )
			contribuyente = query.getSingleResult();
		
		return contribuyente;
	}
	
	public static boolean create( Contribuyente contribuyente ) {
		EntityManager em = EntityManagerManager.getEM();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
			em.persist( contribuyente );
			tx.commit();
			
			return true;
		} catch( Exception e ) {
			tx.rollback();
		}
		
		return false;
	}
	
	public static Contribuyente update( Contribuyente contribuyente ) {
		EntityManager em = EntityManagerManager.getEM();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
			em.merge( contribuyente );
			tx.commit();
		} catch( Exception e ) {
			tx.rollback();
		}
		
		return read( contribuyente.getTipoDoc(), contribuyente.getNroDoc() );
	}
	
	public static void delete( Contribuyente contribuyente ) {
		EntityManager em = EntityManagerManager.getEM();
		
		EntityTransaction tx = em.getTransaction();
		
		contribuyente = em.find( Contribuyente.class, contribuyente.getId() );
		
		tx.begin();
		
		em.remove( contribuyente );
		
		tx.commit();
	}
}
