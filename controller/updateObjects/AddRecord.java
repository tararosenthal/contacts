package contacts.controller.updateObjects;

import contacts.controller.InputParser;
import contacts.controller.SerializationUtils;
import contacts.display.OutputInstructions;
import contacts.model.PhoneBook;
import contacts.model.Record;

import java.util.HashMap;
/*
 * Handles adding a new Record to Phone Book and serializing updated Phone Book.
 * Utilizes AddFactory to ensure the correct type of Record is created with corresponding field values.
 */
public class AddRecord implements UpdatePhoneBook {
    private final PhoneBook phoneBook;
    private final SerializationUtils serializationUtils;

    public AddRecord(PhoneBook phoneBook, SerializationUtils serializationUtils) {
        this.phoneBook = phoneBook;
        this.serializationUtils = serializationUtils;
    }

    @Override
    public void update() {
        AddFactory addFactory = new AddFactory();
        Record nullRecord = addFactory.getNullRecord(); //for obtaining field names by record type
        HashMap<String, String> input = InputParser.addRecord(nullRecord); //valid field names and values
        phoneBook.addRecords(addFactory.add(input));
        serializationUtils.savePhoneBook(); //serializes updated Phone Book
        OutputInstructions.recordAdded(); //notifies user that Record was added
    }
}
