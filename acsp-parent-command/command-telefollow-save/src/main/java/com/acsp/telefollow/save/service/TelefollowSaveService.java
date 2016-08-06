package com.acsp.telefollow.save.service;

import com.acsp.common.security.ACSPUser;
import com.acsp.telefollow.save.dto.TelefollowSaveDTO;

public interface TelefollowSaveService {

	TelefollowSaveDTO save(TelefollowSaveDTO telefollowSaveDTO, ACSPUser acspUser);
}
