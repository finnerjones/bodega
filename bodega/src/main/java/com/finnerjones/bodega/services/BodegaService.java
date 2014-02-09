package com.finnerjones.bodega.services;

import java.util.List;

import com.finnerjones.bodega.core.struts.dto.ProductDto;
import com.finnerjones.bodega.persistence.entities.Product;

public interface BodegaService {

	public void saveProduct(ProductDto productDto);

	public ProductDto viewProduct(Long id);

	public void deleteProduct(Long id);

	public List<ProductDto> listAllProducts(List<Product> products);
}
