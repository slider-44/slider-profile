package com.acsp.cic.batch.process;

import com.acsp.cic.batch.data.SDFRow;

public interface SDFRowPrinter {
	void print (SDFRow row, PrintInfoDTO printInfoDTO);
	
}
