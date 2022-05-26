package com.bridgelabz;

import java.io.*;
import java.util.ArrayList;

public class JsonFile {

	public static final String SAMPLE_JSON_FILE = "//home//hp//IdeaProjects//AddressBookSystemProject//src//main//resources//Demo.json";

	public static void WriteDataJSON(ArrayList<Contacts> contactDetails) {
		for (Contacts contacts : contactDetails)
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAMPLE_JSON_FILE, true))) {
				writer.write(contacts.getFirstName() + "\t\t" + contacts.getLastName() + "\t" + contacts.getContactNo() + "\t" + contacts.getEmail() +
						"\t" + contacts.getAddress() + "\t" + contacts.getCity() + "\t" + contacts.getState() + "\t" + contacts.getZipCode() + "\n\s");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
	}

	public static void ReadDataJSON() {

		try {
			BufferedReader readerJSON = new BufferedReader(new FileReader(SAMPLE_JSON_FILE));
			String string;
			while ((string = readerJSON.readLine()) != null) {
				System.out.printf(string);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
