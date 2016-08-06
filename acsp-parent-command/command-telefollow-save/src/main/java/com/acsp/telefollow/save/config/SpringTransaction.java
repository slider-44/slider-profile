package com.acsp.telefollow.save.config;

import org.jooq.Transaction;
import org.springframework.transaction.TransactionStatus;

class SpringTransaction implements Transaction {

  final TransactionStatus tx;

  SpringTransaction(TransactionStatus tx) {
    this.tx = tx;
  }
}
