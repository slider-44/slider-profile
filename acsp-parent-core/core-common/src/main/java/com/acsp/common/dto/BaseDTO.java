package com.acsp.common.dto;

import java.util.Date;

import com.acsp.common.util.DateTimeUtil;

public class BaseDTO {

  Integer creDate;
  
  Integer creTime;
  
  String crePerson;
  
  Integer updDate;
  
  Integer updTime;
  
  String updPerson;
  
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

  public String getCrePerson() {
  
    return crePerson;
  }
  
  public void setCrePerson(String crePerson) {
  
    this.crePerson = crePerson;
  }

  
  public Integer getUpdDate() {
  
    return updDate;
  }

  
  public void setUpdDate(Integer updDate) {
  
    this.updDate = updDate;
  }
  
  public Integer getUpdTime() {
  
    return updTime;
  }

  
  public void setUpdTime(Integer updTime) {
  
    this.updTime = updTime;
  }

  
  public String getUpdPerson() {
  
    return updPerson;
  }

  
  public void setUpdPerson(String updPerson) {
  
    this.updPerson = updPerson;
  }
  
  public void updateUpdTimestamp(String userId){
    Date currentDate = DateTimeUtil.getCurrentSqlDate();
    this.updDate = DateTimeUtil.getDatePart(currentDate);
    this.updTime = DateTimeUtil.getTimePart(currentDate);
    this.updPerson = userId;
  }
  
  public void updateCreTimestamp(String userId){
    Date currentDate = DateTimeUtil.getCurrentSqlDate();
    this.creDate = DateTimeUtil.getDatePart(currentDate);
    this.creTime = DateTimeUtil.getTimePart(currentDate);
    this.crePerson = userId;
  }
  
  public void updateTimestamp(String userId){
    updateUpdTimestamp(userId);
    updateCreTimestamp(userId);
  }
  
}
