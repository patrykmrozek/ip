package zoro.model;

public class Task {
    String taskType;
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.taskType = "[T]";
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void toggleDone() {
        this.isDone = !this.isDone;
    }

    @Override
    public String toString() {
        return taskType + " " + (this.isDone ? "[X] " : "[ ] ") + description;
    }
}
