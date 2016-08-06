package com.acsp.telefollow.save.repository;

import com.acsp.common.security.ACSPUser;

import com.acsp.telefollow.save.dto.TelefollowSaveDTO;

public interface TelefollowSaveRepository {

	TelefollowSaveDTO save(TelefollowSaveDTO telefollowSaveDTO, ACSPUser acspUser);
}
