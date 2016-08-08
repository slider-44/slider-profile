package com.acsp.password.reset.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.acsp.common.security.UserRole;

public class AccountDetailsDTO implements Serializable {

  private static final long serialVersionUID = -3803639572479243410L;

  private String userCd;

  private String username;

  private String password;

  private String firstName;

  private String lastName;

  private String email;

  private String storeCd;

  private Set<UserRole> userRoles;

  private Integer status;

  public AccountDetailsDTO() {
    this.userRoles = new HashSet<>();
  }

  public AccountDetailsDTO(String userCd, String password, String role) {
    this();
    this.userCd = userCd;
    this.password = password;
    this.userRoles.add(new UserRole(userCd, role));
  }



  /**
   * Encodes the password using the implementation :
   * {@link org.springframework.security.crypto.password.StandardPasswordEncoder}
   */
  public void encodePassword(PasswordEncoder passwordEncoder) {

    if ( password != null && passwordEncoder != null ) {
      this.password = passwordEncoder.encode(password);
    }
  }

  public String getUserCd() {

    return userCd;
  }

  public void setUserCd(String userCd) {

    this.userCd = userCd;
  }

  public String getUsername() {

    return username;
  }

  public void setUsername(String username) {

    this.username = username;
  }

  public String getPassword() {

    return password;
  }

  public void setPassword(String password) {

    this.password = password;
  }

  public String getFirstName() {

    return firstName;
  }

  public void setFirstName(String firstName) {

    this.firstName = firstName;
  }

  public String getLastName() {

    return lastName;
  }

  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

  public String getEmail() {

    return email;
  }

  public void setEmail(String email) {

    this.email = email;
  }

  public Integer getStatus() {

    return status;
  }

  public void setStatus(Integer status) {

    this.status = status;
  }

  public String getStoreCd() {

    return storeCd;
  }

  public void setStoreCd(String storeCd) {

    this.storeCd = storeCd;
  }

  public Set<UserRole> getUserRoles() {

    return userRoles;
  }

  public void setUserRoles(Set<UserRole> userRoles) {

    this.userRoles = userRoles;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + ((userCd == null) ? 0
                                                : userCd.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if ( this == obj )
      return true;
    if ( obj == null )
      return false;
    if ( getClass() != obj.getClass() )
      return false;
    AccountDetailsDTO other = (AccountDetailsDTO) obj;
    if ( userCd == null ) {
      if ( other.userCd != null )
        return false;
    } else if ( !userCd.equals(other.userCd) )
      return false;
    return true;
  }



  public static final class Builder {

    private String userCd;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String storeCd;

    private Integer status;

    public Builder withUserCd(String userCd) {

      this.userCd = userCd;
      return this;
    }

    public Builder withUsername(String username) {

      this.username = username;
      return this;
    }

    public Builder withPassword(String password) {

      this.password = password;
      return this;
    }

    public Builder withFirstName(String firstName) {

      this.firstName = firstName;
      return this;
    }

    public Builder withLastName(String lastName) {

      this.lastName = lastName;
      return this;
    }

    public Builder withEmail(String email) {

      this.email = email;
      return this;
    }

    public Builder withStoreCd(String storeCd) {

      this.storeCd = storeCd;
      return this;
    }

    public Builder withStatus(Integer status) {

      this.status = status;
      return this;
    }

    public AccountDetailsDTO build() {

      return new AccountDetailsDTO(this);
    }
  }

  private AccountDetailsDTO(Builder builder) {
    this.userCd = builder.userCd;
    this.username = builder.username;
    this.password = builder.password;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.email = builder.email;
    this.storeCd = builder.storeCd;
    this.status = builder.status;
  }
}
