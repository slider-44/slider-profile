package com.acsp.saleskey.dto;

public class SalesKeyDTO {

	String applicationCd;
	
	String currentUser;

	public String getApplicationCd() {
		return applicationCd;
	}

	public void setApplicationCd(String applicationCd) {
		this.applicationCd = applicationCd;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public String toString() {
		return "SalesKeyDTO [applicationCd=" + applicationCd + ", currentUser=" + currentUser + "]";
	}
	
}
