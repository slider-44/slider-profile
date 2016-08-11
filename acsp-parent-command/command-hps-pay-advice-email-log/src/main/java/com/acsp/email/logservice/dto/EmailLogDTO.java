package com.acsp.email.logservice.dto;

public class EmailLogDTO {

	private String emailCD;
	private String paramAgreementCD;
	private String name;
	private String email;
	private String mobileNO;
	private EmailStatus emailStatus;

	public String getEmailCD() {
		return emailCD;
	}

	public void setEmailCD(String emailCD) {
		this.emailCD = emailCD;
	}

	public String getParamAgreementCD() {
		return paramAgreementCD;
	}

	public void setParamAgreementCD(String paramAgreementCD) {
		this.paramAgreementCD = paramAgreementCD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}

	public EmailStatus getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(EmailStatus emailStatus) {
		this.emailStatus = emailStatus;
	}

	@Override
	public String toString() {
		return "EmailLogDTO [paramAgreementCD=" + paramAgreementCD + ", name=" + name + ", email=" + email + ", mobileNO="
				+ mobileNO + ", emailStatus=" + emailStatus + "]";
	}

}
