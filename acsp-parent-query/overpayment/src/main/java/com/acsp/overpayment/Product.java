package com.acsp.overpayment;

import java.math.BigDecimal;

public class Product {
	
	private String productDesc;
	private String productBrand;
	private String nameAndType;
	private String modelNo;
	private BigDecimal price;
	private String agreementCd;
	
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getNameAndType() {
		return nameAndType;
	}
	public void setNameAndType(String nameAndType) {
		this.nameAndType = nameAndType;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getAgreementCd() {
		return agreementCd;
	}
	public void setAgreementCd(String agreementCd) {
		this.agreementCd = agreementCd;
	}
	
}

