package com.finnerjones.bodega.persistence;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityTransaction;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.finnerjones.bodega.core.exceptions.BodegaDatabaseException;
import com.finnerjones.bodega.persistence.entities.Product;
import com.finnerjones.bodega.persistence.entities.ProductType;
import com.finnerjones.bodega.persistence.entities.Year;
import com.finnerjones.bodega.persistence.jpa.ProductJpaPersistence;
import com.finnerjones.bodega.persistence.jpa.ejb.ProductJpaPersistenceEjb;

public class TestProductManagerBean extends TestBodegaManagerBean {

	ProductJpaPersistence productManager;

	@Before
	public void init() {
		super.init();
		productManager = new ProductJpaPersistenceEjb();
		productManager.setEntityManager(getEntityManager());
	}

	@Test
	public void testFindAllProducts() {
		List<Product> products = productManager.findAllProducts();
		// Asserts
		Assert.assertNotNull(products);
		Assert.assertTrue(!products.isEmpty());
		Assert.assertNotNull(products.get(0));
		assertKeyProductFields(products.get(0));
	}

	@Test
	public void testFindProductsByName() {
		List<Product> products = productManager.findProductsByName("Scala Dei");
		// Asserts
		Assert.assertNotNull(products);
		Assert.assertTrue(!products.isEmpty());
		Assert.assertNotNull(products.get(0));
		assertKeyProductFields(products.get(0));

	}

	@Test
	public void findProductsByProductTypeCode() {
		List<Product> products = productManager.findProductsByProductTypeCode("red_wine");
		// Asserts
		Assert.assertNotNull(products);
		Assert.assertNotNull(products.get(0));
		assertKeyProductFields(products.get(0));
		Assert.assertTrue(((Product) products.get(0)).getProductType().getProductTypeCode().equals("red_wine"));
		Iterator<Product> itProd = products.iterator();
		while (itProd.hasNext()) {
			Product prod = itProd.next();
			Assert.assertNotNull(prod.getProductType());
			Assert.assertTrue(prod.getProductType().getProductTypeCode().equals("red_wine"));
		}
	}

	private void assertKeyProductFields(Product product) {
		Assert.assertNotNull(product);
		Assert.assertNotNull(product.getId());
		Assert.assertNotNull(product.getProductType());
		Assert.assertNotNull(product.getProductName());
	}

	@Test
	public void insertAndDeleteProduct() {
		try {
			Product product = new Product();
			product.setProductCountry("Ireland");
			product.setProductDescription("This is a test");
			product.setProductCeller("Finner Bodega SA.");
			product.setProductName("House Wine");
			Year year = (Year) productManager.find(Year.class, 2000L);
			product.setProductYear(year);
			ProductType productType = (ProductType) productManager.find(ProductType.class, 1L);
			product.setProductType(productType);
			product.setProductDatePurchased(createDateFromView("30.12.1971"));
			product.setProductDateInserted(new Timestamp(System.currentTimeMillis()));
			// insert (manual transaction because we are outside the server)
			EntityTransaction tx = productManager.getEntityManager().getTransaction();
			tx.begin();
			productManager.insert(product);
			tx.commit();

			// delete (manual transaction because we are outside the server)
			tx = productManager.getEntityManager().getTransaction();
			tx.begin();
			List<Product> prodListToDelete = productManager.findProductsByName(product.getProductName());
			for (Product prod : prodListToDelete) {
				productManager.delete(prod);
			}
			tx.commit();

		} catch (BodegaDatabaseException e) {
			e.printStackTrace();
		}
	}

	private Timestamp createDateFromView(String date) {
		String[] dateSplit = date.split("\\.");
		int day = new Integer(dateSplit[0]).intValue();
		int month = new Integer(dateSplit[1]).intValue() - 1;
		int year = new Integer(dateSplit[2]).intValue();
		GregorianCalendar gregCal = new GregorianCalendar(year, month, day);
		Long milis = gregCal.getTimeInMillis();
		return new Timestamp(milis);
	}

	@Test
	public void testUpdateProduct() {
		try {
			List<Product> products = (List<Product>) productManager.findProductsByName("Auzelles");
			Product product = products.get(0);
			product.setProductDescription("temp desc");
			EntityTransaction tx = productManager.getEntityManager().getTransaction();
			tx.begin();
			product = (Product) productManager.update(product);
			product.setProductDescription("");
			product.setProductDateLastModified(new Timestamp(System.currentTimeMillis()));
			productManager.update(product);
			tx.commit();
		} catch (BodegaDatabaseException e) {
			e.printStackTrace();
		}

	}
}
