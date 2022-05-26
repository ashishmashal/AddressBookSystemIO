package com.bridgelabz;

import java.io.*;
import java.util.Scanner;

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

    public static void writingFile(){
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(String.valueOf(Operations.hashmap));
            System.out.println("Data Wrote Successfully");
            fileWriter.close();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String st;
            System.out.println("Data From File.");
            while ((st = reader.readLine()) != null) {

                System.out.println(st);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}

