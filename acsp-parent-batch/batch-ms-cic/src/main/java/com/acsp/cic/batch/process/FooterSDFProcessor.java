package com.acsp.cic.batch.process;

import org.jooq.Field;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.data.FooterSDFRow;
import com.acsp.cic.batch.data.SDFRow;
import com.acsp.cic.batch.data.stream.DataStream;
import com.acsp.cic.batch.data.stream.FooterDataStream;

@Component
public class FooterSDFProcessor extends SDFProcessor {

	@Autowired
	FooterDataStream footerDataStream;
	
	@Override
	public SDFRow map(Record record) {

		FooterSDFRow footerSDFRow = new FooterSDFRow();
		
		for (Field<?> recordField : record.fields()) {
			
			footerSDFRow.addData(record.getValue(recordField.getName(),  String.class));
		}
		
		return footerSDFRow;
	}

	@Override
	public DataStream getDataStream() {
		
		return footerDataStream;
	}



}
