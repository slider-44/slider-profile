package com.acsp.cic.batch;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.process.SDFExecutor;


@Component
public class ScheduledTasks {

	@Autowired
	private SDFExecutor sDFExecutor;
	
	
	//@Scheduled(cron = "${cic.sched}")
	@Scheduled(cron = "0 27 20 * * *")
	public void runBatch() throws Exception {
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MMddHHmmss");
		
		System.out.println("=====================================================");
		System.out.println("BATCH JOB STARTED: " + dateFormat.format(new Date()));
		System.out.println("=====================================================");
		long start = System.currentTimeMillis();
		sDFExecutor.init();
		
		sDFExecutor.execute();
		
		sDFExecutor.combineData();
		long end = System.currentTimeMillis();
		System.out.println("=====================================================");
		System.out.println("BATCH JOB ENDED: " + dateFormat.format(new Date()));
		System.out.println("BATCH JOB RUNS FOR : " + (end - start) / 1000f + " seconds");
		System.out.println("=====================================================");
		
		
			
	}
}
