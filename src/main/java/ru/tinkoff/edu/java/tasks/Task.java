package ru.tinkoff.edu.java.tasks;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private UUID id;
    private String summary;
    private String user;
    private LocalDateTime dateCreated;
    private int priority;
    private TaskStatus status;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", user='" + user + '\'' +
                ", dateCreated=" + dateCreated +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
