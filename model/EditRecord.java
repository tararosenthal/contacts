package contacts.model;

import contacts.controller.InputParser;
import contacts.display.OutputInstructions;
import contacts.model.enums.RecordType;

public class EditRecord implements UpdatePhoneBook{
    private PhoneBook phoneBook;

    public EditRecord(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void update() {
        if (UpdatePhoneBook.phoneBookNotEmpty(phoneBook)) {
            OutputInstructions.listRecords(phoneBook);
            int recordNumber = UpdatePhoneBook.validRecordNumber(phoneBook);
            if (recordNumber >= 0) {
                if (phoneBook.getRecord(recordNumber) instanceof Person) {
                    RecordType.setRecordType(RecordType.PERSON);
                } else {
                    RecordType.setRecordType(RecordType.ORGANIZATION);
                }
                SingleRecordEdit recordEdit = InputParser.editRecord();
                if (recordEdit != null) {
                    new EditFactory(phoneBook.getRecord(recordNumber))
                            .edit(recordEdit.getRecordKey(), recordEdit.getValue());
                    OutputInstructions.recordUpdated();
                }
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
