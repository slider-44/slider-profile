package com.acsp.email.checkerservice.batch;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.common.util.DateTimeUtil;
import com.acsp.email.checkerservice.dto.EmailCheckerDto;
import com.acsp.email.checkerservice.dto.SmsResponseDto;
import com.acsp.email.checkerservice.service.EmailCheckerServiceImpl;
import com.acsp.email.checkerservice.service.SmsService;

@Component
public class EmailCheckerBatch {

	private static final Logger logger = LoggerFactory.getLogger(EmailCheckerBatch.class);
	
	@Autowired
	EmailCheckerServiceImpl emailCheckerService;

	@Autowired
	SmsService smsService;

	@Scheduled(cron = "${sms.schedule.cron}")
	public void runBatch() {

		EmailCheckerDto checkerDTO = createCheckerDTO ();

		SmsResponseDto smsResponseDto = emailCheckerService.checkEmailSMS(checkerDTO);

		if(smsResponseDto.isResponseSuccess()) {
		
			sendSMS(smsResponseDto);
			
		} else {
			
			logger.info("No Successful Payment Advice email sent on " + checkerDTO.getDate());
			
		}

	}

	
	private void sendSMS(SmsResponseDto smsResponseDto){
		
		BaseResponseDTO smsResponse;
		
		try {
			
			smsResponse = smsService.createSMSFile(smsResponseDto);
			
		} catch (Exception ex) {
			
			logger.error("Error in communicating with SMS service.", ex);

			return;
		}
		
		if(smsResponse != null) {
			
			if(smsResponse.isResponseSuccess()){
				
				logger.info("Successful sent " + smsResponseDto.getSmsList().size() + " SMS.");
				
			} else {
				
				logger.error("Error in sending SMS. " + smsResponse.getResponseMessage());
				
			}
		}
	}
	
	private EmailCheckerDto createCheckerDTO () {
		EmailCheckerDto checkerDTO = new EmailCheckerDto();

		checkerDTO.setDate(getDateWithOffset(-1));
		
		return checkerDTO;
	}
	

	private String getDateWithOffset(int daysOffSet) {

		DateTime date = new DateTime();

		if (daysOffSet > 0) {
			date = date.plusDays(daysOffSet);
		} else if (daysOffSet < 0) {
			date = date.minusDays(Math.abs(daysOffSet));
		}

		Integer modifiedDate = DateTimeUtil.getDatePart(date);

		return modifiedDate.toString();

	}
}
