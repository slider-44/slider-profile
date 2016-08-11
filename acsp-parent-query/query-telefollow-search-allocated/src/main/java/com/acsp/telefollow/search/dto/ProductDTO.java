package com.acsp.telefollow.search.dto;

public class ProductDTO {

	private String sysappcd;
	
	private String productno;
	
	private String nametype;
	
	private String modelno;
	
	private String financePrice;
	
	private String interest;
	
	private String fullPrice;

	public String getFinancePrice() {
		return financePrice;
	}

	public void setFinancePrice(String financePrice) {
		this.financePrice = financePrice;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(String fullPrice) {
		this.fullPrice = fullPrice;
	}

	
	public String getSysAppCd() {
		return sysappcd;
	}

	public void setSysAppCd(String sysappcd) {
		this.sysappcd = sysappcd;
	}

	public String getProductNo() {
		return productno;
	}

	public void setProductNo(String productno) {
		this.productno = productno;
	}

	public String getNameType() {
		return nametype;
	}

	public void setNameType(String nametype) {
		this.nametype = nametype;
	}

	public String getModelNo() {
		return modelno;
	}

	public void setModelNo(String modelno) {
		this.modelno = modelno;
	}
	
	
}
