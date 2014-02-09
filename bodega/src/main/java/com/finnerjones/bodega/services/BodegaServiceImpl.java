package com.finnerjones.bodega.services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.finnerjones.bodega.core.exceptions.BodegaDatabaseException;
import com.finnerjones.bodega.core.struts.dto.ProductDto;
import com.finnerjones.bodega.persistence.entities.Product;
import com.finnerjones.bodega.persistence.entities.ProductType;
import com.finnerjones.bodega.persistence.entities.Year;
import com.finnerjones.bodega.persistence.jpa.ProductJpaPersistence;
import com.finnerjones.bodega.persistence.jpa.ProductTypeJpaPersistence;
import com.finnerjones.bodega.persistence.jpa.YearsJpaPersistence;
import com.finnerjones.bodega.resources.utils.BodegaResourceUtils;

public class BodegaServiceImpl implements BodegaService {

	private ProductJpaPersistence productManager;
	private ProductTypeJpaPersistence productTypeManager;

	@Override
	public void saveProduct(ProductDto productFromView) {
		productTypeManager = BodegaResourceUtils.getProductTypeManager();
		productManager = BodegaResourceUtils.getProductManager();
		YearsJpaPersistence yearsJpaEjb = BodegaResourceUtils.getYearsManager();
		Product existingProduct = null;

		try {
			if (productFromView.getId() != null) {
				existingProduct = (Product) productManager.find(Product.class, productFromView.getId());
				existingProduct.setProductName(productFromView.getProductName());
				existingProduct.setProductDescription(productFromView.getProductDescription());
				Long productTypeId = new Long(productFromView.getProductType());
				ProductType productType = (ProductType) productTypeManager.find(ProductType.class, productTypeId);
				existingProduct.setProductType(productType);
				existingProduct.setProductCeller(productFromView.getProductCeller());
				existingProduct.setProductVender(productFromView.getProductVender());
				Long yearId = new Long(productFromView.getProductYear());
				Year year = (Year) yearsJpaEjb.find(Year.class, yearId);
				existingProduct.setProductYear(year);
				if (productFromView.getProductAlcohol() != null) {
					try {
						existingProduct.setProductAlcohol(new Double(productFromView.getProductAlcohol()));
					} catch (NumberFormatException nfe) {
						existingProduct.setProductAlcohol(new Double(0));
					}
				}

				if (productFromView.getProductPrice() != null) {
					try {
						existingProduct.setProductPrice(new Double(productFromView.getProductPrice()));
					} catch (NumberFormatException nfe) {
						existingProduct.setProductPrice(new Double(0));
					}
				}
				existingProduct.setProductCountry(productFromView.getProductCountry());
				existingProduct.setProductGrape(productFromView.getProductGrape());
				existingProduct.setProductComments(productFromView.getProductComments());
				existingProduct.setProductDatePurchased(createDateFromView(productFromView.getProductDatePurchased()));
				existingProduct.setProductDateOpened(createDateFromView(productFromView.getProductDateOpened()));
				existingProduct.setProductDateLastModified(getCurrentTimestamp());
				productManager.update(existingProduct);
			} else {

				Long productTypeId = new Long(productFromView.getProductType());
				ProductType productType = (ProductType) productTypeManager.find(ProductType.class, productTypeId);
				Product productToPersist = new Product();
				productToPersist.setProductName(productFromView.getProductName());
				productToPersist.setProductDescription(productFromView.getProductDescription());
				productToPersist.setProductType(productType);
				productToPersist.setProductCeller(productFromView.getProductCeller());
				productToPersist.setProductVender(productFromView.getProductVender());
				Long yearId = new Long(productFromView.getProductYear());
				Year year = (Year) yearsJpaEjb.find(Year.class, yearId);
				productToPersist.setProductYear(year);
				if (productFromView.getProductAlcohol() != null) {
					try {
						productToPersist.setProductAlcohol(new Double(productFromView.getProductAlcohol()));
					} catch (NumberFormatException nfe) {
						productToPersist.setProductAlcohol(new Double(0));
					}
				}

				if (productFromView.getProductPrice() != null) {
					try {
						productToPersist.setProductPrice(new Double(productFromView.getProductPrice()));
					} catch (NumberFormatException nfe) {
						productToPersist.setProductPrice(new Double(0));
					}
				}

				productToPersist.setProductCountry(productFromView.getProductCountry());
				productToPersist.setProductGrape(productFromView.getProductGrape());
				productToPersist.setProductDatePurchased(createDateFromView(productFromView.getProductDatePurchased()));
				productToPersist.setProductDateOpened(createDateFromView(productFromView.getProductDateOpened()));
				productToPersist.setProductDateInserted(getCurrentTimestamp());
				productToPersist.setProductDateLastModified(getCurrentTimestamp());
				productManager.update(productToPersist);
			}
		} catch (BodegaDatabaseException e) {
			e.printStackTrace();
		}

	}

