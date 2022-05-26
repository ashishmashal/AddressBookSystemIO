package com.bridgelabz;

import java.io.*;
import java.util.ArrayList;


public class CSVFile {
    public static final String SAMPLE_CSV_FILE = "//home//hp//IdeaProjects//AddressBookSystemProject//src//main//resources//Demo.csv";
    public static void WriteDataCSV(ArrayList<Contacts> contactDetails) {
        for (Contacts contacts:contactDetails)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAMPLE_CSV_FILE, true))){
                System.out.println("First Name\t\t Last Name \t Contact Number \t Email \t Address \t City \t State \t Zip Code");
                writer.write(contacts.getFirstName()+"\t\t" + contacts.getLastName() + "\t" + contacts.getContactNo() + "\t" + contacts.getEmail()+
                        "\t" + contacts.getAddress() + "\t" + contacts.getCity() +"\t" + contacts.getState() + "\t" + contacts.getZipCode()  + "\n\s");
            }catch (IOException e){
                throw new RuntimeException(e);
            }

    }
    public static void ReadDataCSV() {

        try {
            BufferedReader readerCSV = new BufferedReader(new FileReader(SAMPLE_CSV_FILE));
            String string;
            while ((string = readerCSV.readLine()) != null){
                System.out.printf(string);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


}

