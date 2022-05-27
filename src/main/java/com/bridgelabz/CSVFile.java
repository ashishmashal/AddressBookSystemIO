package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CSVFile {
	public static final String SAMPLE_CSV_FILE = "//home//hp//IdeaProjects//AddressBookSystemProject//src//main//resources//Demo.csv";

	public static void WriteDataCSV(ArrayList<Contacts> contactDetails){

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAMPLE_CSV_FILE, true));
				CSVWriter csvWriter = new CSVWriter(writer,',')){
			for (Contacts contacts:contactDetails) {
				//System.out.println("First Name\t\t Last Name \t Contact Number \t Email \t Address \t City \t State \t Zip Code");
			String[] s=	{"First Name : " + contacts.getFirstName() , "Last Name :" + contacts.getLastName() , "Contact No :" + contacts.getContactNo(),  "Email :" + contacts.getEmail() ,
						"Address :" + contacts.getAddress() , "City :" + contacts.getCity() , "State :" + contacts.getState() , "ZipCode :" + contacts.getZipCode() };
				csvWriter.writeNext(s);
			}
			}catch (IOException e){
				e.printStackTrace();
			}

	}

	public static void ReadDataCSV() {
		try (
				Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE));
				CSVReader csvReader = new CSVReader(reader)
		) {
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				for (String strings : nextLine) {
					System.out.print("\t" + strings + "\n");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

