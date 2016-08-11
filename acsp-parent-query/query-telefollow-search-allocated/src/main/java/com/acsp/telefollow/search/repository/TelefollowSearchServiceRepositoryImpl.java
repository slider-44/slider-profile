package com.acsp.telefollow.search.repository;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acsp.common.security.ACSPUser;
import com.acsp.telefollow.search.dto.ProductDTO;
import com.acsp.telefollow.search.dto.TeleFollowDTO;
import com.acsp.telefollow.search.dto.TelefollowHistoryDTO;

import static com.acsp.core.rs.db.tables.TApplication.T_APPLICATION;
import static com.acsp.core.rs.db.tables.MStore.M_STORE;
import static com.acsp.core.rs.db.tables.MCustomer.M_CUSTOMER;
import static com.acsp.core.rs.db.tables.HTelefollowH.H_TELEFOLLOW_H;
import static com.acsp.core.rs.db.tables.HTelefollowD.H_TELEFOLLOW_D;
import static com.acsp.core.rs.db.tables.TProduct.T_PRODUCT;
import static com.acsp.core.rs.db.tables.MPromotion.M_PROMOTION;
import static com.acsp.core.rs.db.tables.TAgreement.T_AGREEMENT;
import static com.acsp.core.rs.db.tables.HAllocation.H_ALLOCATION;
/**
 * Controller for Search
 * @Author Elizabeth Laguardia
 * 07042016: Exclude in Tracker all Data with Sales Pending Status
 */
@Repository
public class TelefollowSearchServiceRepositoryImpl implements TelefollowSearchServiceRepository {

	@Autowired
	protected DSLContext jooq;
	
	
	@Override
	public List<TeleFollowDTO> getNewAllocatedList(ACSPUser acspUser, String allocated) {
		
		List<Record> records;
		
		//newly allocated
		if(allocated.equals("N")) { 
			
			records = getNewAllocatedRecords(acspUser); 
		}
		else { //Tracker
			records = getTracker(acspUser);
		}
			
		Map<String,TeleFollowDTO> resultMap = new HashMap<>();
		
		if(records.size() > 0) {
		records.stream()
		.forEach(record-> {
			TeleFollowDTO teleFollowDTO = new TeleFollowDTO();
			
			teleFollowDTO.setAppCd(record.getValue(record.field("APPLICATIONNO")).toString());
			teleFollowDTO.setApplicationDate(record.getValue(record.field("APPDATE")).toString());
			teleFollowDTO.setFirstName(record.getValue(record.field("FIRSTNAME")).toString());
			teleFollowDTO.setLastName(record.getValue(record.field("SURNAME")).toString());
			teleFollowDTO.setApprovalDate(record.getValue(record.field("APPROVALDATE")).toString());
			teleFollowDTO.setStoreName(record.getValue(record.field("STORENAME")).toString());
			teleFollowDTO.setStorePhone(record.getValue(record.field("STOREPHONE")).toString());
			teleFollowDTO.setStorePic(record.getValue(record.field("PIC")).toString());
			teleFollowDTO.setApprovalCode(record.getValue(record.field("APPROVECODE")).toString());
			teleFollowDTO.setMobileNo(record.getValue(record.field("MOBILENO")).toString());
			teleFollowDTO.setHomePhone(record.getValue(record.field("HOMEPHONE")).toString());
			teleFollowDTO.setOfficePhone(record.getValue(record.field("CORPTEL")).toString());
			
			if(allocated.equals("Y")) { 
				teleFollowDTO.setFollowupDate(record.getValue(record.field("FOLLOWUPDATE")).toString());
				teleFollowDTO.setCommitmentDate(record.getValue(record.field("COMMITMENTDATE")).toString());
			    teleFollowDTO.setMethod(record.getValue(H_TELEFOLLOW_D.METHOD));
			    teleFollowDTO.setSalesPending(record.getValue(record.field("SALESPENDING")).toString());
			}
		
	
			resultMap.put(record.getValue(record.field("SYSAPPCD")).toString(),teleFollowDTO);
		});
		
		List<Record> recordsProd = getProductsforNewAllocatedRecords(acspUser,allocated);
		
		
		recordsProd.stream()
		.forEach(productrecord -> { 
			ProductDTO productDTO = new ProductDTO();
			
			productDTO.setSysAppCd(productrecord.getValue(T_PRODUCT.SYSAPPCD));
			productDTO.setNameType(productrecord.getValue(T_PRODUCT.NAMEANDTYPE));
			productDTO.setModelNo(productrecord.getValue(T_PRODUCT.MODELNO));
			productDTO.setProductNo(productrecord.getValue(T_PRODUCT.PRODUCTNO));
			productDTO.setFinancePrice(productrecord.getValue(T_PRODUCT.FINANCEPRICE).toString());
			productDTO.setInterest(productrecord.getValue(T_PRODUCT.INTERESTAMOUNT).toString());
			productDTO.setFullPrice(productrecord.getValue(T_PRODUCT.HPPRICE).toString());
	
			if(resultMap.containsKey(productDTO.getSysAppCd())){
				resultMap.get(productDTO.getSysAppCd()).getProducts().add(productDTO);
			}
			
		});
		
		 List<Record> recordsHist = getTelefollowHistory(allocated);
		 
		 recordsHist.stream()
		 .forEach(historyRecord -> {
			 TelefollowHistoryDTO telefollowHistoryDTO = new TelefollowHistoryDTO();
			 
			 telefollowHistoryDTO.setAppCd(historyRecord.getValue(H_TELEFOLLOW_D.APPCD));
			 telefollowHistoryDTO.setAction(historyRecord.getValue(H_TELEFOLLOW_D.ACTION).toString());
			 telefollowHistoryDTO.setContacted(historyRecord.getValue(H_TELEFOLLOW_D.CONTACTTO).toString());
			 telefollowHistoryDTO.setComment(historyRecord.getValue(H_TELEFOLLOW_D.COMMENTS));
			 telefollowHistoryDTO.setSysAppCd(historyRecord.getValue(T_APPLICATION.SYSAPPCD));
			 telefollowHistoryDTO.setStatus(historyRecord.getValue(H_TELEFOLLOW_D.STATUS).toString());
			 telefollowHistoryDTO.setCreateDate(historyRecord.getValue(historyRecord.field("CREATEDATE")).toString());
			 telefollowHistoryDTO.setCommitmentDate(historyRecord.getValue(historyRecord.field("COMMITMENTDATE")).toString());
			 telefollowHistoryDTO.setFollowupDate(historyRecord.getValue(historyRecord.field("FOLLOWUPDATE")).toString());
		
		
			if(resultMap.containsKey(telefollowHistoryDTO.getSysappcd())){
				 resultMap.get(telefollowHistoryDTO.getSysappcd()).getTelefollowHistory().add(telefollowHistoryDTO);
			}
			
		 });
		 
		}
	     
		List<TeleFollowDTO> resultList = new ArrayList<>() ;
	    resultList.addAll(resultMap.values());
		
		 return resultList;
	}
	
	 
	
