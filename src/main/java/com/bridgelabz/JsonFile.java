package com.bridgelabz;


import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class JsonFile {

	public static final String SAMPLE_JSON_FILE = "//home//hp//IdeaProjects//AddressBookSystemProject//src//main//resources//Demo.json";

	public static boolean WriteDataJSON(HashMap<String, ArrayList<Contacts>> hashmap) {

		try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(SAMPLE_JSON_FILE, true))) {
			Gson gson = new Gson();

			String jsonString = gson.toJson(hashmap);
			writer1.write(jsonString);
			return true;
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static boolean ReadDataJSON() {
		try {


			BufferedReader reader = new BufferedReader(new FileReader(SAMPLE_JSON_FILE));
			String st;

			while ((st = reader.readLine()) != null) {
				System.out.println(st);
				System.out.print("\n");

			}
			return true;
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
