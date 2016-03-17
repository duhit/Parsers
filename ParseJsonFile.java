package org.cloudwick.fileParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class ParseJsonFile {
	
	public JsonReader readJSON(){
			FileReader reader = null;
			try {
				reader = new FileReader("G:/data.json");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			JsonReader jsonReader = new JsonReader(reader);
			
			return jsonReader;
	}
	
	private class Address{
		   String streetAddress;
		    String city;
		    String state;
		    int postalCode;
		    
		    @Override
		    public String toString() {
		        String out = String.join("\n", streetAddress, city, state, Integer.toString(postalCode));
		        return out;
		    }
	}
	
	private class Contact {
	    private String firstName;
	    private String lastName;
	    private int age;
	    private Address address;
	    private PhoneNumber[] phoneNumbers;

	    @Override
	    public String toString() {
	        String numbers="";
	        for (PhoneNumber number : phoneNumbers) {
	            numbers = numbers.concat(number.toString()).concat("\n");
	        }
	    String out = String.join("\n", firstName + " " +lastName, 
	            Integer.toString(age),"",
	            address.toString(),"",
	            numbers);
	    return out;
	    }
	}
	
    private class PhoneNumber {
        String type;
        String number;
        
        @Override
        public String toString(){
        return type + ": " + number;
        }
    }
    
    public static void main(String[] args) {
    	ParseJsonFile jsonObject = new ParseJsonFile();
    	
    	JsonReader reader = jsonObject.readJSON();
    	
    	Gson gson = new GsonBuilder().create();
    	Contact contact = gson.fromJson(reader, Contact.class);
    	System.out.println(contact);
	}
}
