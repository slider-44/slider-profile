package com.acsp.common.constants;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public enum ApplicationStatus {
	/**
	 * 0 - Application Login / DE 1 Finished
	 */
	APPLICATION_LOGIN(0, "Application Login"), 
	/**
	 * 1 - Accepted 
	 */
	ACCEPTED(1,"Accepted"), 
	/**
	 * 2 - First Verification / Survey Requested
	 */
	FIRST_VERIFICATION(2,"First Verification"), 
	/**
	 * 3 - First Examining / Survey Pending
	 */
	FIRST_EXAMINING(3,"First Examining"), 
	/**
	 * 4 - Final Examining Over / Final Verification
	 */
	FINAL_EXAMINING_OVER(4, "Final Examining Over"), 
	/**
	 * 5 - Contract Login Over / Agreement
	 */
	CONTRACT_LOGIN_OVER(5, "Contract Login Over"), 
	/**
	 * 6 - Application Cancel
	 */
	APPLICATION_CANCEL(6, "Application Cancel"), 
	/**
	 * 7 - Waiting for first verification
	 */
	WAITING_FOR_FIRST_VERIFICATION(7, "Waiting for First Verification"),
	/**
	 * 8 - First Assessment
	 */
	FIRST_ASSESSMENT(8,"First Assessment"), 
	/**
	 * 9 - Final Verification
	 */
	FINAL_VERIFICATION(9,"Final Verification"), 
	/**
	 * 10 - Final Assessment
	 */
	FINAL_ASSESSMENT(10,"Final Assessment"), 
	/**
	 * 11 - Final Verification
	 */
	WAITING_FOR_FINAL_VERIFICATION(11,"Waiting For Final Verification"), 
	/**
	 * 12 - Waiting for BAP Verification
	 */
	WAITING_FOR_BAP_VERIFICATION(12, "Waiting for BAP Verification");

	private int code;
	private String value;

	/**
	 * Singleton Class for looking up through our ENUM using code or value.
	 * 
	 * @author gvargas
	 *
	 */
	private final static class BootstrapSingleton {
		public static final Map<String, ApplicationStatus> lookupByValue = new HashMap<String, ApplicationStatus>();
		public static final Map<BigDecimal, ApplicationStatus> lookupByCode = new HashMap<BigDecimal, ApplicationStatus>();
	}

	ApplicationStatus(int code, String value) {
		this.code = code;
		this.value = value;
		BootstrapSingleton.lookupByValue.put(value, this);
		BootstrapSingleton.lookupByCode.put(new BigDecimal(code), this);
	}

	public static ApplicationStatus getByValue(String value) {
		return BootstrapSingleton.lookupByValue.get(value);
	}

	public static ApplicationStatus getByCode(BigDecimal code) {
		return BootstrapSingleton.lookupByCode.get(code);
	}

	public int getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}
	
	/**
	 * Gets the code by byte used in condition filtering
	 * @return
	 */
	public byte getCodeAsByte(){
		return (byte) code;
	}
}
