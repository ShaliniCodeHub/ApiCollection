package net.demo.ems.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppLogger {
	
	private static Logger LOGGER = null;

	/**
	 * Classes, which are collections of static members only, are not meant to be
	 * instantiated. So, private constructor is added.
	 */
	private AppLogger() {
		throw new IllegalStateException("AppLogger class!");
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger(Class<?> className) {
		LOGGER = LogManager.getLogger(className);
		return LOGGER;
	}
	 

}
