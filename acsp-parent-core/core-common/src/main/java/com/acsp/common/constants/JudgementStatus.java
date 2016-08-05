package com.acsp.common.constants;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public enum JudgementStatus {
	
	/**
	 * 0 - Once Assessment Pass
	 */
	ONCE_ASSESSMENT_PASS(0, "Once Assessment Pass"),
	/**
	 * 1 - Approved
	 */
	APPROVED(1,"Approved"),
	/**
	 * 2 - Rejected
	 */
	REJECTED(2,"Rejected"),
	/**
	 * 3 - Cancel
	 */
	CANCEL(3,"Cancel"),
	/**
	 * 4 - Verification
	 */
	VERIFICATION(4,"Verification");
	
	private int code;
	private String value;

	/**
	 * Singleton Class for looking up through our ENUM using code or value.
	 * 
	 * @author gvargas
	 *
	 */
	public final static class BootstrapSingleton {
		public static final Map<String, JudgementStatus> lookupByValue = new HashMap<String, JudgementStatus>();
		public static final Map<BigDecimal, JudgementStatus> lookupByCode = new HashMap<BigDecimal, JudgementStatus>();
	}

	JudgementStatus(int code, String value) {
		this.code = code;
		this.value = value;
		BootstrapSingleton.lookupByValue.put(value, this);
		BootstrapSingleton.lookupByCode.put(new BigDecimal(code), this);
	}
	
	public static JudgementStatus getByValue(String value) {
		return BootstrapSingleton.lookupByValue.get(value);
	}

	public static JudgementStatus getByCode(BigDecimal code) {
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
