package com.acsp.cic.batch.data;

import static com.acsp.cic.batch.constants.MandatoryType.*;
import static com.acsp.cic.batch.constants.SDFFieldType.*;

public class InstallmentSDFRow extends AbstractSDFRow {

	private static final String RecordType = "CI";
	
	private static final Integer FIELD_COUNT = 5;
	
	private static final SDFFieldFormat[] SDF_FIELD_FORMATS ={
		new SDFFieldFormat(XTRING,MANDATORY,2),
		new SDFFieldFormat(XTRING,MANDATORY,8),
		new SDFFieldFormat(XTRING,NON_MANDATORY,5),
		new SDFFieldFormat(DATE,MANDATORY,8),
		new SDFFieldFormat(XTRING,MANDATORY,38),
		new SDFFieldFormat(XTRING,MANDATORY,1),
		new SDFFieldFormat(XTRING,MANDATORY,38),
		new SDFFieldFormat(XTRING,MANDATORY,2),
		new SDFFieldFormat(XTRING,MANDATORY,2),
		new SDFFieldFormat(XTRING,NON_MANDATORY,2),
		new SDFFieldFormat(XTRING,MANDATORY,3),
		new SDFFieldFormat(XTRING,MANDATORY,3),
		new SDFFieldFormat(DATE,DEPENDENT,8),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(DATE,DEPENDENT,8),
		new SDFFieldFormat(DATE,DEPENDENT,8),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(XTRING,NON_MANDATORY,1),
		new SDFFieldFormat(XTRING,NON_MANDATORY,1),
		new SDFFieldFormat(NUMBER,MANDATORY,15),
		new SDFFieldFormat(NUMBER,MANDATORY,3),
		new SDFFieldFormat(XTRING,MANDATORY,3),
		new SDFFieldFormat(XTRING,NON_MANDATORY,2),
		new SDFFieldFormat(XTRING,MANDATORY,1),
		new SDFFieldFormat(XTRING,NON_MANDATORY,3),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
		new SDFFieldFormat(NUMBER,DEPENDENT,3),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(NUMBER,DEPENDENT,3),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(XTRING,DEPENDENT,1),
		new SDFFieldFormat(XTRING,NON_MANDATORY,2),
		new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
		new SDFFieldFormat(XTRING,NON_MANDATORY,1),
		new SDFFieldFormat(XTRING,NON_MANDATORY,100),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(XTRING,NON_MANDATORY,20),
		new SDFFieldFormat(XTRING,NON_MANDATORY,38),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(XTRING,NON_MANDATORY,20),
		new SDFFieldFormat(XTRING,NON_MANDATORY,160),
		new SDFFieldFormat(XTRING,NON_MANDATORY,200),
		new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
		new SDFFieldFormat(XTRING,NON_MANDATORY,100),
		new SDFFieldFormat(XTRING,NON_MANDATORY,1),
		new SDFFieldFormat(XTRING,NON_MANDATORY,38),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(XTRING,NON_MANDATORY,20),
		new SDFFieldFormat(XTRING,NON_MANDATORY,160),
		new SDFFieldFormat(XTRING,NON_MANDATORY,200),
		new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
		new SDFFieldFormat(XTRING,NON_MANDATORY,100),
		new SDFFieldFormat(XTRING,NON_MANDATORY,1),
		new SDFFieldFormat(XTRING,NON_MANDATORY,38),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(XTRING,NON_MANDATORY,20),
		new SDFFieldFormat(XTRING,NON_MANDATORY,160),
		new SDFFieldFormat(XTRING,NON_MANDATORY,200),
		new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
		new SDFFieldFormat(XTRING,NON_MANDATORY,100),
		new SDFFieldFormat(XTRING,NON_MANDATORY,1),
		new SDFFieldFormat(XTRING,NON_MANDATORY,38),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(XTRING,NON_MANDATORY,20),
		new SDFFieldFormat(XTRING,NON_MANDATORY,160),
		new SDFFieldFormat(XTRING,NON_MANDATORY,200),
		new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
		new SDFFieldFormat(XTRING,NON_MANDATORY,100),
		new SDFFieldFormat(XTRING,NON_MANDATORY,1),
		new SDFFieldFormat(XTRING,NON_MANDATORY,38),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(XTRING,NON_MANDATORY,20),
		new SDFFieldFormat(XTRING,NON_MANDATORY,160),
		new SDFFieldFormat(XTRING,NON_MANDATORY,200),
		new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
		new SDFFieldFormat(XTRING,NON_MANDATORY,100),
		new SDFFieldFormat(XTRING,NON_MANDATORY,1),
		new SDFFieldFormat(XTRING,NON_MANDATORY,38),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(NUMBER,DEPENDENT,15),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(DATE,NON_MANDATORY,8),
		new SDFFieldFormat(XTRING,DEPENDENT,3),
		new SDFFieldFormat(XTRING,NON_MANDATORY,20),
		new SDFFieldFormat(XTRING,NON_MANDATORY,160),
		new SDFFieldFormat(XTRING,NON_MANDATORY,200),
		new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
		new SDFFieldFormat(XTRING,NON_MANDATORY,100),
		new SDFFieldFormat(XTRING,NON_MANDATORY,1),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,1),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,1),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,1),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,1),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,1),
		new SDFFieldFormat(XTRING,DEPENDENT,220),
		new SDFFieldFormat(XTRING,DEPENDENT,38),
		new SDFFieldFormat(XTRING,DEPENDENT,1),
		new SDFFieldFormat(XTRING,DEPENDENT,220)

	};
	
	@Override
	public String getRecordType() {
		
		return RecordType;
	}

	@Override
	public String getProviderCode() {
		
		return ProviderCode;
	}

	@Override
	public Integer getFieldCount() {
		
		return FIELD_COUNT;
	}

	@Override
	public boolean validate(SDFRow row) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public SDFFieldFormat[] getFieldFormat() {
		
		return SDF_FIELD_FORMATS;
	}

	
}
