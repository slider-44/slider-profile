package com.acsp.overpayment.service;

import java.util.List;

import com.acsp.overpayment.Overpayment;
import com.acsp.overpayment.Product;

public interface OverpaymentService {
	
	/**
	 * Get the list of Over payment agreement based on search condition.
	 * @param overPayment
	 * @return List<Overpayment>
	 * 
	 */
	public List<Overpayment> getOverpaymentList(Overpayment Overpayment);
	
	/**
	 * Get the list of products
	 * @param product
	 * @return List<Product> 
	 * 
	 */
	public List<Product> getProductList(Product product);
	
}
