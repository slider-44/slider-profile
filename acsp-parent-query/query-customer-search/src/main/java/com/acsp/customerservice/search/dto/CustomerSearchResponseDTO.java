package com.acsp.customerservice.search.dto;

import com.acsp.common.dto.BaseResponseDTO;

import java.util.List;


public class CustomerSearchResponseDTO extends BaseResponseDTO {

  List<SearchDTO> results;

  
  public List<SearchDTO> getResults() {
  
    return results;
  }

  
  public void setResults(List<SearchDTO> results) {
  
    this.results = results;
  }
  
}
