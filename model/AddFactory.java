package contacts.model;

import contacts.model.enums.*;

import java.util.HashMap;

public class AddFactory {
    Record record;
    HashMap<RecordKey, String> map;

    public AddFactory(HashMap<RecordKey, String> map) {
        this.map = map;
    }

    public Record add() {
        if (RecordType.PERSON.equals(RecordType.getRecordType())) {
            record = new Person.Builder().setFirstName(map.get(PersonKey.FIRST_NAME))
                    .setLastName(map.get(PersonKey.LAST_NAME))
                    .setBirthDate(map.get(PersonKey.BIRTH_DATE))
                    .setGender(map.get(PersonKey.GENDER))
                    .setPhoneNumber(map.get(PersonKey.PHONE_NUMBER))
                    .build();
        } else {
            record = new Organization.Builder().setOrganizationName(map.get(OrganizationKey.ORGANIZATION_NAME))
                    .setAddress(map.get(OrganizationKey.ADDRESS))
                    .setPhoneNumber(map.get(OrganizationKey.PHONE_NUMBER))
                    .build();
        }
        return record;
    }
}
