package com.acsp.telefollow.service;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.telefollow.AllocatedTelefollow;

import static com.acsp.core.rs.db.tables.HAllocation.H_ALLOCATION;

@Component
public class ProcessTelefollowImpl implements ProcessTelefollow {
	
	@Autowired
	private DSLContext jooq;
	
	public void save(AllocatedTelefollow alloc) {
		
			//Save here
			int rec = jooq
					.insertInto(H_ALLOCATION, H_ALLOCATION.APPCD, 
					H_ALLOCATION.USERCD,
					H_ALLOCATION.CALLED)
			.values(alloc.getAppCd(), 
					alloc.getUserCd(), 
					alloc.getCalled()).execute();
			
	}

}
