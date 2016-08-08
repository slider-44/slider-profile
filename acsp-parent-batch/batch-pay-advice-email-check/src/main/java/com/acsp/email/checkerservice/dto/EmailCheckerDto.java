package com.acsp.email.checkerservice.dto;

public class EmailCheckerDto {

	private String mobileNO;
	private String name;
	private String date;
	private EmailStatus emailStatus;

	public String getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public EmailStatus getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(EmailStatus emailStatus) {
		this.emailStatus = emailStatus;
	}

	@Override
	public String toString() {
		return "EmailCheckerDto [date=" + date + "]";
	}
	
}
