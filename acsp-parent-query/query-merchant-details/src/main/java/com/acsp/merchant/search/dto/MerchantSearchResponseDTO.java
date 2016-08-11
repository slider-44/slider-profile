package com.acsp.merchant.search.dto;

import java.util.List;

import com.acsp.common.dto.BaseResponseDTO;

public class MerchantSearchResponseDTO extends BaseResponseDTO{

 List<MerchantDTO> results;

  
  public List<MerchantDTO> getResults() {
  
    return results;
  }

  
  public void setResults(List<MerchantDTO> results) {
  
    this.results = results;
  }
}
