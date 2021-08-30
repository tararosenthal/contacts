package contacts.display;

import contacts.model.PhoneBook;
import contacts.model.Record;
import contacts.model.enums.AppState;
import contacts.model.enums.RecordKey;
import contacts.model.enums.RecordType;

public class OutputInstructions {

    public static void mainMenu() {
        System.out.print("Enter action (add, remove, edit, count, info, exit): ");
    }

    public static void selectRecordType() {
        System.out.print("Enter the type (person, organization): ");
    }

    public static void recordInputValues(RecordKey recordKey) {
        System.out.printf("Enter the %s: ", recordKey.toString());
    }

    public static void overMaxCharLimit(RecordKey recordKey) {
        System.out.printf("Error, %s over maximum character limit (100).\n", recordKey.toString());
    }

    public static void wrongFormat(RecordKey recordKey) {
        System.out.printf("Bad %s!\n", recordKey.toString());
    }

    public static void selectRecordInput() {
        System.out.print("Select a record: ");
    }

    public static void selectField() {
        if (RecordType.PERSON.equals(RecordType.getRecordType())) {
            System.out.print("Select a field (first name, last name, birth, gender, number): ");
        } else {
            System.out.print("Select a field (organization name, address, number): ");
        }
    }

    public static void recordCount(int count) {
        System.out.printf("The Phone Book has %d records.\n\n", count);
    }

    public static void listRecords(PhoneBook phoneBook) {
        int count = 1;
        for (Record record : phoneBook.getRecords()) {
            listRecord(count++, record.getName());
        }
    }

    public static void listRecord(int count, String record) {System.out.printf("%d. %s\n", count, record);}

    public static void recordAdded() {
        System.out.print("The record added.\n\n");
    }

    public static void recordUpdated() {
        System.out.print("The record updated!\n\n");
    }

    public static void recordRemoved() {
        System.out.print("The record removed!\n\n");
    }

    public static void noRecords() {
        System.out.printf("No records to %s!\n\n", AppState.getAppState());
    }

    public static void doesNotExist() {
        System.out.print("Record does not exist!\n\n");
    }

    public static void invalidSelection() {
        System.out.println("Invalid selection. Try again.");
    }

    public static void printRecord(Record record) {
        System.out.println(record.toString());
    }
}
