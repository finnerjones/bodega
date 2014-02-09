package com.finnerjones.bodega.core.struts.dto;

public class ProductDto {

	private Long id;
	private String productType;
	private String productName;
	private String productCountry;
	private String productDescription;
	private String productYear;
	private String productGrape;
	private String productPrice;
	private String productCeller;
	private String productVender;
	private String productAlcohol;
	private String productDatePurchased;
	private String productDateOpened;
	private String productComments;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCountry() {
		return productCountry;
	}

	public void setProductCountry(String productCountry) {
		this.productCountry = productCountry;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductYear() {
		return productYear;
	}

	public void setProductYear(String year) {
		this.productYear = year;
	}

	public String getProductGrape() {
		return productGrape;
	}

	public void setProductGrape(String productGrape) {
		this.productGrape = productGrape;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCeller() {
		return productCeller;
	}

	public void setProductCeller(String productCeller) {
		this.productCeller = productCeller;
	}

	public String getProductVender() {
		return productVender;
	}

	public void setProductVender(String productVender) {
		this.productVender = productVender;
	}

	public String getProductAlcohol() {
		return productAlcohol;
	}

	public void setProductAlcohol(String productAlcohol) {
		this.productAlcohol = productAlcohol;
	}

	public String getProductDateOpened() {
		return productDateOpened;
	}

	public void setProductDateOpened(String productDateOpened) {
		this.productDateOpened = productDateOpened;
	}

	public void setProductComments(String productComments) {
		this.productComments = productComments;
	}

	public String getProductComments() {
		return productComments;
	}

	public void setProductDatePurchased(String productDatePurchased) {
		this.productDatePurchased = productDatePurchased;
	}

	public String getProductDatePurchased() {
		return productDatePurchased;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", productType=" + productType + ", productName=" + productName + ", productCountry="
				+ productCountry + ", productDescription=" + productDescription + ", productYear=" + productYear + ", productGrape="
				+ productGrape + ", productPrice=" + productPrice + ", productCeller=" + productCeller + ", productVender=" + productVender
				+ ", productAlcohol=" + productAlcohol + ", productDatePurchased=" + productDatePurchased + ", productDateOpened="
				+ productDateOpened + ", productComments=" + productComments + "]";
	}

}
