package com.acsp.customerservice.search.repository;

import com.acsp.customerservice.search.dto.SearchDTO;

import org.jooq.Condition;

import java.util.List;

public interface CustomerServiceRepository {

  
  List<SearchDTO> getCustomerList(Condition condition);
  
}
