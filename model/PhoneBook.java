package contacts.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Class for storing Record objects. One Phone Book is saved and loaded by the app using serialization and
 * deserialization.
 */
public class PhoneBook implements Serializable {
    private static final long serialVersionUID = 2L;

    private final List<Record> records = new ArrayList<>();

    public void addRecords(Record... args) {
        records.addAll(Arrays.asList(args));
    }

    public void deleteRecord(int index) {
        records.remove(index);
    }

    public Record getRecord(int index) {
        return records.get(index);
    }

    public List<Record> getRecords() {
        return records;
    }
}