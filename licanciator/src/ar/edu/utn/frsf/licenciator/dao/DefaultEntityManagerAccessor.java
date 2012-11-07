package ar.edu.utn.frsf.licenciator.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DefaultEntityManagerAccessor {
    private static final ThreadLocal<EntityManager> LOCAL = new ThreadLocal<EntityManager>();
    private EntityManagerFactory entityManagerFactory;

    public DefaultEntityManagerAccessor(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        EntityManager entityManager = LOCAL.get();
        if (entityManager == null) {
            entityManager = entityManagerFactory.createEntityManager();
            LOCAL.set(entityManager);
        }
        return entityManager;
    }

    public void clear() {
        LOCAL.remove();
    }
}