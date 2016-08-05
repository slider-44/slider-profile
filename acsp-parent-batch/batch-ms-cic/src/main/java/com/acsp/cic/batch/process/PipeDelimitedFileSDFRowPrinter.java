package com.acsp.cic.batch.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.data.SDFField;
import com.acsp.cic.batch.data.SDFRow;

/**
 * Created by elaguardia on 04/07/2016.
 */
@Component
public class PipeDelimitedFileSDFRowPrinter implements SDFRowPrinter {
	
	private final static String DELIMETER= "|";
	private final static String EXT= ".txt";
	
	private final static int INDIVIDUAL_LENGTH = 123;
	private final static int HD_LENGTH = 6;
	private final static int INSTALLMENT_LENGTH = 143;
	
	
	
	@Value("${cic.location}")
	private String LOCATION;
	
	
	@Override
	public void print(SDFRow row, PrintInfoDTO printInfoDTO) {
		
		try {
		
			File file = new File (LOCATION + row.getRecordType() + EXT) ;
				if (!file.exists()) {
				file.createNewFile();
		
			}
			
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file.getAbsoluteFile(),true), "UTF-8"));
		
		int count = 0;
		
		for (SDFField sDFField :  row.getFields()) {
			
			count++;
			
			if(sDFField.getPrintValue()!=null) {
				writer.write(sDFField.getPrintValue());
			
			}
			
			if(printInfoDTO.isIndividualRecord()){
				if (count < INDIVIDUAL_LENGTH){
					writer.write(DELIMETER);	
				}
			}
			
			else if (printInfoDTO.isInstallmentRecord()){
				if (count < INSTALLMENT_LENGTH){
					writer.write(DELIMETER);	
				}
			}
			
			else if (printInfoDTO.isHeaderRecord()){
				if (count < HD_LENGTH){
					writer.write(DELIMETER);	
				}
			}
			else 
				writer.write(DELIMETER);
			
		}
		
		
		//count individual records being written on file
		if(printInfoDTO.isIndividualRecord()){
			printInfoDTO.incrementRecordCount();
			
		}
				
		//count installment records being written on file
		if(printInfoDTO.isInstallmentRecord()){
			printInfoDTO.incrementRecordCount();			
		}
		
		//print total number of records written on the file
		if (printInfoDTO.isFooterRecord()){
			
			int recordCount = printInfoDTO.getRecordCount();
			recordCount = recordCount + 2;
			writer.write(Integer.toString(recordCount));
		}
		
		writer.write("\r\n");
		writer.close();
		
		}catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}
