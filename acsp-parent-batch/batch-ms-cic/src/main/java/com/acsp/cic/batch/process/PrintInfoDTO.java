package com.acsp.cic.batch.process;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintInfoDTO {

	private AtomicInteger recordCount = new AtomicInteger(0);
	private AtomicBoolean isIndividualRecord = new AtomicBoolean(false);
	private AtomicBoolean isInstallmentRecord = new AtomicBoolean(false);
	private AtomicBoolean isFooterRecord = new AtomicBoolean(false);
	private AtomicBoolean isHeaderRecord = new AtomicBoolean(false);

	public void setIsFooterRecord(boolean isFooterRecord) {
		this.isFooterRecord.set(isFooterRecord); 
	}
	
	public boolean isFooterRecord() {
		return isFooterRecord.get();
	}
	
	public void setIsHeaderRecord(boolean isHeaderRecord) {
		this.isHeaderRecord.set(isHeaderRecord); 
	}
	
	public boolean isHeaderRecord() {
		return isHeaderRecord.get();
	}
	
	public void setIsIndividualRecord(boolean isIndividualRecord) {
		this.isIndividualRecord.set(isIndividualRecord); 
	}
	
	public boolean isIndividualRecord() {
		return isIndividualRecord.get();
	}
	
	public void setIsInstallmentRecord(boolean isInstallmentRecord){
		this.isInstallmentRecord.set(isInstallmentRecord);
	}
	
	public boolean isInstallmentRecord() {
		return isInstallmentRecord.get();
	}
	
	public int incrementRecordCount() {
		return recordCount.incrementAndGet();
	}
	
	public int getRecordCount() {
		
		//return recordCount.get();
		return recordCount.getAndAdd(2);
	}
	
	
	
	
	
	
}
