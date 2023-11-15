package ru.tinkoff.edu.java.commands;

import ru.tinkoff.edu.java.tasks.TaskStore;

import java.util.StringJoiner;

public class CommandProvider {

    private final TaskStore taskStore;
    private final String HELP_MESSAGE = new StringJoiner("- \n", "Following commands are supported:\n", "")
            .add(AddTaskCommand.NAME)
            .add(ListTasksCommand.NAME)
            .toString();

    public CommandProvider(TaskStore taskStore){
        this.taskStore = taskStore;
    }

    public Command parseCommand(String[] args) throws UnsupportedCommand {
        String commandName = extractCommand(args);
        if (commandName == null) throw new UnsupportedCommand(commandName);
        return switch (commandName) {
            case AddTaskCommand.NAME -> new AddTaskCommand(args, taskStore);
            case ListTasksCommand.NAME -> new ListTasksCommand(args, taskStore);
            case ExitCommand.NAME -> new ExitCommand();
            default -> throw new UnsupportedCommand(commandName);
        };
    }

    public String help(){
        return HELP_MESSAGE;
    }

    private String extractCommand(String[] args) {
        if (args.length > 0) {
            return args[0];
        }
        return null;
    }

}
