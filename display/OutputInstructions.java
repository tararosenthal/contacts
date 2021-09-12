package contacts.display;

import contacts.model.PhoneBook;
import contacts.model.Record;
import contacts.controller.enums.AppState;
/*
 * Handles formatting of all output to user.
 */
public class OutputInstructions {
    /*
     * At start of app if SerializationUtils was able to deserialize Phone Book from given fileName in args.
     * @param fileName     input by user as first element of args
     */
    public static void openFile(String fileName) {
        System.out.printf("open %s\n", fileName);
    }
    /*
     * If fileName not input in args, fileName invalid, or file empty or otherwise not able to deserialize Phone Book
     * from file. Notifies user that new Phone Book was created.
     */
    public static void phoneBookCreated() {
        System.out.println("New phone book created");
    }
    /*
     * Prints list of potential actions corresponding to current AppState.
     */
    public static void printActions() {
        String actions = String.join(", ", AppState.getActions());
        System.out.printf("\n[%s] Enter action (%s): ", AppState.getAppState().toString(), actions);
    }
    /*
     * When adding record, gets record type from user.
     */
    public static void selectRecordType() {
        System.out.print("Enter the type (person, organization): ");
    }
    /*
     * Gets user to input value for a given field.
     * @param field       a valid field (name, number, etc.) for a given Record type
     */
    public static void recordInputValues(String field) {
        System.out.printf("Enter the %s: ", field);
    }
    /*
     * If user input value for a field is over the max char limit, set to 100.
     * @param field     valid field for a given Record type where input is over max limit
     */
    public static void overMaxCharLimit(String field) {
        System.out.printf("Error, %s over maximum character limit (100).\n", field);
    }
    /*
     * When an input value for a field has invalid format.
     * @param field     valid field for a given Record type where input value has invalid format
     */
    public static void wrongFormat(String field) {
        System.out.printf("Invalid %s!\n", field);
    }
    /*
     * Outputs options for fields that can be edited for a given Record.
     * @param record        Record to be edited
     */
    public static void selectField(Record record) {
        String fields = String.join(", ", record.getFieldNames());
        System.out.printf("Select a field (%s): ", fields);
    }
    /*
     * Outputs count of records in a Phone Book.
     * @param count     number of records in a Phone Book
     */
    public static void recordCount(int count) {
        System.out.printf("The Phone Book has %d records.\n", count);
    }
    /*
     * Lists all Records by ordinal position and full name for a given Phone Book.
     * @param phoneBook     containing Records to be listed
     */
    public static void listRecords(PhoneBook phoneBook) {
        int count = 1;
        for (Record record : phoneBook.getRecords()) {
            listRecord(count++, record.getName());
        }
    }
    /*
     * Individual output of Record number and full name for listing.
     */
    public static void listRecord(int count, String record) {System.out.printf("%d. %s\n", count, record);}
    /*
     * Requests user to input search query.
     */
    public static void getSearchQuery() {
        System.out.print("Enter search query: ");
    }
    /*
     * Prints Records matching search query from a given Phone Book or "0 results".
     * @param phoneBook     containing found Records
     */
    public static void printSearchResults(PhoneBook phoneBook) {
        System.out.printf("Found %d results", phoneBook.getRecords().size());
        if (phoneBook.getRecords().size() > 0) {
            System.out.print(":\n");
            listRecords(phoneBook);
        } else {
            System.out.println();
        }
    }
    /*
     * When new Record added to a Phone Book.
     */
    public static void recordAdded() {
        System.out.print("The record added.\n");
    }
    /*
     * When a Record has been edited successfully and saved, also prints full name and all fields of Record.
     * @param record        edited Record
     */
    public static void recordUpdated(Record record) {
        System.out.print("Saved\n");
        printRecord(record);
    }
    /*
     * When Record deleted from Phone Book.
     */
    public static void recordDeleted() {
        System.out.print("The record deleted!\n");
    }
    /*
     * When no Records in Phone Book to complete requested action on.
     */
    public static void noRecords() {
        System.out.printf("No records to %s!\n", AppState.getAppState());
    }
    /*
     * When user inputs invalid Record number.
     */
    public static void doesNotExist() {
        System.out.print("Record does not exist!\n");
    }
    /*
     * When user inputs invalid action or field selection.
     */
    public static void invalidSelection() {
        System.out.println("Invalid selection. Try again.");
    }
    /*
     * Prints full name and all fields of a given Record.
     * @param record      to be printed
     */
    public static void printRecord(Record record) {
        System.out.println(record.toString());
    }
}
