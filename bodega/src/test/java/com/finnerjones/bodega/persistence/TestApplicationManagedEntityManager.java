package com.finnerjones.bodega.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.finnerjones.bodega.persistence.entities.Product;
import com.finnerjones.bodega.persistence.entities.ProductType;
import com.finnerjones.bodega.persistence.entities.Year;

/**
 * Application managed entity manager to carry out basic tests
 * 
 * @author finnerjones
 * 
 */

// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = { "classpath:spring/spring-bodega-beans-test.xml" })
public class TestApplicationManagedEntityManager {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	@Before
	public void createBodegaDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BODEGA-TEST");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Test
	public void testReadProductType() {
		ProductType productType = null;
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			productType = entityManager.find(ProductType.class, 1L);
			entityTransaction.commit();
		} catch (Exception bdbex) {
			Assert.fail();
		} finally {
			entityManager.close();
		}
		// Assert
		Assert.assertNotNull(productType);
		Assert.assertEquals("Red Wine", productType.getProductTypeDescription());
	}

	@Test
	public void testUpdateProduct() {
		Product product = null;
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			product = (Product) entityManager.find(Product.class, 1L);
			product.setProductDescription("Red wine from Priorat");
			entityTransaction.commit();
		} catch (Exception bdbex) {
			Assert.fail();
		} finally {
			entityManager.close();
		}

		// Assert
		Assert.assertNotNull(product);
		Assert.assertEquals("Red wine from Priorat", product.getProductDescription());
	}

	@Test
	public void testReadProductTypeAndInsertProduct() {
		Product product = new Product();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			ProductType productType = entityManager.find(ProductType.class, 1L);
			product.setProductCountry("Spain");
			product.setProductDescription("Wine from Catalunya");
			product.setProductType(productType);
			product.setProductName("Tamaron");
			Year year = entityManager.find(Year.class, 2000L);
			product.setProductYear(year);
			entityManager.persist(product);
			entityTransaction.commit();
		} catch (Exception bdbex) {
			Assert.fail();
		} finally {
			entityManager.close();
		}

		// Assert
		Assert.assertNotNull(product);
	}

	@Test
	public void testRemoveProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String sql = "select * from product where product_name = 'Tamaron'";
			Query query = entityManager.createNativeQuery(sql, Product.class);
			products = (List) query.getResultList();
			for (Product product : products) {
				entityManager.remove(product);
			}
			entityTransaction.commit();
		} catch (Exception bdbex) {
			Assert.fail(bdbex.getMessage());
		} finally {
			entityManager.close();
		}

		// Assert
		Assert.assertNotNull(products);
	}

	@Test
	public void testExecuteSQLStatementSingleResultForProductByName() {
		String sqlStatement = "select * from product where product_id = 1";
		Product product = null;
		try {
			;
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createNativeQuery(sqlStatement, Product.class);
			product = (Product) query.getSingleResult();
			entityTransaction.commit();
		} catch (Exception bdbex) {
			Assert.fail();
		} finally {
			entityManager.close();
		}
		// Asserts
		Assert.assertNotNull(product);
		Assert.assertEquals(Long.parseLong("1"), product.getId().longValue());
	}

}
