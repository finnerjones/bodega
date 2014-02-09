package com.finnerjones.bodega.persistence.jpa;

import java.util.List;

import javax.ejb.Local;

import com.finnerjones.bodega.persistence.entities.ProductType;

@Local
public interface ProductTypeJpaPersistence extends BodegaJpaPersistence {

	public List<ProductType> findAllProductTypes();

	public List<ProductType> findProductTypeByProductTypeCode(String productTypeCode);
}
