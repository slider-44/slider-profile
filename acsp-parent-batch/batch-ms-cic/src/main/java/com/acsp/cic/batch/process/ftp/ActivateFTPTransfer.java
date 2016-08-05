package com.acsp.cic.batch.process.ftp;

import java.io.File;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivateFTPTransfer {
	
	@Autowired
	FtpProperties ftpProperties;
	
	@Autowired
	FtpSender ftpSender;
	
	public void transferFileToFTP(File file) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		ProducerTemplate template = camelContext.createProducerTemplate();
		
		try {
	        //camelContext.addRoutes(new FtpRouteBuilder());
	        camelContext.start();
	        
	        ftpSender.sendFile(ftpProperties, file,template);
	    }
	    finally {
	        camelContext.stop();
	    }
	}
}
