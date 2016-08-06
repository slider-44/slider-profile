package com.acsp.cic.batch.process;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsp.cic.batch.encryption.EncryptFile;
import com.acsp.cic.batch.process.HeaderSDFProcessor;
import com.acsp.cic.batch.process.IndividualSDFProcessor;
import com.acsp.cic.batch.process.SDFProcessor;
import com.acsp.cic.batch.process.ftp.ActivateFTPTransfer;
import com.acsp.cic.batch.utilities.CombineData;
import com.acsp.cic.batch.utilities.ConvertToZipFile;

/**
 * Created by elaguardia on 04/07/2016.
 */
@Service
public class SDFExecutor {

	
	List<SDFProcessor> sDFProcessorList = new ArrayList<SDFProcessor>();
	
	@Autowired
	IndividualSDFProcessor individualSDFProcessor;
	
	@Autowired
	HeaderSDFProcessor headerSDFProcessor;
	
	@Autowired
	FooterSDFProcessor footerSDFProcessor;
	
	@Autowired
	InstallmentSDFProcessor installmentSDFProcessor;
	
	@Autowired
	CombineData combineData;
	
	@Autowired
	ConvertToZipFile convertToZipFile;
	
	@Autowired
	ActivateFTPTransfer activateFTPTransfer;
	
	@Autowired
	EncryptFile encryptFile;
	
	
	
	public void init() {
		
		sDFProcessorList.add(headerSDFProcessor);
		sDFProcessorList.add(individualSDFProcessor);
		sDFProcessorList.add(installmentSDFProcessor);
		sDFProcessorList.add(footerSDFProcessor);
		
	}
	
	public void execute() {
		
		PrintInfoDTO printInfoDTO = new PrintInfoDTO();
		
		for(SDFProcessor sDFProcessor: sDFProcessorList ) {
			printInfoDTO.setIsIndividualRecord(sDFProcessor == individualSDFProcessor);
			printInfoDTO.setIsInstallmentRecord(sDFProcessor == installmentSDFProcessor);
			printInfoDTO.setIsFooterRecord(sDFProcessor == footerSDFProcessor);
			printInfoDTO.setIsHeaderRecord(sDFProcessor == headerSDFProcessor);
			sDFProcessor.process(printInfoDTO);
		}
	}

	public void combineData() throws Exception {
	   System.out.println("------Start of Combine Data!-----------");

	   String filename = convertToZipFile.zipFile(combineData.MergeFiles()); 
	  
	   //File gpgFile = encryptFile.encryptFile(filename);
	   
	   //activateFTPTransfer.transferFileToFTP(gpgFile);
	   
	}
	
}