	private Timestamp createDateFromView(String date) {
		if (date != null && !date.equals("")) {
			String[] dateSplit = date.split("\\.");
			int day = new Integer(dateSplit[0]).intValue();
			int month = new Integer(dateSplit[1]).intValue() - 1;
			int year = new Integer(dateSplit[2]).intValue();
			GregorianCalendar gregCal = new GregorianCalendar(year, month, day);
			Long milis = gregCal.getTimeInMillis();
			return new Timestamp(milis);
		}
		return null;
	}

	@Override
	public ProductDto viewProduct(Long id) {
		try {
			productManager = BodegaResourceUtils.getProductManager();
			Product product = (Product) productManager.find(Product.class, id);
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			if (product.getProductAlcohol() != null) {
				productDto.setProductAlcohol(product.getProductAlcohol().toString());
			}
			productDto.setProductCeller(product.getProductCeller());
			productDto.setProductComments(product.getProductComments());
			productDto.setProductCountry(product.getProductCountry());
			if (product.getProductDateOpened() != null) {
				Date dateOpenedTime = product.getProductDateOpened();
				String dateOpenedStr = new SimpleDateFormat("dd.MM.yyyy").format(dateOpenedTime);
				productDto.setProductDateOpened(dateOpenedStr);
			}
			if (product.getProductDatePurchased() != null) {
				Date datePurchasedTime = product.getProductDatePurchased();
				String datePurchasedStr = new SimpleDateFormat("dd.MM.yyyy").format(datePurchasedTime);
				productDto.setProductDatePurchased(datePurchasedStr);
			}
			productDto.setProductDescription(product.getProductDescription());
			productDto.setProductGrape(product.getProductGrape());
			productDto.setProductName(product.getProductName());
			if (product.getProductPrice() != null) {
				productDto.setProductPrice(product.getProductPrice().toString());
			}
			if (product.getProductType() != null) {
				productDto.setProductType(product.getProductType().getId().toString());
			}
			productDto.setProductVender(product.getProductVender());
			if (product.getProductYear() != null) {
				productDto.setProductYear(product.getProductYear().getId().toString());
			}
			return productDto;
		} catch (BodegaDatabaseException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void deleteProduct(Long id) {
		try {
			productManager = BodegaResourceUtils.getProductManager();
			Product product = (Product) productManager.find(Product.class, id);
			productManager.delete(product);
		} catch (BodegaDatabaseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductDto> listAllProducts(List<Product> products) {
		List<ProductDto> dtoProducts = new ArrayList<ProductDto>();
		for (Product product : products) {
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			if (product.getProductYear() != null) {
				if (product.getProductYear() != null) {
					String year = product.getProductYear().getYear().toString();
					productDto.setProductYear(year);
				}
			}
			productDto.setProductDescription(product.getProductDescription());
			productDto.setProductGrape(product.getProductGrape());
			productDto.setProductType(product.getProductType().getProductTypeDescription());
			if (product.getProductAlcohol() != null) {
				productDto.setProductAlcohol(product.getProductAlcohol().toString());
			}
			if (product.getProductPrice() != null) {
				productDto.setProductPrice(product.getProductPrice().toString());
			}
			productDto.setProductCeller(product.getProductCeller());
			productDto.setProductComments(product.getProductComments());
			productDto.setProductCountry(product.getProductCountry());
			if (product.getProductDateOpened() != null) {
				String dateOpened = new SimpleDateFormat("dd.MMM.yyyy").format(product.getProductDateOpened());
				productDto.setProductDateOpened(dateOpened);
			}
			if (product.getProductDatePurchased() != null) {
				String datePurchased = new SimpleDateFormat("dd.MMM.yyyy").format(product.getProductDatePurchased());
				productDto.setProductDatePurchased(datePurchased);
			}
			productDto.setProductName(product.getProductName());
			productDto.setProductVender(product.getProductVender());
			dtoProducts.add(productDto);
		}
		return dtoProducts;
	}

	private Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}
