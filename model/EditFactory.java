package contacts.model;

import contacts.model.enums.RecordKey;
import contacts.model.enums.RecordType;

public class EditFactory {
    private Record record;

    public EditFactory(Record record) {
        this.record = record;
    }

    public void edit(RecordKey recordKey, String value) {
        if ("phone number".equals(recordKey.toString())) {
            record.setPhoneNumber(value);
        } else if (RecordType.PERSON.equals(RecordType.getRecordType())) {
            Person person = (Person) record;
            switch (recordKey.toString()) {
                case "first name":
                    person.setFirstName(value);
                    break;
                case "last name":
                    person.setLastName(value);
                    break;
                case "birth date":
                    person.setBirthDate(value);
                    break;
                case "gender":
                    person.setGender(value);
                    break;
            }
        } else {
            Organization organization = (Organization) record;
            switch (recordKey.toString()) {
                case "organization name":
                    organization.setOrganizationName(value);
                    break;
                case "address":
                    organization.setAddress(value);
                    break;
            }
        }
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
