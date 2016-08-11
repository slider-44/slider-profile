package com.acsp.salesprocess.dto;

import com.acsp.common.dto.BaseDTO;

public class CustomerDTO extends BaseDTO {

  String customerCd;

  Byte idNo;

  Byte idCardType;

  String idCardNo;

  Byte primaryStatus;

  Byte origPrimaryStatus;

  public String getCustomerCd() {

    return customerCd;
  }

  public void setCustomerCd(String customerCd) {

    this.customerCd = customerCd;
  }

  public Byte getIdNo() {

    return idNo;
  }

  public void setIdNo(Byte idNo) {

    this.idNo = idNo;
  }

  public Byte getIdCardType() {

    return idCardType;
  }

  public void setIdCardType(Byte idCardType) {

    this.idCardType = idCardType;
  }

  public String getIdCardNo() {

    return idCardNo;
  }

  public void setIdCardNo(String idCardNo) {

    this.idCardNo = idCardNo;
  }


  public Byte getPrimaryStatus() {

    return primaryStatus;
  }


  public void setPrimaryStatus(Byte primaryStatus) {

    this.primaryStatus = primaryStatus;
  }


  public Byte getOrigPrimaryStatus() {

    return origPrimaryStatus;
  }


  public void setOrigPrimaryStatus(Byte origPrimaryStatus) {

    this.origPrimaryStatus = origPrimaryStatus;
  }


}
