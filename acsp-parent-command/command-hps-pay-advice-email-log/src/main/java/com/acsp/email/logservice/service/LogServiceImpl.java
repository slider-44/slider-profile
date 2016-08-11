package com.acsp.email.logservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.email.logservice.dto.EmailLogDTO;
import com.acsp.email.logservice.repository.LogRepository;

@Service
public class LogServiceImpl implements LogService {

	private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

	@Autowired
	LogRepository logRepository;

	@Override
	public BaseResponseDTO executeLog(EmailLogDTO emailLogDTO) {

		BaseResponseDTO responseDTO = new BaseResponseDTO();

		try {
			
			boolean isSuccess = logRepository.save(emailLogDTO);
			
			responseDTO.setResponseSuccess(isSuccess);
			
		} catch (Exception e) {
			
			responseDTO.setResponseSuccess(false);
			responseDTO.setResponseMessage(e.getMessage());
			
			logger.error("Failed to save" + emailLogDTO, e);
			
		}

		return responseDTO;

	}

}
