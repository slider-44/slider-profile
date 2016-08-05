package com.acsp.common.dto;

public class OsaBaseResponseDTO extends BaseResponseDTO {

  private String uploaderName;

  public OsaBaseResponseDTO(String uploaderName) {
    super();
    this.uploaderName = uploaderName;
  }

  public String getUploaderName() {

    return uploaderName;
  }

  public void setUploaderName(String uploaderName) {

    this.uploaderName = uploaderName;
  }

}