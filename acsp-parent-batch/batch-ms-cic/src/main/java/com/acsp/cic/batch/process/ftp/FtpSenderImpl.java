package com.acsp.cic.batch.process.ftp;

import java.io.File;
import java.text.MessageFormat;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
public class FtpSenderImpl implements FtpSender {
	
	/** Camel URI, format is ftp://user@host/fileName?password=secret&passiveMode=true */
	private static final String CAMEL_FTP_PATTERN = "{0}://{1}@{2}/{3}?password={4}&passiveMode={5}";


	@Override
	public void sendFile(FtpProperties ftpProperties, File file, ProducerTemplate producerTemplate) throws RuntimeException {
		
	
		producerTemplate.sendBodyAndHeader(createFtpUri(ftpProperties), file, Exchange.FILE_NAME, file.getName());

	}
	
	/**
     * Creates a Camel FTP URI based on the provided FTP properties
     * @param ftpProperties The properties to be used
     */
   private String createFtpUri(FtpProperties ftpProperties) {
       return MessageFormat.format(CAMEL_FTP_PATTERN,
               ftpProperties.getProtocol(),
               ftpProperties.getUserName(),
               ftpProperties.getHost(),
               ftpProperties.getRemoteDirectory(),
               ftpProperties.getPassword(),
               ftpProperties.getPassiveMode());
   }

}
