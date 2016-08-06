package com.acsp.merchant.bank.save.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsp.common.security.ACSPUser;
import com.acsp.merchant.bank.save.dto.MerchantBankSaveDTO;
import com.acsp.merchant.bank.save.repository.MerchantBankSaveRepository;
/**
 * Created by elaguardia on 06/28/2016.
 */
@Service
public class MerchantBankSaveServiceImpl implements MerchantBankSaveService {

	@Autowired
	MerchantBankSaveRepository merchantBankSaveRepository;
	
	@Override
	public MerchantBankSaveDTO save(MerchantBankSaveDTO merchantBankSaveDTO, ACSPUser acspUser) {
		
		merchantBankSaveRepository.save(merchantBankSaveDTO, acspUser);
		
		return merchantBankSaveDTO;
	}

}
