package contacts.controller.updateObjects;

import contacts.display.OutputInstructions;
import contacts.model.PhoneBook;
/*
 * For displaying up-to-date count of records in Phone Book.
 */
public class CountRecords implements UpdatePhoneBook{
    private final PhoneBook phoneBook;

    public CountRecords(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void update() {
        OutputInstructions.recordCount(phoneBook.getRecords().size());
    }
}
