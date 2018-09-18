package com.corprotex.csv.service;

import java.io.File;
import java.util.List;

public interface CorprotexCSVParsingService {

	public List<String> parseFullCSVFile(File cSVFileToParse);
	
	public List<String> readCSVFile(File cSVFileToread);
}
