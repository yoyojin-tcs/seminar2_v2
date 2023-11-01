package ru.tinkoff.edu.java.tasks;

import java.util.UUID;

public interface TaskStore {
    Task save(Task task);
    Task getTask(UUID uuid);
}
