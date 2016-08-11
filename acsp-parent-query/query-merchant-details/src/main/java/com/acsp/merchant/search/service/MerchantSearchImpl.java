package com.acsp.merchant.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsp.merchant.search.dto.MerchantDTO;
import com.acsp.merchant.search.repository.MerchantSearchRepository;

@Service
public class MerchantSearchImpl implements MerchantSearch {

	@Autowired
	MerchantSearchRepository merchantSearchRepository;
	
	@Override
	public List<MerchantDTO> search() {
		// TODO Auto-generated method stub
		return merchantSearchRepository.getMerchantsList();
	}

}
