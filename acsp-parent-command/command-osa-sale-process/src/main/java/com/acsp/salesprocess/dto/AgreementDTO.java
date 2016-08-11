package com.acsp.salesprocess.dto;

import static com.acsp.core.rs.db.tables.TAgreement.T_AGREEMENT;

import com.acsp.common.dto.BaseDTO;

public class AgreementDTO extends BaseDTO {

  String applicationCd;

  String agreementCd;

  Byte agreementType;

  String sysAppCd;

  Integer agreementDate;

  Integer agreementReceivedDate;

  Integer saleDate;

  Byte agreementStatus;

  Byte chargeFlag;

  String customerCd;

  String peopleCd;

  Byte peopleFlag;

  String storeName;

  String storeTelDistrict;

  String storeTel;

  String storePic;

  String storeCd;

  String comments;

  Byte delFlag;

  String crePerson;

  Integer creDate;

  Integer creTime;

  Integer updCnt;

  String agentCd;

  String agentName;

  String merchantStaff;

  String merchantStamp;

  Integer aeonStaffDateReceived;


  public String getAgreementCd() {

    return agreementCd;
  }


  public void setAgreementCd(String agreementCd) {

    this.agreementCd = agreementCd;
  }


  public Byte getAgreementType() {

    return agreementType;
  }


  public void setAgreementType(Byte agreementType) {

    this.agreementType = agreementType;
  }


  public String getSysAppCd() {

    return sysAppCd;
  }


  public void setSysAppCd(String sysAppCd) {

    this.sysAppCd = sysAppCd;
  }


  public Integer getAgreementDate() {

    return agreementDate;
  }


  public void setAgreementDate(Integer agreementDate) {

    this.agreementDate = agreementDate;
  }


  public Integer getAgreementReceivedDate() {

    return agreementReceivedDate;
  }


  public void setAgreementReceivedDate(Integer agreementReceivedDate) {

    this.agreementReceivedDate = agreementReceivedDate;
  }


  public Integer getSaleDate() {

    return saleDate;
  }


  public void setSaleDate(Integer saleDate) {

    this.saleDate = saleDate;
  }


  public Byte getAgreementStatus() {

    return agreementStatus;
  }


  public void setAgreementStatus(Byte agreementStatus) {

    this.agreementStatus = agreementStatus;
  }


  public Byte getChargeFlag() {

    return chargeFlag;
  }


  public void setChargeFlag(Byte chargeFlag) {

    this.chargeFlag = chargeFlag;
  }


  public String getCustomerCd() {

    return customerCd;
  }


  public void setCustomerCd(String customerCd) {

    this.customerCd = customerCd;
  }


  public String getPeopleCd() {

    return peopleCd;
  }


  public void setPeopleCd(String peopleCd) {

    this.peopleCd = peopleCd;
  }


  public Byte getPeopleFlag() {

    return peopleFlag;
  }


  public void setPeopleFlag(Byte peopleFlag) {

    this.peopleFlag = peopleFlag;
  }


  public String getStoreName() {

    return storeName;
  }


  public void setStoreName(String storeName) {

    this.storeName = storeName;
  }


  public String getStoreTelDistrict() {

    return storeTelDistrict;
  }


  public void setStoreTelDistrict(String storeTelDistrict) {

    this.storeTelDistrict = storeTelDistrict;
  }


  public String getStoreTel() {

    return storeTel;
  }


  public void setStoreTel(String storeTel) {

    this.storeTel = storeTel;
  }


  public String getStorePic() {

    return storePic;
  }


  public void setStorePic(String storePic) {

    this.storePic = storePic;
  }


  public String getStoreCd() {

    return storeCd;
  }


  public void setStoreCd(String storeCd) {

    this.storeCd = storeCd;
  }


  public String getComments() {

    return comments;
  }


  public void setComments(String comments) {

    this.comments = comments;
  }


  public Byte getDelFlag() {

    return delFlag;
  }


  public void setDelFlag(Byte delFlag) {

    this.delFlag = delFlag;
  }


  public String getCrePerson() {

    return crePerson;
  }


  public void setCrePerson(String crePerson) {

    this.crePerson = crePerson;
  }


  public Integer getCreDate() {

    return creDate;
  }


  public void setCreDate(Integer creDate) {

    this.creDate = creDate;
  }


  public Integer getCreTime() {

    return creTime;
  }


  public void setCreTime(Integer creTime) {

    this.creTime = creTime;
  }


  public Integer getUpdCnt() {

    return updCnt;
  }


  public void setUpdCnt(Integer updCnt) {

    this.updCnt = updCnt;
  }


  public String getAgentCd() {

    return agentCd;
  }


  public void setAgentCd(String agentCd) {

    this.agentCd = agentCd;
  }


  public String getAgentName() {

    return agentName;
  }


  public void setAgentName(String agentName) {

    this.agentName = agentName;
  }


  public String getMerchantStaff() {

    return merchantStaff;
  }


  public void setMerchantStaff(String merchantStaff) {

    this.merchantStaff = merchantStaff;
  }


  public String getMerchantStamp() {

    return merchantStamp;
  }


  public void setMerchantStamp(String merchantStamp) {

    this.merchantStamp = merchantStamp;
  }


  public Integer getAeonStaffDateReceived() {

    return aeonStaffDateReceived;
  }


  public void setAeonStaffDateReceived(Integer aeonStaffDateReceived) {

    this.aeonStaffDateReceived = aeonStaffDateReceived;
  }

  public String getApplicationCd() {

    return applicationCd;
  }

  public void setApplicationCd(String applicationCd) {

    this.applicationCd = applicationCd;
  }

}
