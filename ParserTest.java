package org.cloudwick.fileParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class ParserTest {
	@Test
	public void parseCSV() throws IOException {
			ArrayList<String[]> records = new ArrayList<String[]>();
			String record;
			BufferedReader file = new BufferedReader(new FileReader("G:/data.csv"));
			while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
			}
			file.close();
	}
	
	@Test
	public void parseXML() throws IOException {
		
	}
}
