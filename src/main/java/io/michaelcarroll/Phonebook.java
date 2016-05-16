package io.michaelcarroll;

import java.util.Map;
import java.util.TreeMap;

public class Phonebook {

    private Map<String, String> phonebookMap = new TreeMap<>();

    public void addEntry(String name, String phonenumber) {
        phonebookMap.put(name, phonenumber);
    }

    public String lookupNumberByName(String number) {
        return phonebookMap.get(number);
    }

    public int getNumberOfListingsInPhonebook() {
        return phonebookMap.size();
    }

    public void removeEntryFromPhonebook(String name) {
        phonebookMap.remove(name);
    }

    public String listAllNamesinPhonebook() {
        String allNames = "";
        for (String key : phonebookMap.keySet()) {
            allNames += key + "\n";
        }
        return allNames;
    }

    public String listAllNamesAndPhoneNumbersInPhonebook() {
        String allNamesAndNumbers = "";
        for (Map.Entry<String, String> entry : phonebookMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            allNamesAndNumbers += key + " : " + value + "\n";
        }
        return allNamesAndNumbers;
    }

    public String reverseLookupByNumber(String number) {
        for (String key : phonebookMap.keySet()) {
            if (phonebookMap.get(key).equals(number)) {
                return key;
            }
        }
        return null;
    }
}
