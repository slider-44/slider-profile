package com.acsp.common.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ACSPUser extends User {

  private static final long serialVersionUID = 3212396007918727749L;

  private static final String DEFAULT_DEFAULT_URL = "/";

  private String userCd;

  private String firstName;

  private String lastName;

  private String email;

  private String storeCd;

  private Integer accountStatus;

  private String defaultUrl;

  public String getUserCd() {

    return userCd;
  }

  public void setUserCd(String userCd) {

    this.userCd = userCd;
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

  public String getStoreCd() {

    return storeCd;
  }

  public Integer getAccountStatus() {

    return accountStatus;
  }

  /**
   * Retrieves the default URL of this User.  Can be used upon initial login.
   * @return Relative path of the default screen assigned to this user.
   */
  public String getDefaultUrl() {

    return defaultUrl == null || defaultUrl.trim().isEmpty() ? DEFAULT_DEFAULT_URL
                                                             : defaultUrl;
  }

  /**
   * Builder class for OsaUser.
   */
  public static class Builder {

    private String username;

    private String userCd;

    private String password;

    private Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    private String firstName;

    private String lastName;

    private String email;

    private String storeCd;

    private Integer accountStatus;

    private boolean enabled = true;

    private boolean accountNonExpired = true;

    private boolean credentialsNonExpired = true;

    private boolean accountNonLocked = true;

    private String defaultUrl;

    public Builder(String username, String password) {
      this.username = username;
      this.password = password;
    }

    /**
     * 
     * @param userCd User code for this user.
     * @return The instance of the builder.
     */
    public Builder withUserCd(String userCd) {

      this.userCd = userCd;
      return this;
    }

    /**
     * 
     * @param firstName First name of this user.
     * @return The instance of the builder.
     */
    public Builder withFirstName(String firstName) {

      this.firstName = firstName;
      return this;
    }

    /**
     * 
     * @param lastName Last name of this user.
     * @return The instance of the builder.
     */
    public Builder withLastName(String lastName) {

      this.lastName = lastName;
      return this;
    }

    /**
     * 
     * @param email Email of this user.
     * @return The instance of the builder.
     */
    public Builder withEmail(String email) {

      this.email = email;
      return this;
    }

    /**
     * 
     * @param storeCd Store Code of this user (for promoters and merchant users).
     * @return The instance of the builder.
     */
    public Builder withStoreCd(String storeCd) {

      this.storeCd = storeCd;
      return this;
    }

    /**
     * 
     * @param accountStatus Account status of this user.
     * @return The instance of the builder.
     */
    public Builder withAccountStatus(Integer accountStatus) {

      this.accountStatus = accountStatus;
      return this;
    }

    /**
     * 
     * @param userRole UserRole instance to be added to this user.
     * @return The instance of the builder.
     */
    public Builder addRole(UserRole userRole) {

      if ( userRole != null && userRole.getRole() != null && !userRole.getRole().isEmpty() ) {
        this.grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
      }
      return this;
    }

    /**
     * 
     * @param userRoles Collection of UserRole to be assigned to this user.
     * @return The instance of the builder.
     */
    public Builder addRoles(Collection<UserRole> userRoles) {

      userRoles.forEach(r -> addRole(r));
      return this;
    }

    /**
     * 
     * @param enabled true if this user is enabled, false otherwise.
     * @return The instance of the builder.
     */
    public Builder withEnabled(boolean enabled) {

      this.enabled = enabled;
      return this;
    }

    /**
     * 
     * @param accountNonExpired true if this user's account is not yet expired, false otherwise.
     * @return The instance of the builder.
     */
    public Builder withAccountNonExpired(boolean accountNonExpired) {

      this.accountNonExpired = accountNonExpired;
      return this;
    }

    /**
     * 
     * @param credentialsNonExpired true if this user's credentials (password) is not
     *        yet expired, false otherwise.
     * @return The instance of the builder.
     */
    public Builder withCredentialsNonExpired(boolean credentialsNonExpired) {

      this.credentialsNonExpired = credentialsNonExpired;
      return this;
    }

    /**
     * 
     * @param accountNonLocked true if this user is not locked, false otherwise.
     * @return The instance of the builder.
     */
    public Builder withAccountNonLocked(boolean accountNonLocked) {

      this.accountNonLocked = accountNonLocked;
      return this;
    }

    public ACSPUser build() {

      return new ACSPUser(this);
    }
  }

  private ACSPUser(Builder builder) {
    super(builder.username,
          builder.password,
          builder.enabled,
          builder.accountNonExpired,
          builder.credentialsNonExpired,
          builder.accountNonLocked,
          builder.grantedAuthorities);

    this.userCd = builder.userCd;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.email = builder.email;
    this.accountStatus = builder.accountStatus;
    this.storeCd = builder.storeCd;
    this.defaultUrl = (builder.defaultUrl == null
                       || builder.defaultUrl.trim().isEmpty()) ? DEFAULT_DEFAULT_URL
                                                               : builder.defaultUrl;
  }
}
