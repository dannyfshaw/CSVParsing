package com.corprotex.csv.ui;

import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class RunCVSUtil {
	private String pathToCSV = "C:\\Development\\Spring boot workspace\\corprotex\\src\\main\\resources\\Sample Data.csv";
	private String fileToWriteTo = "C:\\\\Development\\\\Spring boot workspace\\\\corprotex\\\\src\\\\main\\\\resources\\\\Output Data.csv";

	public static void main(String[] args) {
		RunCVSUtil run = new RunCVSUtil();
		run.callReadWriteFunctions();

	}
	@SuppressWarnings("static-access")
	private void callReadWriteFunctions() {
		CSVUtil cSVUtil = new CSVUtil();
		try {
			List<CSVRecord> listOfRecords = cSVUtil.readCSV(pathToCSV);
		//	cSVUtil.printRecords(listOfRecords, fileToWriteTo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
