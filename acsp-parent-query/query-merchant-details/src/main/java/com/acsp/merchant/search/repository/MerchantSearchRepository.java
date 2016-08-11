package com.acsp.merchant.search.repository;

import java.util.List;

import com.acsp.merchant.search.dto.MerchantDTO;

public interface MerchantSearchRepository {
	
	List<MerchantDTO> getMerchantsList();

}
