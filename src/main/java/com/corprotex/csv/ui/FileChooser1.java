package com.corprotex.csv.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class FileChooser1 implements ActionListener{
 static String selectedFilePath;
	public static void main(String[] args) {

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Corprotex CSV processor");

		int returnValue = jfc.showDialog(null, "A button!");
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFilePath = jfc.getSelectedFile().getPath();
			System.out.println(jfc.getSelectedFile().getPath());
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		JOptionPane pane = new JOptionPane("File Selected"); 
		Object message = "About to load this file:;"+selectedFilePath;
		System.out.println("actionPerformed::Selected this file::"+selectedFilePath);
	//	pane.showMessageDialog(this, message);
	}

}