package com.acsp.salesprocess.dto;

import org.joda.time.LocalDate;

public class ApplicationDetail {

	String applicationId;
	
	String approveCd;
	
	String storeCd;
	
	ApplicationStatus applicationStatus;
	
	String agreementCd;
	
	LocalDate judgementDate;

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getApproveCd() {
		return approveCd;
	}

	public void setApproveCd(String approveCd) {
		this.approveCd = approveCd;
	}

	public String getStoreCd() {
		return storeCd;
	}

	public void setStoreCd(String storeCd) {
		this.storeCd = storeCd;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getAgreementCd() {
		return agreementCd;
	}

	public void setAgreementCd(String agreementCd) {
		this.agreementCd = agreementCd;
	}
	
	public boolean isNoAgreementCd(){
		return this.agreementCd == null || this.agreementCd.trim().isEmpty();
	}

	public LocalDate getJudgementDate() {
		return judgementDate;
	}

	public void setJudgementDate(LocalDate judgementDate) {
		this.judgementDate = judgementDate;
	}
}
