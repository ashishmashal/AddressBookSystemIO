package com.bridgelabz;

import java.io.IOException;

public class AddressBookSystem extends Operations {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Address Book Program!");
        Operations oprations = new Operations();
        System.out.println("-----------------------------*****-------------------------");
        oprations.AddressBookMenu(oprations);

    }
}

