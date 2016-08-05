package com.acsp.cic.batch.data;

import com.acsp.cic.batch.constants.MandatoryType;
import com.acsp.cic.batch.constants.SDFFieldType;

public class SDFFieldFormat {

	SDFFieldType type;
	
	MandatoryType mandatory;
	
	int length;
	
	public SDFFieldFormat(SDFFieldType type, MandatoryType mandatory, int length) {
		super();
		this.type = type;
		this.mandatory = mandatory;
		this.length = length;
	}

	public SDFFieldType getType() {
		return type;
	}

	public void setType(SDFFieldType type) {
		this.type = type;
	}

	public MandatoryType getMandatory() {
		return mandatory;
	}

	public void setMandatory(MandatoryType mandatory) {
		this.mandatory = mandatory;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
