package com.acsp.email.checkerservice.dto;

public class Sms {

	private String name;
	private String mobileNO;
	private String agreementCD;
	private EmailStatus emailStatus;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNO() {
		return mobileNO;
	}
	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}
	public String getAgreementCD() {
		return agreementCD;
	}
	public void setAgreementCD(String agreementCD) {
		this.agreementCD = agreementCD;
	}
	public EmailStatus getEmailStatus() {
		return emailStatus;
	}
	public void setEmailStatus(EmailStatus emailStatus) {
		this.emailStatus = emailStatus;
	}
	
	@Override
	public String toString() {
		return "SmsDTO [name=" + name + ", mobileNO=" + mobileNO + ", agreementCD=" + agreementCD + ", emailStatus="
				+ emailStatus + "]";
	}
	
}
