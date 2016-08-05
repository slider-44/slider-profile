package com.acsp.gateway.service;

import com.acsp.gateway.dto.Account;
import com.acsp.gateway.repository.AccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

  private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

  @Autowired
  private AccountRepository accountRepository;

  @Override
  public Account getAccountByUsername(String username) {

    List<Account> accounts = accountRepository.findByUsername(username);
    return filterResult(accounts, accounts.size(), "username", username);
  }


  private Account filterResult(List<Account> accounts, Object... args) {

    if ( accounts.isEmpty() ) {

      logger.warn("{} [{}] not found", args);
      return null;
    } else if ( accounts.size() == 1 ) {

      return accounts.get(0);
    } else {

      logger.warn("There are {} accounts having {} of [{}]", args);
      return null;
    }

  }

}
