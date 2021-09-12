package contacts.controller;

import contacts.controller.enums.AppState;
import contacts.display.OutputInstructions;
import contacts.model.Record;
/*
 * Handles all validation of user input except for whether a record number is contained in a given Phone Book
 * (handled by Update Phone Book interface)
 */
public class InputValidator {
    /*
     * Supports validation of global phone numbers.
     */
    static boolean validNumber(String number) {
        number = number.trim().toLowerCase();
        return number.matches("(?!.*\\(.*\\).*\\(.*\\).*)" + //parentheses do not surround two groups
                "[+]?" + //optional + at start of number
                "(\\(\\p{Alnum}+\\)|\\p{Alnum}+)" + //first group with or without parentheses, one or more alphanumeric, all other groups optional
                "([\\s-](\\(\\p{Alnum}{2,}\\)|\\p{Alnum}{2,})" + //second group with or without parentheses, two or more alphanumeric
                "([\\s-](\\p{Alnum}{2,})){0,4})?"); //additional groups, up to 6 total, no parentheses, two or more alphanumeric
    }
    /*
     * Validation of birthdate in following formats: dd/dd/dddd, d/d/dd, dd/d/dddd, etc.
     * Forward slashes may be replaced by hyphens.
     */
    static boolean validBirthDate(String date) {
        date = date.trim().toLowerCase();
        return date.matches("(?=(.*/.*/.*)|(.*-.*-.*))\\d{1,2}[/-]\\d{1,2}[/-](\\d{2}|\\d{4})");
    }
    /*
     * Validation of gender for m/M or f/F only.
     */
    static boolean validGender(String gender) {
        gender = gender.trim().toLowerCase();
        return gender.matches("[mf]");
    }
    /*
     * Validates input action based on available options for current app state.
     */
    static boolean validAction(String action) {
        action = action.trim().toLowerCase();
        String[] actions = AppState.getActions();
        for (String option: actions) {
            if ("[number]".equals(option) && action.matches("\\d+")) {
                return true;
            } else if (action.matches(option)){
                return true;
            }
        }
        return false;
    }
    /*
     * Validates record type for add record. Currently supports two options.
     */
    static boolean validRecordType(String recordType) {
        recordType = recordType.trim().toLowerCase();
        return recordType.matches("(person)|(organization)");
    }
    /*
     * Prevents array out of bounds error when utilizing searchOffset
     * @param number        input record number
     * @param searchOffset  saved search offset from previous action, method ensures number is an index of offset
     * @return int          ordinal position of record in Phone Book after utilizing offset, or -1 if out of bounds
     */
    static int validRecordNumber(int number, int[] searchOffset) {
        if (number >= 0 && number < searchOffset.length) {
            return searchOffset[number];
        }
        return -1;
    }
    /*
     * Ensures user input valid field for specific record.
     */
    static boolean validField(String field, Record record) {
        field = field.trim().toLowerCase();
        for (String fieldName: record.getFieldNames()) {
            if (field.matches(fieldName)) {
                return true;
            }
        }
        return false;
    }
    /*
     * Ensures values are validated if needed before assigning to record fields.
     */
    static boolean validValue(String field, String value) {
        boolean valid;
        if (overCharLimit(value)) { //have assigned 100 chars as upper limit for values
            OutputInstructions.overMaxCharLimit(field);
            return false;
        } else {
            switch (field) {
                case "birth":
                    valid = validBirthDate(value);
                    break;
                case "gender":
                    valid = validGender(value);
                    break;
                case "number":
                    valid = validNumber(value);
                    break;
                default:
                    return true;
            }
            if (!valid) { //this case is solely for outputting information to user
                OutputInstructions.wrongFormat(field);
            }
        }
        return valid;
    }

    private static boolean overCharLimit(String value) {
        return value.length() > 100;
    }
}
