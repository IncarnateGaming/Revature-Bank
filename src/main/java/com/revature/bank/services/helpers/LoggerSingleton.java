package com.revature.bank.services.helpers;

import org.apache.log4j.Logger;

import com.revature.bank.Application;

public class LoggerSingleton {
	private static Logger log;
	private LoggerSingleton() {
	}
	public static Logger getLogger() {
		if (log == null) {
			log =  Logger.getLogger(Application.class);
		}
		return log;
	}
}
