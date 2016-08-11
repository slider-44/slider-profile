package com.acsp.telefollow.service;

import static com.acsp.core.rs.db.tables.HTelefollowH.H_TELEFOLLOW_H;
import static com.acsp.core.rs.db.tables.MCustomer.M_CUSTOMER;
import static com.acsp.core.rs.db.tables.TApplication.T_APPLICATION;
import static com.acsp.core.rs.db.tables.HAllocation.H_ALLOCATION;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeleFollowRepository {
	
	@Autowired
	protected DSLContext jooq;

	public List<Record> getList() {
		
		return jooq
				.selectDistinct(T_APPLICATION.APPCD)
				.select(T_APPLICATION.SYSAPPCD)
				.select(T_APPLICATION.APPDATE)
				.select(M_CUSTOMER.FIRSTNAME)
				.select(M_CUSTOMER.MIDDLENAME)
				.select(M_CUSTOMER.SURNAME)
				.from(T_APPLICATION, M_CUSTOMER, H_TELEFOLLOW_H, H_ALLOCATION)
				.where(T_APPLICATION.CUSTOMERCD.eq(M_CUSTOMER.CUSTOMERCD)
						.and("T_APPLICATION.APPCD=H_TELEFOLLOW_H.APPCD (+)"))
						.and(H_TELEFOLLOW_H.APPCD.isNull())
						.and(T_APPLICATION.APPROVECD.isNotNull())
						.and("T_APPLICATION.APPSTATUS <> 6")
						.and("T_APPLICATION.APPROVECD not in (select distinct agreementcd from t_agreement)")
						.and("T_APPLICATION.APPCD not in (select distinct appcd from h_allocation)")
						.and("rownum<=2000").orderBy(T_APPLICATION.APPDATE.desc())
				.fetch();
	}
}
