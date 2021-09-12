package contacts.controller.updateObjects;
/*
 * For processing user input for updating the value of a single field in a single Record.
 * Obtained with InputParser and used by RecordEdit
 */
public class SingleRecordEdit {
    private final String field;
    private final String value;

    public SingleRecordEdit(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }
}
