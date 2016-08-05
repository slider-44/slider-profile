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
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.data.AbstractField;
import com.acsp.cic.batch.data.AbstractRecord;

@Component
public class FooterDataStream implements DataStream {

	@Value("${cic.providercode}")
	private String providercode;
	
	@Override
	public Stream<Record> getStream() {
		
		List<Record> records = new ArrayList<>(); 
		records.add(new FooterRecord(providercode));
		return records.stream();
	}
	
	public static class FooterField extends AbstractField {
		
		private static final long serialVersionUID = -2087687216044606750L;
		private String name;

		public FooterField(String name) {
			super();
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
	}
	
	public static class FooterRecord extends AbstractRecord {
		
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date();
		
		private static final long serialVersionUID = -2982152709449986843L;

		private Map<String, String> fieldMap = new HashMap<>();
		
		private Field<?>[] fields = {
				new FooterField("RecordType"),
				new FooterField("ProviderCode"),
				new FooterField("FileReferenceDate")
				
		};
		
		public FooterRecord (String providercode){
			
			fieldMap.put("RecordType", "FT");
			fieldMap.put("ProviderCode", providercode);
			fieldMap.put("FileReferenceDate", dateFormat.format(date));
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
