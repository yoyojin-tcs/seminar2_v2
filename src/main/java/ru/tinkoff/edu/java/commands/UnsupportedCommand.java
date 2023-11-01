package ru.tinkoff.edu.java.commands;

public class UnsupportedCommand extends Exception {
    private final String commandName;

    public UnsupportedCommand(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
