package com.acsp.email.checkerservice.service;

import com.acsp.email.checkerservice.dto.EmailCheckerDto;
import com.acsp.email.checkerservice.dto.SmsResponseDto;

public interface EmailCheckerService {

	SmsResponseDto checkEmailSMS(EmailCheckerDto checkerDTO);
	
}
