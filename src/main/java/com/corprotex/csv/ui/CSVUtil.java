package com.corprotex.csv.ui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVUtil {
	private static final String SAMPLE_CSV_FILE = "./output_Danny.csv";
	private static final String NEW_LINE_SEPARATOR = "\n";

	// CSV file header
	private static final Object[] FILE_HEADER = { "Branch Details", "Employee Number", "fit", "Inch Size", "Full name","Size", "Product"};

	public static void writeCsvFile(String fileName, List<OutCSVFormat> listOfOutboundCSVFormat) {

		FileWriter fileWriter = null;

		CSVPrinter csvFilePrinter = null;

		// Create the CSVFormat object with "\n" as a record delimiter
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

		try {

			// initialize FileWriter object
			fileWriter = new FileWriter(fileName);

			// initialize CSVPrinter object
			csvFilePrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);//(fileWriter, csvFileFormat);

			// Create CSV file header
			
			
			List<String[]> listOfRowValues = new ArrayList<String[]>();
			for(OutCSVFormat item: listOfOutboundCSVFormat) {
				String[] rowValues = {item.getBranch(), item.getEmployeeNumber(),item.getFit(), item.getInchSize(), item.getFullName(), item.getSize(),item.getProduct()};
				listOfRowValues.add(rowValues);
			//	csvFilePrinter.print(rowValues);
			}
			csvFilePrinter.printRecord(FILE_HEADER);
			csvFilePrinter.printRecords(listOfRowValues);
			

		//	csvFilePrinter.printRecords(listOfOutboundCSVFormat);

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
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

//	public static List<CSVRecord> readCSV(String pathToCSV) throws IOException {
//		// try (
//		Reader reader = Files.newBufferedReader(Paths.get(pathToCSV));
//		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//		System.out.println("AFter creating the CSVParser");
//		{
//			for (int i = 1; i <= csvParser.getRecords().size(); i++) {
//
//				CSVRecord csvRecord = csvParser.getRecords().get(i);
//				// Accessing Values by Column Index
//				String name = csvRecord.get(0);
//				String employeeNumber = csvRecord.get(1);
//				String BranchDtails = csvRecord.get(2);
//				String quantity = csvRecord.get(3);
//				String num4 = csvRecord.get(4);
//				String num5 = csvRecord.get(5);
//				String num6 = csvRecord.get(6);
//
//				System.out.println("Record No - " + csvRecord.getRecordNumber());
//				System.out.println("---------------");
//				System.out.println("Name : " + name);
//				System.out.println("employeeNumber : " + employeeNumber);
//				System.out.println("BranchDtails : " + BranchDtails);
//				System.out.println("num4 : " + num4);
//				System.out.println("num5 : " + num5);
//				System.out.println("num6 : " + num6);
//
//				System.out.println("---------------\n\n");
//			}
//		}
//		System.out.println("After reading all he records");
//		return csvParser.getRecords();
//	}
//
////	private List<OutCSVFormat> mapInboudToOutbuondFormat(List<InboundCSVFormat> listOfInboundCSVFormat) {
////		List<OutCSVFormat> response = new ArrayList<OutCSVFormat>();
////		for (InboundCSVFormat inbound : listOfInboundCSVFormat) {
////			OutCSVFormat outbound = new OutCSVFormat();
////			outbound.setBranch(inbound.getBranchDetails());
////			outbound.setEmployeeNumber(inbound.getEmployeeNumber());
////			String[] splitName = inbound.getName().split(" ");
////			outbound.setFirstName(splitName[0]);
////			outbound.setSurname(splitName[1]);
////
////		}
////
////		return response;
////
////	}
}
