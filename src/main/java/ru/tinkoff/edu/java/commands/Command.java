package ru.tinkoff.edu.java.commands;

public interface Command {

    String name();
    String execute() throws InvalidCommandArguments;

    String help();
}
