package com.rk.yt.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Logs {

	public Logs() {

		DOMConfigurator.configure(System.getProperty("user.dir") + "./Logs/logs.xml");

	}

	public void takeLog(String clazz, String message) {

		Logger l = Logger.getLogger(clazz);
		l.info(message);
	}
}
