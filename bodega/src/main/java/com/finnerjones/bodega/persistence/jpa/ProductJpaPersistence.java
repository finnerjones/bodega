package com.finnerjones.bodega.persistence.jpa;

import java.util.List;

import javax.ejb.Local;

import com.finnerjones.bodega.persistence.entities.Product;

@Local
public interface ProductJpaPersistence extends BodegaJpaPersistence {

	public List<Product> findAllProducts();

	public List<Product> findProductsByName(String productName);

	public List<Product> findProductsByProductTypeCode(String productTypeCode);

}
