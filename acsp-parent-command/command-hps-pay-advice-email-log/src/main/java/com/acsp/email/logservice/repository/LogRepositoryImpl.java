package com.acsp.email.logservice.repository;

import static com.acsp.core.rs.db.tables.TEmailDetails.T_EMAIL_DETAILS;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acsp.common.util.DateTimeUtil;
import com.acsp.core.orm.util.NumberingMachineUtil;
import com.acsp.email.logservice.dto.EmailLogDTO;

@Repository
public class LogRepositoryImpl implements LogRepository{

	@Autowired
	DSLContext jooq;
	
	@Override
	public boolean save(EmailLogDTO emailLogDTO) {
		
		String emailCD = NumberingMachineUtil.fileGenerateRequestNumber("T_EMAIL_DETAILS", jooq);
		
		int recordCount = jooq.insertInto(T_EMAIL_DETAILS,
						T_EMAIL_DETAILS.EMAILCD,
						T_EMAIL_DETAILS.AGREEMENTCD, 
						T_EMAIL_DETAILS.NAME, 
						T_EMAIL_DETAILS.EMAIL,
						T_EMAIL_DETAILS.MOBILE_NO,
						T_EMAIL_DETAILS.EMAIL_STATUS,
						T_EMAIL_DETAILS.CREDATE)
				.values(emailCD, 
						emailLogDTO.getParamAgreementCD(),
						emailLogDTO.getName(),
						emailLogDTO.getEmail(),
						emailLogDTO.getMobileNO(),
						emailLogDTO.getEmailStatus().toString(),
						DateTimeUtil.getNowDateString())
				.execute();
		
		return recordCount > 0;
		
	}
	
}
