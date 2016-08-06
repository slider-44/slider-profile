package com.acsp.overpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.common.security.ACSPUser;
import com.acsp.overpayment.dto.Overpayment;
import com.acsp.overpayment.service.OverpaymentUpdate;

@RestController
public class OverpaymentUpdateController {
	
	@Autowired
	private OverpaymentUpdate overPaymentUpdate;
	
	@RequestMapping(value="updateoverpayment", method=RequestMethod.POST)
	public BaseResponseDTO updateOverpayment(@Validated @RequestBody Overpayment overPaymentDTO,
			@AuthenticationPrincipal ACSPUser acspUser){
		
		overPaymentUpdate.updateOverpyament(overPaymentDTO);

	    BaseResponseDTO responseDTO = new BaseResponseDTO();
	    responseDTO.setResponseSuccess(true);
		
		return responseDTO;
		
	}
	
	
	
}
