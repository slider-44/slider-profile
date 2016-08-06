package com.acsp.merchant.bank.save.dto;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.acsp.common.dto.BaseResponseDTO;


public class BaseDTO extends BaseResponseDTO {

  private String crePerson;

  private String creProId;

  private Integer creDate;

  private Integer creTime;

  private String updPerson;

  private String updProId;

  private Integer updDate;

  private Integer updTime;

  private Byte delflag;

  private Integer updCnt;

  /**
   * Sets everything into current date.
   */
  public BaseDTO() {
    // this should be parameterized.
    DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyyMMdd");
    DateTimeFormatter timeFormat = DateTimeFormat.forPattern("HHmmss");

    DateTime now = new DateTime();
    LocalTime time = new LocalTime();

    Integer currentDate = new Integer(now.toString(dateFormat));
    this.creDate = currentDate;
    this.updDate = currentDate;

    Integer currentTime = new Integer(time.toString(timeFormat));

    this.creTime = currentTime;
    this.updTime = currentTime;
    this.updCnt = new Integer(0);
  }

  /**
   * clears the credate and cretme to exclude it on update.
   */
  public void prepareForUpdate() {

    DateTime now = new DateTime();
    LocalTime time = new LocalTime();
    DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyyMMdd");
    DateTimeFormatter timeFormat = DateTimeFormat.forPattern("HHmmss");
    Integer currentDate = new Integer(now.toString(dateFormat));

    this.updDate = currentDate;
    Integer currentTime = new Integer(time.toString(timeFormat));
    this.updTime = currentTime;
  }

  public Integer getCreDate() {

    return creDate;
  }

  public void setCreDate(Integer creDate) {

    this.creDate = creDate;
  }

  /**
   * Returns current date always.
   * 
   * @return
   */
  public Integer getCreTime() {

    return creTime;
  }

  public void setCreTime(Integer creTime) {

    this.creTime = creTime;
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

  public Byte getDelflag() {

    return delflag;
  }

  public void setDelflag(Byte delflag) {

    this.delflag = delflag;
  }

  public String getCrePerson() {

    return crePerson;
  }

  public void setCrePerson(String crePerson) {

    this.crePerson = crePerson;
  }

  public String getUpdPerson() {

    return updPerson;
  }

  public void setUpdPerson(String updPerson) {

    this.updPerson = updPerson;
  }

  public Integer getUpdCnt() {

    return updCnt;
  }

  public void setUpdCnt(Integer updCnt) {

    this.updCnt = updCnt;
  }

  public String getCreProId() {

    return creProId;
  }

  public void setCreProId(String creProId) {

    this.creProId = creProId;
  }

  public String getUpdProId() {

    return updProId;
  }

  public void setUpdProId(String updProId) {

    this.updProId = updProId;
  }

}
