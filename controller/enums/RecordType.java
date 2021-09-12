package contacts.controller.enums;
/*
 * Only used with InputParser and AddFactory classes to ensure appropriate record is created before adding to Phone Book
 */
public enum RecordType {
    PERSON,
    ORGANIZATION,
    INVALID;

    public static RecordType recordType;

    public static RecordType getRecordType() {
        return recordType;
    }

    public static void setRecordType(String string) {
        switch (string.toLowerCase().trim()) {
            case "person":
                recordType = PERSON;
                break;
            case "organization":
                recordType = ORGANIZATION;
                break;
            default:
                recordType = INVALID;
                break;
        }
    }

    public static void setRecordType(RecordType recordType) {
        RecordType.recordType = recordType;
    }
}
