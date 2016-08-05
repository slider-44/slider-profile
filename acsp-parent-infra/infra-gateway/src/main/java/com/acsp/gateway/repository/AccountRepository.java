package com.acsp.gateway.repository;

import com.acsp.gateway.dto.Account;

import java.util.List;

public interface AccountRepository {

  /**
   * Find account by username.
   * 
   * @param username Username to search (User Code).
   * @return List of accounts with the username supplied.
   */
  List<Account> findByUsername(String username);

}
