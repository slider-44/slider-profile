package com.acsp.merchant.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.merchant.search.dto.MerchantSearchResponseDTO;
import com.acsp.merchant.search.service.MerchantSearch;

@RestController
public class MerchantRestController {

	private static final Logger logger = LoggerFactory.getLogger(MerchantRestController.class);
	
	@Autowired
	MerchantSearch merchantSearch;
	
	@RequestMapping(value="" , method = RequestMethod.GET)
	public MerchantSearchResponseDTO search() {
		 
		MerchantSearchResponseDTO responseDTO = new MerchantSearchResponseDTO();
		responseDTO.setResponseSuccess(true);
		 
		responseDTO.setResults(merchantSearch.search());
		
		return responseDTO;
	}
	
	 public BaseResponseDTO exception(Exception ex) {

	    BaseResponseDTO responseDTO = new BaseResponseDTO();

	    responseDTO.setResponseSuccess(false);
	    responseDTO.setResponseMessage(ex.getMessage());

	    logger.error("Error in controller", ex);

	    return responseDTO;

	}
	
}
