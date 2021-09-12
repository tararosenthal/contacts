package contacts.controller;

import contacts.controller.updateObjects.UpdateFactory;
import contacts.display.OutputInstructions;
import contacts.controller.enums.AppState;
import contacts.model.PhoneBook;
import contacts.controller.updateObjects.UpdatePhoneBookObjectRetrievalError;

public class ContactsApp {
    /*
     * Sets up Phone Book for App and ensures orderly flow for actions.
     * @param args      command line arguments where first element should contain fileName for loading Phone Book
     *                  or where Phone Book should be saved after it is created
     */
    public static void runApp(String[] args) {
        SerializationUtils serializationUtils = new SerializationUtils(args); //uses fileName for deserialization
        PhoneBook phoneBook = serializationUtils.getPhoneBook(); //loads phone book from file or creates new
        UpdateFactory updateFactory = new UpdateFactory(phoneBook, serializationUtils); //allows updating and saving phone book

        while (AppState.getAppState() != AppState.EXIT) { //should not meet this state, exiting is handled in AppState
            InputParser.getAction(); //requests user input for action on Phone Book
            if (AppState.getAppState().isUpdateObject()) { //if action requires interaction with Phone Book records
                try {
                    updateFactory.getUpdatePhoneBookObject().update(); //handles any updates or queries of Phone Book records
                } catch (UpdatePhoneBookObjectRetrievalError error) { //should not meet this state due to previous check
                    OutputInstructions.invalidSelection();
                    AppState.setAppState(AppState.MENU); //outputs error message and returns to main menu
                }
            }
            if (AppState.getAppState().isMenuState()) { //if action requires returning to main menu after completion
                AppState.setAppState(AppState.MENU);
            } else if (AppState.getAppState().isRecordState()) { //if action requires progressing to record state after completion
                AppState.setAppState(AppState.RECORD);
            }
        }
    }
}
