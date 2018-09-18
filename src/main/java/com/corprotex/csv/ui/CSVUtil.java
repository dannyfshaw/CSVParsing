package com.corprotex.csv.ui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;


public class CSVUtil {
	private static final String SAMPLE_CSV_FILE = "./output_Danny.csv";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final Object [] FILE_HEADER = {"Branch Details","Employee Number","fit","Inch Size","name", "size"};

	 public static void writeCSV(String pathToFile) {
		 try (
		            BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

		            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
		                    .withHeader("ID", "Name", "Designation", "Company"));
		        ) {
		            csvPrinter.printRecord("1", "Sundar Pichai", "CEO", "Google");
		            csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft");
		            csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple");

		            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));

		            csvPrinter.flush();            
		        } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 }
		 
public static List<InboundCSVFormat> buildListOfInboundCSVFormatRecords() {
	return null;
}


public static void writeCsvFile(String fileName, List<InboundCSVFormat> listOfInboundCSVFormat) {
	

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
		
		//Write a new student object list to the CSV file
		for (InboundCSVFormat item : listOfInboundCSVFormat) {
			List<String> inboundCSVFormatDataRecord = new ArrayList<String>();
			inboundCSVFormatDataRecord.add(String.valueOf(item.getBranchDetails()));
			inboundCSVFormatDataRecord.add(item.getEmployeeNumber());
			inboundCSVFormatDataRecord.add(item.getFit());
			inboundCSVFormatDataRecord.add(item.getInchSize());
			inboundCSVFormatDataRecord.add(String.valueOf(item.getName()));
			inboundCSVFormatDataRecord.add(String.valueOf(item.getSize()));
            csvFilePrinter.printRecord(inboundCSVFormatDataRecord);
		}

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

public static List<CSVRecord> readCSV(String pathToCSV) throws IOException {
    // try (
         Reader reader = Files.newBufferedReader(Paths.get(pathToCSV));
         CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
         System.out.println("AFter creating the CSVParser");
    // ) 
{
         for (CSVRecord csvRecord : csvParser.getRecords()) {
             // Accessing Values by Column Index
             String name = csvRecord.get(0);
             String employeeNumber = csvRecord.get(1);
             String BranchDtails = csvRecord.get(2);
             String quantity = csvRecord.get(3);
             String num4 = csvRecord.get(4);
             String num5 = csvRecord.get(5);
             String num6 = csvRecord.get(6);
//             String num7 = csvRecord.get(7);
//             String num8 = csvRecord.get(7);
//             String num9 = csvRecord.get(7);
//             String num10 = csvRecord.get(10);
//             String num11 = csvRecord.get(11);
//             String num12 = csvRecord.get(12);
//             String num13 = csvRecord.get(13);
//             String num14 = csvRecord.get(14);
//             String num15 = csvRecord.get(15);
//             String num16 = csvRecord.get(16);
//             String num17 = csvRecord.get(17);
//             String num18 = csvRecord.get(18);
//             String num19 = csvRecord.get(19);
    //         String num20 = csvRecord.get(20);

             System.out.println("Record No - " + csvRecord.getRecordNumber());
             System.out.println("---------------");
             System.out.println("Name : " + name);
             System.out.println("employeeNumber : " + employeeNumber);
             System.out.println("BranchDtails : " + BranchDtails);
             System.out.println("num4 : " + num4);
             System.out.println("num5 : " + num5);
             System.out.println("num6 : " + num6);
             
//             System.out.println("num7 : " + num7);
//             System.out.println("num8 : " + num8);
//             System.out.println("num9 : " + num9);
//             System.out.println("num10 : " + num10);
//             System.out.println("num11 : " + num11);
//             System.out.println("num12 : " + num12);
//             System.out.println("num13 : " + num13);
//             System.out.println("num14 : " + num14);
//             System.out.println("num15 : " + num15);
//             System.out.println("num16 : " + num16);
//             System.out.println("num17 : " + num17);
//             System.out.println("num18 : " + num18);
//             System.out.println("num19 : " + num19);
    //         System.out.println("num20 : " + num20);
             
             
             System.out.println("---------------\n\n");
         }
     }
System.out.println("After readnig all he records");
return csvParser.getRecords();
 }
}
