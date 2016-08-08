package com.acsp.password.reset.dto;


import java.sql.Date;

public class SavePasswordDTO {

  private String usercd;

  private String newPassword;

  private String currentPassword;

  private Date createDate;

  private Date updateDate;



  public Date getCreateDate() {

    return createDate;
  }

  public void setCreateDate(Date createDate) {

    this.createDate = createDate;
  }

  public Date getUpdateDate() {

    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {

    this.updateDate = updateDate;
  }

  public String getUserCD() {

    return usercd;
  }

  public void setUserCD(String usercd) {

    this.usercd = usercd;
  }

  public String getNewPassword() {

    return newPassword;
  }

  public void setNewPassword(String newpassword) {

    this.newPassword = newpassword;
  }

  public String getCurrentPassword() {

    return currentPassword;
  }

  public void setCurrentPassword(String currentPassword) {

    this.currentPassword = currentPassword;
  }

}