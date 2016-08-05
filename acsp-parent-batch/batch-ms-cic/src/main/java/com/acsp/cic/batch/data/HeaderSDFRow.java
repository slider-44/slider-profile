package com.acsp.cic.batch.data;

import static com.acsp.cic.batch.constants.MandatoryType.*;
import static com.acsp.cic.batch.constants.SDFFieldType.*;
/**
 * Created by elaguardia on 03/22/2016.
 */
public class HeaderSDFRow extends AbstractSDFRow {
	
	private static final String RecordType = "HD";

	private static final Integer FIELD_COUNT = 5;
	
	
	private static final SDFFieldFormat[] SDF_FIELD_FORMATS = {
			new SDFFieldFormat(XTRING,MANDATORY,2),
			new SDFFieldFormat(XTRING,MANDATORY,8),
			new SDFFieldFormat(DATE,MANDATORY,8),
			new SDFFieldFormat(XTRING,MANDATORY,12),
			new SDFFieldFormat(XTRING,MANDATORY,1),
			new SDFFieldFormat(XTRING,NON_MANDATORY,100)

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
