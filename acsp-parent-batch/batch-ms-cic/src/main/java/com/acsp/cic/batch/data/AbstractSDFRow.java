package com.acsp.cic.batch.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
/**
 * Created by elaguardia on 03/22/2016.
 */
public abstract class AbstractSDFRow implements SDFRow {

	protected List<SDFField> sDFFields;
	
	@Value("${cic.providercode}")
	protected String ProviderCode; 

	public AbstractSDFRow() {
		sDFFields = new ArrayList<SDFField>(getFieldCount());
	}

	public abstract SDFFieldFormat[] getFieldFormat();

	@Override
	public SDFField[] getFields() {

		return sDFFields.toArray(new SDFField[getFieldCount()]);

	}

	@Override
	public void addData(String data) {

		SDFField sDFField = new SDFField(data, getFieldFormat()[sDFFields.size()]);
		sDFFields.add(sDFField);

	}

}
