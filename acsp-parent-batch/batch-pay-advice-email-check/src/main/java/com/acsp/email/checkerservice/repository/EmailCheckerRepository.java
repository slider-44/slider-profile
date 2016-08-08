package com.acsp.email.checkerservice.repository;

import java.util.List;

import org.jooq.Record;

import com.acsp.email.checkerservice.dto.EmailCheckerDto;

public interface EmailCheckerRepository {

	List<Record> searchSMSQuery(EmailCheckerDto checkerDTO);
	
}
