package com.acsp.cic.batch.process;

import org.jooq.Field;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.data.HeaderSDFRow;
import com.acsp.cic.batch.data.SDFRow;
import com.acsp.cic.batch.data.stream.DataStream;
import com.acsp.cic.batch.data.stream.HeaderDataStream;
/**
 * Created by elaguardia on 03/22/2016.
 */
@Component
public class HeaderSDFProcessor extends SDFProcessor {

	@Autowired
	HeaderDataStream headerDataStream;
	
	@Override
	public SDFRow map(Record record) {
		
		HeaderSDFRow headerSDFRow = new HeaderSDFRow();
		
		for (Field<?> recordField : record.fields()) {
			
			headerSDFRow.addData(record.getValue(recordField.getName(),  String.class));
		}
		
		return headerSDFRow;
	}

	@Override
	public DataStream getDataStream() {
		return headerDataStream;
	}

}
