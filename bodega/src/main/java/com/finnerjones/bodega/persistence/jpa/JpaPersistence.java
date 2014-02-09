package com.finnerjones.bodega.persistence.jpa;

import javax.persistence.EntityManager;

public interface JpaPersistence {

	public EntityManager getEntityManager();

	public void setEntityManager(EntityManager entityManager);
}
