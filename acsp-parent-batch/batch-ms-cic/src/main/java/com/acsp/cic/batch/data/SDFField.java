package com.acsp.cic.batch.data;


public class SDFField {

	private String code;

	private SDFFieldFormat fieldFormat;

	private String data;

	public SDFField(String data, SDFFieldFormat fieldFormat) {
		this.data = data;
		this.fieldFormat = fieldFormat;
	}

	public String getCode() {
		return code;
	}

	public String getRawValue() {
		return data;
	}

	public String getPrintValue() {
		switch (fieldFormat.getType()) {
		case XTRING:
			return data;

		case NUMBER:
			return data;

		case DATE:
			return data;

		default:
			return null;
		}
	}

}
