package contacts.model.enums;

public enum RecordType {
    PERSON,
    ORGANIZATION,
    INVALID;

    public static RecordType recordType;

    public static RecordType getRecordType() {
        return recordType;
    }

    public static RecordType getRecordType(String string) {
        switch (string.toLowerCase().trim()) {
            case "person":
                return PERSON;
            case "organization":
            case "business":
                return ORGANIZATION;
            default:
                return INVALID;
        }
    }

    public static void setRecordType(String string) {
        switch (string.toLowerCase().trim()) {
            case "person":
                recordType = PERSON;
                break;
            case "organization":
            case "business":
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
