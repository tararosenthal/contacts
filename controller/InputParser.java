package contacts.controller;

import contacts.display.OutputInstructions;
import contacts.model.SingleRecordEdit;
import contacts.model.enums.*;

import java.util.HashMap;
import java.util.Scanner;

public class InputParser {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void getAction() {
        OutputInstructions.mainMenu();
        String action = SCANNER.nextLine();
        if (InputValidator.validAction(action)) {
            AppState.setAppState(action);
            if (AppState.ADD.equals(AppState.getAppState())) {
                getRecordType();
            }
        } else {
            AppState.setAppState(AppState.ERROR);
            OutputInstructions.invalidSelection();
        }
    }

    public static void getRecordType() {
        do {
            OutputInstructions.selectRecordType();
            String recordType = SCANNER.nextLine();
            if (InputValidator.validRecordType(recordType)) {
                RecordType.setRecordType(recordType);
            } else {
                RecordType.setRecordType(RecordType.INVALID);
                OutputInstructions.invalidSelection();
            }
        } while (RecordType.INVALID.equals(RecordType.getRecordType()));
    }

    public static HashMap<RecordKey, String> addRecord() {
        HashMap<RecordKey, String> input = new HashMap<>();
        if (RecordType.PERSON.equals(RecordType.getRecordType())) {
            addPersonRecord(input);
        } else {
            addOrganizationRecord(input);
        }
        return input;
    }

    public static int selectRecord() {
        OutputInstructions.selectRecordInput();
        String line = SCANNER.nextLine();
        if (line.matches("\\d+")) {
            return Integer.parseInt(line) - 1;
        } else {
            return -1;
        }
    }

    public static SingleRecordEdit editRecord() {
        SingleRecordEdit singleRecordEdit = null;
        RecordKey key = getRecordKey();
        OutputInstructions.recordInputValues(key);
        String value = SCANNER.nextLine();

        if ((RecordType.PERSON.equals(RecordType.getRecordType()) && InputValidator.validPersonValue((PersonKey) key, value))
                || (RecordType.ORGANIZATION.equals(RecordType.getRecordType())
                && InputValidator.validOrganizationValue((OrganizationKey) key, value))) {
            singleRecordEdit = new SingleRecordEdit(key, value);
        }
        return singleRecordEdit;
}

    private static void addPersonRecord(HashMap<RecordKey, String> input) {
        for (PersonKey personKey : PersonKey.values()) {
            OutputInstructions.recordInputValues(personKey);
            String value = SCANNER.nextLine();
            if (InputValidator.validPersonValue(personKey, value)) {
                input.put(personKey, value);
            } else {
                input.put(personKey, null);
            }
        }
    }

    private static void addOrganizationRecord(HashMap<RecordKey, String> input) {
        for (OrganizationKey organizationKey : OrganizationKey.values()) {
            OutputInstructions.recordInputValues(organizationKey);
            String value = SCANNER.nextLine();
            if (InputValidator.validOrganizationValue(organizationKey, value)) {
                input.put(organizationKey, value);
            } else {
                input.put(organizationKey, null);
            }
        }
    }

    private static RecordKey getRecordKey() {
        while (true) {
            OutputInstructions.selectField();
            String temp = SCANNER.nextLine();
            if (InputValidator.validField(temp)) {
                return RecordKey.getRecordKey(temp);
            } else {
                OutputInstructions.invalidSelection();
            }
        }
    }
}