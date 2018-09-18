package com.jcg;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class RunMe {
public static String fileToRead = "C:\\Development\\Spring boot workspace\\Apache Commons CSV Example\\src\\resources\\student.csv";
public static String fileToWriteTo = "C:\\Development\\Spring boot workspace\\Apache Commons CSV Example\\src\\resources\\studentOutput.csv";
//Delimiter used in CSV file
private static final String NEW_LINE_SEPARATOR = "\n";
//CSV file header
private static final Object [] FILE_HEADER = {"id","firstName","lastName","gender","age"};
	public static void main(String[] args) {
		CsvFileReader csvFileReader = new CsvFileReader();
		List<Student> listOfStudents = csvFileReader.readCsvFile(fileToRead);
		for(Student student: listOfStudents) {
			System.out.println("GOT THIS Student::"+student.toString());
		}
	}
	
	private static void writeTofile(String fileName) {
FileWriter fileWriter = null;
		
		CSVPrinter csvFilePrinter = null;
		
		//Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
				
		try {
			
			//initialize FileWriter object
			fileWriter = new FileWriter(fileName);
			
			//initialize CSVPrinter object 
	        csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
	        
	        //Create CSV file header
	        csvFilePrinter.printRecord(FILE_HEADER);
	}catch (Exception e) {
		System.out.println("Error in CsvFileWriter !!!");
		e.printStackTrace();
	} finally {
		try {
			fileWriter.flush();
			fileWriter.close();
			csvFilePrinter.close();
		} catch (IOException e) {
			System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
            e.printStackTrace();
		}
	}
}
}
