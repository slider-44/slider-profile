package com.acsp.cic.batch.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import org.apache.commons.io.IOUtils;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BGPEncryption {
	
	private String publicKeyFilePath;
	
	private PGPPublicKey publicKey;
	
	private PGPEncryptedDataGenerator pedg;
	
	private boolean checkIntegrity;
	
	private boolean isArmored;

	@Autowired
	BCPGPUtils bCPGPUtils;
	
	public String getPublicKeyFilePath() {
		return publicKeyFilePath;
	}

	public void setPublicKeyFilePath(String publicKeyFilePath)
			throws IOException, PGPException {
		this.publicKeyFilePath = publicKeyFilePath;
		publicKey = bCPGPUtils.readPublicKey(publicKeyFilePath);
	}
	
	public boolean isCheckIntegrity() {
		return checkIntegrity;
	}

	public void setCheckIntegrity(boolean checkIntegrity) {
		this.checkIntegrity = checkIntegrity;
	}
	
	public boolean isArmored() {
		return isArmored;
	}

	public void setArmored(boolean isArmored) {
		this.isArmored = isArmored;
	}
	

	public void encryptFile(File inputFile, File outputFile) 
			throws PGPException, IOException, PGPException, NoSuchProviderException  {
	
		if (pedg == null) {
			
			pedg = new PGPEncryptedDataGenerator(PGPEncryptedData.CAST5,
					checkIntegrity, new SecureRandom(), "BC");
			
			try {
				pedg.addMethod(publicKey);
			} catch (PGPException e) {
				throw new PGPException (
						"Error when creating PGP encryptino data generator.");
			}
		}
		
		OutputStream fileOutStream = new FileOutputStream(outputFile);
		
		
		if (isArmored) {
			fileOutStream = new ArmoredOutputStream(fileOutStream);
		}
		
		OutputStream encryptdOutStream = pedg.open(fileOutStream, new byte[1 << 16]);
		
		
		PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator( PGPCompressedData.ZIP);
		OutputStream compressedOutStream = comData.open(encryptdOutStream);
	
		PGPLiteralDataGenerator lg= new PGPLiteralDataGenerator();
		OutputStream literalDataOutStream = lg.open(compressedOutStream, PGPLiteralData.BINARY, inputFile);
		
		byte[] bytes = IOUtils.toByteArray(new FileInputStream(inputFile));
		
		literalDataOutStream.write(bytes);
		
		literalDataOutStream.close();
		
		lg.close();
		compressedOutStream.close();
		comData.close();
		pedg.close();
		fileOutStream.close();
		
		
	}
	
	
}
