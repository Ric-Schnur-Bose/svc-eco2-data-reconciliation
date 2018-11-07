package com.bose.reconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvironmentConfigUtil {

	private static final Logger log = LoggerFactory.getLogger(BatchRunner.class);
	
	static String getEnvironmentConfigSetting(String settingName) {
		//log.error("MY_ENV value: " + System.getenv("MY_ENV"));
		return (null == System.getenv("MY_ENV") || !System.getenv("MY_ENV").equals("prod")) ? System.getenv("dev" + settingName) : System.getenv("prod" + settingName);
	}
}
