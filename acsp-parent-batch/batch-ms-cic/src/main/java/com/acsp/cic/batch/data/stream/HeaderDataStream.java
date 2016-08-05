package com.acsp.cic.batch.data.stream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


import org.jooq.Field;
import org.jooq.Record;
import org.jooq.exception.DataTypeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.acsp.cic.batch.data.AbstractField;
import com.acsp.cic.batch.data.AbstractRecord;

/**
 * Created by elaguardia on 03/22/2016.
 */
@Repository
public class HeaderDataStream implements DataStream {

	
	@Value("${cic.providercode}")
	private String providercode;
	
	@Override
	public Stream<Record> getStream() {
		
		List<Record> records = new ArrayList<>(); 
		records.add(new HeaderRecord(providercode));
		return records.stream();
	}

	public static class HeaderField extends AbstractField {

		private static final long serialVersionUID = 1994835628845632755L;
		private String name;

		public HeaderField(String name) {
			super();
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

	}

	public static class HeaderRecord extends AbstractRecord {
		
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date();

		private static final long serialVersionUID = -7324620626076067746L;
		
		private Map<String, String> fieldMap = new HashMap<>();

		private Field<?>[] fields = {
				new HeaderField("RecordType"),
				new HeaderField("ProviderCode"),
				new HeaderField("FileReferenceDate"), // currentdate
				new HeaderField("Version"),
				new HeaderField("SubmissionType"),
				new HeaderField("ProviderComments")
				
		};
		
		public HeaderRecord (String providercode){
			fieldMap.put("RecordType", "HD");
			fieldMap.put("ProviderCode", providercode);
			fieldMap.put("FileReferenceDate", dateFormat.format(date));
			fieldMap.put("Version", "1.0");
			fieldMap.put("SubmissionType", "0");
			fieldMap.put("ProviderComments", "");
		}
		
		@Override
		public Field<?>[] fields() {
			return fields;
		}

		@Override
		public <T> T getValue(String name, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
	
			return (T) fieldMap.get(name);
		}

	}

}
