package contacts.controller;

import contacts.display.OutputInstructions;
import contacts.model.enums.OrganizationKey;
import contacts.model.enums.PersonKey;
import contacts.model.enums.RecordKey;
import contacts.model.enums.RecordType;

public class InputValidator {
    static boolean validNumber(String number) {
        number = number.trim();
        return number.matches("(?!.*\\(.*\\).*\\(.*\\).*)" + //parentheses do not surround two groups
                "[+]?" + //optional + at start of number
                "(\\(\\p{Alnum}+\\)|\\p{Alnum}+)" + //first group with or without parentheses, one or more alphanumeric, all other groups optional
                "([\\s-](\\(\\p{Alnum}{2,}\\)|\\p{Alnum}{2,})" + //second group with or without parentheses, two or more alphanumeric
                "([\\s-](\\p{Alnum}{2,})){0,3})?"); //additional groups, up to 5 total, no parentheses, two or more alphanumeric
    }

    static boolean validBirthDate(String date) {
        date = date.trim();
        return date.matches("(?=(.*/.*/.*)|(.*-.*-.*))\\d{1,2}[/-]\\d{1,2}[/-](\\d{2}|\\d{4})");
    }

    static boolean validGender(String gender) {
        gender = gender.trim();
        return gender.matches("(?i)[mf]");
    }

    static boolean validAction(String action) {
        action = action.trim();
        return action.matches("(?i)(add)|(remove)|(edit)|(count)|(info)|(exit)");
    }

    static boolean validRecordType(String recordType) {
        recordType = recordType.trim();
        return recordType.matches("(?i)(person)|(organization)|(business)");
    }

    static boolean validField(String field) {
        if (RecordType.PERSON.equals(RecordType.getRecordType())) {
            return validPersonField(field);
        } else {
            return validOrganizationField(field);
        }
    }

    static boolean validPersonField(String personField) {
        personField = personField.trim();
        return personField.matches("(?i)(first name)|(name)|(given name)|(surname)" +
                "|(last name)|(birth)|(birth date)|(birthday)|(gender)|(sex)|(number)|(phone number)");
    }

    static boolean validOrganizationField(String organizationField) {
        organizationField = organizationField.trim();
        return organizationField.matches("(?i)(organization name)|(name)|(business name)" +
                "|(address)|(location)|(number)|(phone number)");
    }

    static boolean validPersonValue(PersonKey personKey, String value) {
        if ((personKey.equals(PersonKey.BIRTH_DATE) && !validBirthDate(value))
                || (personKey.equals(PersonKey.GENDER) && !validGender(value))
                || (personKey.equals(PersonKey.PHONE_NUMBER) && !validNumber(value))) {
            OutputInstructions.wrongFormat(personKey);
            return false;
        } else return !overCharLimit(personKey, value);
    }

    static boolean validOrganizationValue(OrganizationKey organizationKey, String value) {
        if (organizationKey.equals(OrganizationKey.PHONE_NUMBER) && !validNumber(value)) {
            OutputInstructions.wrongFormat(organizationKey);
            return false;
        } else return !overCharLimit(organizationKey, value);
    }

    private static boolean overCharLimit(RecordKey recordKey, String value) {
        if (value.length() > 100) {
            OutputInstructions.overMaxCharLimit(recordKey);
            return true;
        }
        return false;
    }
}
