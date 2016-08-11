package com.acsp.overpayment.controller;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acsp.common.util.DateTimeUtil;
import com.acsp.overpayment.Overpayment;
import com.acsp.overpayment.Product;
import com.acsp.overpayment.service.OverpaymentService;

@RestController
public class OverpaymentController {
	
	@Autowired
	private OverpaymentService overpaymentService;
	
	@ResponseBody
	@RequestMapping(value="getoverpayment", method = RequestMethod.GET)
	public List<Overpayment> getOverpaymentList(
			@RequestParam(value="agreementCd", required=false) String agreementCd,
			@RequestParam(value="firstName", required=false) String firstName,
			@RequestParam(value="middleName", required=false) String middleName,
			@RequestParam(value="surName", required=false) String surName,
			@RequestParam(value="status", required=false) String status,
			@RequestParam(value="retDate", required=false) String retDate){
		
		Overpayment overPayment = new Overpayment();
		
		overPayment.setAgreementCd(agreementCd);
		overPayment.setFirstName(firstName);
		overPayment.setMiddleName(middleName);
		overPayment.setSurName(surName);
		overPayment.setStatus(status);
		overPayment.setRetDate(retDate);
		
		return overpaymentService.getOverpaymentList(overPayment);
	}
	
	@ResponseBody
	@RequestMapping(value="getproducts", method=RequestMethod.GET)
	public List<Product> getProductList(@RequestParam(value="agreementCd",required=false) String agreementCd){
		
		Product product = new Product();
		product.setAgreementCd(agreementCd);
		
		return overpaymentService.getProductList(product);
		
	}
	
}
