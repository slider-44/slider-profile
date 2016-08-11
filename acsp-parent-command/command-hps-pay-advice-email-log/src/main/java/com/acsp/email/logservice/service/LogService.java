package com.acsp.email.logservice.service;

import com.acsp.common.dto.BaseResponseDTO;
import com.acsp.email.logservice.dto.EmailLogDTO;

public interface LogService {

	BaseResponseDTO executeLog(EmailLogDTO emailLogDTO);

}
