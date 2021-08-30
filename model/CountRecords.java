package contacts.model;

import contacts.display.OutputInstructions;

public class CountRecords implements UpdatePhoneBook{
    private PhoneBook phoneBook;

    public CountRecords(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void update() {
        OutputInstructions.recordCount(phoneBook.getRecords().size());
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
}
