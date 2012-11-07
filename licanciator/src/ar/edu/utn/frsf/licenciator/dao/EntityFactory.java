package ar.edu.utn.frsf.licenciator.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {
	static EntityManagerFactory emf;
	
	private EntityFactory() { super(); }

	public static EntityManagerFactory getEMFactory() {
		if(emf==null) {
			emf= Persistence.createEntityManagerFactory("licenciator");
		}
		
		return emf;
	}
}
