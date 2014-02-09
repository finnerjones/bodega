package com.finnerjones.bodega.persistence.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@NamedQueries({
		@NamedQuery(name = "findAllProducts", query = "select p from Product p"),
		@NamedQuery(name = "findProductsByName", query = "select p from Product p where p.productName = :productName"),
		@NamedQuery(name = "findProductsByProductTypeCode", query = "select p from Product p where p.productType.productTypeCode = :productTypeCode") })
public class Product implements BodegaEntity {

	protected Long id;
	protected ProductType productType;
	protected String productName;
	protected String productCountry;
	protected String productDescription;
	protected Year productYear;
	protected String productGrape;
	protected Double productPrice;
	protected String productCeller;
	protected String productVender;
	protected Double productAlcohol;
	protected Timestamp productDatePurchased;
	protected Timestamp productDateOpened;
	protected Timestamp productDateInserted;
	protected Timestamp productDateLastModified;
	private String productComments;

	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// TODO: Should this be ManyToOne ? http://www.zabada.com/tutorials/hibernate-and-jpa-with-spring-example
	@ManyToOne
	@JoinColumn(name = "PRODUCT_TYPE", referencedColumnName = "PRODUCT_TYPE_ID", updatable = true)
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Column(name = "PRODUCT_NAME")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "PRODUCT_COUNTRY")
	public String getProductCountry() {
		return productCountry;
	}

	public void setProductCountry(String productCountry) {
		this.productCountry = productCountry;
	}

	@Column(name = "PRODUCT_DESCRIPTION")
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@ManyToOne
	@JoinColumn(name = "PRODUCT_YEAR", referencedColumnName = "YEARS_ID", updatable = true)
	public Year getProductYear() {
		return productYear;
	}

	public void setProductYear(Year year) {
		this.productYear = year;
	}

	@Column(name = "PRODUCT_GRAPES")
	public String getProductGrape() {
		return productGrape;
	}

	public void setProductGrape(String productGrape) {
		this.productGrape = productGrape;
	}

	@Column(name = "PRODUCT_PRICE")
	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "PRODUCT_CELLER")
	public String getProductCeller() {
		return productCeller;
	}

	public void setProductCeller(String productCeller) {
		this.productCeller = productCeller;
	}

	@Column(name = "PRODUCT_VENDER")
	public String getProductVender() {
		return productVender;
	}

	public void setProductVender(String productVender) {
		this.productVender = productVender;
	}

	@Column(name = "PRODUCT_ALCOHOL")
	public Double getProductAlcohol() {
		return productAlcohol;
	}

	public void setProductAlcohol(Double productAlcohol) {
		this.productAlcohol = productAlcohol;
	}

	@Column(name = "PRODUCT_DATE_PURCHASED")
	public Timestamp getProductDatePurchased() {
		return productDatePurchased;
	}

	public void setProductDatePurchased(Timestamp productDatePurchased) {
		this.productDatePurchased = productDatePurchased;
	}

	@Column(name = "PRODUCT_DATE_OPENED")
	public Timestamp getProductDateOpened() {
		return productDateOpened;
	}

	public void setProductDateOpened(Timestamp productDateOpened) {
		this.productDateOpened = productDateOpened;
	}

	public void setProductComments(String productComments) {
		this.productComments = productComments;
	}

	@Column(name = "PRODUCT_COMMENTS")
	public String getProductComments() {
		return productComments;
	}

	@Column(name = "PRODUCT_DATE_INSERTED")
	public Timestamp getProductDateInserted() {
		return productDateInserted;
	}

	public void setProductDateInserted(Timestamp productDateInserted) {
		this.productDateInserted = productDateInserted;
	}

	@Column(name = "PRODUCT_DATE_LAST_MODIFIED")
	public Timestamp getProductDateLastModified() {
		return productDateLastModified;
	}

	public void setProductDateLastModified(Timestamp productDateLastModified) {
		this.productDateLastModified = productDateLastModified;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productType=" + productType + ", productName=" + productName + ", productCountry=" + productCountry
				+ ", productDescription=" + productDescription + ", productYear=" + productYear + ", productGrape=" + productGrape
				+ ", productPrice=" + productPrice + ", productCeller=" + productCeller + ", productVender=" + productVender
				+ ", productAlcohol=" + productAlcohol + ", productDatePurchased=" + productDatePurchased + ", productDateOpened="
				+ productDateOpened + ", productDateInserted=" + productDateInserted + ", productDateLastModified="
				+ productDateLastModified + ", productComments=" + productComments + "]";
	}

}
