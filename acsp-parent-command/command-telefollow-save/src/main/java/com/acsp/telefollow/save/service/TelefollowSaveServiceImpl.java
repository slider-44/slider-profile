package com.acsp.telefollow.save.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsp.common.security.ACSPUser;
import com.acsp.telefollow.save.dto.TelefollowSaveDTO;
import com.acsp.telefollow.save.repository.TelefollowSaveRepository;

@Service
public class TelefollowSaveServiceImpl implements TelefollowSaveService {

	@Autowired
	TelefollowSaveRepository telefollowSaveServiceRepository;
	
	@Override
	public TelefollowSaveDTO save(TelefollowSaveDTO telefollowSaveDTO, ACSPUser acspUser) {
		
		telefollowSaveServiceRepository.save(telefollowSaveDTO, acspUser);
		  
		 return telefollowSaveDTO;

	}

}
