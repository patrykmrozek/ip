public class Task {
    String task_type;
    protected String description;
    protected boolean isDone;

    Task(String description) {
        this.description = description;
        this.isDone = false;
        this.task_type = "[T]";
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
        return task_type + " " + (this.isDone ? "[X] " : "[ ] ") + description;
    }
}
