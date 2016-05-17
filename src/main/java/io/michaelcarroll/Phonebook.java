package io.michaelcarroll;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Phonebook {

    private Map<String, ArrayList<String>> phonebookMap = new TreeMap<>();

    public void addEntry(String name, ArrayList phoneNumbers) {

        phonebookMap.put(name, phoneNumbers);
    }

    public String lookupNumberByName(String name) {
        String numbers = "";
        for(String number : phonebookMap.get(name)){
            numbers += number+"\n";
        }
        return numbers;
    }

    public int getNumberOfListingsInPhonebook() {
        return phonebookMap.size();
    }

    public void removeEntryFromPhonebook(String name) {
        phonebookMap.remove(name);
    }

    public String listAllNamesInPhonebook() {
        String allNames = "";
        for (String key : phonebookMap.keySet()) {
            allNames += key + "\n";
        }
        return allNames;
    }

    public String listAllNamesAndPhoneNumbersInPhonebook() {
        String allNamesAndNumbers = "";
        for (Map.Entry<String, ArrayList<String>> entry : phonebookMap.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            allNamesAndNumbers += key + " : " + value + "\n";
        }
        return allNamesAndNumbers;
    }

    public String reverseLookupByNumber(String number) {
        for (String key : phonebookMap.keySet()) {
            if (phonebookMap.get(key).contains(number)) {
                return key;
            }
        }
        return null;
    }
}
