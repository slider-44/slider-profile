package com.acsp.password.reset.repository;

import java.util.List;

import org.jooq.Condition;
import org.jooq.Record;

import com.acsp.common.security.ACSPUser;
import com.acsp.password.reset.dto.SavePasswordDTO;

public interface PasswordHistoryGateway {

	 List<Record> getPasswordHistory(Condition condition);
	 
	 SavePasswordDTO insertHistory(SavePasswordDTO savePasswordDTO, ACSPUser acspUser);
	
}
