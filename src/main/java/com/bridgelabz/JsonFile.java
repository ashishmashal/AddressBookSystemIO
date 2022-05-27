package com.bridgelabz;


import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;


public class JsonFile {

	public static final String SAMPLE_JSON_FILE = "//home//hp//IdeaProjects//AddressBookSystemProject//src//main//resources//Demo.json";

	public static void WriteDataJSON(ArrayList<Contacts> contactDetails) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAMPLE_JSON_FILE, true))) {
			Gson gson = new Gson();
			String jsonString = gson.toJson(contactDetails);
			writer.write(jsonString);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
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
