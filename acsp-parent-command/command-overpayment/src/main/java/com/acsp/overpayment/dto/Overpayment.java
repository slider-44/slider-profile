package com.acsp.overpayment.dto;

import java.util.Date;

public class Overpayment {
	
	private String agreementCd;
	private String status;
	private String contactedTo;
	private String action;
	private String remarks;
	
	private String paymentCd;
	
	private Date recontactDate;
	
	private Date retDate;
	
	public String getAgreementCd() {
		return agreementCd;
	}
	public void setAgreementCd(String agreementCd) {
		this.agreementCd = agreementCd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContactedTo() {
		return contactedTo;
	}
	public void setContactedTo(String contactedTo) {
		this.contactedTo = contactedTo;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getRecontactDate() {
		return recontactDate;
	}
	public void setRecontactDate(Date recontactDate) {
		this.recontactDate = recontactDate;
	}
	public String getPaymentCd() {
		return paymentCd;
	}
	public void setPaymentCd(String paymentCd) {
		this.paymentCd = paymentCd;
	}
	public Date getRetDate() {
		return retDate;
	}
	public void setRetDate(Date retDate) {
		this.retDate = retDate;
	}
}
