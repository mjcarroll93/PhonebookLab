package io.michaelcarroll;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PhonebookTest {

    Phonebook phonebook;
    Citizen citizen;
    Citizen citizen2;

    @Before
    public void setup() {
        phonebook = new Phonebook();
        citizen = new Citizen();
        citizen2 = new Citizen();
    }

    @Test
    public void addEntryToPhonebookTest() {
        citizen.setName("MC");
        citizen.addPhoneNumbers("213-456-4567");
        phonebook.addEntry(citizen.getName(), citizen.getPhoneNumbers());
        int expectedValue = 1;
        int actualValue = phonebook.getNumberOfListingsInPhonebook();
        assertEquals("The expected value is 1", expectedValue, actualValue);
    }

    @Test
    public void lookupPhoneNumberByNameTest() {
        citizen.setName("MC");
        citizen.addPhoneNumbers("213-456-4567");
        phonebook.addEntry(citizen.getName(), citizen.getPhoneNumbers());
        String expectedValue = "213-456-4567\n";
        String actualValue = phonebook.lookupNumberByName("MC");
        assertEquals("The expected number is 213-456-4567", expectedValue, actualValue);
    }

    @Test
    public void removeEntryFromPhonebookTest() {
        citizen.setName("TJ");
        citizen.addPhoneNumbers("215-333-5566");
        citizen.addPhoneNumbers("215-999-9999");
        phonebook.addEntry("TJ", citizen.getPhoneNumbers());
        int expectedSize = 1;
        int actualSize = phonebook.getNumberOfListingsInPhonebook();
        assertEquals("The size should start out at 1", expectedSize, actualSize);
        phonebook.removeEntryFromPhonebook("TJ");
        int expectedNewSize = 0;
        int actualNewSize = phonebook.getNumberOfListingsInPhonebook();
        assertEquals("The new size should be 0", expectedNewSize, actualNewSize);
    }

    @Test
    public void listAllNamesInPhonebookTest() {
        citizen.setName("Michael");
        citizen.addPhoneNumbers("215-333-5566");
        citizen2.setName("TJ");
        citizen2.addPhoneNumbers("213-444-5555");
        phonebook.addEntry(citizen.getName(), citizen.getPhoneNumbers());
        phonebook.addEntry(citizen2.getName(), citizen2.getPhoneNumbers());
        String expectedValue = "Michael\nTJ\n";
        String actualValue = phonebook.listAllNamesInPhonebook();
        assertEquals("The expected return is Michael Carroll\n" +
                "TJ\n", expectedValue, actualValue);
    }

    @Test
    public void listAllNamesAndPhoneNumbersInPhonebookTest() {
        citizen.setName("Michael");
        citizen.addPhoneNumbers("215-333-5566");
        citizen2.setName("TJ");
        citizen2.addPhoneNumbers("213-444-5555");
        phonebook.addEntry(citizen.getName(), citizen.getPhoneNumbers());
        phonebook.addEntry(citizen2.getName(), citizen2.getPhoneNumbers());
        String expectedValue = "Michael : [215-333-5566]\nTJ : [213-444-5555]\n";
        String actualValue = phonebook.listAllNamesAndPhoneNumbersInPhonebook();
        assertEquals("The expected return is Michael : 215-378-6666\n" +
                "TJ : 215-345-5678\n", expectedValue, actualValue);
    }

    @Test
    public void reverseLookupTest() {
        citizen.setName("Kobe Bryant");
        citizen.addPhoneNumbers("215-333-5566");
        phonebook.addEntry(citizen.getName(), citizen.getPhoneNumbers());
        String expectedValue = "Kobe Bryant";
        String actualValue = phonebook.reverseLookupByNumber("215-333-5566");
        assertEquals("The expected return value is Kobe Bryant", expectedValue, actualValue);

    }
}
