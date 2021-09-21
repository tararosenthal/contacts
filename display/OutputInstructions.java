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
     * from file.
     */
    public static void phoneBookCreated() {
        System.out.println("New phone book created");
    }
    /*
     * So user can interact with menus.
     */
    public static void printActions() {
        String actions = String.join(", ", AppState.getActions());
        System.out.printf("\n[%s] Enter action (%s): ", AppState.getAppState().toString(), actions);
    }
    /*
     * When adding record, gets desired record type from user.
     */
    public static void selectRecordType() {
        System.out.print("Enter the type (person, organization): ");
    }
    /*
     * @param field       a valid field (name, number, etc.) for a given Record type
     */
    public static void recordInputValues(String field) {
        System.out.printf("Enter the %s: ", field);
    }
    /*
     * When input value for a Record field is over max char limit.
     */
    public static void overMaxCharLimit(String field) {
        System.out.printf("Error, %s over maximum character limit (100).\n", field);
    }
    /*
     * When an input value for a field has invalid format.
     */
    public static void wrongFormat(String field) {
        System.out.printf("Invalid %s!\n", field);
    }
    /*
     * Outputs options for fields that can be edited for a given Record.
     */
    public static void selectField(Record record) {
        String fields = String.join(", ", record.getFieldNames());
        System.out.printf("Select a field (%s): ", fields);
    }
    /*
     * Works with Count Update Object.
     */
    public static void recordCount(int count) {
        System.out.printf("The Phone Book has %d records.\n", count);
    }
    /*
     * Lists all Records by ordinal position and full name (first and last for Person, organization name for Organization) for a given Phone Book.
     */
    public static void listRecords(PhoneBook phoneBook) {
        int positionInPhoneBook = 1;
        for (Record record : phoneBook.getRecords()) {
            listRecord(positionInPhoneBook++, record.getName());
        }
    }
    
    public static void listRecord(int positionInPhoneBook, String record) {System.out.printf("%d. %s\n", positionInPhoneBook, record);}
    
    public static void getSearchQuery() {
        System.out.print("Enter search query: ");
    }
    /*
     * Prints Records matching search query from a given Phone Book or "0 results".
     */
    public static void printSearchResults(PhoneBook recordsMatchingSearchQuery) {
        System.out.printf("Found %d results", recordsMatchingSearchQuery.getRecords().size());
        if (recordsMatchingSearchQuery.getRecords().size() > 0) {
            System.out.print(":\n");
            listRecords(recordsMatchingSearchQuery);
        } else {
            System.out.println();
        }
    }
    /*
     * When new Record successfully added to a Phone Book.
     */
    public static void recordAdded() {
        System.out.print("The record added.\n");
    }
    /*
     * When a Record has been edited successfully and saved, also prints full name and all fields of Recordd
     */
    public static void recordUpdated(Record record) {
        System.out.print("Saved\n");
        printRecord(record);
    }
    /*
     * When Record successfully deleted from Phone Book.
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
     */
    public static void printRecord(Record record) {
        System.out.print(record.toString());
    }
}
