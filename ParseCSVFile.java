package org.cloudwick.fileParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseCSVFile {
	 public static void main(String[] args){
			//Input file which needs to be parsed
	        String fileToParse = "G:/data.csv";
        
        parse(fileToParse);
	 }
	 
	 public static List<String[]> parse(String code){

	        BufferedReader fileReader = null;
	        
	        //Delimiter used in CSV file
	        final String DELIMITER = ",";
	        
	        List<String[]> records = new ArrayList<String[]>();
	        
	        try
	        {
	        	
	            String line = "";
	            //Create the file reader
	            int count = 0;
	            fileReader = new BufferedReader(new FileReader(code));
	             
	            //Read the file line by line
	            while ((line = fileReader.readLine()) != null) 
	            {
	                //Get all tokens available in line
	                String[] tokens = line.split(DELIMITER);
	                for(String token : tokens)
	                {
	                	records.add(tokens);
	                    //Print all tokens
	                    System.out.print(token + "-->");
	                    count++;
	                    if(count%2 == 0){
	                    	System.out.println();
	                    }
	                }
	            }
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        } 
	        finally
	        {
	            try {
	                fileReader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return records;
	    }
}
