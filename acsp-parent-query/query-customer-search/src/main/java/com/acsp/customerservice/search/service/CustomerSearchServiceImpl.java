package com.acsp.customerservice.search.service;

import static com.acsp.core.rs.db.tables.MCustomer.M_CUSTOMER;
import static com.acsp.core.rs.db.tables.TApplication.T_APPLICATION;

import com.acsp.common.util.DateTimeUtil;
import com.acsp.customerservice.search.dto.SearchDTO;
import com.acsp.customerservice.search.repository.CustomerServiceRepository;

import org.joda.time.DateTime;
import org.jooq.Condition;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerSearchServiceImpl implements CustomerSearchService {

  @Autowired
  CustomerServiceRepository customerServiceRepository;

  @Override
  public List<SearchDTO> search(String firstName,
                                String surName,
                                DateTime birthDay,
                                String telNo,
                                String appCd,
                                String agreementCd) {

    Condition likeFirstName = DSL.trueCondition();
    Condition likeLastName = DSL.trueCondition();
    Condition likeBirthDay = DSL.trueCondition();
    Condition likeTelNo = DSL.trueCondition();
    Condition likeAppcd = DSL.trueCondition();
    Condition likeAgreementCd = DSL.trueCondition();

    if ( checkIfNotEmpty(firstName) ) {
      likeFirstName = M_CUSTOMER.FIRSTNAME.like("%" + firstName + "%");
    }

    if ( checkIfNotEmpty(surName) ) {
      likeLastName = M_CUSTOMER.SURNAME.like("%" + surName + "%");
    }

    if ( birthDay != null ) {
      likeBirthDay = M_CUSTOMER.BIRTHDAY.eq(DateTimeUtil.getDatePart(birthDay));
    }

    if ( checkIfNotEmpty(telNo) ) {
      likeTelNo = M_CUSTOMER.HOMETEL.like("%" + telNo + "%")
                                    .or(M_CUSTOMER.MOBILENO.like("%" + telNo + "%"));
    }

    if ( checkIfNotEmpty(appCd) ) {
      likeAppcd = T_APPLICATION.APPCD.like("%" + appCd + "%");
    }

    if ( checkIfNotEmpty(agreementCd) ) {
      likeAgreementCd = T_APPLICATION.APPROVECD.like("%" + agreementCd + "%");
    }

    return customerServiceRepository.getCustomerList(likeFirstName.and(likeLastName)
                                                                  .and(likeBirthDay)
                                                                  .and(likeBirthDay)
                                                                  .and(likeTelNo)
                                                                  .and(likeAppcd)
                                                                  .and(likeAgreementCd)
                                                                  .and("ROWNUM <= 500"));

  }


  private boolean checkIfNotEmpty(String value) {

    return value != null && !value.trim().equalsIgnoreCase("");
  }

}
