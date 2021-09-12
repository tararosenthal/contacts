package contacts.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
/*
 * Person Record utilizing Builder for object creation, uses polymorphism where possible.
 */
public class Person extends Record{
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;

    private Person(String firstName, String lastName, String birthDate,
                   String gender, String phoneNumber) {
        super(phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    /*
     * Returns full name of Record.
     */
    @Override
    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }
    /*
     * Returns all fields for entering values to create or update Record.
     */
    @Override
    public String[] getFieldNames() {
        return new String[]{"first name", "last name", "birth", "gender", "number"};
    }
    /*
     * After validation, changes a given field to a given value. Requires set methods to update time of last edit.
     */
    @Override
    public void changeField(String field, String value) {
        switch (field) {
            case "first name":
                setFirstName(value);
                break;
            case "last name":
                setLastName(value);
                break;
            case "birth":
                setBirthDate(value);
                break;
            case "gender":
                setGender(value);
                break;
            case "number":
                setPhoneNumber(value);
                break;
        }
    }
    /*
     * Obtains fields other than full name for searching Records.
     */
    @Override
    public String getFieldValues() {
        return birthDate + gender + getPhoneNumber();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.setTimeUpdated(LocalDateTime.now());
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.setTimeUpdated(LocalDateTime.now());
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        this.setTimeUpdated(LocalDateTime.now());
    }

    public void setGender(String gender) {
        this.gender = gender;
        this.setTimeUpdated(LocalDateTime.now());
    }
    /*
     * Formatting of output for all field values of object.
     */
    @Override
    public String toString() {
        return String.format("First name: %s\nLast name: %s\nBirth date: %s\nGender: %s\n" + super.toString(),
                firstName == null ? "[no data]" : firstName,
                lastName == null ? "[no data]" : lastName,
                birthDate == null ? "[no data]" : birthDate,
                gender == null ? "[no data]" : gender.toUpperCase());
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String birthDate;
        private String gender;
        /*
         * Sets any number of fields depending on items in HashMap.
         * @param map       contains field and value pairs
         * @return this     for stringing together methods
         */
        public Builder setFields(HashMap<String, String> map) {
            for (Map.Entry<String, String> entry: map.entrySet()) {
                switch (entry.getKey()) {
                    case "first name":
                        this.firstName = entry.getValue();
                        break;
                    case "last name":
                        this.lastName = entry.getValue();
                        break;
                    case "birth":
                        this.birthDate = entry.getValue();
                        break;
                    case "gender":
                        this.gender = entry.getValue();
                        break;
                    case "number":
                        this.phoneNumber = entry.getValue();
                        break;
                }
            }
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName,
                    birthDate, gender, phoneNumber);
        }
    }
}
