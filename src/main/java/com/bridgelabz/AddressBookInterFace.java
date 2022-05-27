package com.bridgelabz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

 interface AddressBookInterFace {
     void AddressBook(Operations oprations) throws IOException;

     void displayAddressBook();

     ArrayList<Contacts> addDetails(ArrayList<Contacts> contactDetails);

     void displayContacts(ArrayList<Contacts> contactDetails);

     void editDetails(ArrayList<Contacts> contactDetails);

     void deleteContact(ArrayList<Contacts> contactDetails);

     void MenuOption(Operations oprations, ArrayList<Contacts> contactDetails) throws IOException;

      void AddressBookMenu(Operations oprations) throws IOException;

     List<Contacts> SearchInMultipleAddressBook(String name);

     void searchByCityOrState(ArrayList<Contacts> contactDetails);

       List<Contacts> CountPersonFromSameCityOrState(String name);

      void sortContactsByPersonName(HashMap<String, ArrayList<Contacts>> hashmap);

      void sortContactsByZipOrCityOrState(HashMap<String, ArrayList<Contacts>> hashmap);
 }
