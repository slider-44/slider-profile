package com.acsp.telefollow.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.common.security.ACSPUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acsp.telefollow.search.dto.TeleFollowSearchResponseDTO;
import com.acsp.telefollow.search.service.TelefollowSearch;

@RestController
public class TeleFollowRestController {

	 private static final Logger logger = LoggerFactory.getLogger(TeleFollowRestController.class);
	 
	 @Autowired
	 TelefollowSearch telefollowNewAllocatedSearch;
	 
	 @RequestMapping(value="" , method = RequestMethod.GET)
	 public TeleFollowSearchResponseDTO search(@AuthenticationPrincipal ACSPUser acspUser, @RequestParam("allocated") String allocated) {
		 
		 TeleFollowSearchResponseDTO responseDTO = new TeleFollowSearchResponseDTO();
		 responseDTO.setResponseSuccess(true);
		 
		 responseDTO.setResults(telefollowNewAllocatedSearch.search(acspUser,allocated));
		
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
