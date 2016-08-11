package com.acsp.customerservice.search.controller;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.customerservice.search.dto.CustomerSearchResponseDTO;
import com.acsp.customerservice.search.service.CustomerSearchService;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchRestController {

  private static final Logger logger = LoggerFactory.getLogger(SearchRestController.class);
  
  @Autowired
  private CustomerSearchService customerSearchService;


  @RequestMapping(path = "", method = RequestMethod.GET)
  public CustomerSearchResponseDTO search(@RequestParam(value = "firstName", required = false) String firstName,
                                          @RequestParam(value = "lastName", required = false) String surName,
                                          @RequestParam(value = "birthDay", required = false) @DateTimeFormat(iso = ISO.DATE_TIME) DateTime birthDay,
                                          @RequestParam(value = "telNo", required = false) String telNo,
                                          @RequestParam(value = "appCd", required = false) String appCd,
                                          @RequestParam(value = "agreementCd", required = false) String agreementCd) {

    CustomerSearchResponseDTO responseDTO = new CustomerSearchResponseDTO();
    responseDTO.setResponseSuccess(true);
    
    responseDTO.setResults(customerSearchService.search(firstName,
                                                        surName,
                                                        birthDay,
                                                        telNo,
                                                        appCd,
                                                        agreementCd));
    
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
