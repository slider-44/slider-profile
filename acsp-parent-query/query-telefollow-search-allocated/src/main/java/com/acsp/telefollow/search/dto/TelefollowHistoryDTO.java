package com.acsp.telefollow.search.dto;

/**
 * Controller for Search
 * @Author Elizabeth Laguardia
 * 06152016
 */
public class TelefollowHistoryDTO {
	
	private String contacted;
	
	private String action;
	
	private String recontactDate;
	
	private String comment;
	
	private String appCd;
	
	private String telefollowCd;
	
	private String sysAppCd;
	
	private String status;
	
	private String createDate;
	
	private String followupDate;
	
	private String commitmentDate;

	public String getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(String followupDate) {
		this.followupDate = followupDate;
	}

	public String getCommitmentDate() {
		return commitmentDate;
	}

	public void setCommitmentDate(String commitmentDate) {
		this.commitmentDate = commitmentDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		
		String statusValue=status;
		switch(status) {
			case "1":
				statusValue = "SALES";
				break;
			case "2":
				statusValue = "CANCEL";
				break;
			case "3":
				statusValue = "NOT YET CONTACTED";
				break;
			case "5":
				statusValue = "WAITING FOR PICK UP";
				break;
			case "8":
				statusValue = "SALES PENDING";
				break;
			default:
				statusValue = "OTHER";
				break;
			
		}
		
		this.status = statusValue;
	}

	public String getSysappcd() {
		return sysAppCd;
	}

	public void setSysAppCd(String sysAppCd) {
		this.sysAppCd = sysAppCd;
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

	public String getContacted() {
		return contacted;
	}

	public void setContacted(String contacted) {
		
		String contactedTo=contacted;
		switch(contacted) {
			case "1":
				contactedTo = "MERCHANT";
				break;
			case "2":
				contactedTo = "PROMOTER";
				break;
			case "3":
				contactedTo = "CUSTOMER";
				break;
			case "4":
				contactedTo = "EDP";
			default:
				contactedTo = "OTHER";
				break;
			
		}
		
		this.contacted = contactedTo;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		
		String actionValue=action;
		switch(action) {
			case "1":
				actionValue = "END";
				break;
			case "2":
				actionValue = "CANCEL";
				break;
			case "3":
				actionValue = "NONE";
				break;
			case "4":
				actionValue = "RECONTACT";
				break;
			case "5":
				actionValue = "FEEDBACK TO CAD";
				break;
			case "6":
				actionValue = "FEEDBACK TO CMD";
				break;
			default:
				actionValue = "FEEDBACK TO MKT";
				break;
			
		}
		this.action = actionValue;
	}

	public String getRecontactDate() {
		return recontactDate;
	}

	public void setRecontactDate(String recontactDate) {
		this.recontactDate = recontactDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	

}
