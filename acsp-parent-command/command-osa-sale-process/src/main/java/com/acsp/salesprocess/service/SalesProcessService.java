package com.acsp.salesprocess.service;

import com.acsp.salesprocess.dto.SalesProcessRequestDTO;
import com.acsp.salesprocess.dto.SalesProcessResponseDTO;

public interface SalesProcessService {

	SalesProcessResponseDTO performSalesProcess(SalesProcessRequestDTO requestDTO);
	
}
