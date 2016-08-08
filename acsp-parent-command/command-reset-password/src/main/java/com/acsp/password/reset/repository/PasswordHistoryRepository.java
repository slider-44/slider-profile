package com.acsp.password.reset.repository;

import static com.acsp.core.rs.db.tables.HAccountPassword.H_ACCOUNT_PASSWORD;



import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.common.security.ACSPUser;
import com.acsp.password.reset.dto.PasswordHistoryDTO;
import com.acsp.password.reset.dto.SavePasswordDTO;

@Component
public class PasswordHistoryRepository {

	@Autowired
	PasswordHistoryGateway passwordHistoryGateway;
	
	
	public List<PasswordHistoryDTO> getPasswordHistory(Condition condition){
		
		List<Record> records = passwordHistoryGateway.getPasswordHistory(condition);
		List<PasswordHistoryDTO> resultList = new ArrayList<>();
		
		for(Record record : records){			
			PasswordHistoryDTO passwordHistoryDTO = new PasswordHistoryDTO()
						.setCreateDate(record.getValue(H_ACCOUNT_PASSWORD.CREATEDATE).toString())
						.setUserCd(record.getValue(H_ACCOUNT_PASSWORD.USERCD))
						.setPassword(record.getValue(H_ACCOUNT_PASSWORD.PASSWORD));
			resultList.add(passwordHistoryDTO);
		}
		
		return resultList;
	}
	
	public SavePasswordDTO insertHistory(SavePasswordDTO savePasswordDTO, ACSPUser acspUser) {
		
		return passwordHistoryGateway.insertHistory(savePasswordDTO, acspUser);
		
	}
	
	
	
	
}
