package com.acsp.viewimage.service;

import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.acsp.core.rs.db.tables.TApplication.T_APPLICATION;
import static com.acsp.core.rs.db.tables.TAgreement.T_AGREEMENT;
import static com.acsp.core.rs.db.tables.TImage.T_IMAGE;

@Component
public class ViewImageServiceImpl implements ViewImageService {
	
	@Autowired
	protected DSLContext jooq;

	public List<Record> getSalesImages(Condition customerCd) {
		
		return jooq
			.select(T_IMAGE.IMAGECODE)
			.select(T_IMAGE.IMAGEFILENAME.as("IMG"))
			.select(T_IMAGE.IMAGEPATH.as("THUMB"))
			.from(T_AGREEMENT)
				.innerJoin(T_APPLICATION)
				.on(T_AGREEMENT.SYSAPPCD.eq(T_APPLICATION.SYSAPPCD))
				.innerJoin(T_IMAGE)
				.on(T_IMAGE.DATACD.eq(T_APPLICATION.APPCD))
				.where(customerCd.and(T_APPLICATION.DELFLAG.eq((byte) 0))).fetch();			
		 
	}


	
}
