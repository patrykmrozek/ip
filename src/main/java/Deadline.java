public class Deadline extends Task {
    protected String deadlineBy;

    public Deadline(String description, String deadlineBy) {
        super(description);
        this.deadlineBy = deadlineBy;
        this.taskType = "[D]";
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + deadlineBy + ")";
    }
}
