package com.acsp.cic.batch.process.ftp;

import java.io.File;

import org.apache.camel.ProducerTemplate;

public interface FtpSender {
	  /**
     * Uses the {@code ftpProperties} to transmit the provided {@code file} to a remote server
     *
     * @param ftpProperties The FTP properties of the remote server
     * @param file The file to transmit
     */

	void sendFile(FtpProperties ftpProperties, File file, ProducerTemplate producerTemplate) throws RuntimeException;
}
