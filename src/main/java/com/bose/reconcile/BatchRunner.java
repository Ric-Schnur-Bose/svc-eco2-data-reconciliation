package com.bose.reconcile;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchRunner {

	@Autowired
	DataReconciler dataReconciler;
	
    private static final Logger log = LoggerFactory.getLogger(BatchRunner.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	
    @Scheduled(fixedDelay = 20000)
    public void process() {
        
        //log.info("The time is now {}", dateFormat.format(new Date()));
		//log.error("MY_ENV value: " + System.getenv("MY_ENV"));
		
    	dataReconciler.reconcileData();

    }
}

