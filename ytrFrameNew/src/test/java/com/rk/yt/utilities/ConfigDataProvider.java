package com.rk.yt.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;

	public ConfigDataProvider() {

		File f = new File("./config/config.properties");

		try {
			FileInputStream fis = new FileInputStream(f);

			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {

			System.out.println("Not able to load the property file" + e.getMessage());
		}
	}
	
	
	public String getData(String key) {
		return prop.getProperty(key);
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
	}

	public String getUrl() {
		return prop.getProperty("URL");
	}


}
