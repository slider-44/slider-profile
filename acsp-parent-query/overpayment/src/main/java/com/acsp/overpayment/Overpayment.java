package com.acsp.overpayment;

import java.util.Date;

public class Overpayment {
	
	private String agreementCd;
	private String firstName;
	private String middleName;
	private String surName;
	private String status;
	private String storeName;
	private String lastPaymentDate;
	private String storeCd;
	private String recontactDate;
	private String overPayment;
	private String saleDate;
	private String mobileNo;
	
	private String telDistrict;
	private String telNo;
	
	private String productDesciption;
	
	private String paymentCd;
	
	private String remarks;
	
	private String retDate;
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getAgreementCd() {
		return agreementCd;
	}
	public void setAgreementCd(String agreementCd) {
		this.agreementCd = agreementCd;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getSurName() {
		return surName;
	}
	public String getFullName(){
		return surName + "," + firstName + " " + middleName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(String lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	public String getRecontactDate() {
		return recontactDate;
	}
	public void setRecontactDate(String recontactDate) {
		this.recontactDate = recontactDate;
	}
	public String getOverPayment() {
		return overPayment;
	}
	public void setOverPayment(String overPayment) {
		this.overPayment = overPayment;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public String getStoreCd() {
		return storeCd;
	}
	public void setStoreCd(String storeCd) {
		this.storeCd = storeCd;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getTelDistrict() {
		return telDistrict;
	}
	public void setTelDistrict(String telDistrict) {
		this.telDistrict = telDistrict;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getPhoneNo(){
		return telDistrict + "-" + telNo;
	}
	public String getProductDesciption() {
		return productDesciption;
	}
	public void setProductDesciption(String productDesciption) {
		this.productDesciption = productDesciption;
	}
	public String getPaymentCd() {
		return paymentCd;
	}
	public void setPaymentCd(String paymentCd) {
		this.paymentCd = paymentCd;
	}
	public String getRetDate() {
		return retDate;
	}
	public void setRetDate(String retDate) {
		this.retDate = retDate;
	}
}