	private Result<Record> getTelefollowHistory(String allocated) {
		
		Field<?> FOLLOWUPDATE = DSL.field("NVL(TO_CHAR(TO_DATE(H_TELEFOLLOW_D.RECONTACTDATE, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> COMMITMENTDATE = DSL.field("NVL(TO_CHAR(TO_DATE(H_TELEFOLLOW_D.COMMITMENTDATE, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> SALESPENDING = DSL.field("NVL(TO_CHAR(TO_DATE(H_TELEFOLLOW_D.SALESPENDING, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> CREATEDATE = DSL.field("NVL(TO_CHAR(TO_DATE(H_TELEFOLLOW_D.CREDATE, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		return jooq
				.select(H_TELEFOLLOW_D.CREDATE)
				.select(H_TELEFOLLOW_D.TELEFOLLOWCD)
				.select(H_TELEFOLLOW_D.APPCD)
				.select(T_APPLICATION.SYSAPPCD)
				.select(H_TELEFOLLOW_D.CONTACTTO)
				.select(H_TELEFOLLOW_D.STATUS)
				.select(H_TELEFOLLOW_D.ACTION)
				.select(FOLLOWUPDATE.as("FOLLOWUPDATE"))
				.select(COMMITMENTDATE.as("COMMITMENTDATE"))
				.select(SALESPENDING.as("SALESPENDING"))
				.select(CREATEDATE.as("CREATEDATE"))
				.select(H_TELEFOLLOW_D.METHOD)
				.select(H_TELEFOLLOW_D.COMMENTS)
				.from(H_TELEFOLLOW_H)
				.innerJoin(H_TELEFOLLOW_D).on(H_TELEFOLLOW_D.APPCD.eq( H_TELEFOLLOW_H.APPCD))
				.innerJoin(T_APPLICATION).on(T_APPLICATION.APPCD.eq(H_TELEFOLLOW_D.APPCD))
				.innerJoin(H_ALLOCATION).on(H_ALLOCATION.APPCD.eq(H_TELEFOLLOW_D.APPCD))
				.where(H_ALLOCATION.CALLED.eq(allocated)).orderBy(H_TELEFOLLOW_D.TELEFOLLOWCD.desc())
				.fetch();
	}
	
	private Result<Record> getProductsforNewAllocatedRecords(ACSPUser acspUser, String allocated) {
		
		return jooq
				.select(T_PRODUCT.SYSAPPCD)
				.select(T_PRODUCT.PRODUCTNO)
				.select(T_PRODUCT.NAMEANDTYPE)
				.select(T_PRODUCT.MODELNO)
				.select(T_PRODUCT.FINANCEPRICE)
				.select(T_PRODUCT.INTERESTAMOUNT)
				.select(T_PRODUCT.HPPRICE)
				.from(T_PRODUCT)
				.innerJoin(T_APPLICATION).on(T_APPLICATION.SYSAPPCD.eq(T_PRODUCT.SYSAPPCD))
				.innerJoin(H_ALLOCATION).on(H_ALLOCATION.APPCD.eq(T_APPLICATION.APPCD))
				.where(H_ALLOCATION.CALLED.eq(allocated))
				.fetch();
	}
	
	private Result<Record> getTracker(ACSPUser acspUser) {
		
	    Field<?> STOREPHONE = DSL.field("CONCAT(CONCAT(M_STORE.TELREGION, '-'), M_STORE.TELNO)");
		
		Field<?> FOLLOWUPDATE = DSL.field("NVL(TO_CHAR(TO_DATE(H_TELEFOLLOW_D.RECONTACTDATE, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> SALESPENDING = DSL.field("NVL(TO_CHAR(TO_DATE(H_TELEFOLLOW_D.SALESPENDING, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> COMMITMENTDATE = DSL.field("NVL(TO_CHAR(TO_DATE(H_TELEFOLLOW_D.COMMITMENTDATE, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> APPROVALDATE = DSL.field("NVL(TO_CHAR(TO_DATE(T_APPLICATION.JUDGEMENTDATE, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> APPDATE = DSL.field("NVL(TO_CHAR(TO_DATE(T_APPLICATION.APPDATE, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> HOMETEL = DSL.field("NVL(M_CUSTOMER.HOMETEL, '---')");
		
		Field<?> MOBILENO = DSL.field("NVL(M_CUSTOMER.MOBILENO, '---')");
		
		Field<?> METHOD = DSL.field("NVL(H_TELEFOLLOW_D.METHOD, '---')");
		
		
		
		return jooq
	               .select(T_APPLICATION.APPCD.as("APPLICATIONNO"))
	               .select(APPDATE.as("APPDATE"))
	               .select(T_APPLICATION.SYSAPPCD)
	               .select(T_APPLICATION.APPROVECD.as("APPROVECODE"))
	               .select(APPROVALDATE.as("APPROVALDATE"))
	               .select(M_STORE.STORENAME)
	               .select(STOREPHONE.as("STOREPHONE"))
	               .select(M_STORE.PIC)
	               .select(M_CUSTOMER.FIRSTNAME)
	               .select(M_CUSTOMER.MIDDLENAME)
	               .select(M_CUSTOMER.SURNAME)
	               .select(HOMETEL.as("HOMEPHONE"))
	               .select(MOBILENO.as("MOBILENO"))
	               .select(FOLLOWUPDATE.as("FOLLOWUPDATE"))
	               .select(COMMITMENTDATE.as("COMMITMENTDATE"))
	               .select(SALESPENDING.as("SALESPENDING"))
	               .select(METHOD.as("METHOD"))
	               .select(M_CUSTOMER.CORPTEL)
	               .select(H_TELEFOLLOW_H.LASTSTATUS)
	               .select(H_TELEFOLLOW_H.LASTACTION)
	               .select(T_PRODUCT.NAMEANDTYPE)
	               .from(T_APPLICATION).innerJoin(M_CUSTOMER)
	               .on(T_APPLICATION.CUSTOMERCD.eq(M_CUSTOMER.CUSTOMERCD))
	               .innerJoin(M_STORE).on(M_STORE.STORECD.eq(T_APPLICATION.STORECD))
	               .innerJoin(T_PRODUCT).on(T_PRODUCT.SYSAPPCD.eq(T_APPLICATION.SYSAPPCD))
	               .leftJoin(M_PROMOTION).on(M_PROMOTION.PROMOTIONCD.eq(T_PRODUCT.PROMOTIONCD))
	               .leftJoin(H_TELEFOLLOW_H).on(H_TELEFOLLOW_H.APPCD.eq(T_APPLICATION.APPCD))
	                .innerJoin(H_TELEFOLLOW_D).on(H_TELEFOLLOW_D.TELEFOLLOWCD.eq(H_TELEFOLLOW_H.TELEFOLLOWCD))
	               .innerJoin(H_ALLOCATION).on(H_ALLOCATION.APPCD.eq(T_APPLICATION.APPCD))
	               .where(T_APPLICATION.SYSAPPCD.notIn(jooq.selectDistinct(T_AGREEMENT.SYSAPPCD).from(T_AGREEMENT)))
	               .and(H_TELEFOLLOW_H.LASTSTATUS.notEqual((byte) 2))
	               .and(H_TELEFOLLOW_H.LASTSTATUS.notEqual((byte) 8)) // Sales Pending
	               .and(H_TELEFOLLOW_H.LASTACTION.notEqual((byte) 2))
	               .and(H_ALLOCATION.USERCD.equal(acspUser.getUserCd()))
	               .and(H_ALLOCATION.CALLED.eq("Y"))
	               .orderBy(T_APPLICATION.JUDGEMENTDATE.asc())
	               .fetch();
	               
		
	}
	
	private Result<Record> getNewAllocatedRecords(ACSPUser acspUser) {

		Field<?> STOREPHONE = DSL.field("CONCAT(CONCAT(M_STORE.TELREGION, '-'), M_STORE.TELNO)");
					
		Field<?> APPROVALDATE = DSL.field("NVL(TO_CHAR(TO_DATE(T_APPLICATION.JUDGEMENTDATE, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> APPDATE = DSL.field("NVL(TO_CHAR(TO_DATE(T_APPLICATION.APPDATE, 'YYYYMMDD'), 'MM/DD/YYYY'), '---')");
		
		Field<?> HOMETEL = DSL.field("NVL(M_CUSTOMER.HOMETEL, '---')");
		
		Field<?> MOBILENO = DSL.field("NVL(M_CUSTOMER.MOBILENO, '---')");
		
		
		
		return jooq
	               .select(T_APPLICATION.APPCD.as("APPLICATIONNO"))
	               .select(APPDATE.as("APPDATE"))
	               .select(T_APPLICATION.SYSAPPCD)
	               .select(T_APPLICATION.APPROVECD.as("APPROVECODE"))
	               .select(APPROVALDATE.as("APPROVALDATE"))
	               .select(M_STORE.STORENAME)
	               .select(STOREPHONE.as("STOREPHONE"))
	               .select(M_STORE.PIC)
	               .select(M_CUSTOMER.FIRSTNAME)
	               .select(M_CUSTOMER.MIDDLENAME)
	               .select(M_CUSTOMER.SURNAME)
	               .select(HOMETEL.as("HOMEPHONE"))
	               .select(MOBILENO.as("MOBILENO"))
	               .select(M_CUSTOMER.CORPTEL)
	               .select(H_TELEFOLLOW_H.LASTSTATUS)
	               .select(H_TELEFOLLOW_H.LASTACTION)
	               .select(T_PRODUCT.NAMEANDTYPE)
	               .from(T_APPLICATION).innerJoin(M_CUSTOMER)
	               .on(T_APPLICATION.CUSTOMERCD.eq(M_CUSTOMER.CUSTOMERCD))
	               .innerJoin(M_STORE).on(M_STORE.STORECD.eq(T_APPLICATION.STORECD))
	               .innerJoin(T_PRODUCT).on(T_PRODUCT.SYSAPPCD.eq(T_APPLICATION.SYSAPPCD))
	               .leftJoin(M_PROMOTION).on(M_PROMOTION.PROMOTIONCD.eq(T_PRODUCT.PROMOTIONCD))
	               .leftJoin(H_TELEFOLLOW_H).on(H_TELEFOLLOW_H.APPCD.eq(T_APPLICATION.APPCD))
	               .innerJoin(H_ALLOCATION).on(H_ALLOCATION.APPCD.eq(T_APPLICATION.APPCD))
	               .where(T_APPLICATION.SYSAPPCD.notIn(jooq.selectDistinct(T_AGREEMENT.SYSAPPCD).from(T_AGREEMENT)))
	               .and(T_APPLICATION.DELFLAG.eq((byte) 0))
	               .and(T_APPLICATION.APPSTATUS.notEqual((byte)6))
	               .and(T_APPLICATION.APPROVECD.isNotNull())
	               .and(T_PRODUCT.PRODUCTNO.eq("001"))
	               .and(M_PROMOTION.PARTNERNAME.isNotNull().or(M_PROMOTION.PARTNERNAME.notLike("C:%")))
	               .and(T_PRODUCT.PROMOTIONCD.isNotNull().or(T_PRODUCT.PROMOTIONCD.notLike("M%")))
	               .and(H_ALLOCATION.USERCD.equal(acspUser.getUserCd()))
	               .and(H_ALLOCATION.CALLED.eq("N"))
	               .orderBy(T_APPLICATION.JUDGEMENTDATE.asc())
	               .fetch();
	            
	  }
	
	
}
