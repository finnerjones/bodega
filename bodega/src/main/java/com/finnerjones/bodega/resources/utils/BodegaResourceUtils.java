package com.finnerjones.bodega.resources.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.finnerjones.bodega.persistence.jpa.ProductJpaPersistence;
import com.finnerjones.bodega.persistence.jpa.ProductTypeJpaPersistence;
import com.finnerjones.bodega.persistence.jpa.YearsJpaPersistence;

public class BodegaResourceUtils {

	public static Context ctx;

	/**
	 * 
	 * @param resourceName
	 * @return a context resource (eg. an EJB).
	 *         <p/>
	 *         Example resourceName = <code>ProductJpaPersistenceEjb/local</code> for <code>ProductJpaPersistenceEjb</code>
	 */
	public static Object getResource(String resourceName) {
		Object resource = null;
		try {
			if (ctx == null) {
				ctx = new InitialContext();
			}
			resource = ctx.lookup(resourceName);
			return resource;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ProductJpaPersistence getProductManager() {
		return (ProductJpaPersistence) getResource("ProductJpaPersistenceEjb/local");
	}

	public static ProductTypeJpaPersistence getProductTypeManager() {
		return (ProductTypeJpaPersistence) getResource("ProductTypeJpaPersistenceEjb/local");
	}

	public static YearsJpaPersistence getYearsManager() {
		return (YearsJpaPersistence) getResource("YearsJpaPersistenceEjb/local");
	}

}
