public class Deadline extends Task {
    protected String deadline_by;

    public Deadline(String description, String deadline_by) {
        super(description);
        this.deadline_by = deadline_by;
    }
}
