package contacts.controller.updateObjects;

import contacts.controller.InputParser;
import contacts.controller.SerializationUtils;
import contacts.display.OutputInstructions;
import contacts.model.PhoneBook;
import contacts.model.Record;
/*
 * Handles editing an individual field value in an individual Record.
 * Serializes updated Phone Book after completed edit.
 */
public class EditRecord implements UpdatePhoneBook{
    private final PhoneBook phoneBook;
    private final SerializationUtils serializationUtils;

    public EditRecord(PhoneBook phoneBook, SerializationUtils serializationUtils) {
        this.phoneBook = phoneBook;
        this.serializationUtils = serializationUtils;
    }

    @Override
    public void update() {
        //Checks if Phone Book contains at least one Record, then obtains a number from user and ensures that Phone Book
        //contains at least that many Records. If invalid number or Phone Book empty, will return -1
        int recordNumber = UpdatePhoneBook.validRecordNumber(phoneBook);
        if (recordNumber >= 0) {
            Record record = phoneBook.getRecord(recordNumber);
            //obtains a new valid value for a valid field in chosen Record, returns null object if invalid
            SingleRecordEdit recordEdit = InputParser.editRecord(record);
            if (recordEdit != null) {
                //finds field by String and replaces with new value
                record.changeField(recordEdit.getField(), recordEdit.getValue());
                serializationUtils.savePhoneBook(); //serializes after completed edit
                OutputInstructions.recordUpdated(record); //notifies user that change was made and saved
            }
        }
    }
}
