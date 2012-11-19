package ar.edu.utn.frsf.licenciator.dao;
import java.util.List;
import javax.persistence.*;
import ar.edu.utn.frsf.licenciator.entidades.*;
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
		
		return licencia;
	}
	
	// crea una licencia en la tabla licencias
	public static void create(Licencia licencia) {
		EntityManager em = EntityManagerManager.getEM();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			em.persist(licencia);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		
	}
	
	/*Trae todas las licencias asociadas a un Titular*/
	public static List<Licencia> read(Titular titular) 
	{
		EntityManager em = EntityManagerManager.getEM();
		
		TypedQuery<Licencia> query =
				em.createQuery("SELECT l FROM Licencia l WHERE l.Titular = :titular",
						Licencia.class);
		query.setParameter("titular", titular);
		
		return query.getResultList();
	}
}