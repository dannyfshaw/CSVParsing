package com.corprotex.csv.ui;

import java.io.FileWriter;

import com.opencsv.CSVWriter;

//import au.com.bytecode.opencsv.CSVWriter;
 
public class WritingCSVFileExample
{
   public static void main(String[] args) throws Exception
   {
      String csv = "dataQD.csv";
      CSVWriter writer = new CSVWriter(new FileWriter(csv));
        
      //Create record
      String [] record = "4,David,Miller,Australia,30".split(",");
      String [] record2 = "2,David,Miller,Iraq,30".split(",");
      //Write the record to file
      writer.writeNext(record);
      writer.writeNext(record2);
        
      //close the writer
      writer.close();
   }
}