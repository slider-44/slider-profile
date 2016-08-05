package com.acsp.cic.batch.process;

import org.jooq.Field;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.data.InstallmentSDFRow;
import com.acsp.cic.batch.data.SDFRow;
import com.acsp.cic.batch.data.stream.DataStream;
import com.acsp.cic.batch.data.stream.InstallmentDataStream;

@Component
public class InstallmentSDFProcessor extends SDFProcessor {

	@Autowired
	InstallmentDataStream installmentDataStream;
	
	@Override
	public SDFRow map(Record record) {
		
		InstallmentSDFRow installmentSDFRow = new InstallmentSDFRow();
		
		for (Field<?> recordField : record.fields()) {
			
			installmentSDFRow.addData(record.getValue(recordField.getName(), String.class));
		
		}
	
		return installmentSDFRow;
	}

	@Override
	public DataStream getDataStream() {
		
		return installmentDataStream;
	}

	

}
