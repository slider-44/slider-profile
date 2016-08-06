package com.acsp.telefollow.save.dto;



public class TelefollowSaveDTO extends BaseDTO {

	private String appCd;
	
	private Byte status;
	
	private Byte cancelReason;
	
	private Byte action;
	
	private Integer recontactDate;
	
	private String comments;
	
	private Byte contactTo;
	
	private Integer approvalDate;
	
	private String telefollowCd;
	
	private String called;
	
	private String commitmentDate;
	
	private String followupDate;
	
	private String salesPending;
	
	private String method;
	
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCalled() {
		return called;
	}

	public void setCalled(String called) {
		this.called = called;
	}

	public String getCommitmentDate() {
	
		return commitmentDate;
	}

	public void setSalesPending(String salesPending) {
		String formatDate = null;
		
		if(salesPending != null)
			formatDate = salesPending.substring(0,4) + salesPending.substring(5,7) + salesPending.substring(8,10);
	    
		this.salesPending = formatDate;
	}
	
	public String getSalesPending() {
		
		return salesPending;
	}

	public void setCommitmentDate(String commitmentDate) {
		String formatDate = null;
		
		if(commitmentDate != null)
			formatDate = commitmentDate.substring(0,4) + commitmentDate.substring(5,7) + commitmentDate.substring(8,10);
	    
		this.commitmentDate = formatDate;
	}

	public String getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(String followupDate) {
		String formatDate = null;
		
		if(followupDate != null) 
			formatDate = followupDate.substring(0,4) + followupDate.substring(5,7) + followupDate.substring(8,10);
		
		this.followupDate = formatDate;
	}

	
	public String getTelefollowCd() {
		return telefollowCd;
	}

	public void setTelefollowCd(String telefollowCd) {
		this.telefollowCd = telefollowCd;
	}

	public String getAppCd() {
		return appCd;
	}

	public void setAppCd(String appCd) {
		this.appCd = appCd;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(Byte cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Byte getAction() {
		return action;
	}

	public void setAction(Byte action) {
		this.action = action;
	}

	public Integer getRecontactDate() {
		return recontactDate;
	}

	public void setRecontactDate(Integer recontactDate) {
		this.recontactDate = recontactDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Byte getContactTo() {
		return contactTo;
	}

	public void setContactTo(Byte contactTo) {
		this.contactTo = contactTo;
	}

	public Integer getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Integer approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	
}
