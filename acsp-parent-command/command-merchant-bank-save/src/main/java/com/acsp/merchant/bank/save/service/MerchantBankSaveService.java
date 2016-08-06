package com.acsp.merchant.bank.save.service;

import com.acsp.common.security.ACSPUser;
import com.acsp.merchant.bank.save.dto.MerchantBankSaveDTO;

public interface MerchantBankSaveService {
	
	MerchantBankSaveDTO save(MerchantBankSaveDTO merchantBankSaveDTO, ACSPUser acspUser);
}
