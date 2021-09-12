package contacts.controller.updateObjects;

import contacts.display.OutputInstructions;
import contacts.model.PhoneBook;
/*
 * Handles listing ordinal position and full name of each Record in a Phone Book.
 * Required to select Records for viewing info, editing, and deleting.
 */
public class ListRecords implements UpdatePhoneBook{
    private final PhoneBook phoneBook;

    public ListRecords(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void update() {
        //Lists Records if Phone Book contains at least one Record, otherwise notifies user Phone Book is empty
        if (UpdatePhoneBook.phoneBookNotEmpty(phoneBook)) {
            OutputInstructions.listRecords(phoneBook);
        }
    }
}
