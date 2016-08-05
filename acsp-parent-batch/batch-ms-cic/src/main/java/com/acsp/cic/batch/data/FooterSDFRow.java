package com.acsp.cic.batch.data;

import static com.acsp.cic.batch.constants.MandatoryType.MANDATORY;
import static com.acsp.cic.batch.constants.SDFFieldType.DATE;
import static com.acsp.cic.batch.constants.SDFFieldType.NUMBER;
import static com.acsp.cic.batch.constants.SDFFieldType.XTRING;

public class FooterSDFRow extends AbstractSDFRow {

	private static final String RecordType = "FT";
		
	private static final Integer FIELD_COUNT = 3;
	
	private static final SDFFieldFormat[] SDF_FIELD_FORMATS = {
			new SDFFieldFormat(XTRING,MANDATORY,2),
			new SDFFieldFormat(XTRING,MANDATORY,8),
			new SDFFieldFormat(DATE,MANDATORY,8),
			new SDFFieldFormat(NUMBER,MANDATORY,8)

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
		return true;
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
