package contacts.model;

import contacts.controller.InputParser;
import contacts.display.OutputInstructions;
import contacts.model.enums.RecordKey;

import java.util.HashMap;

public class AddRecord implements UpdatePhoneBook {
    private PhoneBook phoneBook;

    public AddRecord(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void update() {
        HashMap<RecordKey, String> input = InputParser.addRecord();
        phoneBook.addRecords(new AddFactory(input).add());
        OutputInstructions.recordAdded();
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
}
