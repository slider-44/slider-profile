package com.acsp.customerservice.search.repository;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acsp.customerservice.search.dto.SearchDTO;

import static com.acsp.core.rs.db.tables.MCustomer.M_CUSTOMER;
import static com.acsp.core.rs.db.tables.TApplication.T_APPLICATION;

@Repository
public class CustomerServiceRepositoryImpl implements CustomerServiceRepository {

  @Autowired
  protected DSLContext jooq;

  
  public List<SearchDTO> getCustomerList(Condition condition) {

    List<Record> records = getCustomerRecords(condition);
    List<SearchDTO> resultList = new ArrayList<>();

    for ( Record record : records ) {
      
      SearchDTO searchDTO = new SearchDTO().setFirstName(record.getValue(M_CUSTOMER.FIRSTNAME))
                                           .setFirstName(record.getValue(M_CUSTOMER.FIRSTNAME))
                                           .setSurName(record.getValue(M_CUSTOMER.SURNAME))
                                           .setTelNo(record.getValue(M_CUSTOMER.HOMETEL))
                                           .setMobileNo(record.getValue(M_CUSTOMER.MOBILENO))
                                           .setCustomerCd(record.getValue(M_CUSTOMER.CUSTOMERCD))
                                           .setAppCd(record.getValue(T_APPLICATION.APPCD))
                                           .setAgreementCd(record.getValue(T_APPLICATION.APPROVECD))
                                           .setBirthDay(String.valueOf(record.getValue(M_CUSTOMER.BIRTHDAY)));
      resultList.add(searchDTO);
      
    }

    return resultList;
  }

  
  public List<Record> getCustomerRecords(Condition condition) {

    return jooq
               .select(M_CUSTOMER.FIRSTNAME)
               .select(M_CUSTOMER.SURNAME)
               .select(M_CUSTOMER.BIRTHDAY)
               .select(M_CUSTOMER.IDCARDNO)
               .select(M_CUSTOMER.CUSTOMERCD)
               .select(M_CUSTOMER.HOMETEL)
               .select(M_CUSTOMER.MOBILENO)
               .select(T_APPLICATION.APPCD)
               .select(T_APPLICATION.APPROVECD)
               .from(M_CUSTOMER).innerJoin(T_APPLICATION)
               .on(T_APPLICATION.CUSTOMERCD.eq(M_CUSTOMER.CUSTOMERCD))
               .where(condition).fetch();
  }

}
