package contacts.controller.updateObjects;

import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.Record;
import contacts.controller.enums.*;

import java.util.HashMap;
/*
 * Interacts with record type to assist with obtaining needed fields from user and creating appropriate record
 * for adding to Phone Book. Adding handled by AddRecord object.
 */
public class AddFactory {
    Record record;
    RecordType recordType;
/*
 * Creates depending on type chosen by user, creates either Person or Organization record with null fields
 * to obtain field names for creating filled Record for Phone Book.
 * @return Record       Person or Organization Record object will null values for all fields
 */
    public Record getNullRecord() {
        if (RecordType.PERSON.equals(RecordType.getRecordType())) {
            recordType = RecordType.PERSON;
            return new Person.Builder().build();
        } else if (RecordType.ORGANIZATION.equals(RecordType.getRecordType())){
            recordType = RecordType.ORGANIZATION;
            return new Organization.Builder().build();
        }
        throw new AddFactoryException("Invalid record type at time of object creation");
    }
/*
 * Creates record with valid field values obtained from user with same type as previously created Null Record.
 * @param map       HashMap with valid field value pairs corresponding to chosen record type.
 * @ return Record  Person or Organization type Record with valid field values filled in, all other values will be null,
 *                  null values should not create null pointer exception anywhere in program as values are only for
 *                  displaying or changing.
 */
    public Record add(HashMap<String, String> map) {
        if (RecordType.PERSON.equals(recordType)) {
            record = new Person.Builder().setFields(map).build();
        } else {
            record = new Organization.Builder().setFields(map).build();
        }
        return record;
    }
}
