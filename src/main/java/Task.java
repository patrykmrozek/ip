public class Task {
    protected String description;
    protected boolean isDone;

    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }
    public boolean isDone() {
        return isDone;
    }
    public boolean setDone() {
        this.isDone = !this.isDone;
        return this.isDone;
    }
}
