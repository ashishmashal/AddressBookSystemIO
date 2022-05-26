package com.bridgelabz;

import com.opencsv.bean.CsvBind;


public class CSVData {
    public String firstName, lastName, address, city, state, zipCode, contactNo, email;
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getZipCode() {
        return zipCode;
    }


    public CSVData( String firstName, String lastName, String email, String contactNo,String address,String city,String state,String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNo = contactNo;
        this.city=city;
        this.state=state;
        this.address=address;
        this.zipCode=zipCode;
    }
}
