package contacts.controller;

import contacts.display.OutputInstructions;
import contacts.model.enums.AppState;
import contacts.model.PhoneBook;
import contacts.model.UpdateFactory;
import contacts.model.UpdatePhoneBookObjectRetrievalError;

public class ContactsApp {
    public static void runApp() {
        PhoneBook phoneBook = new PhoneBook();
        UpdateFactory updateFactory = new UpdateFactory(phoneBook);

        while (AppState.getAppState() != AppState.EXIT) {
            InputParser.getAction();
            if (!AppState.ERROR.equals(AppState.getAppState()) && !AppState.EXIT.equals(AppState.getAppState())) {
                try {
                    updateFactory.getUpdatePhoneBookObject().update();
                } catch (UpdatePhoneBookObjectRetrievalError error) {
                    OutputInstructions.invalidSelection();
                }
            }
        }
    }
}
