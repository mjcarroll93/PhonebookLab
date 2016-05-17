package io.michaelcarroll;


import java.util.ArrayList;

public class Citizen {

    private String name;
    private ArrayList<String> phoneNumbers = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addPhoneNumbers(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }
}
