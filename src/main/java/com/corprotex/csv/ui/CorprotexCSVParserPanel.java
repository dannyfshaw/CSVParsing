package com.corprotex.csv.ui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.apache.commons.lang3.StringUtils;

//import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class CorprotexCSVParserPanel extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1551650759596123144L;
	private JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private JButton OKButton = new JButton();
	private String selectedFilePath;
	 private CSVUtil cSVUtil = new CSVUtil();
	private List<CSVRecord> linesread;
	private String fileToWriteTo = ".\\ParsedOutcome.csv";
//	private final String NEW_LINE_SEPARATOR = "\n";

	// CSV file header
//	private final Object[] FILE_HEADER = { "Branch Details", "Employee Number", "fit", "Inch Size", "name", "size" };

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

	@SuppressWarnings("deprecation")
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
			csvParser.close();
			return listOfInboundCSVFormat;
		}

	}

	private List<OutCSVFormat> mapInboundToOutboundFormat(List<InboundCSVFormat> listOfInboundCSVFormat) {
		List<OutCSVFormat> response = new ArrayList<OutCSVFormat>();
		for (InboundCSVFormat inbound : listOfInboundCSVFormat) {
			OutCSVFormat outbound = new OutCSVFormat();
			outbound.setBranch(inbound.getBranchDetails());
			outbound.setEmployeeNumber(inbound.getEmployeeNumber());
			outbound.setSize(inbound.getInchSize());
			outbound.setProduct("J140M Soft Shell Jacket Size");
			outbound.setFit(inbound.getFit());
			outbound.setInchSize(inbound.getInchSize());
			String name = inbound.getName();
			String stanitisednameString = StringUtils.remove(name, "?");
			outbound.setFullName(stanitisednameString);
			response.add(outbound);

		}

		return response;

	}
}
