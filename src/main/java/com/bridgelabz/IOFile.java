package com.bridgelabz;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IOFile {
    static File file = new File("//home//hp//IdeaProjects//AddressBookSystemProject//src//demo.txt");

    public static void createFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("File Is Created" + file.getName());
            } else {
                System.out.println("File Is Already Exist" + file.getName());
            }
        } catch (IOException e) {
            System.out.println("Error Is :" +e);
        }

    }

    public static boolean writingFile(HashMap<String, ArrayList<Contacts>> hashmap) {
        for (Map.Entry<String, ArrayList<Contacts>> addressBookHashMap : hashmap.entrySet()) {
            ArrayList<Contacts> values = addressBookHashMap.getValue();
            for (Contacts p : values)
            /* writer reads the current line and the Java readLine function writer.readLine() returns a string.
             Hence, the loop will iterate until it’s not null.*/
                try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(file, true))) {
                    writer1.write("\nAddress Book Name- "+addressBookHashMap.getKey()+"\tFirst Name- " + p.getFirstName() + "\tLast Name- " + p.getLastName()
                            + "\tContact Number- " + p.getContactNo() + "\tEmail- " + p.getEmail() + "\tAddress- " + p.getAddress() + "\tCity- " + p.getCity()
                            + "\tState-" + p.getState() + "\tZip Code- " + p.getZipCode());

                } catch (IOException e) {
                    throw new RuntimeException(e);

                }
        }
        return true;
    }
    public static boolean readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String st;
            System.out.println("Data From File.");
            while ((st = reader.readLine()) != null) {

                System.out.println(st);
            }
            return true;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}

