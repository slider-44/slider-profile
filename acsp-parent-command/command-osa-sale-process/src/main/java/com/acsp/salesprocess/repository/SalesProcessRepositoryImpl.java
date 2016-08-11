package com.acsp.salesprocess.repository;

import static com.acsp.core.rs.db.tables.TAgreement.T_AGREEMENT;
import static com.acsp.core.rs.db.tables.TPaystagesagreement.T_PAYSTAGESAGREEMENT;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.acsp.salesprocess.dto.AgreementDTO;
import com.acsp.salesprocess.dto.ApplicationDetail;
import com.acsp.salesprocess.dto.PayStagesAgreementDTO;

@Repository
public class SalesProcessRepositoryImpl implements SalesProcessRepository {

  @Autowired
  DSLContext jooq;

  @Override
  public ApplicationDetail getApplicationDetail(String applicationCd) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AgreementDTO retrieveAgreement(String applicationCd) {

    
    return null;
  }

  @Override
  public int insertAgreement(AgreementDTO agreementDTO) {

    int result = jooq
                     .insertInto(T_AGREEMENT,
                                 T_AGREEMENT.AGREEMENTCD,
                                 T_AGREEMENT.AGREEMENTTYPE,
                                 T_AGREEMENT.SYSAPPCD,
                                 T_AGREEMENT.AGREEMENTDATE,
                                 T_AGREEMENT.AGREEMENTRECEIVEDDATE,
                                 T_AGREEMENT.SALEDATE,
                                 T_AGREEMENT.AGREEMENTSTATUS,
                                 T_AGREEMENT.CHARGEFLAG,
                                 T_AGREEMENT.CUSTOMERCD,
                                 T_AGREEMENT.PEOPLECD,
                                 T_AGREEMENT.PEOPLEFLAG,
                                 T_AGREEMENT.STORENAME,
                                 T_AGREEMENT.STORETELDISTRICT,
                                 T_AGREEMENT.STORETEL,
                                 T_AGREEMENT.STOREPIC,
                                 T_AGREEMENT.STORECD,
                                 T_AGREEMENT.COMMENTS,
                                 T_AGREEMENT.DELFLAG,
                                 T_AGREEMENT.CREPERSON,
                                 T_AGREEMENT.CREDATE,
                                 T_AGREEMENT.CRETIME,
                                 T_AGREEMENT.UPDPERSON,
                                 T_AGREEMENT.UPDDATE,
                                 T_AGREEMENT.UPDTIME,
                                 T_AGREEMENT.UPDCNT,
                                 T_AGREEMENT.AGENTCD,
                                 T_AGREEMENT.AGENTNAME,
                                 T_AGREEMENT.MERCHANTSTAFF,
                                 T_AGREEMENT.MERCHANTSTAMP,
                                 T_AGREEMENT.AEONSTAFFDATERECEIVED)
                     .values(agreementDTO.getAgreementCd(),
                             agreementDTO.getAgreementType(),
                             agreementDTO.getSysAppCd(),
                             agreementDTO.getAgreementDate(),
                             agreementDTO.getAgreementReceivedDate(),
                             agreementDTO.getSaleDate(),
                             agreementDTO.getAgreementStatus(),
                             agreementDTO.getChargeFlag(),
                             agreementDTO.getCustomerCd(),
                             agreementDTO.getPeopleCd(),
                             agreementDTO.getPeopleFlag(),
                             agreementDTO.getStoreName(),
                             agreementDTO.getStoreTelDistrict(),
                             agreementDTO.getStoreTel(),
                             agreementDTO.getStorePic(),
                             agreementDTO.getStoreCd(),
                             agreementDTO.getComments(),
                             agreementDTO.getDelFlag(),
                             agreementDTO.getCrePerson(),
                             agreementDTO.getCreDate(),
                             agreementDTO.getCreTime(),
                             agreementDTO.getUpdPerson(),
                             agreementDTO.getUpdDate(),
                             agreementDTO.getUpdTime(),
                             agreementDTO.getUpdCnt(),
                             agreementDTO.getAgentCd(),
                             agreementDTO.getAgentName(),
                             agreementDTO.getMerchantStaff(),
                             agreementDTO.getMerchantStamp(),
                             agreementDTO.getAeonStaffDateReceived())
                     .execute();
    return result;
  }

  @Override
  public int insertPayStagesAgreement(PayStagesAgreementDTO payStagesAgreementDTO) {

/*    int result = jooq
        .insertInto(T_PAYSTAGESAGREEMENT,
                    T_PAYSTAGESAGREEMENT.AGREEMENTCD,
                    T_PAYSTAGESAGREEMENT.AGREEMENTTYPE,
                    T_PAYSTAGESAGREEMENT.PRODUCTTOTALMONEY,
                    T_PAYSTAGESAGREEMENT.APPROVALFEE,
                    T_PAYSTAGESAGREEMENT.APPROVALFEEIFANY,
                    T_PAYSTAGESAGREEMENT.APPROVALFEETYPE,
                    T_PAYSTAGESAGREEMENT.DOWNPAYMENT,
                    T_PAYSTAGESAGREEMENT.FINANCEPRICE,
                    T_PAYSTAGESAGREEMENT.NUMBEROFINSTALMENT,
                    T_PAYSTAGESAGREEMENT.INTERESTAMOUNT,
                    T_PAYSTAGESAGREEMENT.HPPRICE,
                    T_PAYSTAGESAGREEMENT.MONTHLYPAYMENT,
                    T_PAYSTAGESAGREEMENT.INITIALPAYMENT,
                    T_PAYSTAGESAGREEMENT.HPLASTDAY,
                    T_PAYSTAGESAGREEMENT.HPFIRSTDAY,
                    T_PAYSTAGESAGREEMENT.PAYMENTTYPE,
                    T_PAYSTAGESAGREEMENT.DELFLAG,
                    T_PAYSTAGESAGREEMENT.CREPERSON,
                    T_PAYSTAGESAGREEMENT.CREDATE,
                    T_PAYSTAGESAGREEMENT.CRETIME,
                    T_PAYSTAGESAGREEMENT.UPDPERSON,
                    T_PAYSTAGESAGREEMENT.UPDDATE,
                    T_PAYSTAGESAGREEMENT.UPDTIME,
                    T_PAYSTAGESAGREEMENT.UPDCNT,
                    T_PAYSTAGESAGREEMENT.DOCSTAMPAMOUNT,
                    T_PAYSTAGESAGREEMENT.PROMOTIONVOUCHER,
                    T_PAYSTAGESAGREEMENT.PAYMENTTYPE,
                    T_PAYSTAGESAGREEMENT.APPROVALFEEPAYTYPE)
        .values(null)*/
        
    return 0;
  }

  @Override
  public int insertPayStagesHistory(PayStagesAgreementDTO payStagesAgreementDTO) {

    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int insertMCustomer(AgreementDTO agreementDTO) {

    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public PayStagesAgreementDTO retrievePayStage(String applicationCd) {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int insertAgreementHistory(AgreementDTO agreementDTO) {

    // TODO Auto-generated method stub
    return 0;
  }

}
