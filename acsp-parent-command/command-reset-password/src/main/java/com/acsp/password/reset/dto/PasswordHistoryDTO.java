package com.acsp.password.reset.dto;

public class PasswordHistoryDTO {

  private String userCd;

  private String password;

  private String createDate;

  public String getCreateDate() {

    return createDate;
  }

  public PasswordHistoryDTO setCreateDate(String createDate) {

    this.createDate = createDate;
    return this;
  }

  public String getPassword() {

    return password;
  }

  public PasswordHistoryDTO setPassword(String password) {

    this.password = password;
    return this;

  }

  public String getUserCd() {

    return userCd;
  }

  public PasswordHistoryDTO setUserCd(String userCd) {

    this.userCd = userCd;
    return this;
  }
}
