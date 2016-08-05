package com.acsp.gateway.service;

import com.acsp.common.security.ACSPUser;
import com.acsp.gateway.dto.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ACSPUserDetailsService implements UserDetailsService {

  @Autowired
  private AccountService accountService;

  
  /**
   * Implements loading by user name for Spring Security Context.
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Account account = accountService.getAccountByUsername(username);
    
    if ( account != null ) {
      
      return createUserDetails(account);
      
    } else {
      
      throw new UsernameNotFoundException("User not found");
      
    }
    
  }

  
  private UserDetails createUserDetails(Account account) {

    return new ACSPUser.Builder(account.getUsername(), 
                                account.getPassword())
                                                      .addRoles(account.getUserRoles())
                                                      .withUserCd(account.getUserCd())
                                                      .withFirstName(account.getFirstName())
                                                      .withLastName(account.getLastName())
                                                      .withEmail(account.getEmail())
                                                      .withStoreCd(account.getStoreCd())
                                                      .withAccountStatus(account.getStatus())
                                                      .withEnabled(true)
                                                      .withAccountNonExpired(true)
                                                      .withAccountNonLocked(true)
                                                      .withCredentialsNonExpired(true)
                                                      .build();
  }

}
