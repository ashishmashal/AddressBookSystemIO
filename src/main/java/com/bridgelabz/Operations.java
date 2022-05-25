package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;


public class Operations implements AddressBookInterFace {
    static ArrayList<String> contactsDetails = new ArrayList<>();

    //static HashMap<String, Object> AddressBook = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);


    static HashMap<String, ArrayList<Contacts>> hashmap = new HashMap<>();
    HashMap<String, ArrayList<Contacts>> addressBook;
    public Operations() {
        addressBook = new HashMap<>();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    method For Adding Multiple Address Book.
     */
    public void AddressBook(Operations oprations) {
        int ans;
        do {
            System.out.println("Enter Name For Address Book");
            String AddressBookName = scanner.next();
            contactsDetails.add(AddressBookName);
            // addressBookSystem.MenuOption(addressBookSystem,contactsDetails);
            if (hashmap.containsKey(AddressBookName)) {
                System.out.println("The AddressBook already contains");
                break;
            } else {
                ArrayList<Contacts> contactDetails = new ArrayList<>();
                oprations.MenuOption(oprations, contactDetails);
                hashmap.put(AddressBookName, contactDetails);
                IOFile.createFile();
            }
            System.out.println("AddressBook Added" + hashmap + " ");
            System.out.println("Do You Want To Continue in AddressBook the Press 1 ");
            ans = scanner.nextInt();
        } while (ans == 1);
    }

    public void displayAddressBook() {
        System.out.println("AddressBooks Are:" + hashmap + " "  );

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Contacts> addDetails(ArrayList<Contacts> contactDetails) {
        Contacts info = new Contacts();
        if (contactDetails.size() == 0) {
            System.out.println("Enter first name: ");
            info.setFirstName(scanner.next());
            System.out.println("Enter last name: ");
            info.setLastName(scanner.next());
            System.out.println("Enter address: ");
            info.setAddress(scanner.next());
            System.out.println("Enter city name: ");
            info.setCity(scanner.next());
            System.out.println("Enter state name: ");
            info.setState(scanner.next());
            System.out.println("Enter zip code: ");
            info.setZipCode(scanner.next());
            System.out.println("Enter contact no.: ");
            info.setContactNo(scanner.next());
            System.out.println("Enter email: ");
            info.setEmail(scanner.next());
            contactDetails.add(info);
            System.out.println("Contact details added!");
            return contactDetails;
        } else {
            System.out.println("Enter First Name");
            String firstname = scanner.next();
            /*
            For searching the duplicate names in arraylist
             */
            for (Contacts contact : contactDetails) {
                /*
                checking the duplicate name.
                 */
                if (contact.getFirstName().equals(firstname)) {
                    System.out.print("Name already present\n");
                } else {
                    info.setFirstName(firstname);
                    System.out.println("Enter last name: ");
                    info.setLastName(scanner.next());
                    System.out.println("Enter address: ");
                    info.setAddress(scanner.next());
                    System.out.println("Enter city name: ");
                    info.setCity(scanner.next());
                    System.out.println("Enter state name: ");
                    info.setState(scanner.next());
                    System.out.println("Enter zip code: ");
                    info.setZipCode(scanner.next());
                    System.out.println("Enter contact no.: ");
                    info.setContactNo(scanner.next());
                    System.out.println("Enter email: ");
                    info.setEmail(scanner.next());
                    contactDetails.add(info);
                    System.out.println("Contact details added!");
                    return contactDetails;
                }
            }
        }
        return contactDetails;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Displaying All Content From ArrayList.
     */
    public void displayContacts(ArrayList<Contacts> contactDetails) {
        for (Contacts contactsDetail : contactDetails) {
            System.out.println("-----------------------***************************-----------------------------------");
            System.out.print(contactsDetail + " ");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
        Method For Modifying Person Details .
         */
    public void editDetails(ArrayList<Contacts> contactDetails) {
        System.out.println("Enter First Name for which you want to modify info: ");
        String searchFirstName = scanner.next();
        /*  Iterate to search for first name */
        for (Contacts contact : contactDetails) {
            /*  compare first name
             *   if matches display menu for edit
             *   else display no record found message
             */
            if (contact.getFirstName().equals(searchFirstName)) {
                System.out.println("Enter the number to edit respective info: ");
                System.out.println("""
                        1. First Name\s
                        2. Last Name\s
                        3. Address\s
                        4. City\s
                        5. State\s
                        6. Zip Code\s
                        7. Contact No\s
                        8. Email""");
                int index = scanner.nextInt();
                System.out.println("Enter value to update: ");
                switch (index) {
                    case 1 -> {
                        String updatedFirstName = scanner.next();
                        contact.setFirstName(updatedFirstName);
                    }
                    case 2 -> {
                        String updatedLastName = scanner.next();
                        contact.setLastName(updatedLastName);
                    }
                    case 3 -> {
                        String updatedAddress = scanner.next();
                        contact.setAddress(updatedAddress);
                    }
                    case 4 -> {
                        String updatedCity = scanner.next();
                        contact.setCity(updatedCity);
                    }
                    case 5 -> {
                        String updatedState = scanner.next();
                        contact.setState(updatedState);
                    }
                    case 6 -> {
                        String updatedZipCode = scanner.next();
                        contact.setZipCode(updatedZipCode);
                    }
                    case 7 -> {
                        String updatedContact = scanner.next();
                        contact.setContactNo(updatedContact);
                    }
                    case 8 -> {
                        String updatedEmail = scanner.next();
                        contact.setEmail(updatedEmail);
                    }
                    default -> System.out.println("Invalid number!");
                }
                /*  Display updated contact */
                System.out.println("Details updated");
            } else {
                System.out.println("No record found!");
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
        Delete The Person From Arraylist.
         */
    public void deleteContact(ArrayList<Contacts> contactDetails) {
        System.out.println("Enter email for which you want to delete contact: ");
        String searchEmail = scanner.next();
        Iterator<Contacts> removeContact = contactDetails.iterator();
        /*  Checking the next element where
         *   condition holds true till there is single element
         *   in the List using hasNext() method
         */
        while (removeContact.hasNext()) {
            /*  Move cursor to next element */
            Contacts nextElement = removeContact.next();
            if (nextElement.getEmail().equals(searchEmail)) {
                removeContact.remove();
                System.out.println("Contact is removed!");
                break;
            } else {
                System.out.println("Contact not found.");
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /*
   Methods For Search Person in multiple Address Book.
    */
    public List<Contacts> SearchInMultipleAddressBook(String name) {
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()) {
            for (Contacts v : entry.getValue()) {
                if (v.getCity().equals(name) || v.getState().equals(name)) {
                    System.out.println("\n Record Found in=>" + entry.getKey());
                    System.out.println("\tPersons Details Are=>" + v);
                } else {
                    System.out.println("No record found:");
                }
            }
        }
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Counting how many persons belonging from same city or state from Multiple AddressBook.
     */
    public List<Contacts> CountPersonFromSameCityOrState(String name) {
        int count = 0;
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()) {
            for (Contacts v : entry.getValue()) {
                if (v.getCity().equals(name) || v.getState().equals(name)) {
                    count++;
                }
            }
        }
        System.out.printf(count + "\tPersons belonging From => \n " + name);
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Sorting The person Data Alphabetically.
     */
    public void sortContactsByPersonName(HashMap<String, ArrayList<Contacts>> hashmap) {
        for (Map.Entry<String, ArrayList<Contacts>> addressBookMapEntry : hashmap.entrySet()) {
            List<Contacts> sortedContacts = addressBookMapEntry.getValue()
                    .stream()
                    .sorted(Comparator.comparing(contactInfo -> contactInfo.getFirstName() + contactInfo.getLastName()))
                    .collect(Collectors.toList());
            System.out.println("Sorted Contacts By Name : ");
            for (Contacts item : sortedContacts) {
                System.out.println(addressBookMapEntry.getKey());
                System.out.println(item.toString());
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Sorting
     */
    public void sortContactsByZipOrCityOrState(HashMap<String, ArrayList<Contacts>> hashmap){
        for (Map.Entry<String, ArrayList<Contacts>> addressBookMapEntry : hashmap.entrySet()) {
            List<Contacts> sortedContacts = addressBookMapEntry.getValue()
                    .stream()
                    .sorted(Comparator.comparing(contactInfo -> contactInfo.getZipCode() + contactInfo.getCity() +
                            contactInfo.getState()))
                    .collect(Collectors.toList());
            System.out.println("Sorted Contacts By Zip : ");
            for (Contacts item : sortedContacts) {
                System.out.println(addressBookMapEntry.getKey());
                System.out.println(item.toString() + " ");
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Search Person in Specified AddressBook.
     */
    public void searchByCityOrState(ArrayList<Contacts> contactDetails) {
        int flag = 0;
        ArrayList<Contacts> match = new ArrayList<>();
        System.out.println("Enter First Name");
        String CityOrstate = scanner.next();
        for (Contacts contact : contactDetails) {
            if (contact.getCity().equals(CityOrstate) || contact.getState().equals(CityOrstate)) {
                flag = 1;
                match.add(contact);
            }
        }
        if (flag == 1) {
            System.out.println("...Match Found...");
            for (Contacts p : match) {
                System.out.println(p);
            }
        } else {
            System.out.println("Match Not Found!!!");
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
        Displaying the Menu Options Person.
         */
    public void MenuOption(Operations oprations, ArrayList<Contacts> contactDetails) {
        System.out.println("Enter a number to perform For Persons action: ");
        int menu, ans;
        do {
            System.out.println("""
                    \s
                    1. Add details\s
                    2. Edit details\s
                    3. Delete details\s
                    4. Display details\s
                    5. Exit""");
            System.out.println("Enter Option");
            menu = scanner.nextInt();
            switch (menu) {
                case 1 ->
                    /*  Add contact details in address book */
                        oprations.addDetails(contactDetails);
                case 2 ->
                    /*  Edit contact details in address book */
                        oprations.editDetails(contactDetails);
                case 3 ->
                    /*  Delete contact details */
                        oprations.deleteContact(contactDetails);
                case 4 ->
                    /*  Display contact details */
                        oprations.displayContacts(contactDetails);
                case 5 ->
                    /* Search Contact Details */
                        oprations.searchByCityOrState(contactDetails);
                case 6 ->
                    /* Exiting The MenuOption */
                        System.out.println("Exit!");

                default -> System.out.println("Invalid option selected.");
            }
            System.out.println("Do You Want To continue In MenuOption ......If Yes The Press '1' ");
            ans = scanner.nextInt();
        } while (ans == 1);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void AddressBookMenu(Operations oprations) {
        System.out.println("Enter a number to perform AddressBook actions: ");
        int menu, ans;

        do {
            System.out.println("""
                    \s
                    1. Add AddressBook\s
                    2. Display AddressBook\s
                    3.Search In Multiple AddressBook\s
                    4.Count Person By City Or State\s
                    5.Sort By Name.\s
                    6.Sorting By Zipcode.\s
                    7.Write Into The File.\s
                    8.Read From File.\s
                    9.Exit""");
            System.out.println("Enter Option");
            menu = scanner.nextInt();
            switch (menu) {
                case 1 -> AddressBook(oprations);
                case 2 -> displayAddressBook();
                case 3 -> {
                    System.out.println("Enter city name or state name to search records");
                    String name = scanner.next();
                    SearchInMultipleAddressBook(name);
                }
                case 4 -> {
                    System.out.println("Enter city name or state name to Count Persons belonging from same city or state");
                    String countName = scanner.next();
                    CountPersonFromSameCityOrState(countName);
                }
                case 5->
                        sortContactsByPersonName(hashmap);
                case 6->
                        sortContactsByZipOrCityOrState(hashmap);
                case 7->
                        IOFile.writingFile();
                case 8->
                        IOFile.readFromFile();
                case 9 ->
                System.out.println("Exit");

            }

            System.out.print("Do You Want TO Continue In Address Book Menu Option if Yes Enter \n " +
                    "1 For continue or Else Enter \n 2 For Exit.\n ");
            ans = scanner.nextInt();
        } while (ans == 1);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}


