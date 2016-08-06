package com.acsp.telefollow.save.repository;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.common.security.ACSPUser;
import com.acsp.telefollow.save.dto.TelefollowSaveDTO;


import static com.acsp.core.rs.db.tables.HTelefollowH.H_TELEFOLLOW_H;
import static com.acsp.core.rs.db.tables.HTelefollowD.H_TELEFOLLOW_D;
import static com.acsp.core.rs.db.tables.HAllocation.H_ALLOCATION;

import java.math.BigDecimal;

@Component
public class TelefollowSaveRepositoryImpl implements TelefollowSaveRepository {

	 private static final Logger logger = LoggerFactory.getLogger(TelefollowSaveRepositoryImpl.class);
	
	@Autowired
	protected DSLContext jooq;
	 
	@Override
	public TelefollowSaveDTO save(TelefollowSaveDTO telefollowSaveDTO, ACSPUser acspUser) {
		
		// TODO INSERT ON TELEFOLLOW_H
		String seqNumber = getTelefollowSequenceNo(telefollowSaveDTO.getAppCd());
		
		telefollowSaveDTO.setTelefollowCd(telefollowSaveDTO.getAppCd().concat("-").concat(seqNumber));
		
		if(telefollowSaveDTO.getStatus().equals(new BigDecimal("1"))) {
			telefollowSaveDTO.setDelflag((byte) 1);
		}
		else {
			telefollowSaveDTO.setDelflag((byte) 0);
		}
			
		//Insert to History
		if(insertTelefollowD(telefollowSaveDTO,acspUser)) {
			telefollowSaveDTO.setCalled("Y");
			Record count = getTelefollowH(telefollowSaveDTO.getAppCd());
			
			if(count != null){ //Do update if record is present, insert if not
				telefollowSaveDTO.setUpdCnt(count.getValue(H_TELEFOLLOW_H.UPDCNT));
				updateTelefollowH(telefollowSaveDTO,acspUser);
				updateAllocation(telefollowSaveDTO);
			}
			else {
				
				if(insertTelefollowH(telefollowSaveDTO,acspUser)) {
					updateAllocation(telefollowSaveDTO);
				}
			}
		}
		
		return telefollowSaveDTO;
	}
	
	private Record getTelefollowSequenceNumber(String appCd) {
		
		Field<?> SEQ = DSL.field("TO_CHAR(TO_NUMBER(SUBSTR(TELEFOLLOWCD,13,2)) + 1, '00')");
		
		return jooq
		 .select(SEQ.as("SEQ"))
		 .from(H_TELEFOLLOW_H)
		 .where(H_TELEFOLLOW_H.APPCD.eq(appCd))
		 .fetchOne();
		
	}
	
	private String getTelefollowSequenceNo(String appCd) {
		
		Record record = getTelefollowSequenceNumber(appCd);
		
		//Fix for null H_TELEFOLLOW_H record condition.
		if(record != null && record.field("SEQ")!=null && record.getValue(record.field("SEQ")) != null) {			
			return record.getValue(record.field("SEQ")).toString().trim();
			
		}
		else {
			return "01";
		}
		
		
	}
	
	private void updateAllocation(TelefollowSaveDTO telefollowSaveDTO) {
		
		jooq.update(H_ALLOCATION)
		.set(H_ALLOCATION.CALLED,telefollowSaveDTO.getCalled())
		.where(H_ALLOCATION.APPCD.equal(telefollowSaveDTO.getAppCd()))
		.execute();
	}
	
	private void updateTelefollowH(TelefollowSaveDTO telefollowSaveDTO,ACSPUser acspUser) {
		
		
		jooq.update(H_TELEFOLLOW_H)
		.set(H_TELEFOLLOW_H.TELEFOLLOWCD,telefollowSaveDTO.getTelefollowCd())
		.set(H_TELEFOLLOW_H.LASTSTATUS, telefollowSaveDTO.getStatus())
		.set(H_TELEFOLLOW_H.LASTACTION, telefollowSaveDTO.getAction())
		.set(H_TELEFOLLOW_H.RECONTACTDATE, Integer.parseInt(telefollowSaveDTO.getFollowupDate()))
		.set(H_TELEFOLLOW_H.UPDDATE, telefollowSaveDTO.getUpdDate())
		.set(H_TELEFOLLOW_H.UPDTIME, telefollowSaveDTO.getUpdTime())
		.set(H_TELEFOLLOW_H.UPDPERSON, acspUser.getUserCd())
		.set(H_TELEFOLLOW_H.DELFLAG, telefollowSaveDTO.getDelflag())
		.where(H_TELEFOLLOW_H.APPCD.equal(telefollowSaveDTO.getAppCd()))
		.execute();
		
	}
	
