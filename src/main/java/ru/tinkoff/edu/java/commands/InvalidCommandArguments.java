package ru.tinkoff.edu.java.commands;

public class InvalidCommandArguments extends Exception {

    private final String helpMessage;

    public InvalidCommandArguments(String helpMessage) {
        this.helpMessage = helpMessage;
    }

    public String getHelpMessage() {
        return helpMessage;
    }
}
