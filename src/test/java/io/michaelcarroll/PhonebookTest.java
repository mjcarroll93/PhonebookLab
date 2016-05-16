package io.michaelcarroll;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;


public class PhonebookTest {

    Phonebook phonebook;

    @Before
    public void setup() {
        phonebook = new Phonebook();
    }

    @Test
    public void addEntryToPhonebookTest() {
        phonebook.addEntry("MC", "213-456-4567");
        int expectedValue = 1;
        int actualValue = phonebook.getNumberOfListingsInPhonebook();
        assertEquals("The expected value is 1", expectedValue, actualValue);
    }

    @Test
    public void lookupPhoneNumberByNameTest() {
        phonebook.addEntry("Michael Jordan", "215-345-5678");
        String expectedValue = "215-345-5678";
        String actualValue = phonebook.lookupNumberByName("Michael Jordan");
        assertEquals("The expected number is 215-345-5678", expectedValue, actualValue);
    }

    @Test
    public void removeEntryFromPhonebookTest() {
        phonebook.addEntry("TJ", "267-879-6785");
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
        phonebook.addEntry("TJ", "215-345-5678");
        phonebook.addEntry("Michael Carroll", "215-378-6666");
        String expectedValue = "Michael Carroll\nTJ\n";
        String actualValue = phonebook.listAllNamesinPhonebook();
        assertEquals("The expected return is Michael Carroll\n" +
                "TJ\n", expectedValue, actualValue);
    }

    @Test
    public void listAllNamesAndPhoneNumbersInPhonebookTest() {
        phonebook.addEntry("TJ", "215-345-5678");
        phonebook.addEntry("Michael Carroll", "215-378-6666");
        String expectedValue = "Michael Carroll : 215-378-6666\nTJ : 215-345-5678\n";
        String actualValue = phonebook.listAllNamesAndPhoneNumbersInPhonebook();
        assertEquals("The expected return is Michael Carroll : 215-378-6666\n" +
                "TJ : 215-345-5678\n", expectedValue, actualValue);
    }

    @Test
    public void reverseLookupTest() {
        phonebook.addEntry("Kobe Bryant", "215-888-2424");
        String expectedValue = "Kobe Bryant";
        String actualValue = phonebook.reverseLookupByNumber("215-888-2424");
        assertEquals("The expected return value is Kobe Bryant", expectedValue, actualValue);

    }
}
