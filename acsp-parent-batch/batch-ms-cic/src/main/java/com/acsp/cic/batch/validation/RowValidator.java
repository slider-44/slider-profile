package com.acsp.cic.batch.validation;

import com.acsp.cic.batch.data.SDFRow;

public interface RowValidator {

	boolean validate(SDFRow row);
	boolean validate();
}
