package contacts.controller.updateObjects;

import contacts.controller.SerializationUtils;
import contacts.display.OutputInstructions;
import contacts.model.PhoneBook;
/*
 * Handles deleting a single Record from Phone Book and serializing updated Phone Book.
 */
public class DeleteRecord implements UpdatePhoneBook{
    private final PhoneBook phoneBook;
    private final SerializationUtils serializationUtils;

    public DeleteRecord(PhoneBook phoneBook, SerializationUtils serializationUtils) {
        this.phoneBook = phoneBook;
        this.serializationUtils = serializationUtils;
    }

    @Override
    public void update() {
        //Checks if Phone Book contains at least one Record, then obtains a number from user and ensures that Phone Book
        // contains at least that many Records. If invalid number or Phone Book empty, will return -1
        int recordNumber = UpdatePhoneBook.validRecordNumber(phoneBook);
        if (recordNumber >= 0) {
            phoneBook.deleteRecord(recordNumber); //deletes Record from Phone Book
            serializationUtils.savePhoneBook(); //serializes updated Phone Book
            OutputInstructions.recordDeleted(); //notifies user that change was made
       }
    }
}
