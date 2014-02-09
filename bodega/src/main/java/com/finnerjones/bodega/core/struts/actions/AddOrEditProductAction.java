package com.finnerjones.bodega.core.struts.actions;

import java.util.List;

import com.finnerjones.bodega.core.struts.dto.ProductDto;
import com.finnerjones.bodega.persistence.entities.ProductType;
import com.finnerjones.bodega.persistence.entities.Year;
import com.finnerjones.bodega.resources.utils.BodegaResourceUtils;
import com.finnerjones.bodega.services.BodegaService;
import com.opensymphony.xwork2.ActionSupport;

public class AddOrEditProductAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ProductDto product;
	private List<ProductType> productTypes;
	private List<Year> years;
	private BodegaService bodegaService;

	@Override
	public String execute() throws Exception {
		if ((product == null) || (product.getId() == null) || (product.getId().equals(""))) {
			return "success";
		}

		setProduct(getBodegaService().viewProduct(product.getId()));
		return "success";
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public List<ProductType> getProductTypes() {
		if (productTypes == null) {
			productTypes = BodegaResourceUtils.getProductTypeManager().findAllProductTypes();
		}
		return productTypes;
	}

	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public void setYears(List<Year> years) {
		this.years = years;
	}

	public List<Year> getYears() {
		if (years == null) {
			years = BodegaResourceUtils.getYearsManager().findAllYears();
		}
		return years;

	}

	public void setBodegaService(BodegaService bodegaService) {
		this.bodegaService = bodegaService;
	}

	public BodegaService getBodegaService() {
		return bodegaService;
	}

}
