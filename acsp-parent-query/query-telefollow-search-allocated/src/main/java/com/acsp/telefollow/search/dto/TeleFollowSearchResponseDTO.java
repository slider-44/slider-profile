package com.acsp.telefollow.search.dto;

import com.acsp.common.dto.BaseResponseDTO;

import java.util.List;


public class TeleFollowSearchResponseDTO extends BaseResponseDTO {

  List<TeleFollowDTO> results;

  
  public List<TeleFollowDTO> getResults() {
  
    return results;
  }

  
  public void setResults(List<TeleFollowDTO> results) {
  
    this.results = results;
  }
  
}
