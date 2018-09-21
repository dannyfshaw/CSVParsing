package com.corprotex.csv.ui;

import java.io.*;
import java.util.Properties;

public class PropertiesExample {
	 
	public static void main(String[] args) {
		 
		// Properties file path.
		String filePath = "application.properties";
		Properties prop = new Properties();
 
		try (InputStream inputStream = PropertiesExample.class.getClassLoader().getResourceAsStream(filePath)) {
 
			// Loading the properties.
			prop.load(inputStream);
 
			// Getting properties
			String fileToWriteTo = prop.getProperty("fileToWriteTo");
			String initialDirectory = prop.getProperty("initial.Directory.to.open");
			String columnHeaders = prop.getProperty("column.headers");
			
			String[] arrayOfColumnNames = columnHeaders.split(",");
			
			System.out.println("fileToWriteTo = " + fileToWriteTo);
			System.out.println("initialDirectory = " + initialDirectory);
			System.out.println("columnHeaders = " + columnHeaders);
			
			
			for(String header:arrayOfColumnNames) {
				System.out.println("COLUMN:: "+header);
				
			}
		} catch (IOException ex) {
			System.out.println("Problem occurs when reading file !");
			ex.printStackTrace();
		} 
	}
}