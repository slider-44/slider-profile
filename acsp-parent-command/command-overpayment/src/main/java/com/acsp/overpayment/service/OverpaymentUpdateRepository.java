package com.acsp.overpayment.service;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acsp.common.util.DateTimeUtil;
import com.acsp.overpayment.dto.Overpayment;

import static com.acsp.core.rs.db.tables.TOverpayment.T_OVERPAYMENT;

@Repository
public class OverpaymentUpdateRepository {
	
	@Autowired
	private DSLContext jooq;
	
	public void updateOverpayment(Overpayment overPayment){
		
		jooq
			.update(T_OVERPAYMENT)
				.set(T_OVERPAYMENT.CONTACTEDTO, overPayment.getContactedTo())
				.set(T_OVERPAYMENT.RECONTACTDATE, String.valueOf(DateTimeUtil.getDatePart(overPayment.getRecontactDate())))
				.set(T_OVERPAYMENT.STATUS, overPayment.getStatus())
				.set(T_OVERPAYMENT.ACTION, overPayment.getAction())
				.set(T_OVERPAYMENT.REMARKS, overPayment.getRemarks())
				.set(T_OVERPAYMENT.RETDATE, String.valueOf(DateTimeUtil.getDatePart(overPayment.getRetDate())))
					.where(T_OVERPAYMENT.AGREEMENTCD.eq(overPayment.getAgreementCd())
							.and(T_OVERPAYMENT.PAYMENTCD.eq(overPayment.getPaymentCd()))).execute();
		
	}
}
