package ru.tinkoff.edu.java.commands;

import ru.tinkoff.edu.java.tasks.Task;
import ru.tinkoff.edu.java.tasks.TaskStore;

import java.util.stream.Collectors;

public class ListTasksCommand implements Command {
    public static final String NAME = "listTasks";
    private final String[] args;
    private final TaskStore taskStore;

    ListTasksCommand(String[] args, TaskStore taskStore) {
        this.args = args;
        this.taskStore = taskStore;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String execute() throws InvalidCommandArguments {
        if (args.length != 1){
            throw new InvalidCommandArguments(help());
        }

        return taskStore.getAllTasks().stream().map(Task::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String help() {
        return """
                usage: listTasks
                """;
    }
}
