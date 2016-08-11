package com.acsp.salesprocess.repository;

import com.acsp.salesprocess.dto.AgreementDTO;
import com.acsp.salesprocess.dto.ApplicationDetail;
import com.acsp.salesprocess.dto.PayStagesAgreementDTO;

public interface SalesProcessRepository {
	
	ApplicationDetail getApplicationDetail(String applicationCd);
	
	AgreementDTO retrieveAgreement(String applicationCd);
	
	int insertAgreement(AgreementDTO agreementDTO);
	
	int insertAgreementHistory(AgreementDTO agreementDTO);
	
	PayStagesAgreementDTO retrievePayStage(String applicationCd);
	
	int insertPayStagesAgreement(PayStagesAgreementDTO payStagesAgreementDTO);
	
	int insertPayStagesHistory(PayStagesAgreementDTO payStagesAgreementDTO);
	
	int insertMCustomer(AgreementDTO agreementDTO);

}
