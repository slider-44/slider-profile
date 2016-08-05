package com.acsp.cic.batch.encryption;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EncryptFile {
	
	
	@Value("${cic.location}")
	private String location;
	
	@Value("${cic.key}")
	private String key;
	
	@Autowired
	BGPEncryption bGPEncryption;
	
	public File encryptFile(String inputFilePath)
			throws NoSuchProviderException, PGPException, IOException{
		
		//gpg output file
		String outputFilePath = inputFilePath + ".gpg";
		
		File inputFile = new File(inputFilePath);
		File outputFile = new File(outputFilePath);
		
		String keyPath = location + key;
		
		Security.addProvider(new BouncyCastleProvider());
		
		bGPEncryption.setArmored(false);
		bGPEncryption.setCheckIntegrity(true);
		bGPEncryption.setPublicKeyFilePath(keyPath);
		bGPEncryption.encryptFile(inputFile, outputFile);
		
		return outputFile;
	}

}
