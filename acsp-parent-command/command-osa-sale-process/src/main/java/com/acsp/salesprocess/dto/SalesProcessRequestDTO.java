package com.acsp.salesprocess.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class SalesProcessRequestDTO {

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private DateTime claimDate;

  @NotEmpty
  private String remarks;

  @NotEmpty
  private String applicationCd;

  @NotEmpty
  private String currentUser;

  private String storeCd;

  public DateTime getClaimDate() {

    return claimDate;
  }

  public void setClaimDate(DateTime claimDate) {

    this.claimDate = claimDate;
  }

  public String getRemarks() {

    return remarks;
  }

  public void setRemarks(String remarks) {

    this.remarks = remarks;
  }

  public String getApplicationCd() {

    return applicationCd;
  }

  public void setApplicationCd(String applicationCd) {

    this.applicationCd = applicationCd;
  }

  public String getCurrentUser() {

    return currentUser;
  }

  public void setCurrentUser(String currentUser) {

    this.currentUser = currentUser;
  }


  public String getStoreCd() {

    return storeCd;
  }


  public void setStoreCd(String storeCd) {

    this.storeCd = storeCd;
  }

  @Override
  public String toString() {

    return "SalesProcessRequestDTO [claimDate=" + claimDate + ", remarks=" + remarks
           + ", applicationCd="
           + applicationCd + ", currentUser=" + currentUser + "]";
  }

}
