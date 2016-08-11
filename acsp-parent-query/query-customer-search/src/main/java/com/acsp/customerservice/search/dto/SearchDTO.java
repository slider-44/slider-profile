package com.acsp.customerservice.search.dto;

import java.util.List;

public class SearchDTO {

	private String content;

	private String firstName;
	private String surName;
	private String birthDay;
	private String idCardNo;

	private String telNo;
	private String mobileNo;

	private String customerCd;

	private String appCd;
	private String agreementCd;

	private List<ApplicationDTO> applicationList;

	public String getFullName() {
		return surName + ", " + firstName;
	}

	public String getTelNo() {
		return telNo;
	}

	public SearchDTO setTelNo(String telNo) {
		this.telNo = telNo == null || telNo.length() < 4 ? null : telNo;
		return this;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public SearchDTO setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo == null || mobileNo.length() < 4 ? null : mobileNo;
		return this;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFirstName() {
		return firstName;
	}

	public SearchDTO setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getSurName() {
		return surName;
	}

	public SearchDTO setSurName(String surName) {
		this.surName = surName;
		return this;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public SearchDTO setBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getCustomerCd() {
		return customerCd;
	}

	public SearchDTO setCustomerCd(String customerCd) {
		this.customerCd = customerCd;
		return this;
	}

	public String getAppCd() {
		return appCd;
	}

	public SearchDTO setAppCd(String appCd) {
		this.appCd = appCd;
		return this;
	}

	public String getAgreementCd() {
		return agreementCd;
	}

	public SearchDTO setAgreementCd(String agreementCd) {
		this.agreementCd = agreementCd;
		return this;
	}

	public List<ApplicationDTO> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<ApplicationDTO> applicationList) {
		this.applicationList = applicationList;
	}
}
