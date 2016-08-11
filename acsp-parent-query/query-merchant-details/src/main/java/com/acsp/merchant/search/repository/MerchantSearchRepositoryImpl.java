package com.acsp.merchant.search.repository;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acsp.merchant.search.dto.MerchantDTO;

import static com.acsp.core.rs.db.tables.MAgent.M_AGENT;
import static com.acsp.core.rs.db.tables.MBankMerchant.M_BANK_MERCHANT;

@Repository
public class MerchantSearchRepositoryImpl implements MerchantSearchRepository {

	@Autowired
	protected DSLContext jooq;
	
	@Override
	public List<MerchantDTO> getMerchantsList() {
		
		List<Record> records = getAllMerchant();
		
		List<MerchantDTO> resultList = new ArrayList<>();
		
		if(records.size() > 0) {
			
			records.stream()
			.forEach(record -> {
				MerchantDTO merchantDTO = new MerchantDTO();
				
				merchantDTO.setAgentCd(record.getValue(M_AGENT.AGENTCD));
				merchantDTO.setAgentName(record.getValue(M_AGENT.AGENTNAME));
				merchantDTO.setMerchantCategory(record.getValue(M_AGENT.MERCHANTCATEGORY));
				merchantDTO.setMerchantAddress(record.getValue(M_AGENT.AGENTADDRESS));
				merchantDTO.setPic(record.getValue(M_AGENT.PIC));
				merchantDTO.setAccountName(record.getValue(M_AGENT.ACCOUNTNAME));
				merchantDTO.setBankName(record.getValue(M_AGENT.BANKNAME));
				merchantDTO.setAccountNo(record.getValue(M_AGENT.ACCOUNTNO));
				merchantDTO.setFaxNo(record.getValue(record.field("FAXNO")).toString());
				merchantDTO.setTelephoneNo(record.getValue(record.field("TELNO")).toString());
				merchantDTO.setAccountType(record.getValue(M_BANK_MERCHANT.ACCOUNTTYPE));
				
				resultList.add(merchantDTO);
				
			});
			
		}
		
		return resultList;
	}
	
	private Result<Record> getAllMerchant() {
		
		 Field<?> FAXNO = DSL.field("CONCAT(CONCAT(M_AGENT.FAXREGION, '-'), M_AGENT.FAXNO)");
		 
		 Field<?> TELNO = DSL.field("CONCAT(CONCAT(M_AGENT.TELREGION, '-'), M_AGENT.TELNO)");
		 
		return jooq
				.select(M_AGENT.AGENTCD)
				.select(M_AGENT.AGENTNAME)
				.select(M_AGENT.MERCHANTCATEGORY)
				.select(M_AGENT.AGENTADDRESS)
				.select(M_AGENT.PIC)
				.select(M_AGENT.ACCOUNTNAME)
				.select(M_AGENT.BANKNAME)
				.select(M_AGENT.ACCOUNTNO)
				.select(M_BANK_MERCHANT.ACCOUNTTYPE)
				.select(FAXNO.as("FAXNO"))
				.select(TELNO.as("TELNO"))
				.from(M_AGENT)
				.leftJoin(M_BANK_MERCHANT).on(M_BANK_MERCHANT.AGENTCD.eq( M_AGENT.AGENTCD))
				.fetch();
	}

}
