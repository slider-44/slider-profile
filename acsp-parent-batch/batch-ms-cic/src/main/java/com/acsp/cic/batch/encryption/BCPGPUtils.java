package com.acsp.cic.batch.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.springframework.stereotype.Component;

/*
 * Read and import public ket from asc file
 * 
 * */
@Component
public class BCPGPUtils {

	@SuppressWarnings({ "rawtypes", "resource" })
	public PGPPublicKey readPublicKey(String publicKeyFilePath) 
			throws IOException, PGPException {
		
		InputStream in = new FileInputStream(new File(publicKeyFilePath));
		
		in = PGPUtil.getDecoderStream(in);
	
		PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(in);
		
		PGPPublicKey key = null;
		Iterator rIt = pgpPub.getKeyRings();
		
		while (key == null && rIt.hasNext()) {
			
			PGPPublicKeyRing kRing = (PGPPublicKeyRing) rIt.next();
			
			Iterator kIt = kRing.getPublicKeys();
			
			while (key == null && kIt.hasNext()) {
				
				PGPPublicKey k = (PGPPublicKey) kIt.next();
				if (k.isEncryptionKey()) {
					key = k;
				}
			}
		
		}
		
		
		if (key == null) {
			throw new IllegalArgumentException(
					"Can't find encryption key in key ring.");
		}
		
		return key;
		
	}
}
