package contacts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneBook {
    private List<Record> records = new ArrayList<>();

    public void addRecords(Record... args) {
        records.addAll(Arrays.asList(args));
    }

    public void removeRecord(int index) {
        records.remove(index);
    }

    public void removeRecords(Record... args) {
        records.removeAll(Arrays.asList(args));
    }

    public Record getRecord(int index) {
        return records.get(index);
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}