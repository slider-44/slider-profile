package com.acsp.telefollow.service;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.telefollow.User;

import static com.acsp.core.rs.db.tables.MAccountExt.M_ACCOUNT_EXT;
import static com.acsp.core.rs.db.tables.MAccountRoles.M_ACCOUNT_ROLES;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserServiceRepository userRepository;
	
	public List<User> getUserList() {
		Condition condition = M_ACCOUNT_ROLES.ROLE.eq("ROLE_CS_AGENT");
		List<Record> recUser = userRepository.getUserList(condition);
		
		List<User> userList = new ArrayList<>();

		for(Record rec : recUser){
			
			User user = new User();
			
			user.setUserCd(rec.getValue(M_ACCOUNT_EXT.USERCD));
			userList.add(user);
		}
		
		return userList;
	}

}
