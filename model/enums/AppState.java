package contacts.model.enums;

public enum AppState {
    ADD,
    REMOVE,
    EDIT,
    COUNT,
    LIST,
    ERROR,
    EXIT;

    public static AppState appState;

    public static AppState getAppState() {
        return appState;
    }

    public static void setAppState(String string) {
        switch (string.toLowerCase().trim()) {
            case "add":
                appState = ADD;
                break;
            case "remove":
                appState = REMOVE;
                break;
            case "edit":
                appState = EDIT;
                break;
            case "count":
                appState = COUNT;
                break;
            case "info":
                appState = LIST;
                break;
            case "exit":
                appState = EXIT;
                System.exit(0);
            default:
                appState = ERROR;
                break;
        }
    }

    public static void setAppState(AppState appState) {
        AppState.appState = appState;
    }


    @Override
    public String toString() {
        return super.toString().toLowerCase().trim();
    }
}
