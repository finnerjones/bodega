package com.finnerjones.bodega.core.struts.actions;

import java.util.List;

import com.finnerjones.bodega.core.struts.dto.ProductDto;
import com.finnerjones.bodega.persistence.entities.Product;
import com.finnerjones.bodega.persistence.jpa.ProductJpaPersistence;
import com.finnerjones.bodega.resources.utils.BodegaResourceUtils;
import com.finnerjones.bodega.services.BodegaService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Extending <code>ActionSupport</code> gives us a way to do validation, i18n. <br/>
 * Can also implement ModelDriven ( getModel() ) to obtain the model object
 * 
 * @author finnerjones
 * 
 */
public class AllProductsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<ProductDto> products;
	private BodegaService bodegaService;

	public String execute() {
		ProductJpaPersistence productManager = (ProductJpaPersistence) BodegaResourceUtils.getProductManager();
		List<Product> prods = productManager.findAllProducts();
		products = bodegaService.listAllProducts(prods);
		return "success";
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProduct(List<ProductDto> products) {
		this.products = products;
	}

	public BodegaService getBodegaService() {
		return bodegaService;
	}

	public void setBodegaService(BodegaService bodegaService) {
		this.bodegaService = bodegaService;
	}

}
