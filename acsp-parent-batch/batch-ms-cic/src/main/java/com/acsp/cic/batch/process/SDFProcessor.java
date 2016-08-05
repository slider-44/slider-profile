package com.acsp.cic.batch.process;

import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.data.SDFRow;
import com.acsp.cic.batch.data.stream.DataStream;

@Component
public abstract class SDFProcessor {
	
	@Autowired
	SDFRowPrinter sDFRowPrinter;
	
	public void process(PrintInfoDTO printInfoDTO) {
		
		getDataStream() // return DataStream individualDataStream
			.getStream()
			.map(record-> map(record))
			.filter(SDFRow::validate)
			.forEach(row-> sDFRowPrinter.print(row,printInfoDTO));
	}
	
	public abstract SDFRow map(Record record);
	
	public abstract DataStream getDataStream();
	
}
