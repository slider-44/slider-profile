package com.acsp.telefollow.search.service;

import java.util.List;

import com.acsp.common.security.ACSPUser;
import com.acsp.telefollow.search.dto.TeleFollowDTO;

public interface TelefollowSearch {

	List<TeleFollowDTO> search(ACSPUser acspUser, String allocated);
}
