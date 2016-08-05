package com.acsp.cic.batch.process.ftp;

import org.springframework.stereotype.Component;

@Component
public class FtpPropertiesImpl implements FtpProperties {

	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return "ftps";
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return "AEON9ENL";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "9-wk$zJp";
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return "ftp-test.creditinfo.com.ph";
	}

	@Override
	public String getRemoteDirectory() {
		// TODO Auto-generated method stub
		return "/Submission/Input";
	}

	@Override
	public boolean getPassiveMode() {
		// TODO Auto-generated method stub
		return true;
	}

}
