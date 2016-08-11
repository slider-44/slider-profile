package com.acsp.salesprocess.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.salesprocess.dto.SalesProcessRequestDTO;
import com.acsp.salesprocess.dto.SalesProcessResponseDTO;
import com.acsp.salesprocess.service.SalesProcessService;

@RestController
public class SalesProcessController {

	private static final Logger logger = LoggerFactory.getLogger(SalesProcessController.class);
	
	@Autowired
	SalesProcessService salesProcessService;
	
	
	@RequestMapping(path="", method = RequestMethod.POST)
	public SalesProcessResponseDTO performSalesProcess(@Validated SalesProcessRequestDTO requestDTO) {
		
		logger.debug(requestDTO.toString());
		
		SalesProcessResponseDTO responseDTO = salesProcessService.performSalesProcess(requestDTO);
		
		return responseDTO;
	}
	
	@ExceptionHandler(BindException.class)
	public BaseResponseDTO bindException(BindException ex) {

	    BaseResponseDTO responseDTO = new BaseResponseDTO();
	
	    responseDTO.setResponseSuccess(false);
	    responseDTO.setResponseMessage("Error in input.");
	
	    responseDTO.addFieldErrors(ex.getFieldErrors());
	
	    logger.error("Error in controller", ex);
	
	    return responseDTO;
	}
	
	@ExceptionHandler(Exception.class)
	public BaseResponseDTO exception(Exception ex) {

		BaseResponseDTO responseDTO = new BaseResponseDTO();

		responseDTO.setResponseSuccess(false);
		responseDTO.setResponseMessage(ex.getMessage());

		logger.error("Error in controller", ex);

		return responseDTO;

	}
	
}
