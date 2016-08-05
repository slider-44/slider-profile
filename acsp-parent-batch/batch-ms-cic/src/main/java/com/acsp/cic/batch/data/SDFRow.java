package com.acsp.cic.batch.data;

import com.acsp.cic.batch.validation.RowValidator;

public interface SDFRow extends RowValidator{
	
	String getRecordType();
	
	String getProviderCode();
	
	SDFField[] getFields();

	Integer getFieldCount();
	
	void addData(String data);
	
}
