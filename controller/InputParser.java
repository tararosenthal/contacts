package contacts.controller;

import contacts.display.OutputInstructions;
import contacts.model.Record;
import contacts.controller.updateObjects.SingleRecordEdit;
import contacts.controller.enums.*;

import java.util.HashMap;
import java.util.Scanner;
/*
 * Handles all user input. Calls validation before passing input to Update Objects.
 * Can store record number and offset for record number to ensure continuity when switching between app states.
 */
public class InputParser {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int recordNumber; //corresponds to ordinal position of chosen Record in Phone Book, may not be valid
    private static int[] searchOffset; //offset after search queries to ensure accurate record number
    /*
     * When more than one action is possible for a given app state, this method ensures a valid next action is chosen.
     */
    public static void getAction() {
        OutputInstructions.printActions(); //prints possible actions for current app state
        String action = SCANNER.nextLine();
        if (InputValidator.validAction(action)) { //ensures chosen action is valid
            if (action.matches("\\d+")) { //for record state, assigns recordNumber (or -1) utilizing searchOffset if not null
                int number = Integer.parseInt(action) - 1;
                if (searchOffset != null) {
                    recordNumber = InputValidator.validRecordNumber(number, searchOffset);//prevents array out of bounds
                    searchOffset = null; //resets to ensure later recordNumbers are not offset in error
                } else {
                    recordNumber = number;
                }
                AppState.setAppState(AppState.RECORD); //record state required for utilizing recordNumber
            } else {
                AppState.setAppState(action); //all other actions
            }
            if (AppState.ADD.equals(AppState.getAppState())) {
                getRecordType(); //record type required to add record
            }
        } else {
            OutputInstructions.invalidSelection();
        }
    }
    /*
     * To create new records, a type is required. Only for add state. Utilized further by Add Factory.
     * Will loop until valid selection for type is made.
     */
    public static void getRecordType() {
        do {
            OutputInstructions.selectRecordType();
            String recordType = SCANNER.nextLine();
            if (InputValidator.validRecordType(recordType)) { //currently, two options: Person and Organization
                RecordType.setRecordType(recordType);
            } else {
                RecordType.setRecordType(RecordType.INVALID);
                OutputInstructions.invalidSelection();
            }
        } while (RecordType.INVALID.equals(RecordType.getRecordType()));
    }
    /*
     * Obtains field values for creating a new record. Only valid values will be processed further.
     * @param nullRecord        record of type Person or Organization with all null values to obtain field names, created by AddFactory
     * @return input            String HashMap with valid field/value pairs
     */
    public static HashMap<String, String> addRecord(Record nullRecord) {
        HashMap<String, String> input = new HashMap<>();
        for (String field : nullRecord.getFieldNames()) {
            OutputInstructions.recordInputValues(field);
            String value = SCANNER.nextLine();
            if (InputValidator.validValue(field, value)) {
                input.put(field, value);
            }
        }
        return input;
    }
    /*
     * Obtains field value for editing a record. Only a valid value will be processed further.
     * @param record             Record to be edited
     * @return singleRecordEdit  single valid String field/value pair with new value
     */
    public static SingleRecordEdit editRecord(Record record) {
        SingleRecordEdit singleRecordEdit = null;
        String field = getValidField(record);
        OutputInstructions.recordInputValues(field);
        String value = SCANNER.nextLine();

        if (InputValidator.validValue(field, value)) {
            singleRecordEdit = new SingleRecordEdit(field, value);
        }
        return singleRecordEdit;
}
   /*
    * Ensures valid field is input before obtaining value for editing.
    * @param record         Record for editing, ensures field is valid for record type
    * @return temp          validated field
    */
    private static String getValidField(Record record) {
        while (true) {
            OutputInstructions.selectField(record);
            String temp = SCANNER.nextLine();
            if (InputValidator.validField(temp, record)) {
                return temp;
            } else {
                OutputInstructions.invalidSelection();
            }
        }
    }
    /*
     * Gets search query for search object.
     * @return String       search query
     */
    public static String getSearchQuery() {
        OutputInstructions.getSearchQuery();
        return SCANNER.nextLine().trim().toLowerCase();
    }

    public static int getRecordNumber() {
        return recordNumber;
    }

    public static void setSearchOffset(int[] searchOffset) {
        InputParser.searchOffset = searchOffset;
    }
}