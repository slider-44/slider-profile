package com.acsp.cic.batch.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by elaguardia on 04/07/2016.
 */

@Component
public class ConvertToZipFile {

	@Value("${cic.location}")
	private String location;
	
	public String zipFile(String filename) {
		
		
		File file = new File(location + filename);
		//substring file name to remove .txt extension on the the zip file name
		String zipFilepath = location + filename.substring(0,filename.length() - 4) + ".zip";
		//File zipFileName = new File(zipFilepath);
		
		try {
			
			
			FileOutputStream fileOutputStream = new FileOutputStream(zipFilepath);
			ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

			//ZipEntry after the original file's name
			ZipEntry zipEntry = new ZipEntry(file.getName());
			zipOutputStream.putNextEntry(zipEntry);
			
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] buf = new byte[1024];
			int bytesRead;

			// Read the input file by chucks of 1024 bytes
			// and write the read bytes to the zip stream
			while ((bytesRead = fileInputStream.read(buf)) > 0) {
				zipOutputStream.write(buf, 0, bytesRead);

			}
			
			// close ZipEntry to store the stream to the file
			zipOutputStream.closeEntry();
			zipOutputStream.close();
			fileOutputStream.close();
			fileInputStream.close();

			System.out.println("Regular file :" + file.getCanonicalPath()+" is zipped to archive :"+ zipFilepath);

			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return zipFilepath;
		
	}
	
	
}
