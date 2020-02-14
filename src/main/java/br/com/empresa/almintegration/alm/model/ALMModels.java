package br.com.empresa.almintegration.alm.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class ALMModels {
	
	public static Properties properties = loadPropertiesFile();
	protected static final String UNDERSCORE = "_";
	
	private static Properties loadPropertiesFile() {
		String propFileName = "resources\\ALMFields.properties";
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(propFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}	
}
