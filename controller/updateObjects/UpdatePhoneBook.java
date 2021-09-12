package contacts.controller.updateObjects;

import contacts.controller.InputParser;
import contacts.display.OutputInstructions;
import contacts.model.PhoneBook;
/*
 * Interface to label Update Objects with simple shared methods for checking if Phone Book contains one or more Records
 * and to ensure that Phone Book has a requested Record as determined by ordinal position.
 */
public interface UpdatePhoneBook {
    void update();
    /*
     * Checks if Phone Book contains at least one Record. Outputs information to user if Phone Book is empty.
     * @param phoneBook     Phone Book to check
     * @return boolean      true if contains at least one Record, false otherwise
     */
    static boolean phoneBookNotEmpty(PhoneBook phoneBook) {
        if (phoneBook.getRecords().isEmpty()) {
            OutputInstructions.noRecords();
            return false;
        }
        return true;
    }
    /*
     * If Phone Book contains at least one record, obtains user input number and checks to see if it corresponds to
     * the ordinal position of any Record in the Phone Book. Outputs instructions to user if Phone Book empty or if a
     * Record does not exist at that position.
     * @param phoneBook            Phone Book to check
     * @return recordNumber or -1  returns user input number if corresponds to existing Record or -1 if not or if
     *                             Phone Book is empty
     */
    static int validRecordNumber(PhoneBook phoneBook) {
        if (phoneBookNotEmpty(phoneBook)) {
            int recordNumber = InputParser.getRecordNumber();
            if (recordNumber < 0 || recordNumber > phoneBook.getRecords().size() - 1) {
                OutputInstructions.doesNotExist();
                return -1;
            }
            return recordNumber;
        }
        return -1;
    }
}
