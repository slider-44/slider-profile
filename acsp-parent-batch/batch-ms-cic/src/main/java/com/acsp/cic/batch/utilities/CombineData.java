package com.acsp.cic.batch.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by elaguardia on 04/07/2016.
 */

@Component
public class CombineData {
	
	@Value("${cic.location}")
	private String location;
	
	@Value("${cic.providercode}")
	private String providercode;
	
	@Value("${cic.filename}")
	private String dataname;
	
	
	public String MergeFiles() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String time  = dateFormat.format(new Date());
		
		//List of Files to merge
		//String []filename={"HD.txt","ID.txt", "CI.txt", "FT.txt"};
		
		String []filename={"HD.txt","CI.txt", "FT.txt"};
		
		//String []filename={"HD.txt","FT.txt"};
		File[] filesToMerge = new File[filename.length];
		
		//merged file location
		String mergedFilePath = location  + providercode + dataname + time + ".txt";
		File mergedFile = new File(mergedFilePath);
		
		 for(int i=0;i<filename.length;i++) {
			 filesToMerge[i] = new File(location + filename[i]);
		 }
		 
		 System.out.println("START : " + time);
		 mergeFiles(filesToMerge,mergedFile);
		 
		 return mergedFile.getName();
	}
	

	
	
	private void mergeFiles(File[] filesToMerge, File mergedFile) {
		FileWriter fstream = null;
		BufferedWriter out = null;
		
		
		try {
			 fstream = new FileWriter(mergedFile, true);
			 out = new BufferedWriter(fstream);
			 
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for (File f:  filesToMerge) {
			System.out.println("merging: " + f.getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
				
				String aLine;
				while ((aLine = in.readLine()) != null) {
					out.write(aLine);
					out.newLine();
				}
				in.close();
				
				if(f.delete()){
	    			System.out.println(f.getName() + " is deleted!");
	    		}else{
	    			System.out.println("Delete operation failed.");
	    		}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			out.close();
			System.out.println(mergedFile.getName() + " is created!");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
