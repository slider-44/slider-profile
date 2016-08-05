package com.acsp.cic.batch.process.ftp;

import org.apache.camel.builder.RouteBuilder;

public class FtpRouteBuilder extends RouteBuilder {
	
 @Override
    public void configure() throws Exception {
    
        from("file:C:/Users/elaguardia/Documents/ISD/CIC/result/")
        .to("ftps://AEON9ENL@ftps-test.creditinfo.com.ph//Submission/Input?password=secret&passiveMode=true");
        
   
    }

}
