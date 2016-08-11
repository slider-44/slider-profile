package com.acsp.salesprocess.service;

import com.acsp.salesprocess.dto.AgreementDTO;
import com.acsp.salesprocess.dto.SalesProcessResponseDTO;

public interface CreditDataService {

  void processCreditData(AgreementDTO agreementDTO, SalesProcessResponseDTO responseDTO);
  
}
