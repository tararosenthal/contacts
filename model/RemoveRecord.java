package contacts.model;

import contacts.display.OutputInstructions;

public class RemoveRecord implements UpdatePhoneBook{
    private PhoneBook phoneBook;

    public RemoveRecord(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void update() {
        if (UpdatePhoneBook.phoneBookNotEmpty(phoneBook)) {
            OutputInstructions.listRecords(phoneBook);
            int recordNumber = UpdatePhoneBook.validRecordNumber(phoneBook);
            if (recordNumber >= 0) {
                phoneBook.removeRecord(recordNumber);
                OutputInstructions.recordRemoved();
            }
        }
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
}
