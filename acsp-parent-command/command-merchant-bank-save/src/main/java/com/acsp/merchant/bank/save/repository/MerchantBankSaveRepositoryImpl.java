package com.acsp.merchant.bank.save.repository;

import static com.acsp.core.rs.db.tables.MBankMerchant.M_BANK_MERCHANT;
import static com.acsp.core.rs.db.tables.MAgent.M_AGENT;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.common.security.ACSPUser;
import com.acsp.merchant.bank.save.dto.MerchantBankSaveDTO;

/**
 * Created by elaguardia on 06/28/2016.
 */
@Component
public class MerchantBankSaveRepositoryImpl implements MerchantBankSaveRepository {
		
	@Autowired
	protected DSLContext jooq;
	@Override
	public MerchantBankSaveDTO save(MerchantBankSaveDTO merchantSaveDTO,ACSPUser acspUser) {
		
		// UPDATE M_AGENT
		updateMAgentTable(merchantSaveDTO,acspUser);
		
		if(checkRecord(merchantSaveDTO.getAgentCd())!=null) {
			//Update M_BANK_MERCHANT
			updateMBankMerchantTable(merchantSaveDTO);
		}
		else {
			insertMBankMerchantTable(merchantSaveDTO);
		}
		
	
		return merchantSaveDTO;
	}
	
	private void updateMBankMerchantTable(MerchantBankSaveDTO merchantBankSaveDTO) {
		
		jooq.update(M_BANK_MERCHANT)
		.set(M_BANK_MERCHANT.ACCOUNTTYPE, merchantBankSaveDTO.getAccountType())
		.where(M_BANK_MERCHANT.AGENTCD.equal(merchantBankSaveDTO.getAgentCd()))
		.execute();
	}
	
	private void updateMAgentTable(MerchantBankSaveDTO merchantBankSaveDTO,ACSPUser acspUser) {
		
		jooq.update(M_AGENT)
		.set(M_AGENT.BANKNAME, merchantBankSaveDTO.getBankName())
		.set(M_AGENT.ACCOUNTNAME, merchantBankSaveDTO.getAccountName())
		.set(M_AGENT.ACCOUNTNO, merchantBankSaveDTO.getAccountNo())
		.set(M_AGENT.UPDDATE, merchantBankSaveDTO.getUpdDate())
		.set(M_AGENT.UPDTIME, merchantBankSaveDTO.getUpdTime())
		.set(M_AGENT.UPDPERSON, merchantBankSaveDTO.getUpdPerson())
		.where(M_AGENT.AGENTCD.equal(merchantBankSaveDTO.getAgentCd()))
		.execute();
	}
	
	private void insertMBankMerchantTable(MerchantBankSaveDTO merchantBankSaveDTO) {
		
		jooq.insertInto(M_BANK_MERCHANT,
				M_BANK_MERCHANT.AGENTCD,
				M_BANK_MERCHANT.ACCOUNTTYPE)
	    .values(merchantBankSaveDTO.getAgentCd(),
	    		merchantBankSaveDTO.getAccountType())
	    .execute();
	}
	
	private Record checkRecord(String agentCd) {
		
		return jooq
		.select(M_BANK_MERCHANT.AGENTCD)
		.select(M_BANK_MERCHANT.ACCOUNTTYPE)
		.from(M_BANK_MERCHANT)
		.where(M_BANK_MERCHANT.AGENTCD.eq(agentCd))
		.fetchOne();
	}

}
