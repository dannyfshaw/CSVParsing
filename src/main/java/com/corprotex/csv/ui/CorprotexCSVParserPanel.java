package com.corprotex.csv.ui;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.WritableRenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.w3c.dom.ls.LSInput;

import com.opencsv.bean.ColumnPositionMappingStrategy;

import com.opencsv.bean.CsvToBean;

import com.opencsv.CSVReader;

//import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class CorprotexCSVParserPanel extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1551650759596123144L;
	private JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private JButton OKButton = new JButton();
	private String selectedFilePath;
	private String favIcon = "https://www.corprotex.com/favicon.ico";
	 private CSVUtil cSVUtil = new CSVUtil();
	private List<CSVRecord> linesread;
	private String fileToWriteTo = "C:\\GIT\\CSVParsing\\src\\main\\resources\\\\Output DataNew5.csv";
	private final String NEW_LINE_SEPARATOR = "\n";

	// CSV file header
	private final Object[] FILE_HEADER = { "Branch Details", "Employee Number", "fit", "Inch Size", "name", "size" };

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("ApproveSelection")) {
			selectedFilePath = chooser.getSelectedFile().getPath();
			System.out.println("Selected File::" + chooser.getSelectedFile());
			// readFile(selectedFilePath);
			// readSelectedCSV(selectedFilePath);
			try {
				List<InboundCSVFormat> listOfInboundCSVFormat = readCSV(selectedFilePath);
				List<OutCSVFormat> listOfOutboundCSVFormat = mapInboundToOutboundFormat(listOfInboundCSVFormat);
				cSVUtil.writeCsvFile(fileToWriteTo, listOfOutboundCSVFormat);
				// cSVUtil.writeCsvFile(fileToWriteTo, listOfOutboundCSVFormat);
				System.out.println("Finished writing to new file::"+fileToWriteTo);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		// What to do when Cancel is clicked
		if (e.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
			System.exit(ABORT);
		}
	}

	public static void main(String[] args) {
		CorprotexCSVParserPanel run = new CorprotexCSVParserPanel();
		run.init();
	}

	private void init() {
		chooser.setApproveButtonText("Select CSV to parse");
		chooser.addActionListener(this);
		OKButton.setText("OK start");
		OKButton.addActionListener(this);
		OKButton.setActionCommand("OK_BUTTON");
		this.chooser.setCurrentDirectory(new File("C:\\for Danny\\Corprotex"));
		this.add(chooser);
		this.setTitle("CSV Parser");

		this.show();
		this.setEnabled(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
	}

	public CorprotexCSVParserPanel() throws HeadlessException {
		super();
	}

	public String getSelectedFilePath() {
		return selectedFilePath;
	}

	public void setSelectedFilePath(String selectedFilePath) {
		this.selectedFilePath = selectedFilePath;
	}

	public List<CSVRecord> getLinesread() {
		return linesread;
	}

	public void setLinesread(List<CSVRecord> linesread) {
		this.linesread = linesread;
	}

	public static List<InboundCSVFormat> readCSV(String pathToCSV) throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get(pathToCSV));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		{

			List<InboundCSVFormat> listOfInboundCSVFormat = new ArrayList<InboundCSVFormat>();

			for (CSVRecord csvRecord : csvParser) {
				InboundCSVFormat rowData = new InboundCSVFormat();
				// Accessing Values by Column Index
				String name = csvRecord.get(FieldPostionConstants.NAME);
				rowData.setName(name);
				String employeeNumber = csvRecord.get(FieldPostionConstants.EMPLOYEE_NUMBER);
				rowData.setEmployeeNumber(employeeNumber);
				String branchDetails = csvRecord.get(FieldPostionConstants.BRANCH_DETAILS);
				rowData.setBranchDetails(branchDetails);
				String shellJacketSize = csvRecord.get(FieldPostionConstants.SHELL_JACKET_SIZE);
				 
				rowData.setShellJacketSize(shellJacketSize);
				String waterproofJacketSize =  csvRecord.get(FieldPostionConstants.WATERPROOF_JACKET_SIZE);
				rowData.setWaterproofJacketSize(waterproofJacketSize);
				String fit = csvRecord.get(FieldPostionConstants.FIT);
				rowData.setFit(fit);
				String inchSize = csvRecord.get(FieldPostionConstants.INCH_SIZE);
				rowData.setInchSize(inchSize);
				String quantity = csvRecord.get(FieldPostionConstants.QUANTITY);
				rowData.setQuantity(Integer.valueOf(quantity).intValue());

		//		String inchSize = csvRecord.get(6);
		//		;
		//		rowData.setInchSize(inchSize);

				System.out.println("Record No - " + csvRecord.getRecordNumber());
				System.out.println("---------------");
				 System.out.println("Name : " + name);
				 System.out.println("employeeNumber : " + employeeNumber);
				 System.out.println("BranchDtails : " + branchDetails);
				 System.out.println("quantity : " + quantity);
				 System.out.println("inchSize : " + inchSize);
				 System.out.println("waterproofJacketSize : " + waterproofJacketSize);

				listOfInboundCSVFormat.add(rowData);

				System.out.println("---------------\n\n");
			}
			return listOfInboundCSVFormat;
		}

	}

