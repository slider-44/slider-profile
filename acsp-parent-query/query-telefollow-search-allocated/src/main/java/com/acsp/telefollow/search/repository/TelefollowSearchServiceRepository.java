package com.acsp.telefollow.search.repository;

import com.acsp.common.security.ACSPUser;
import com.acsp.telefollow.search.dto.TeleFollowDTO;

import java.util.List;


public interface TelefollowSearchServiceRepository {

	List <TeleFollowDTO> getNewAllocatedList(ACSPUser acspUser, String allocated);
}
