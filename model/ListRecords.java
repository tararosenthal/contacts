package contacts.model;

import contacts.display.OutputInstructions;

public class ListRecords implements UpdatePhoneBook{
    private PhoneBook phoneBook;

    public ListRecords(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void update() {
        if (UpdatePhoneBook.phoneBookNotEmpty(phoneBook)) {
            OutputInstructions.listRecords(phoneBook);
            int recordNumber = UpdatePhoneBook.validRecordNumber(phoneBook);
            if (recordNumber >= 0) {
                OutputInstructions.printRecord(phoneBook.getRecord(recordNumber));
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
