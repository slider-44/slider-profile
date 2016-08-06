package com.acsp.merchant.bank.save.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.common.security.ACSPUser;
import com.acsp.merchant.bank.save.dto.MerchantBankSaveDTO;
import com.acsp.merchant.bank.save.service.MerchantBankSaveService;

/**
 * Created by elaguardia on 06/28/2016.
 */
@RestController
public class MerchantBankController {
	
	 private static final Logger logger = LoggerFactory.getLogger(MerchantBankController.class);
	 
	 @Autowired
	 MerchantBankSaveService merchantBankSaveService;
	 
	 @RequestMapping(path = "", method = RequestMethod.POST)
	 public BaseResponseDTO save(@RequestBody MerchantBankSaveDTO merchantBankSaveDTO,
			 	@AuthenticationPrincipal ACSPUser acspUser) {
		 
		 merchantBankSaveService.save(merchantBankSaveDTO, acspUser);
		 
		 BaseResponseDTO responseDTO = new BaseResponseDTO();
		 responseDTO.setResponseSuccess(true);

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
