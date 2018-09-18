package com.corprotex.csv.ui;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	private  JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private JButton OKButton = new JButton();
	private String selectedFilePath;
	private String favIcon = "https://www.corprotex.com/favicon.ico";
	private CSVUtil cSVUtil = new CSVUtil();
	private List<CSVRecord> linesread;
	private String fileToWriteTo = "C:\\\\Development\\\\Spring boot workspace\\\\corprotex\\\\src\\\\main\\\\resources\\\\Output Data.csv";

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("ApproveSelection")) {
			selectedFilePath = chooser.getSelectedFile().getPath();
			System.out.println("Selected File::"+chooser.getSelectedFile());
		//	readFile(selectedFilePath);
			//readSelectedCSV(selectedFilePath);
			try {
				List<InboundCSVFormat>  writeCsvFile = readCSV(selectedFilePath);
				cSVUtil.writeCsvFile(fileToWriteTo, writeCsvFile);
				System.out.println("Finished writing to new file");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//What to do when Cancel is clicked
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
		this.add(chooser);
		this.setTitle("CSV Parser");
	
		
		this.show();
		this.setEnabled(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000);
	}

	public CorprotexCSVParserPanel() throws HeadlessException {
		super();
	}
//	private void readSelectedCSV(String pathToCSV) {
//		 CSVReader reader = null;
//		try {
//			reader = new CSVReader(new FileReader(pathToCSV), ',' , '"' , 1);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	       
//	      String[] nextLine;
//	      try {
//			while ((nextLine = reader.readNext()) != null) {
//			     if (nextLine != null) {
//			        //Verifying the read data here
//			        System.out.println(Arrays.toString(nextLine));
//			     }
//			   }
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	      
//	}
//	private void readAllLines(String pathToCSV) {
//		//Build reader instance
//	      CSVReader reader = null;
//		try {
//			reader = new CSVReader(new FileReader(pathToCSV), ',', '"', 1);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	       
//	      //Read all rows at once
//	      List<String[]> allRows = new ArrayList<String[]>();
//	      String[] temp = (String[]) allRows.toArray(); 
//		try {
//			allRows = reader.readAll();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	       
//	      //Read CSV line by line and use the string array as you want
//	     for(String[] row : allRows){
//	        System.out.println(Arrays.toString(row));
//	     }
//	     
//	     
//	}
	
	private void writeParsedCV() {
		
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
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);{
	            	
	            	List<InboundCSVFormat> listOfInboundCSVFormat = new ArrayList<InboundCSVFormat>();
	            	
	            for (CSVRecord csvRecord : csvParser) {
	            	InboundCSVFormat rowData = new InboundCSVFormat();
	                // Accessing Values by Column Index
	                String name = csvRecord.get(0);
	                rowData.setName(name);
	                String employeeNumber = csvRecord.get(1);
	                rowData.setEmployeeNumber(employeeNumber);
	                String branchDetails = csvRecord.get(2);
	                rowData.setBranchDetails(branchDetails);
	                String quantity = csvRecord.get(3);
	                String size = csvRecord.get(4);
	                rowData.setSize(size);
	                String fit = csvRecord.get(5);
	                rowData.setFit(fit);

	                String inchSize = csvRecord.get(6);;
	                rowData.setInchSize(inchSize);
	                
	                System.out.println("Record No - " + csvRecord.getRecordNumber());
	                System.out.println("---------------");
//	                System.out.println("Name : " + name);
//	                System.out.println("employeeNumber : " + employeeNumber);
//	                System.out.println("BranchDtails : " + BranchDtails);
//	                System.out.println("num4 : " + num4);
//	                System.out.println("num5 : " + num5);
//	                System.out.println("num6 : " + num6);
	                
	                listOfInboundCSVFormat.add(rowData);
	                
	                System.out.println("---------------\n\n");
	            }
	        	return listOfInboundCSVFormat;
	        }

	    }

}
