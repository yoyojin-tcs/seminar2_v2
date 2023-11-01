package ru.tinkoff.edu.java.commands;

public class ExitCommand implements Command{

    public static final String NAME = "exit";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String execute() throws InvalidCommandArguments {
        throw new RuntimeException("Exit command called.");
    }

    @Override
    public String help() {
        return "exit";
    }
}
