package com.finnerjones.bodega.persistence;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.finnerjones.bodega.persistence.entities.Year;
import com.finnerjones.bodega.persistence.jpa.YearsJpaPersistence;
import com.finnerjones.bodega.persistence.jpa.ejb.YearsJpaPersistenceEjb;

public class TestYearsManagerBean extends TestBodegaManagerBean {

	YearsJpaPersistence yearsManager;

	@Before
	public void init() {
		super.init();
		yearsManager = new YearsJpaPersistenceEjb();
		yearsManager.setEntityManager(getEntityManager());
	}

	@Test
	public void testFindAllYears() {
		List<Year> years = yearsManager.findAllYears();
		// Asserts
		Assert.assertNotNull(years);
		Assert.assertFalse(years.isEmpty());
		Assert.assertTrue(years.size() >= 17);
	}

}
