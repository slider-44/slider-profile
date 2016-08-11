package com.acsp.telefollow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.acsp.telefollow.service.ProcessTelefollow;
import com.acsp.telefollow.service.TelefollowService;
import com.acsp.telefollow.service.UserService;

@Component
public class ScheduledTasks {

	@Autowired
	private TelefollowService telefollowService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProcessTelefollow process;
	
	@Scheduled(cron = "${tele.sched}")
	public void runBatch() {

		// get the list of all CS user from query-users
		List<User> getUserList = userService.getUserList();
		
		int userCnt = getUserList.size();
		
		// get the list of all waiting for pickup calls
		List<Telefollow> teleFollow = telefollowService.getList();
		
		int counter = 0;
		
		if (teleFollow.size() > 0) {
			
			if(getUserList.size() > 0){
				
				for (Telefollow telObj : teleFollow) {
					
						if(counter>=userCnt){
							counter=0;
						}
						
						AllocatedTelefollow alloc = doAllocationBuilder(getUserList, telObj, userCnt,counter);
						
						process.save(alloc);
						
						counter++;
				}
				
			} else {
				
				System.out.println("No available users to be allocated.");
				
			}
		} else {
			
			System.out.println("No available application");
			
		}

	}
	
	/**
	 * 
	 * @param getUserList
	 * @param telObj
	 * @return AllocatedTelefollow
	 * 
	 * Builder method to allocate calls to users.
	 * 
	 */
	private AllocatedTelefollow doAllocationBuilder(List<User> getUserList, Telefollow telObj, int userCnt, int counter) {
		
		AllocatedTelefollow allocObj = new AllocatedTelefollow();
		
		allocObj.setAppCd(telObj.getAppCd());
		allocObj.setCalled("N");
		
		// set usercd to allocate object.
		if(getUserList.size()>0){
			allocObj.setUserCd(getUserList.get(counter).getUserCd());
		}
		
		return allocObj;
	}
}
