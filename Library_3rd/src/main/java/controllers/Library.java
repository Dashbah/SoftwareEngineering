package controllers;

import Commands.Command;
import models.Storage;

import java.util.Scanner;

/**
 * main controller for working with the app
 * command handler
 */
public class Library {
    private final Storage storage;
    private static final Scanner input = new Scanner(System.in);

    public Library() {
        storage = new Storage();
        storage.addToStorageRandomElements();
    }

    /**
     * reads commands from console until
     * user enters "\q"
     * for parsing input line uses Parser
     * java/controllers/Parser.java
     */
    public void startDialog() {
        showCommands();
        while (true) {
            var nextLine = input.nextLine();
            if (nextLine.startsWith("/q")) {
                return;
            }
            try {
                Command command = Parser.parseCommand(nextLine);
                command.execute(storage);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * prints rules to the console
     */
    private void showCommands() {
        System.out.println("""
                Commands:\s
                /get {bookName} - take a book
                /list - your books
                /put {bookName}- return book
                /all - all books and num of them
                /q - quit
                """);
    }
}
