package com.corprotex.csv.ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	private Properties prop = new Properties();
	String propertiesFilePath = "application.properties";
	
	public String getFileToWriteTo() {
		return prop.getProperty("fileToWriteTo");
	}
	public String getDirectoryToStartIn() {
		return prop.getProperty("initial.Directory.to.open");
	}
	public String[] getColumnHeaders() {
		String columnHeaders = prop.getProperty("column.headers");
		
		String[] arrayOfColumnNames = columnHeaders.split(",");
		
		return arrayOfColumnNames;
	}
	public String getIconImageName() {
		return prop.getProperty("icon.image.name");
	}

	public PropertiesReader() {
		super();
		try (InputStream inputStream = PropertiesExample.class.getClassLoader().getResourceAsStream(propertiesFilePath)) {

			prop.load(inputStream);
		} catch (IOException ex) {
			System.out.println("Problem occurs when reading file !");
			ex.printStackTrace();
		}
	}

}
