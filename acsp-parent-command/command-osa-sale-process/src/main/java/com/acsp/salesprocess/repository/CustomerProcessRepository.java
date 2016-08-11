package com.acsp.salesprocess.repository;

import com.acsp.salesprocess.dto.CustomerDTO;

public interface CustomerProcessRepository {

	CustomerDTO getCustomerInfo(String applicationCd);
	
	Byte getIdNo(String customerCd);
	
	int updateCustomerIdPrimary(CustomerDTO customerDTO);
	
	int insertCustomerIdPrimary(CustomerDTO customerDTO);

}
