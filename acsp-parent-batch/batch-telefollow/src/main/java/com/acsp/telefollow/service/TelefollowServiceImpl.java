package com.acsp.telefollow.service;

import static com.acsp.core.rs.db.tables.MCustomer.M_CUSTOMER;
import static com.acsp.core.rs.db.tables.TApplication.T_APPLICATION;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acsp.telefollow.Telefollow;

/**
 * Get the list of application from telefollow query.
 * 
 * @author fcortez
 *
 */
@Component
public class TelefollowServiceImpl implements TelefollowService {
	
	@Autowired
	private TeleFollowRepository teleFollowRepository;
	
	/**
	 * Convert Telefollow array data to list
	 * 
	 */
	public List<Telefollow> getList() {

		List<Record> tellist = teleFollowRepository.getList();
		
		List<Telefollow> resultList = new ArrayList<>();

		for (Record rec : tellist) {
			
			Telefollow teleFollow  = new Telefollow();
			
			teleFollow.setAppDate(String.valueOf(rec.getValue(T_APPLICATION.APPDATE)));
			teleFollow.setAppCd(rec.getValue(T_APPLICATION.APPCD));
			teleFollow.setFirstName(rec.getValue(M_CUSTOMER.FIRSTNAME));
			teleFollow.setMiddleName(rec.getValue(M_CUSTOMER.MIDDLENAME));
			teleFollow.setSurName(rec.getValue(M_CUSTOMER.SURNAME));
			
			resultList.add(teleFollow);
		}
		
		return resultList;

	}
}
