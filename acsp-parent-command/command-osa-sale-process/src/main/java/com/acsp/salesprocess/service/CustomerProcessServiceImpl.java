package com.acsp.salesprocess.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsp.salesprocess.dto.CustomerDTO;
import com.acsp.salesprocess.dto.SalesProcessRequestDTO;
import com.acsp.salesprocess.dto.SalesProcessResponseDTO;
import com.acsp.salesprocess.repository.CustomerProcessRepository;

@Service
public class CustomerProcessServiceImpl implements CustomerProcessService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerProcessServiceImpl.class);

	@Autowired
	CustomerProcessRepository customerProcessRepository;
	
	public boolean processCustomerInformation(SalesProcessRequestDTO requestDTO, SalesProcessResponseDTO responseDTO){
		
		CustomerDTO customer = customerProcessRepository.getCustomerInfo(requestDTO.getApplicationCd());
		
		Byte idNo = customerProcessRepository.getIdNo(customer.getCustomerCd());
		customer.setIdNo(idNo);
		
		if(!isEmpty(customer.getIdCardType()) && !isEmpty(customer.getIdCardNo())) {
			
			int updateCount = customerProcessRepository.updateCustomerIdPrimary(customer);
			
			logger.debug("Updated " + updateCount + " records for " + customer.getCustomerCd());
			
			int insertCount = customerProcessRepository.insertCustomerIdPrimary(customer);
			
			if(insertCount == 0) {
				
				logger.debug("Error inserting M_ACCOUNT_ID records for " + customer.getCustomerCd());	
				
				responseDTO.setResponseSuccess(false);
				responseDTO.setResponseMessage("Error updating records.");
				
				return false;
			}
			
		}
		
		return true;
		
	}
	
	private boolean isEmpty(Byte value) {
		return value == null;
	}
	
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
	
	
}
