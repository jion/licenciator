package ar.edu.utn.frsf.licenciator.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import ar.edu.utn.frsf.licenciator.entidades.Usuario;

public class DaoUsuarios {
	
	public static Usuario read(String nombre) {
		EntityManager em = EntityFactory.getEMFactory().createEntityManager();
		Usuario usuario=null;
		
		TypedQuery<Usuario> query =
				em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :username",
						Usuario.class);
		query.setParameter("username", nombre);

		if(query.getResultList().size() == 1)
			usuario = query.getSingleResult();
		em.close();
		
		return usuario;
	}
	
	public static Usuario create(Usuario usuario) {
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
	}
	
	public static Usuario update(Usuario usuario) {
		EntityManager em = EntityFactory.getEMFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			em.merge(usuario);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		}
		
		em.close();
		
		return read(usuario.getNombre());
	}

	public static void delete(Usuario usuario) {
		EntityManager em = EntityFactory.getEMFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		usuario = em.find(Usuario.class, usuario.getId());
		tx.begin();
		em.remove(usuario);
		tx.commit();
		
/*		try {
			usuario = em.find(Usuario.class, usuario.getId());
			tx.begin();
			em.remove(usuario);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} */
		
		em.close();
	}
}
