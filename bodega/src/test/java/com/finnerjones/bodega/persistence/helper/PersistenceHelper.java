package com.finnerjones.bodega.persistence.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceHelper {

	public static EntityManager getEntityManagerForBodegaTest() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BODEGA-TEST");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

}
