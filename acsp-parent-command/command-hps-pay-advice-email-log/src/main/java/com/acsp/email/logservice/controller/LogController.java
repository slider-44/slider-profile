package com.acsp.email.logservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.email.logservice.dto.EmailLogDTO;
import com.acsp.email.logservice.service.LogService;

/**
 * @author jfajardo
 *	2016/04/27
 */
@RestController
public class LogController {

	private static final Logger logger = LoggerFactory.getLogger(LogController.class);
	
	@Autowired
	LogService logService;
	
	@RequestMapping(value="/log", method=RequestMethod.POST)
	public BaseResponseDTO executeLog(@RequestBody EmailLogDTO emailLogDTO) {
		
		return logService.executeLog(emailLogDTO);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public BaseResponseDTO exception(Exception e) {
		
		BaseResponseDTO responseDTO = new BaseResponseDTO();
		
		responseDTO.setResponseSuccess(false);
		responseDTO.setResponseMessage(e.getMessage());
		
		logger.error("Error in controller",e);
		
		return responseDTO;
		
	}
	
}
