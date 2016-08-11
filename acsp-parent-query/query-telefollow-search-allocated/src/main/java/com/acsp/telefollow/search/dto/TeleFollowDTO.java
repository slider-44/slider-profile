package com.acsp.telefollow.search.dto;

import java.util.ArrayList;
import java.util.List;


/**
 * Controller for Search
 * @Author Elizabeth Laguardia
 * 06162016
 */
public class TeleFollowDTO {

	private String appCd;
	
	private String birthday;

	private String storeName;
	
	private String storePhone;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String approvalCode;
	
	private String approvalDate;
	
	private String lastStatus;
	
	private String lastAction;
	
	private String recontactDate;
	
	private String nameAndType;
	
	private String applicationDate;
	
	private String storePIC;
	
	private String mobileNo;
	
	private String officePhone;
	
	private String homePhone;
	
	private String followupDate;
	
	private String commitmentDate;
	
	private String salesPending;
	
	private String method;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		
		String methodValue = method;
		switch(method) {
			case "1":
				methodValue = "CALL";
				break;
			case "2":
				methodValue = "TEXT";
				break;
			default:
				methodValue = "---";
				break;
			
		}
		
		this.method = methodValue;
	}

	public String getSalesPending() {
		return salesPending;
	}

	public void setSalesPending(String salesPending) {
		this.salesPending = salesPending;
	}
	
	

	public String getCommitmentDate() {
		return commitmentDate;
	}

	public void setCommitmentDate(String commitmentDate) {
		this.commitmentDate = commitmentDate;
	}

	public String getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(String followupDate) {
		this.followupDate = followupDate;
	}

	private List<ProductDTO> products;
	
	private List<TelefollowHistoryDTO> telefollowHistory;
	
	public TeleFollowDTO () {
		
		this.products = new ArrayList<>();
		this.telefollowHistory = new ArrayList<>();
	}
	
	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
	public List<ProductDTO> getProducts() {
		return products;
	}
	
	public void setTelefollowHistory(List<TelefollowHistoryDTO> telefollowHistory) {
		this.telefollowHistory = telefollowHistory;
	}
	
	public List<TelefollowHistoryDTO> getTelefollowHistory() {
		return telefollowHistory;
	}
	
	public String getAppCd() {
		return appCd;
	}

	public void setAppCd(String appCd) {
		this.appCd = appCd;
		
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
		
	}
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
		
	}
	
	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}
	
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
		
	}
	
	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
		
	}
	
	public String getLastStatus() {
		return lastStatus;
	}

	public void setLastStatus(String lastStatus) {
		this.lastStatus = lastStatus;
		
	}
	
	public String getLastAction() {
		return lastAction;
	}

	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
		
	}
	
	public String getRecontactDate() {
		return recontactDate;
	}

	public void setRecontactDate(String recontactDate) {
		this.recontactDate = recontactDate;
		
	}
	
	public String getNameAndType() {
		return nameAndType;
	}

	public void setNameAndType(String nameAndType) {
		this.nameAndType = nameAndType;
		
	}
	
	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
		
	}
	
	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}
	
	public String getStorePic() {
		return storePIC;
	}

	public void setStorePic(String storePIC) {
		this.storePIC = storePIC;
	}
	
	public String getFullName() {
		return lastName + ", " + firstName;
	}

	
}
