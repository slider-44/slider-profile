package com.acsp.telefollow.service;

import static com.acsp.core.rs.db.tables.MAccountExt.M_ACCOUNT_EXT;
import static com.acsp.core.rs.db.tables.MAccountRoles.M_ACCOUNT_ROLES;

import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceRepository {
	
	@Autowired
	private DSLContext jooq;
	
	/**
	 * Fetch the list of Customer service user from M_ACCOUNT_EXT table.
	 * @param Condition condition
	 * @return List<Record>
	 */
	public List<Record> getUserList(Condition condition) {
		
		return jooq
				.select(M_ACCOUNT_EXT.USERCD)
				.select(M_ACCOUNT_EXT.FIRST_NAME)
				.select(M_ACCOUNT_EXT.LAST_NAME)
				.from(M_ACCOUNT_EXT).innerJoin(M_ACCOUNT_ROLES)
				.on(M_ACCOUNT_EXT.USERCD.eq(M_ACCOUNT_ROLES.USERCD))
				.where(condition).fetch();
	}
	
}
