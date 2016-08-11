package com.acsp.customerservice.search.service;

import com.acsp.customerservice.search.dto.SearchDTO;

import org.joda.time.DateTime;

import java.util.List;

public interface CustomerSearchService {

  List<SearchDTO> search(String firstName,
                         String surName,
                         DateTime birthDay,
                         String telNo,
                         String appCd,
                         String agreementCd);

}