//	public void writeCsvFile(String fileName, List<OutCSVFormat> listOfOutboundCSVFormat) {
//
//		FileWriter fileWriter = null;
//
//		CSVPrinter csvFilePrinter = null;
//
//		// Create the CSVFormat object with "\n" as a record delimiter
//		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
//
//		try {
//
//			// initialize FileWriter object
//			fileWriter = new FileWriter(fileName);
//
//			// initialize CSVPrinter object
//			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
//
//			// Create CSV file header
//			csvFilePrinter.printRecord(FILE_HEADER);
//
//			csvFilePrinter.printRecords(listOfOutboundCSVFormat);
//			// Write a new student object list to the CSV file
//			// for (InboundCSVFormat item : listOfInboundCSVFormat) {
//			// List<String> inboundCSVFormatDataRecord = new ArrayList<String>();
//			// inboundCSVFormatDataRecord.add(String.valueOf(item.getBranchDetails()));
//			// inboundCSVFormatDataRecord.add(item.getEmployeeNumber());
//			// inboundCSVFormatDataRecord.add(item.getFit());
//			// inboundCSVFormatDataRecord.add(item.getInchSize());
//			// inboundCSVFormatDataRecord.add(String.valueOf(item.getName()));
//			// inboundCSVFormatDataRecord.add(String.valueOf(item.getSize()));
//			// csvFilePrinter.printRecord(inboundCSVFormatDataRecord);
//			// }
//
//			System.out.println("CSV file was created successfully !!!");
//
//		} catch (Exception e) {
//			System.out.println("Error in CsvFileWriter !!!");
//			e.printStackTrace();
//		} finally {
//			try {
//				fileWriter.flush();
//				fileWriter.close();
//				csvFilePrinter.close();
//			} catch (IOException e) {
//				System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
//				e.printStackTrace();
//			}
//		}
//	}

	private List<OutCSVFormat> mapInboundToOutboundFormat(List<InboundCSVFormat> listOfInboundCSVFormat) {
		List<OutCSVFormat> response = new ArrayList<OutCSVFormat>();
		for (InboundCSVFormat inbound : listOfInboundCSVFormat) {
			OutCSVFormat outbound = new OutCSVFormat();
			outbound.setBranch(inbound.getBranchDetails());
			outbound.setEmployeeNumber(inbound.getEmployeeNumber());
			outbound.setSize(inbound.getInchSize());
			outbound.setProduct("SomeProductName");
			outbound.setFit(inbound.getFit());
			outbound.setInchSize(inbound.getInchSize());
			String name = inbound.getName();
			outbound.setFullName(name);
//			String[] splitName = inbound.getName().split(" ");
//			if (splitName.length != 2) {
//				outbound.setFullName(inbound.getName());
//			} else {
//				outbound.setFullName(splitName[0]);
//			}
			response.add(outbound);

		}

		return response;

	}
}
