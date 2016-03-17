package org.cloudwick.fileParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseXMLFile {
	public void parseXml(){
		try{
			File xmlFile = new File("G:/data.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(xmlFile);
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("Employee");
					
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
						
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Employee id : " + eElement.getAttribute("ID"));
					System.out.println("First Name : " + eElement.getElementsByTagName("Firstname").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("Lastname").item(0).getTextContent());
					System.out.println("Age : " + eElement.getElementsByTagName("Age").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("Salary").item(0).getTextContent());

				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ParseXMLFile obj = new ParseXMLFile();
		obj.parseXml();
	}
}
