package contacts.model;

import contacts.model.enums.RecordKey;

public class SingleRecordEdit {
    private final RecordKey recordKey;
    private final String value;

    public SingleRecordEdit(RecordKey recordKey, String value) {
        this.recordKey = recordKey;
        this.value = value;
    }

    public RecordKey getRecordKey() {
        return recordKey;
    }

    public String getValue() {
        return value;
    }
}
