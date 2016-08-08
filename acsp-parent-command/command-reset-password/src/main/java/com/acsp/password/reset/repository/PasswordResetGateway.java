package com.acsp.password.reset.repository;

import java.util.List;


import com.acsp.common.security.ACSPUser;
import com.acsp.password.reset.dto.AccountDetailsDTO;
import com.acsp.password.reset.dto.SavePasswordDTO;

public interface PasswordResetGateway {
	
	 SavePasswordDTO save(SavePasswordDTO savePasswordDTO, ACSPUser acspUser);
	 
	 List<AccountDetailsDTO> findByUsername(String username);
	 
	 
}
