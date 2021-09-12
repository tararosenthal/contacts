package contacts;

import contacts.controller.ContactsApp;

public class Main {
    public static void main(String[] args) {
        ContactsApp.runApp(args); //passes args to parse fileName in first element for deserialization of Phone Book
    }
}
