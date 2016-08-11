package com.acsp.overpayment.service;

import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.acsp.core.rs.db.tables.TAgreement.T_AGREEMENT;
import static com.acsp.core.rs.db.tables.MCustomer.M_CUSTOMER;
import static com.acsp.core.rs.db.tables.TPayment.T_PAYMENT;
import static com.acsp.core.rs.db.tables.TProduct.T_PRODUCT;

import static com.acsp.core.rs.db.tables.TOverpayment.T_OVERPAYMENT; 

@Repository
public class OverpaymentRepository {
	
	@Autowired
	private DSLContext jooq;
	
	public List<Record> getOverpaymentList(Condition condition){
		
		return jooq
				.selectDistinct(T_AGREEMENT.AGREEMENTCD)
				.select(T_AGREEMENT.SALEDATE)
				.select(T_AGREEMENT.STORENAME)
				.select(T_AGREEMENT.STORECD)
				.select(T_OVERPAYMENT.OVERPAYMENT)
				.select(T_OVERPAYMENT.REMARKS)
				.select(T_OVERPAYMENT.STATUS)
				.select(T_OVERPAYMENT.RECONTACTDATE)
				.select(M_CUSTOMER.FIRSTNAME)
				.select(M_CUSTOMER.MIDDLENAME)
				.select(M_CUSTOMER.SURNAME)
				.select(M_CUSTOMER.MOBILENO)
				.select(M_CUSTOMER.HOMETELDISTRICT)
				.select(M_CUSTOMER.HOMETEL)
				.select(T_PRODUCT.PRODUCTDESCRIPTION)
				.select(T_OVERPAYMENT.PAYMENTCD)
				.select(T_OVERPAYMENT.RETDATE)
				.from(T_OVERPAYMENT)
				.innerJoin(T_AGREEMENT).on("T_OVERPAYMENT.AGREEMENTCD=T_AGREEMENT.AGREEMENTCD")
				.innerJoin(M_CUSTOMER).on("T_OVERPAYMENT.CUSTOMERCD=M_CUSTOMER.CUSTOMERCD")
				.innerJoin(T_PAYMENT).on("T_AGREEMENT.AGREEMENTCD=T_PAYMENT.AGREEMENTCD")
				.innerJoin(T_PRODUCT).on("T_PRODUCT.SYSAPPCD=T_AGREEMENT.SYSAPPCD and T_PRODUCT.PRODUCTNO='001'")
				.where(condition)
				.fetch();
		
	}
	
	public List<Record> getProductList(Condition condition){
		
		return jooq.select(T_PRODUCT.PRODUCTDESCRIPTION)
				   .select(T_PRODUCT.BRAND)
				   .select(T_PRODUCT.NAMEANDTYPE)
				   .select(T_PRODUCT.MODELNO)
				   .select(T_PRODUCT.PRICE)
					.from(T_PRODUCT).where(condition).fetch();
		
	}
}
