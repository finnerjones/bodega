package com.finnerjones.bodega.core.struts.actions;

import com.finnerjones.bodega.core.struts.dto.ProductDto;
import com.finnerjones.bodega.services.BodegaService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProductAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private BodegaService bodegaService;
	private ProductDto product;

	@Override
	public String execute() throws Exception {
		getBodegaService().deleteProduct(product.getId());
		return "success";
	}

	public void setBodegaService(BodegaService bodegaService) {
		this.bodegaService = bodegaService;
	}

	public BodegaService getBodegaService() {
		return bodegaService;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public ProductDto getProduct() {
		return product;
	}

}
