package com.acsp.email.checkerservice.repository;

import static com.acsp.core.rs.db.tables.TEmailDetails.T_EMAIL_DETAILS;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acsp.email.checkerservice.dto.EmailCheckerDto;
import com.acsp.email.checkerservice.dto.EmailStatus;

@Repository
public class EmailCheckerRepositoryImpl implements EmailCheckerRepository{
	
	@Autowired
	DSLContext jooq;

	@Override
	public List<Record> searchSMSQuery(EmailCheckerDto checkerDTO) {
		
		  List<Record> record = jooq
				  					.select(T_EMAIL_DETAILS.MOBILE_NO)
				  					.select(T_EMAIL_DETAILS.AGREEMENTCD)
				  					.from(T_EMAIL_DETAILS)
				  					.where(T_EMAIL_DETAILS.EMAIL_STATUS.eq(EmailStatus.SUCCESS.toString()))
				  					.and(T_EMAIL_DETAILS.CREDATE.eq(checkerDTO.getDate())).fetch();
		  
		return record;
		
	}
	
}
