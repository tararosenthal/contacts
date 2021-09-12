package contacts.controller.updateObjects;

import contacts.controller.InputParser;
import contacts.display.OutputInstructions;
import contacts.model.PhoneBook;
import contacts.model.Record;
/*
 * Handles searching through all records in a Phone Book using a user input search query.
 */
public class SearchRecords implements UpdatePhoneBook{
    private final PhoneBook phoneBook;

    public SearchRecords(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void update() {
        PhoneBook foundRecords = new PhoneBook(); //Stores Records matching search query
        String query = InputParser.getSearchQuery(); //Gets search query from user
        for (Record record: phoneBook.getRecords()) {
            //Finds all Records with query contained in either full name or field values
            if (record.getName().trim().toLowerCase().contains(query)
                    || record.getFieldValues().trim().toLowerCase().contains(query)) {
                foundRecords.addRecords(record);
            }
        }
        //Sets Record number offset to retain ordinal values in Phone Book for list of Records found
        InputParser.setSearchOffset(getSearchOffset(foundRecords));
        OutputInstructions.printSearchResults(foundRecords);
    }
    /*
     * Retains absolute ordinal values of found Records in Phone Book for further processing.
     * @param foundRecords      Phone Book containing only Records matching search query
     * @return searchOffset     order in array matches order in search query,
     *                          value is absolute order from Phone Book containing all Records
     */
    private int[] getSearchOffset(PhoneBook foundRecords) {
        int[] searchOffset = new int[foundRecords.getRecords().size()];
        int count = 0;
        for (Record record: foundRecords.getRecords()) {
            searchOffset[count++] = phoneBook.getRecords().lastIndexOf(record);
        }
        return searchOffset;
    }
}
