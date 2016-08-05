package com.acsp.core.orm.util;

import org.jooq.DSLContext;

import com.acsp.common.util.DateTimeUtil;
import com.acsp.core.rs.db.routines.Numberingmachine;

public class NumberingMachineUtil {

	public static String fileGenerateRequestNumber(String numpd, DSLContext jooq) {

		Numberingmachine sequenceGenerator = new Numberingmachine();

		String dateNowAsYYYYMMDD = DateTimeUtil.getDateAsYYYYMMDDFromDateTime().toString();
		sequenceGenerator.setNow(dateNowAsYYYYMMDD);
		sequenceGenerator.setNumtype(numpd);
		sequenceGenerator.execute(jooq.configuration());
		String sequence = sequenceGenerator.getReturnValue();

		return sequence;

	}
	
}
