package com.revature.bank.services.helpers;

import org.apache.log4j.Logger;

public class LoggerSingleton {
	private static Logger log;
	private static Logger businessLog;
	private static Logger accessDeniedLog;
	private LoggerSingleton() {
	}
	public static Logger getLogger() {
		if (log == null) {
			log =  Logger.getLogger("errorLog");
		}
		return log;
	}
	public static Logger getBusinessLog() {
		if(businessLog == null) {
			businessLog = Logger.getLogger("businessLog");
		}
		return businessLog;
	}
	public static Logger getAccessLog() {
		if(accessDeniedLog == null) {
			accessDeniedLog = Logger.getLogger("accessDeniedLog");
		}
		return accessDeniedLog;
	}
}
