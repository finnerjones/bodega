package com.finnerjones.bodega.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_TYPE")
@NamedQueries({
		@NamedQuery(name = "findAllProductTypes", query = "select pt from ProductType pt"),
		@NamedQuery(name = "findProductTypeByProductTypeCode", query = "select pt from ProductType pt where pt.productTypeCode = :productTypeCode") })
public class ProductType implements BodegaEntity {

	protected Long id;
	protected String productTypeCode;
	protected String productTypeDescription;

	@Id
	@Column(name = "PRODUCT_TYPE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PRODUCT_TYPE_CODE")
	public String getProductTypeCode() {
		return productTypeCode;
	}

	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}

	@Column(name = "PRODUCT_TYPE_DESCRIPTION")
	public String getProductTypeDescription() {
		return productTypeDescription;
	}

	public void setProductTypeDescription(String productTypeDescription) {
		this.productTypeDescription = productTypeDescription;
	}

}
