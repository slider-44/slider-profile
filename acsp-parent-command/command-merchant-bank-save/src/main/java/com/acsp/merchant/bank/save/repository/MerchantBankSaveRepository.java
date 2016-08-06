package com.acsp.merchant.bank.save.repository;

import com.acsp.common.security.ACSPUser;
import com.acsp.merchant.bank.save.dto.MerchantBankSaveDTO;

public interface MerchantBankSaveRepository {

	MerchantBankSaveDTO save(MerchantBankSaveDTO merchantSaveDTO, ACSPUser acspUser);
}
