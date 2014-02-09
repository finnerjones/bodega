package com.finnerjones.bodega.persistence.jpa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.finnerjones.bodega.core.exceptions.BodegaDatabaseException;
import com.finnerjones.bodega.persistence.entities.Product;
import com.finnerjones.bodega.persistence.jpa.ProductJpaPersistence;

@Stateless
public class ProductJpaPersistenceEjb extends BodegaJpaPersistenceEjb implements ProductJpaPersistence {

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		Query query = getEntityManager().createNamedQuery("findAllProducts");
		List<Product> products = query.getResultList();
		return products;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByName(String productName) {
		Query query = getEntityManager().createNamedQuery("findProductsByName");
		query.setParameter("productName", productName);
		List<Product> products = query.getResultList();
		return products;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByProductTypeCode(String productTypeCode) {
		Query query = getEntityManager().createNamedQuery("findProductsByProductTypeCode");
		query.setParameter("productTypeCode", productTypeCode);

		List<Product> products = query.getResultList();
		return products;
	}

	@Override
	public void delete(Object entity) throws BodegaDatabaseException {
		Object entityToDelete = getEntityManager().merge(entity);
		super.delete(entityToDelete);
	}
}
