package com.acsp.cic.batch.data;

import static com.acsp.cic.batch.constants.MandatoryType.*;
import static com.acsp.cic.batch.constants.SDFFieldType.*;

import org.springframework.stereotype.Component;

/**
 * Created by elaguardia on 03/22/2016.
 */

@Component
public class IndividualSDFRow extends AbstractSDFRow {
	
	private static final String RecordType = "ID";
	
	private static final Integer FIELD_COUNT = 5;
	
	
	private static final SDFFieldFormat[] SDF_FIELD_FORMATS = {
			new SDFFieldFormat(XTRING,MANDATORY,2),
			new SDFFieldFormat(XTRING,MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,5),
			new SDFFieldFormat(DATE,MANDATORY,8),
			new SDFFieldFormat(XTRING,MANDATORY,38),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(XTRING,MANDATORY,70),
			new SDFFieldFormat(XTRING,MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,40),
			new SDFFieldFormat(XTRING,NON_MANDATORY,40),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,MANDATORY,1),
			new SDFFieldFormat(DATE,MANDATORY,8),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(NUMBER,NON_MANDATORY,2),
			new SDFFieldFormat(NUMBER,NON_MANDATORY,3),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,70),
			new SDFFieldFormat(XTRING,NON_MANDATORY,40),
			new SDFFieldFormat(XTRING,MANDATORY,2),
			new SDFFieldFormat(XTRING,DEPENDENT,400),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,4),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,60),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,400),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,4),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,60),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,250),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,250),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,250),
			new SDFFieldFormat(XTRING,DEPENDENT,1),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,DEPENDENT,1),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,120),
			new SDFFieldFormat(XTRING,NON_MANDATORY,20),
			new SDFFieldFormat(XTRING,NON_MANDATORY,20),
			new SDFFieldFormat(XTRING,NON_MANDATORY,5),
			new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(XTRING,NON_MANDATORY,3),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,4),
			new SDFFieldFormat(XTRING,NON_MANDATORY,120),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,400),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,4),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,60),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,400),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,4),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,60),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(XTRING,DEPENDENT,1),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,DEPENDENT,1),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,MANDATORY,2),
			new SDFFieldFormat(XTRING,MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,5),
			new SDFFieldFormat(DATE,MANDATORY,8),
			new SDFFieldFormat(XTRING,MANDATORY,38),
			new SDFFieldFormat(XTRING,MANDATORY,120),
			new SDFFieldFormat(XTRING,NON_MANDATORY,120),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,NON_MANDATORY,5),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(NUMBER,NON_MANDATORY,9),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
			new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
			new SDFFieldFormat(NUMBER,NON_MANDATORY,15),
			new SDFFieldFormat(XTRING,NON_MANDATORY,3),
			new SDFFieldFormat(XTRING,MANDATORY,2),
			new SDFFieldFormat(XTRING,DEPENDENT,400),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,4),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,60),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,400),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,4),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,NON_MANDATORY,60),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,DEPENDENT,50),
			new SDFFieldFormat(XTRING,NON_MANDATORY,2),
			new SDFFieldFormat(XTRING,NON_MANDATORY,1),
			new SDFFieldFormat(DATE,NON_MANDATORY,8),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(XTRING,DEPENDENT,2),
			new SDFFieldFormat(XTRING,DEPENDENT,20),
			new SDFFieldFormat(XTRING,DEPENDENT,1),
			new SDFFieldFormat(XTRING,DEPENDENT,100),
			new SDFFieldFormat(XTRING,DEPENDENT,1),
			new SDFFieldFormat(XTRING,DEPENDENT,100)		
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
