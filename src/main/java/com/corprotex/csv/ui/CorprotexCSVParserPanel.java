package com.corprotex.csv.ui;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import com.opencsv.CSVReader;

public class CorprotexCSVParserPanel extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1551650759596123144L;
	private  JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private JButton OKButton = new JButton();
	private String selectedFilePath;
	private String favIcon = "https://www.corprotex.com/favicon.ico";

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("ApproveSelection")) {
			selectedFilePath = chooser.getSelectedFile().getPath();
			System.out.println("Selected File::"+chooser.getSelectedFile());
			readSelectedCSV(selectedFilePath);
			
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
	//	Image iconImage = new Image("https://www.corprotex.com/corportex_logo.png"); 
	//	try {
	//		this.setIconImage(new ImageIcon(getClass().getResource("C:\\Development\\Spring boot workspace\\corprotex\\src\\main\\resources\\corportex_logo.png")).getImage());
	//	} catch (IOException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		
		this.show();
		this.setEnabled(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000);
	}

	public CorprotexCSVParserPanel() throws HeadlessException {
		super();
	//	init();
		// TODO Auto-generated constructor stub
	}
	private void readSelectedCSV(String pathToCSV) {
		 CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(pathToCSV), ',' , '"' , 1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      //Read CSV line by line and use the string array as you want
	      String[] nextLine;
//	      List<String> allLinesInfile = new ArrayList<String>();
//	      try {
//			while(( reader.readNext()) != null) {
//				allLinesInfile.add(reader.readNext());			  }
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	      try {
			while ((nextLine = reader.readNext()) != null) {
			     if (nextLine != null) {
			        //Verifying the read data here
			        System.out.println(Arrays.toString(nextLine));
			     }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void readAllLines(String pathToCSV) {
		//Build reader instance
	      CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(pathToCSV), ',', '"', 1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      //Read all rows at once
	      List<String[]> allRows = new ArrayList<String[]>();
	      String[] temp = (String[]) allRows.toArray(); 
		try {
			allRows = reader.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      //Read CSV line by line and use the string array as you want
	     for(String[] row : allRows){
	        System.out.println(Arrays.toString(row));
	     }
	}
	
	private void writeParsedCV() {
		
	}
	
	
}
