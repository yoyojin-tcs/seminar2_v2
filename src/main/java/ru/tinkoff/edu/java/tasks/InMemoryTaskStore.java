package ru.tinkoff.edu.java.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryTaskStore implements TaskStore {

    private Map<UUID, Task> store = new HashMap<>();

    @Override
    public Task save(Task task) {
        return store.put(task.getId(), task);
    }

    @Override
    public Task getTask(UUID uuid) {
        return store.get(uuid);
    }
}
