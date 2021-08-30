package contacts.model;

import contacts.controller.InputParser;
import contacts.display.OutputInstructions;

public interface UpdatePhoneBook {
    void update();

    static boolean phoneBookNotEmpty(PhoneBook phoneBook) {
        if (phoneBook.getRecords().isEmpty()) {
            OutputInstructions.noRecords();
            return false;
        }
        return true;
    }

    static int validRecordNumber(PhoneBook phoneBook) {
        int recordNumber = InputParser.selectRecord();
        if (recordNumber < 0 || recordNumber > phoneBook.getRecords().size() - 1) {
            OutputInstructions.doesNotExist();
            return -1;
        }
        return recordNumber;
    }
}
