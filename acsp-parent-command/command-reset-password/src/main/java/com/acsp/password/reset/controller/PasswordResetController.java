package com.acsp.password.reset.controller;


import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.common.security.ACSPUser;
import com.acsp.password.reset.dto.SavePasswordDTO;
import com.acsp.password.reset.service.PasswordResetService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordResetController {

  private static final Logger logger = LoggerFactory.getLogger(PasswordResetController.class);
  
  @Autowired
  PasswordResetService passwordResetService;


  @RequestMapping(path = "", method = RequestMethod.POST)
  public BaseResponseDTO save(@RequestBody SavePasswordDTO savePasswordDTO,
                              @AuthenticationPrincipal ACSPUser acspUser) {

    return passwordResetService.save(savePasswordDTO, acspUser);
  }
  
  

  @ExceptionHandler(Exception.class)
  public BaseResponseDTO error(Exception ex) {

    BaseResponseDTO responseDTO = new BaseResponseDTO();
    responseDTO.setResponseSuccess(false);
    responseDTO.setResponseMessage(ex.getMessage());
    
    logger.error("Error in controller.", ex);

    return responseDTO;
  }


}
