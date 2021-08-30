package contacts.model;

import contacts.model.enums.AppState;

public class UpdateFactory {
    private final AddRecord addRecord;
    private final RemoveRecord removeRecord;
    private final EditRecord editRecord;
    private final CountRecords countRecords;
    private final ListRecords listRecords;

    public UpdateFactory(PhoneBook phoneBook) {
        this.addRecord = new AddRecord(phoneBook);
        this.removeRecord = new RemoveRecord(phoneBook);
        this.editRecord = new EditRecord(phoneBook);
        this.countRecords = new CountRecords(phoneBook);
        this.listRecords = new ListRecords(phoneBook);
    }

    public UpdatePhoneBook getUpdatePhoneBookObject() {
        switch (AppState.getAppState()) {
            case ADD:
                return this.addRecord;
            case REMOVE:
                return this.removeRecord;
            case EDIT:
                return this.editRecord;
            case COUNT:
                return this.countRecords;
            case LIST:
                return this.listRecords;
            default:
                throw new UpdatePhoneBookObjectRetrievalError("Invalid app state at time of object retrieval.");
        }
    }
}
