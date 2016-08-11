package com.acsp.merchant.search.dto;

public class MerchantDTO {

	private String agentCd;
	
	private String agentName;
	
	private String merchantCategory;
	
	private String telephoneNo;
	
	private String faxNo;
	
	private String merchantAddress;
	
	private String pic;
	
	private String accountName;
	
	private String bankName;
	
	private String accountNo;
	
	private String accountType;
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public String getAgentCd() {
		return agentCd;
	}

	public void setAgentCd(String agentCd) {
		this.agentCd = agentCd;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getMerchantCategory() {
		return merchantCategory;
	}

	public void setMerchantCategory(String merchantCategory) {
		String categoryValue = merchantCategory;
		switch(merchantCategory) {
			case "EL":
				categoryValue = "ELECTRICAL APPLIANCES";
				break;
			case "CM":
				categoryValue = "CAMERA";
				break;
			case "PC":
				categoryValue = "COMPUTER";
				break;
			case "CO":
				categoryValue = "COMMUNICATION";
				break;
			case "FU":
				categoryValue = "FURNITURE";
				break;
			case "CA":
				categoryValue = "CAR ACCESSORIES";
				break;
			case "SP":
				categoryValue = "SPORT ACCESSORIES";
				break;
			case "MU":
				categoryValue = "MUSIC INSTRUMENT";
				break;
			case "BI":
				categoryValue = "BICYCLE & EBIKE STORE";
				break;
			case "HW":
				categoryValue = "HARDWARE STORE";
				break;
			case "HL":
				categoryValue = "HEALTH EQUIPMENT";
				break;
			default:
				categoryValue = "OTHER";
				break;
			
		}
		
		this.merchantCategory = categoryValue;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	
	
	
}
