package com.acsp.password.reset.repository;

import static com.acsp.core.rs.db.tables.HAccountPassword.H_ACCOUNT_PASSWORD;
import static com.acsp.core.rs.db.tables.MAccountExt.M_ACCOUNT_EXT;

import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.common.security.ACSPUser;
import com.acsp.password.reset.dto.SavePasswordDTO;
import com.acsp.password.reset.util.PasswordEncoder;


@Component
public class PasswordHistoryGatewayImp implements PasswordHistoryGateway {

  @Autowired
  protected DSLContext jooq;

  @Autowired
  PasswordEncoder passwordEncoder;


  @Override
  public List<Record> getPasswordHistory(Condition condition) {

    return jooq.select(H_ACCOUNT_PASSWORD.CREATEDATE)
               .select(H_ACCOUNT_PASSWORD.USERCD)
               .select(H_ACCOUNT_PASSWORD.PASSWORD)
               
               .from(H_ACCOUNT_PASSWORD)
                 .innerJoin(M_ACCOUNT_EXT).on(M_ACCOUNT_EXT.USERCD.eq(H_ACCOUNT_PASSWORD.USERCD))
               .where(condition)
               .orderBy(H_ACCOUNT_PASSWORD.CREATEDATE.desc())
               .limit(3)
               .fetch();

  }


  @Override
  public SavePasswordDTO insertHistory(SavePasswordDTO savePasswordDTO, ACSPUser acspUser) {

    jooq.insertInto(H_ACCOUNT_PASSWORD,
                    H_ACCOUNT_PASSWORD.PASSWORD,
                    H_ACCOUNT_PASSWORD.CREATEDATE,
                    H_ACCOUNT_PASSWORD.USERCD)
        .values(passwordEncoder.encode(savePasswordDTO.getNewPassword()),
                savePasswordDTO.getUpdateDate(),
                acspUser.getUserCd())
        .execute();

    return savePasswordDTO;
  }



}
