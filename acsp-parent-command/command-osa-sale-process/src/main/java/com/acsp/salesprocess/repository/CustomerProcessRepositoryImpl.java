package com.acsp.salesprocess.repository;

import static com.acsp.core.rs.db.tables.MCustomerId.M_CUSTOMER_ID;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acsp.salesprocess.dto.CustomerDTO;

@Repository
public class CustomerProcessRepositoryImpl implements CustomerProcessRepository {

  @Autowired
  DSLContext jooq;
  
  @Override
  public CustomerDTO getCustomerInfo(String applicationCd) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Byte getIdNo(String customerCd) {

    return (byte) (jooq
        .select(DSL.max(M_CUSTOMER_ID.IDNO))
        .from(M_CUSTOMER_ID)
        .where(DSL.and(M_CUSTOMER_ID.CUSTOMERCD.eq(customerCd),
                       M_CUSTOMER_ID.DELFLAG.eq((byte) 0)
               ))
        .fetchOne(0, Byte.class)
        .byteValue() + 1);
  }

  @Override
  public int updateCustomerIdPrimary(CustomerDTO customerDTO) {
    int result = jooq.update(M_CUSTOMER_ID)
      .set(M_CUSTOMER_ID.PRIMARYSTATUS, customerDTO.getOrigPrimaryStatus())
      .where(DSL.and(M_CUSTOMER_ID.CUSTOMERCD.eq(customerDTO.getCustomerCd()),
                     M_CUSTOMER_ID.PRIMARYSTATUS.eq(customerDTO.getPrimaryStatus()),
                     M_CUSTOMER_ID.DELFLAG.eq((byte) 0) 
             ))
      .execute();
    return result;
  }

  @Override
  public int insertCustomerIdPrimary(CustomerDTO customerDTO) {
    
    int result = jooq.insertInto(M_CUSTOMER_ID, 
                                 M_CUSTOMER_ID.CUSTOMERCD, 
                                 M_CUSTOMER_ID.IDNO, 
                                 M_CUSTOMER_ID.IDCARDTYPE, 
                                 M_CUSTOMER_ID.IDCARDNO,
                                 M_CUSTOMER_ID.PRIMARYSTATUS,
                                 M_CUSTOMER_ID.DELFLAG,
                                 M_CUSTOMER_ID.UPDPERSON,
                                 M_CUSTOMER_ID.UPDDATE,
                                 M_CUSTOMER_ID.UPDTIME,
                                 M_CUSTOMER_ID.CREPERSON,
                                 M_CUSTOMER_ID.CREDATE,
                                 M_CUSTOMER_ID.CRETIME,
                                 M_CUSTOMER_ID.UPDCNT)
        .values(customerDTO.getCustomerCd(),
                customerDTO.getIdNo(),
                customerDTO.getIdCardType(),
                customerDTO.getIdCardNo(),
                customerDTO.getPrimaryStatus(),
                (byte) 0,
                customerDTO.getUpdPerson(),
                customerDTO.getUpdDate(),
                customerDTO.getUpdTime(),
                customerDTO.getCrePerson(),
                customerDTO.getCreDate(),
                customerDTO.getCreTime(),
                0)
        .execute();
    
    return result;
  }

}
