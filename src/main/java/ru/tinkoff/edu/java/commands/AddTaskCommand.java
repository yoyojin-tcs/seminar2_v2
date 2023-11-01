package ru.tinkoff.edu.java.commands;

import ru.tinkoff.edu.java.tasks.Task;
import ru.tinkoff.edu.java.tasks.TaskStatus;
import ru.tinkoff.edu.java.tasks.TaskStore;

import java.time.LocalDateTime;
import java.util.UUID;

public class AddTaskCommand implements Command {

    public static final String NAME = "addTask";
    private final String[] args;
    private final TaskStore taskStore;

    private String taskId;

    AddTaskCommand(String[] args, TaskStore taskStore){
        this.args = args;
        this.taskStore = taskStore;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String execute() throws InvalidCommandArguments {
        if (args.length != 4){
            throw new InvalidCommandArguments(help());
        }
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setSummary(args[1]);
        task.setUser(args[2]);
        task.setPriority(Integer.parseInt(args[3]));
        task.setStatus(TaskStatus.TODO);
        task.setDateCreated(LocalDateTime.now());
        taskStore.save(task);
        return task.toString();
    }

    @Override
    public String help() {
        return """
                addTask <summary> <username> <priority>
                """;
    }
}
