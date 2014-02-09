package com.finnerjones.bodega.persistence;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.finnerjones.bodega.core.exceptions.BodegaDatabaseException;
import com.finnerjones.bodega.persistence.entities.ProductType;
import com.finnerjones.bodega.persistence.helper.PersistenceHelper;
import com.finnerjones.bodega.persistence.jpa.BodegaJpaPersistence;
import com.finnerjones.bodega.persistence.jpa.ejb.BodegaJpaPersistenceEjb;

public class TestBodegaManagerBean {

	private EntityManager entityManager;
	private BodegaJpaPersistence bodegaManager;

	@Before
	public void init() {
		entityManager = PersistenceHelper.getEntityManagerForBodegaTest();
		bodegaManager = new BodegaJpaPersistenceEjb();
		bodegaManager.setEntityManager(entityManager);
	}

	@Test
	public void testFindProductTypeById() {
		try {
			ProductType productType = (ProductType) bodegaManager.find(ProductType.class, 1L);
			Assert.assertNotNull(productType);
			Assert.assertEquals("Red Wine", productType.getProductTypeDescription());
			Assert.assertEquals("red_wine", productType.getProductTypeCode());
		} catch (BodegaDatabaseException bdbe) {
			Assert.fail();

		}

	}

	@Test
	public void testInsertProductType() {
		ProductType productType = new ProductType();
		productType.setProductTypeCode("test");
		productType.setProductTypeDescription("test desc");
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
