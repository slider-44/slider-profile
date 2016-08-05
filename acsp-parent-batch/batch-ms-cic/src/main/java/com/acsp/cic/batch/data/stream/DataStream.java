package com.acsp.cic.batch.data.stream;

import java.util.stream.Stream;

import org.jooq.Record;

public interface DataStream {
	
	Stream<Record> getStream();
	
}
