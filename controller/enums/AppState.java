package contacts.controller.enums;
/*
 * Organizes actions in the app. Assigned booleans are to ensure proper flow in the ContactsApp class and prevent errors.
 * Update object: action requires interaction with Records in Phone Book
 * Record state: action requires progressing to record app state after completion
 * Menu state: action requires progressing to menu state after completion
 * Can set state by string or AppState value
 * Several states have a list of potential actions that may be chosen when state is active, handled by getActions()
 */
public enum AppState {
    MENU(false, false, true),
    ADD(true, false, true),
    LIST(true, false, false),
    SEARCH(true, false, false),
    COUNT(true, false, true),
    EXIT(false, false, false),
    DELETE(true, false, true),
    RECORD(true, false, false),
    EDIT(true, true, false);

    boolean updateObject;
    boolean recordState;
    boolean menuState;

    AppState(boolean updateObject, boolean recordState, boolean menuState) {
        this.updateObject = updateObject;
        this.recordState = recordState;
        this.menuState = menuState;
    }

    public static AppState appState = MENU;

    public static AppState getAppState() {
        return appState;
    }

    public static void setAppState(String string) {
        switch (string.toLowerCase().trim()) {
            case "add":
                appState = ADD;
                break;
            case "list":
                appState = LIST;
                break;
            case "search":
                appState = SEARCH;
                break;
            case "count":
                appState = COUNT;
                break;
            case "exit": //handles exiting the app
                appState = EXIT;
                System.exit(0);
            case "delete":
                appState = DELETE;
                break;
            case "record":
                appState = RECORD;
                break;
            case "again": //maintains same app state
                break;
            case "edit":
                appState = EDIT;
                break;
            default:
                appState = MENU;
                break;
        }
    }

    public static void setAppState(AppState appState) {
        AppState.appState = appState;
    }
    /*
     * Assigns potential actions by app state. Most are app states themselves.
     * Back returns to main menu. Again maintains current state. [number] selects record by number for processing.
     * @return String[]         array of potential actions in current state
     */
    public static String[] getActions() {
        switch (appState) {
            case MENU:
                return new String[]{"add", "list", "search", "count", "exit"};
            case SEARCH:
                return new String[]{"[number]", "back", "again"};
            case RECORD:
                return new String[]{"edit", "delete", "menu"};
            case LIST:
                return new String[]{"[number]", "back"};
            default:
                throw new GetAppStateActionsError("Invalid AppState while attempting to get actions");
        }
    }

    public boolean isUpdateObject() {
        return updateObject;
    }

    public boolean isRecordState() {
        return recordState;
    }

    public boolean isMenuState() {
        return menuState;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase().trim();
    }
}
