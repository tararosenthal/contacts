package contacts.controller.updateObjects;

import contacts.display.OutputInstructions;
import contacts.model.PhoneBook;
/*
 * Prints values of all changeable fields for a given Record as well as time created and updated.
 */
public class RecordInfo implements UpdatePhoneBook{
    private final PhoneBook phoneBook;

    public RecordInfo(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void update() {
        //obtains a number from user and ensures that Phone Book contains at least that many Records
        int recordNumber = UpdatePhoneBook.validRecordNumber(phoneBook); //if invalid number, will return -1
        if (recordNumber >= 0) {
            OutputInstructions.printRecord(phoneBook.getRecord(recordNumber));
        }
    }
}
