package com.acsp.gateway.dto;

import com.acsp.common.security.ACSPUser;

import java.io.Serializable;
import java.util.List;

public class SimpleACSPUser implements Serializable {

  private static final long serialVersionUID = -1338714044556876504L;

  String firstName;

  String lastName;

  String email;
  
  private List<Menu> menus;
  
  private String userCd;

  /**
   * 
   * @param acspUser ACSPUser to map to a new SimpleACSPUser instance.
   */
  public SimpleACSPUser(ACSPUser acspUser) {

    this.firstName = acspUser.getFirstName();
    this.lastName = acspUser.getLastName();
    this.email = acspUser.getEmail();
    this.userCd = acspUser.getUserCd();
  }

  public String getFirstName() {

    return firstName;
  }

  public String getLastName() {

    return lastName;
  }

  public String getEmail() {

    return email;
  }

  
  public String getUserCd() {
  
    return userCd;
  }

  public List<Menu> getMenus() {
  
    return menus;
  }

  
  public void setMenus(List<Menu> menus) {
  
    this.menus = menus;
  }

}