	private Record getTelefollowH(String appCd) {
		
		return jooq
		.select(H_TELEFOLLOW_H.UPDCNT)
		.select(H_TELEFOLLOW_H.LASTSTATUS)
		.from(H_TELEFOLLOW_H)
		.where(H_TELEFOLLOW_H.APPCD.eq(appCd))
		.fetchOne();
		
	}
	
	private boolean insertTelefollowH(TelefollowSaveDTO telefollowSaveDTO,ACSPUser acspUser) {
		
		int rec = jooq.insertInto(H_TELEFOLLOW_H,
				H_TELEFOLLOW_H.APPCD,
				H_TELEFOLLOW_D.TELEFOLLOWCD,
				H_TELEFOLLOW_H.APPROVALDATE,
				H_TELEFOLLOW_H.LASTSTATUS,
				H_TELEFOLLOW_H.LASTACTION,
				H_TELEFOLLOW_H.RECONTACTDATE,
				H_TELEFOLLOW_H.UPDDATE,
				H_TELEFOLLOW_H.UPDTIME,
				H_TELEFOLLOW_H.UPDPERSON,
				H_TELEFOLLOW_H.UPDCNT,
				H_TELEFOLLOW_H.DELFLAG)
	    .values(telefollowSaveDTO.getAppCd(),
	    		telefollowSaveDTO.getTelefollowCd(),
	    		telefollowSaveDTO.getApprovalDate(),
	    		telefollowSaveDTO.getStatus(),
	    		telefollowSaveDTO.getAction(),
	    		Integer.parseInt(telefollowSaveDTO.getFollowupDate()),
	    		telefollowSaveDTO.getUpdDate(),
	    		telefollowSaveDTO.getUpdTime(),
	    		acspUser.getUserCd(),
	    		telefollowSaveDTO.getUpdCnt(),
	    		telefollowSaveDTO.getDelflag())
	    .execute();
		
		logger.info("Customer with Application ID [" + telefollowSaveDTO.getAppCd() + "] was " + ((rec > 0) ? "successfully saved in H_TELEFOLLOW_H Table" : "not saved."));
		
		if (rec > 0 )
			return true;
		else
			return false;
	}
	
	private boolean insertTelefollowD(TelefollowSaveDTO telefollowSaveDTO,ACSPUser acspUser) {
		
		int rec = jooq.insertInto(H_TELEFOLLOW_D,
				H_TELEFOLLOW_D.APPCD,
				H_TELEFOLLOW_D.TELEFOLLOWCD,
				H_TELEFOLLOW_D.STATUS,
				H_TELEFOLLOW_D.CANCELREASON,
				H_TELEFOLLOW_D.ACTION,
				H_TELEFOLLOW_D.RECONTACTDATE,
				H_TELEFOLLOW_D.COMMENTS,
				H_TELEFOLLOW_D.CONTACTTO,
				H_TELEFOLLOW_D.METHOD,
				H_TELEFOLLOW_D.COMMITMENTDATE,
				H_TELEFOLLOW_D.SALESPENDING,
				H_TELEFOLLOW_D.DELFLAG,
				H_TELEFOLLOW_D.CREDATE,
				H_TELEFOLLOW_D.CRETIME,
				H_TELEFOLLOW_D.CREPERSON)
	    .values(telefollowSaveDTO.getAppCd(),
	    		telefollowSaveDTO.getTelefollowCd(),
	    		telefollowSaveDTO.getStatus(),
	    		telefollowSaveDTO.getCancelReason(),
	    		telefollowSaveDTO.getAction(),
	    		Integer.parseInt(telefollowSaveDTO.getFollowupDate()),
	    		telefollowSaveDTO.getComments(),
	    		telefollowSaveDTO.getContactTo(),
	    		telefollowSaveDTO.getMethod(),
	    		telefollowSaveDTO.getCommitmentDate(),
	    		telefollowSaveDTO.getSalesPending(),
	    		telefollowSaveDTO.getDelflag(),
	    		telefollowSaveDTO.getCreDate(),
	    		telefollowSaveDTO.getCreTime(),
	            acspUser.getUserCd())
	    .execute();
		
		logger.info("Customer with Application ID [" + telefollowSaveDTO.getAppCd() + "] was " + ((rec > 0) ? "successfully saved in H_TELEFOLLOW_D" : "not saved."));
		
		if (rec > 0 )
			return true;
		else
			return false;
		
	}
	
	
	
	

}
