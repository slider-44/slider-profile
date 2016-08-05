package com.acsp.cic.batch.process;



import org.jooq.Field;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.data.IndividualSDFRow;
import com.acsp.cic.batch.data.SDFRow;
import com.acsp.cic.batch.data.stream.DataStream;
import com.acsp.cic.batch.data.stream.IndividualDataStream;
/**
 * Created by elaguardia on 03/22/2016.
 */
@Component
public class IndividualSDFProcessor extends SDFProcessor {

	@Autowired
	IndividualDataStream individualDataStream;
	
	@Override
	public SDFRow map(Record record) {
		
		IndividualSDFRow individualSDFRow = new IndividualSDFRow();
		
		for (Field<?> recordField : record.fields()) {
			
			individualSDFRow.addData(record.getValue(recordField.getName(), String.class));
		
		}
	
		return individualSDFRow;
	}

	@Override
	public DataStream getDataStream() {
		return individualDataStream;
		
	}

	

	

}
