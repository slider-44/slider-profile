package com.acsp.telefollow.search.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsp.common.security.ACSPUser;
import com.acsp.telefollow.search.dto.TeleFollowDTO;
import com.acsp.telefollow.search.repository.TelefollowSearchServiceRepository;

@Service
public class TelefollowSearchImp implements TelefollowSearch {

	@Autowired
	TelefollowSearchServiceRepository telefollowNewAllocatedServiceRepository;
	
	@Override
	public List<TeleFollowDTO> search(ACSPUser acspUser, String allocated) {
	
		return telefollowNewAllocatedServiceRepository.getNewAllocatedList(acspUser,allocated);
	}

}
