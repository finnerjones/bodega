package com.finnerjones.bodega.core.struts.actions;

import java.util.List;

import com.finnerjones.bodega.core.struts.dto.ProductDto;
import com.finnerjones.bodega.persistence.entities.ProductType;
import com.finnerjones.bodega.persistence.entities.Year;
import com.finnerjones.bodega.resources.utils.BodegaResourceUtils;
import com.finnerjones.bodega.services.BodegaService;
import com.opensymphony.xwork2.ActionSupport;

public class SaveProductAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ProductDto product;
	private List<ProductType> productTypes;
	private BodegaService bodegaService;

	@Override
	public String execute() throws Exception {
		getBodegaService().saveProduct(product);
		return "success";
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public List<ProductType> getProductTypes() {
		productTypes = BodegaResourceUtils.getProductTypeManager().findAllProductTypes();
		return productTypes;
	}

	public List<Year> getYears() {
		return BodegaResourceUtils.getYearsManager().findAllYears();
	}

	public void setBodegaService(BodegaService bodegaService) {
		this.bodegaService = bodegaService;
	}

	public BodegaService getBodegaService() {
		return bodegaService;
	}

}
