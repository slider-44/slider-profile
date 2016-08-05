package com.acsp.gateway.service;

import com.acsp.gateway.dto.Account;

/**
 * Created by fsoli_000 on 12/31/2015.
 */
public interface AccountService {

  Account getAccountByUsername(String username);

}
