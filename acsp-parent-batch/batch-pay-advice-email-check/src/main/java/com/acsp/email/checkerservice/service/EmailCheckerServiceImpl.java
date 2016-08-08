package com.acsp.email.checkerservice.service;

import static com.acsp.core.rs.db.tables.TEmailDetails.T_EMAIL_DETAILS;

import java.util.List;
import java.util.stream.Collectors;

import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.acsp.email.checkerservice.dto.EmailCheckerDto;
import com.acsp.email.checkerservice.dto.Sms;
import com.acsp.email.checkerservice.dto.SmsResponseDto;
import com.acsp.email.checkerservice.repository.EmailCheckerRepository;


@Service
public class EmailCheckerServiceImpl implements EmailCheckerService {

	@Autowired
	EmailCheckerRepository checkerRepository;
	
	@Value("${sms.template.message.email-notification}")
	String message;
	
	@Value("${sms.template.message.subject}")
	String subject;
	
	public SmsResponseDto checkEmailSMS(EmailCheckerDto checkerDTO){
		
		SmsResponseDto responseDTO = new SmsResponseDto();

		List<Record> result = checkerRepository.searchSMSQuery(checkerDTO);
		
		if(result == null || result.isEmpty()) {
			
			responseDTO.setResponseSuccess(false);
			responseDTO.setResponseMessage("No data found. " + checkerDTO);
			
		} else {
				
			List<Sms> smsList = result.stream().map(record->{
				
				Sms sms = new Sms();
				sms.setMobileNO(record.getValue(T_EMAIL_DETAILS.MOBILE_NO));
				sms.setAgreementCD(record.getValue(T_EMAIL_DETAILS.AGREEMENTCD));
				
				return sms;
				
			}).collect(Collectors.toList());
			
			responseDTO.setMessage(message);
			responseDTO.setSubject(subject);
			responseDTO.setSmsList(smsList);
			responseDTO.setResponseSuccess(true);
			
		}

		return responseDTO;
		
	}
}
