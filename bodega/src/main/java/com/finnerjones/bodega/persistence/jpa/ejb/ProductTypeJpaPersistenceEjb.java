package com.finnerjones.bodega.persistence.jpa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.finnerjones.bodega.persistence.entities.ProductType;
import com.finnerjones.bodega.persistence.jpa.ProductTypeJpaPersistence;

@Stateless
public class ProductTypeJpaPersistenceEjb extends BodegaJpaPersistenceEjb implements ProductTypeJpaPersistence {

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductType> findAllProductTypes() {
		Query query = getEntityManager().createNamedQuery("findAllProductTypes");
		List<ProductType> productTypes = query.getResultList();
		return productTypes;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductType> findProductTypeByProductTypeCode(String productTypeCode) {
		Query query = getEntityManager().createNamedQuery("findProductTypeByProductTypeCode");
		query.setParameter("productTypeCode", productTypeCode);
		List<ProductType> productTypes = query.getResultList();
		return productTypes;
	}

}
