package com.finnerjones.bodega.persistence.jpa.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.finnerjones.bodega.core.exceptions.BodegaDatabaseException;
import com.finnerjones.bodega.persistence.jpa.BodegaJpaPersistence;

@Stateless
public class BodegaJpaPersistenceEjb implements BodegaJpaPersistence {

	@PersistenceContext(unitName = "Bodega")
	EntityManager entityManager;

	public BodegaJpaPersistenceEjb() {

	}

	@Override
	public void insert(Object entity) throws BodegaDatabaseException {
		entityManager.persist(entity);
	}

	@Override
	public Object update(Object entity) throws BodegaDatabaseException {
		return entityManager.merge(entity);
	}

	@Override
	public Object find(Class<?> entityClass, Object primaryKey) throws BodegaDatabaseException {
		Object entity = entityManager.find(entityClass, primaryKey);
		return entity;
	}

	@Override
	public void delete(Object entity) throws BodegaDatabaseException {
		entityManager.remove(entity);

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
