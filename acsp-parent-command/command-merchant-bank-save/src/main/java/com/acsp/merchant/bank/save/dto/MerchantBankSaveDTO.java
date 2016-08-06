package com.acsp.merchant.bank.save.dto;

/**
 * Created by elaguardia on 06/28/2016.
 */
public class MerchantBankSaveDTO  extends BaseDTO {

	private String accountName;
	
	private String accountNo;
	
	private String bankName;
	
	private String accountType;
	
	private String agentCd;

	public String getAgentCd() {
		return agentCd;
	}

	public void setAgentCd(String agentCd) {
		this.agentCd = agentCd;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
