package com.salesforce.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigFileReader {
	public static Properties prop;
	
	
	public ConfigFileReader() throws IOException  {
		
		// FileReader f= new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\salesforce\\configuration\\data.properties");
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\salesforce\\configuration\\data.properties");
		FileInputStream fis = new FileInputStream(f);
		//InputStreamReader fis = new InputStreamReader(f); 
		prop = new Properties();
		prop.load(fis);
		
	}

	public String browser() {
		
		return prop.getProperty("browser");
	}

	public String siteAddress() {
		return prop.getProperty("url");
	}

}
