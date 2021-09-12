package contacts.controller.updateObjects;

import contacts.controller.SerializationUtils;
import contacts.model.*;
import contacts.controller.enums.AppState;
/*
 * Handles creation and return of appropriate Phone Book Update Objects for use in app along with assigning
 * SerializationUtils to objects that change Records or Phone Book.
 * Further logic to manage flow of actions in app handled by AppState, ContactsApp, and InputParser.
 */
public class UpdateFactory {
    private final AddRecord addRecord;
    private final DeleteRecord deleteRecord;
    private final EditRecord editRecord;
    private final CountRecords countRecords;
    private final ListRecords listRecords;
    private final RecordInfo recordInfo;
    private final SearchRecords searchRecords;

    public UpdateFactory(PhoneBook phoneBook, SerializationUtils serializationUtils) {
        this.addRecord = new AddRecord(phoneBook, serializationUtils);
        this.deleteRecord = new DeleteRecord(phoneBook, serializationUtils);
        this.editRecord = new EditRecord(phoneBook, serializationUtils);
        this.countRecords = new CountRecords(phoneBook);
        this.listRecords = new ListRecords(phoneBook);
        this.recordInfo = new RecordInfo(phoneBook);
        this.searchRecords = new SearchRecords(phoneBook);
    }

    public UpdatePhoneBook getUpdatePhoneBookObject() {
        switch (AppState.getAppState()) {
            case ADD:
                return this.addRecord;
            case DELETE:
                return this.deleteRecord;
            case EDIT:
                return this.editRecord;
            case COUNT:
                return this.countRecords;
            case LIST:
                return this.listRecords;
            case RECORD:
                return this.recordInfo;
            case SEARCH:
                return this.searchRecords;
            default:
                throw new UpdatePhoneBookObjectRetrievalError("Invalid app state at time of object retrieval.");
        }
    }
}
