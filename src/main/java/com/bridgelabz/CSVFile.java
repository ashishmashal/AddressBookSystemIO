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

	public static boolean WriteDataCSV(HashMap<String, ArrayList<Contacts>> hashmap) throws IOException {
		try (Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
		     CSVWriter csvWriter = new CSVWriter(writer, ',');) {
			System.out.println("First Name\t\t Last Name \t Contact Number \t Email \t Address \t City \t State \t Zip Code");
			for (Map.Entry<String, ArrayList<Contacts>> addressBookMapEntry : hashmap.entrySet()) {
				ArrayList<Contacts> values = addressBookMapEntry.getValue();
				for (Contacts c : values) {
					String[] s = {"AddressBook Name:" + addressBookMapEntry.getKey(), "First Name:" + c.getFirstName(), "Last Name:" + c.getLastName(), "Contact No:" + c.getContactNo(), "Email ID:" + c.getEmail(), "Address:" + c.getAddress(), "City:" + c.getCity()
							, "State:" + c.getState(), "Zip Code:" + c.getZipCode()};
					csvWriter.writeNext(s);
				}
			}
			return true;
		}
	}

	public static boolean ReadDataCSV() {
		try (
				Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE));
				CSVReader csvReader = new CSVReader(reader)
		) {
			String nextLine[];
			while ((nextLine = csvReader.readNext()) != null) {
				for(String token : nextLine)
				{
					System.out.print("\t");
					System.out.print(token);
				}
			}
			return true;
		} catch (Exception e){
			System.out.println(e);
		}
		return false;
	}



}

