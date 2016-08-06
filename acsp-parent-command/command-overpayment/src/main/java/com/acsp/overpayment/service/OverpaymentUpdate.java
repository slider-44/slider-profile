package com.acsp.overpayment.service;

import com.acsp.overpayment.dto.Overpayment;

public interface OverpaymentUpdate {
	
	/**
	 * Update Status, action and input comment for updating Overpayment
	 * @param overPayment
	 */
	public void updateOverpyament(Overpayment overPayment);
	
}
