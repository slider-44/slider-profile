package com.acsp.email.checkerservice.dto;

import java.util.List;

import com.acsp.common.dto.BaseResponseDTO;

public class SmsResponseDto extends BaseResponseDTO{

	private String message;
	private String subject;
	private List<Sms> smsList;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Sms> getSmsList() {
		return smsList;
	}

	public void setSmsList(List<Sms> smsList) {
		this.smsList = smsList;
	}

}
