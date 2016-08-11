package com.acsp.email.logservice.repository;

import com.acsp.email.logservice.dto.EmailLogDTO;

public interface LogRepository {

	boolean save(EmailLogDTO emailLogDTO);
	
}
