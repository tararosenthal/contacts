package contacts.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
/*
 * Organization Record utilizing Builder for object creation, uses polymorphism where possible.
 */
public class Organization extends Record{
    private String organizationName;
    private String address;

    private Organization(String organizationName, String address, String phoneNumber) {
        super(phoneNumber);
        this.organizationName = organizationName;
        this.address = address;
    }
    /*
     * Returns full name of Record.
     */
    @Override
    public String getName() {
        return organizationName;
    }
    /*
     * Returns all fields for entering values to create or update Record.
     */
    @Override
    public String[] getFieldNames() {
        return new String[]{"name", "address", "number"};
    }
    /*
     * After validation, changes a given field to a given value. Requires set methods to update time of last edit.
     */
    @Override
    public void changeField(String field, String value) {
        switch (field) {
            case "name":
                setOrganizationName(value);
                break;
            case "address":
                setAddress(value);
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
        return address + getPhoneNumber();
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        this.setTimeUpdated(LocalDateTime.now());
    }

    public void setAddress(String address) {
        this.address = address;
        this.setTimeUpdated(LocalDateTime.now());
    }
    /*
     * Formatting of output for all field values of object.
     */
    @Override
    public String toString() {
        return String.format("Organization name: %s\nAddress: %s\n" + super.toString(),
                organizationName == null ? "[no data]" : organizationName,
                address == null ? "[no data]" : address);
    }

    public static class Builder {
        private String organizationName;
        private String address;
        private String phoneNumber;
        /*
         * Sets any number of fields depending on items in HashMap.
         * @param map       contains field and value pairs
         * @return this     for stringing together methods
         */
        public Builder setFields(HashMap<String, String> map) {
            for (Map.Entry<String, String> entry: map.entrySet()) {
                switch (entry.getKey()) {
                    case "name":
                        this.organizationName = entry.getValue();
                        break;
                    case "address":
                        this.address = entry.getValue();
                        break;
                    case "number":
                        this.phoneNumber = entry.getValue();
                        break;
                }
            }
            return this;
        }

        public Organization build() {
            return new Organization(organizationName, address, phoneNumber);
        }
    }
}
