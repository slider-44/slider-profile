package com.acsp.overpayment.service;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acsp.overpayment.Overpayment;
import com.acsp.overpayment.Product;

import static com.acsp.core.rs.db.tables.TOverpayment.T_OVERPAYMENT; 
import static com.acsp.core.rs.db.tables.TAgreement.T_AGREEMENT;
import static com.acsp.core.rs.db.tables.MCustomer.M_CUSTOMER;
import static com.acsp.core.rs.db.tables.TProduct.T_PRODUCT;

@Component
public class OverpaymentServiceImpl implements OverpaymentService {
	
	@Autowired
	private OverpaymentRepository overpaymentRepo;

	public List<Overpayment> getOverpaymentList(Overpayment overPayment) {
		
		Condition condition=processCondition(overPayment);
		
		List<Record> recordList = overpaymentRepo.getOverpaymentList(condition);
		List<Overpayment> overPaymentList = new ArrayList<>();
		
		for(Record record : recordList){
			
			Overpayment overPaymentDTO = new Overpayment();
			
			overPaymentDTO.setAgreementCd(record.getValue(T_AGREEMENT.AGREEMENTCD));
			overPaymentDTO.setSaleDate(String.valueOf(record.getValue(T_AGREEMENT.SALEDATE)));
			overPaymentDTO.setOverPayment(record.getValue(T_OVERPAYMENT.OVERPAYMENT).toString());
			overPaymentDTO.setStoreCd(record.getValue(T_AGREEMENT.STORECD));
			overPaymentDTO.setFirstName(record.getValue(M_CUSTOMER.FIRSTNAME));
			overPaymentDTO.setMiddleName(record.getValue(M_CUSTOMER.MIDDLENAME));
			overPaymentDTO.setSurName(record.getValue(M_CUSTOMER.SURNAME));
			overPaymentDTO.setStoreName(record.getValue(T_AGREEMENT.STORENAME));
			overPaymentDTO.setStatus(record.getValue(T_OVERPAYMENT.STATUS));
			overPaymentDTO.setRecontactDate(record.getValue(T_OVERPAYMENT.RECONTACTDATE));
			overPaymentDTO.setMobileNo(record.getValue(M_CUSTOMER.MOBILENO));
			overPaymentDTO.setTelDistrict(record.getValue(M_CUSTOMER.HOMETELDISTRICT));
			overPaymentDTO.setTelNo(record.getValue(M_CUSTOMER.HOMETEL));
			overPaymentDTO.setProductDesciption(record.getValue(T_PRODUCT.PRODUCTDESCRIPTION));
			overPaymentDTO.setPaymentCd(record.getValue(T_OVERPAYMENT.PAYMENTCD));
			overPaymentDTO.setRemarks(record.getValue(T_OVERPAYMENT.REMARKS));
			overPaymentDTO.setRetDate(record.getValue(T_OVERPAYMENT.RETDATE));
			overPaymentList.add(overPaymentDTO);
			
		}
		
		return overPaymentList;
	}
	
	public List<Product> getProductList(Product product) {
		Condition equalApplicationCode = DSL.trueCondition();
		
		List<Record> recordList = overpaymentRepo.getProductList(equalApplicationCode);
		List<Product> productList = new ArrayList<>();
		
		for(Record record : recordList){
			
			Product productDTO= new Product();
			
			productDTO.setProductBrand(record.getValue(T_PRODUCT.BRAND));
			productDTO.setProductDesc(record.getValue(T_PRODUCT.PRODDESC));
			productDTO.setModelNo(record.getValue(T_PRODUCT.MODELNO));
			productDTO.setPrice(record.getValue(T_PRODUCT.PRICE));
			
			productList.add(productDTO);
			
		}
		
		return productList;
		
	}
	
	private Condition processCondition(Overpayment overPayment){
		
		Condition equalApplicationCode = DSL.trueCondition();
		Condition likeFirstName = DSL.trueCondition();
		Condition likeMiddleName = DSL.trueCondition();
		Condition likeSurName = DSL.trueCondition();
		Condition equalStatus = DSL.trueCondition();
		Condition equalRetDate = DSL.trueCondition();
		
		//Agreement No Criteria
		if(overPayment.getAgreementCd()!=null && !overPayment.getAgreementCd().equalsIgnoreCase("")){
			equalApplicationCode = T_AGREEMENT.AGREEMENTCD.eq(overPayment.getAgreementCd());
		}
		
		//Agreement No Criteria
		if(overPayment.getStatus()!=null && !overPayment.getStatus().equalsIgnoreCase("")){
			equalStatus = T_OVERPAYMENT.STATUS.eq(overPayment.getStatus());
		}
		
		//First name criteria
		if(overPayment.getFirstName()!=null && !overPayment.getFirstName().equalsIgnoreCase("")){
			likeFirstName = M_CUSTOMER.FIRSTNAME.like("%"+overPayment.getFirstName()+"%");
		}
		
		//Middle name criteria
		if(overPayment.getMiddleName()!=null && !overPayment.getMiddleName().equalsIgnoreCase("")){
			likeMiddleName = M_CUSTOMER.MIDDLENAME.like("%"+overPayment.getMiddleName()+"%");
		}
		
		//Surname criteria
		if(overPayment.getSurName()!=null && !overPayment.getSurName().equalsIgnoreCase("")){
			likeSurName = M_CUSTOMER.SURNAME.like("%"+overPayment.getMiddleName()+"%");
		}
		
		//Retrieval Date Criteria
		if(overPayment.getRetDate()!=null){
			String retDate = overPayment.getRetDate().replaceAll("-", "");
			equalRetDate = T_OVERPAYMENT.RETDATE.eq(retDate.replaceAll("", ""));
		}

		return equalApplicationCode.and(likeFirstName).and(likeMiddleName)
				.and(likeSurName).and(equalStatus).and(equalRetDate).and("ROWNUM<=500");
	}

}
