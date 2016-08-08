package com.acsp.email.checkerservice.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.email.checkerservice.dto.SmsResponseDto;

@FeignClient("utils-sms")
public interface SmsService {

	@RequestMapping(method = RequestMethod.POST, value = "/sendSMS", consumes = "application/json")
	public BaseResponseDTO createSMSFile(SmsResponseDto smsResponseDto);
	
}
