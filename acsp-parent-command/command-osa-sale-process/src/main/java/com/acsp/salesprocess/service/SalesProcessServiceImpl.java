package com.acsp.salesprocess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.acsp.common.util.DateTimeUtil;
import com.acsp.salesprocess.dto.AgreementDTO;
import com.acsp.salesprocess.dto.ApplicationDetail;
import com.acsp.salesprocess.dto.ApplicationStatus;
import com.acsp.salesprocess.dto.PayStagesAgreementDTO;
import com.acsp.salesprocess.dto.SalesProcessRequestDTO;
import com.acsp.salesprocess.dto.SalesProcessResponseDTO;
import com.acsp.salesprocess.repository.SalesProcessRepository;

@Service
public class SalesProcessServiceImpl implements SalesProcessService {

  @Autowired
  CustomerProcessService customerProcessService;

  @Autowired
  SalesProcessRepository salesProcessRepository;

  @Autowired
  CreditDataService creditDataService; 

  @Override
  @Transactional
  public SalesProcessResponseDTO performSalesProcess(SalesProcessRequestDTO requestDTO) {

    SalesProcessResponseDTO responseDTO = new SalesProcessResponseDTO();
    responseDTO.setResponseSuccess(true);

    if ( !validateParameters(requestDTO, responseDTO) ) {

      return responseDTO;
    }

    ApplicationDetail applicationDetail = salesProcessRepository.getApplicationDetail(requestDTO.getApplicationCd());

    validateApplication(requestDTO, applicationDetail, responseDTO);
    
    if ( !customerProcessService.processCustomerInformation(requestDTO, responseDTO) ) {

      return responseDTO;
    }

    AgreementDTO agreementDTO = salesProcessRepository.retrieveAgreement(requestDTO.getApplicationCd());

    insertAgreementDetails(requestDTO, agreementDTO, responseDTO);
    
    insertPayStagesAgreement(agreementDTO, responseDTO);

    creditDataService.processCreditData(agreementDTO, responseDTO);

    return responseDTO;
  }


  /**
   * 
   * @param agreementDTO
   * @param responseDTO
   * @return
   */
  private void insertPayStagesAgreement(AgreementDTO agreementDTO,
                                        SalesProcessResponseDTO responseDTO) {

    PayStagesAgreementDTO payStagesAgreementDTO = salesProcessRepository.retrievePayStage(agreementDTO.getApplicationCd());

    Assert.notNull(payStagesAgreementDTO,
                   "Error retrieving agreement pay stages for " + agreementDTO.getApplicationCd());

    int insertCount = salesProcessRepository.insertPayStagesHistory(payStagesAgreementDTO);

    Assert.isTrue(insertCount > 0,
                  "Error inserting pay stages agreement details for "
                                   + agreementDTO.getApplicationCd());
    
    insertCount = salesProcessRepository.insertPayStagesHistory(payStagesAgreementDTO);

    Assert.isTrue(insertCount > 0,
                    "Error inserting pay stages agreement details for "
                                     + agreementDTO.getApplicationCd());

  }


  /**
   * 
   * @param requestDTO
   * @param agreementDTO
   * @param responseDTO
   */
  private void insertAgreementDetails(SalesProcessRequestDTO requestDTO,
                                      AgreementDTO agreementDTO,
                                      SalesProcessResponseDTO responseDTO) {

    Assert.notNull(agreementDTO, "Error retrieving agreement details for "
                                     + requestDTO.getApplicationCd());

    int insertCount = salesProcessRepository.insertAgreement(agreementDTO);

    Assert.isTrue(insertCount > 0,
                  "Error inserting agreement details for "
                                     + requestDTO.getApplicationCd());
  }


  /**
   * 
   * @param requestDTO
   * @param responseDTO
   * @return
   */
  private boolean validateParameters(SalesProcessRequestDTO requestDTO,
                                     SalesProcessResponseDTO responseDTO) {

    if ( DateTimeUtil.isBeforeToday(requestDTO.getClaimDate()) ) {
      
      responseDTO.setResponseSuccess(false);
      responseDTO.setResponseMessage("Claim date must be before today's date.");
      responseDTO.addError("claimDate", "Claim date must be before today's date.");

      return false;
    }

    return true;

  }

  
  /**
   * 
   * @param requestDTO
   * @param applicationDetail
   * @param responseDTO
   */
  private void validateApplication(SalesProcessRequestDTO requestDTO,
                                   ApplicationDetail applicationDetail,
                                   SalesProcessResponseDTO responseDTO) {

    Assert.notNull(applicationDetail,
                   "Application [" + requestDTO.getApplicationCd()
                                     + "] is not found.");
    Assert.isTrue(!ApplicationStatus.APPLICATION_CANCEL.equals(applicationDetail.getApplicationStatus()),
                  "Application is cancelled.");

    Assert.notNull(ApplicationStatus.FINAL_EXAMINATION_OVER.equals(applicationDetail.getApplicationStatus()),
                   "Application is not yet approved");

    Assert.notNull(applicationDetail.isNoAgreementCd(),
                   "Sales for the application is already processed.");

    Assert.notNull(!requestDTO.getClaimDate().toLocalDate().isBefore(applicationDetail.getJudgementDate()),
                   "Claim date is before approval date.");
    
    Assert.isTrue(requestDTO.getStoreCd() != null && !requestDTO.getStoreCd().trim().isEmpty(),
        "User is not associated with any store.");
    
    Assert.isTrue(requestDTO.getStoreCd().equalsIgnoreCase(applicationDetail.getStoreCd()),
                  "No permission to process application.");
    
  }

}
