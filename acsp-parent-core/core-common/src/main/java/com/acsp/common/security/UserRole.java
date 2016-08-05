package com.acsp.common.security;

import java.io.Serializable;

public class UserRole implements Serializable {

  private static final long serialVersionUID = 1916131929823848802L;

  private String userCd;

  private String role;

  public UserRole() {}

  public UserRole(String userCd, String role) {
    this.role = role;
    this.userCd = userCd;
  }

  public String getUserCd() {

    return userCd;
  }

  public void setUserCd(String userCd) {

    this.userCd = userCd;
  }

  public String getAuthority() {

    return role;
  }

  public String getRole() {

    return role;
  }

  public void setRole(String role) {

    this.role = role;
  }

  public static final class Builder {

    private String userCd;

    private String role;

    /**
     * 
     * @param userCd User Code assigned to this user.
     * @return The instance of the builder.
     */
    public Builder withUserCd(String userCd) {

      this.userCd = userCd;
      return this;
    }

    /**
     * 
     * @param role Role assigned to this user.
     * @return The instance of the builder.
     */
    public Builder withRole(String role) {

      this.role = role;
      return this;
    }

    public UserRole build() {

      return new UserRole(this);
    }
  }

  public UserRole(Builder builder) {
    this.userCd = builder.userCd;
    this.role = builder.role;
  }

}
