package com.acsp.viewimage.controller;

import java.util.List;

import org.jooq.Condition;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acsp.viewimage.service.SalesImage;
import com.acsp.viewimage.service.ViewImageRepository;

import static com.acsp.core.rs.db.tables.TAgreement.T_AGREEMENT;

@RestController
public class ViewImageRestController {

	@Autowired
	private ViewImageRepository viewImage;
	
	@ResponseBody
	@RequestMapping(value = "/{customerCd}")
	public List<SalesImage> getSalesImageList(@PathVariable String customerCd) {

		Condition condition = DSL.trueCondition();
		condition = T_AGREEMENT.CUSTOMERCD.eq(customerCd);

	   List<SalesImage> imageList = viewImage.getCustomerList(condition);
		
 		return imageList;
	}
	
	
	
}
