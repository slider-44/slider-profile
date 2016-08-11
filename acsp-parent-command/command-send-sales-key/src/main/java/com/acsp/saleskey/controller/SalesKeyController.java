package com.acsp.saleskey.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.saleskey.dto.SalesKeyDTO;

@RestController
public class SalesKeyController {
	
	private static final Logger logger = LoggerFactory.getLogger(SalesKeyController.class);

	@RequestMapping(path="", method=RequestMethod.POST)
	public BaseResponseDTO sendSales(SalesKeyDTO salesKeyDTO){
		
		BaseResponseDTO responseDTO = new BaseResponseDTO();
		
		logger.debug(salesKeyDTO.toString());
		
		return responseDTO;
	}

}