package contacts.controller.updateObjects;
/*
 * Error if AppState is invalid at time of Update Object retrieval by UpdateFactory.
 * Should not happen due to assignment of enum states as corresponding valid Update Object and check by ContactsApp.
 */
public class UpdatePhoneBookObjectRetrievalError extends RuntimeException{
    public UpdatePhoneBookObjectRetrievalError(String message) {
        super(message);
    }
}
