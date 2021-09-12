package contacts.controller.enums;
/*
 * If app state which does not have associated list of actions is active when appState.getActions() is called.
 * Should not occur as ContactsApp sets app state appropriately using assigned booleans before calling InputParser.getAction()
 */
public class GetAppStateActionsError extends RuntimeException{
    public GetAppStateActionsError(String message) {
        super(message);
    }
}
