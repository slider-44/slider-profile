package com.acsp.viewimage.service;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.acsp.core.rs.db.tables.TImage.T_IMAGE;

/**
 * 
 * @author fcortez
 *
 */
@Repository
public class ViewImageRepository {
	
	private ViewImageService viewImageService;
	
	@Autowired
	public ViewImageRepository(ViewImageService viewImageService){
		this.viewImageService = viewImageService;
	}
	
	public List<SalesImage> getCustomerList(Condition condition){
		
		List<Record> records = viewImageService.getSalesImages(condition);
		List<SalesImage> saleImages = new ArrayList<>();
		
		for(Record record : records){
			SalesImage salesImage = new SalesImage();
			salesImage.setImg("utils-viewimage/" + record.getValue(T_IMAGE.IMAGECODE) + "?isThumb=false");
			salesImage.setThumb("utils-viewimage/" + record.getValue(T_IMAGE.IMAGECODE) + "?isThumb=true");
			
			saleImages.add(salesImage);
		}
		
		return saleImages;
	}

}
