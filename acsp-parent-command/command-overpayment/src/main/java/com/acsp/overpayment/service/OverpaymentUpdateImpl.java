package com.acsp.overpayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.overpayment.dto.Overpayment;

@Component
public class OverpaymentUpdateImpl implements OverpaymentUpdate {
	
	@Autowired
	private OverpaymentUpdateRepository overPaymentRepo;
	
	public void updateOverpyament(Overpayment overPayment) {
		overPaymentRepo.updateOverpayment(overPayment);
	}

}
