package com.finnerjones.bodega.resources.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBodegaResourceUtils {

	BodegaResourceUtils bodegaResourceUtils;

	@Before
	public void init() {
		bodegaResourceUtils = new BodegaResourceUtils();
	}

	@Test
	public void bodegaResourceUtilsIsNotNull() {
		Assert.assertNotNull(bodegaResourceUtils);
	}

}
