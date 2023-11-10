package ru.tinkoff.edu.java.tasks;

import java.util.*;

public class InMemoryTaskStore implements TaskStore {

    private final Map<UUID, Task> store = new HashMap<>();

    @Override
    public Task save(Task task) {
        return store.put(task.getId(), task);
    }

    @Override
    public Task getTask(UUID uuid) {
        return store.get(uuid);
    }

    @Override
    public Collection<Task> getAllTasks() {
        return store.values();
    }
}
