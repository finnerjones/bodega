package com.finnerjones.bodega.persistence;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.finnerjones.bodega.persistence.entities.ProductType;
import com.finnerjones.bodega.persistence.jpa.ProductTypeJpaPersistence;
import com.finnerjones.bodega.persistence.jpa.ejb.ProductTypeJpaPersistenceEjb;

public class TestProductTypeManagerBean extends TestBodegaManagerBean {

	ProductTypeJpaPersistence productTypeManager;

	@Before
	public void init() {
		super.init();
		productTypeManager = new ProductTypeJpaPersistenceEjb();
		productTypeManager.setEntityManager(getEntityManager());
	}

	@Test
	public void testFindAllProductTypes() {
		List<ProductType> productTypes = productTypeManager.findAllProductTypes();
		// Asserts
		Assert.assertNotNull(productTypes);
		Assert.assertFalse(productTypes.isEmpty());
		Assert.assertTrue(productTypes.size() > 0);
		ProductType productType = (ProductType) productTypes.get(0);
		Assert.assertEquals(productType.getId().longValue(), 1L);
		Assert.assertTrue("red_wine".equals(productType.getProductTypeCode()));
		Assert.assertTrue("Red Wine".equals(productType.getProductTypeDescription()));
	}

	@Test
	public void testFindProductTypeByProductTypeCode() {
		List<ProductType> productTypes = productTypeManager.findProductTypeByProductTypeCode("red_wine");
		// Asserts
		Assert.assertNotNull(productTypes);
		Assert.assertFalse(productTypes.isEmpty());
		ProductType productType = (ProductType) productTypes.get(0);
		Assert.assertNotNull(productType.getId());
		Assert.assertNotNull(productType.getProductTypeCode());
		Assert.assertNotNull(productType.getProductTypeDescription());
	}

}
