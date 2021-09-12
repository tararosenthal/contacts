package contacts.controller;

import contacts.display.OutputInstructions;
import contacts.model.PhoneBook;

import java.io.*;
/*
 * Handles serialization and deserialization of Phone Book objects.
 * File name is obtained through first element of command line args.
 * If args is empty or file name is invalid, no serialization or deserialization will occur but new Phone Book will be created.
 * If file has not been created at start of program, will create file and new Phone Book and save Phone Book to file.
 * If file has been created, will load Phone Book and save to same file after updates.
 */
public class SerializationUtils {
    String fileName;
    boolean validFile;
    File file;
    PhoneBook phoneBook;

    public SerializationUtils(String[] args) {
        if (args.length < 1) {
            validFile = false;
        } else {
            validFile = true;
            this.fileName = args[0];
            file = new File(fileName);
        }
    }

    public PhoneBook getPhoneBook() {
        if (validFile) {
            if (file.isFile()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
                    OutputInstructions.openFile(fileName);
                    phoneBook = (PhoneBook) objectInputStream.readObject();
                    objectInputStream.close();
                    return phoneBook;
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    if(!file.createNewFile()) {
                        validFile = false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        phoneBook = new PhoneBook();
        OutputInstructions.phoneBookCreated();
        if (validFile) {
            savePhoneBook();
        }
        return phoneBook;
    }

    public void savePhoneBook() {
        if (validFile) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
                objectOutputStream.writeObject(phoneBook);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}