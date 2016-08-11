package com.acsp.viewimage.service;

import java.util.List;

import org.jooq.Condition;
import org.jooq.Record;

public interface ViewImageService {
	
	public List<Record> getSalesImages(Condition customerCd);
	
}
