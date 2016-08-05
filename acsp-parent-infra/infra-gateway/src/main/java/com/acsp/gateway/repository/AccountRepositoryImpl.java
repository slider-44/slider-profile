package com.acsp.gateway.repository;

import static com.acsp.core.rs.db.tables.MAccountExt.M_ACCOUNT_EXT;
import static com.acsp.core.rs.db.tables.MAccountRoles.M_ACCOUNT_ROLES;

import com.acsp.common.security.UserRole;
import com.acsp.core.orm.Pair;
import com.acsp.gateway.dto.Account;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConnectByStep;
import org.jooq.SelectJoinStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fsoli_000 on 12/31/2015.
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Autowired
  DSLContext jooq;

  @Override
  public List<Account> findByUsername(String username) {

    return findUsingCondition(M_ACCOUNT_EXT.USERCD.eq(username));
  }

  private List<Account> findUsingCondition(Condition condition) {

    List<Account> accounts = select(condition).orderBy(M_ACCOUNT_EXT.USERCD)
                                              .fetch(record -> new Pair<>(new Account.Builder()
                                                                                               .withUserCd(record.getValue(M_ACCOUNT_EXT.USERCD))
                                                                                               .withUsername(record.getValue(M_ACCOUNT_EXT.USERCD))
                                                                                               .withPassword(record.getValue(M_ACCOUNT_EXT.PASSWORD))
                                                                                               .withFirstName(record.getValue(M_ACCOUNT_EXT.FIRST_NAME))
                                                                                               .withLastName(record.getValue(M_ACCOUNT_EXT.LAST_NAME))
                                                                                               .withEmail(record.getValue(M_ACCOUNT_EXT.EMAIL))
                                                                                               .withStoreCd(record.getValue(M_ACCOUNT_EXT.STORECD))
                                                                                               .build(),
                                                                          new UserRole.Builder()
                                                                                                .withRole(record.getValue(M_ACCOUNT_ROLES.ROLE))
                                                                                                .withUserCd(record.getValue(M_ACCOUNT_ROLES.USERCD))
                                                                                                .build()))
                                              .stream()
                                              /*
                                               * creates an Account and UserRole and then creates a
                                               * Map<Account, Set<UserRole>> Account
                                               */
                                              .collect(Collectors.groupingBy(Pair::getFirst,
                                                                             Collectors.mapping(Pair::getSecond,
                                                                                                Collectors.toSet())))
                                              .entrySet()
                                              .stream()
                                              /*
                                               * iterates Map<Account, Set<UserRole>> setting
                                               * Set<UserRole> for each Account and then collects
                                               * List<Account>
                                               */
                                              .map(entry -> {
                                                entry.getKey().setUserRoles(entry.getValue());
                                                return entry.getKey();
                                              })
                                              .collect(Collectors.toList());

    return accounts;
  }



  private SelectConnectByStep<Record> select(Condition condition) {

    return (condition == null ? select()
                              : select().where(condition));
  }



  private SelectJoinStep<Record> select() {

    return jooq.select(M_ACCOUNT_EXT.STORECD)
               .select(M_ACCOUNT_EXT.USERCD)
               .select(M_ACCOUNT_EXT.PASSWORD)
               .select(M_ACCOUNT_EXT.FIRST_NAME)
               .select(M_ACCOUNT_EXT.LAST_NAME)
               .select(M_ACCOUNT_EXT.EMAIL)
               .select(M_ACCOUNT_ROLES.ID)
               .select(M_ACCOUNT_ROLES.ROLE)
               .from(M_ACCOUNT_EXT
                                  .join(M_ACCOUNT_ROLES).on(M_ACCOUNT_EXT.USERCD.equal(M_ACCOUNT_ROLES.USERCD)));
  }
}
