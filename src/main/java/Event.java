public class Event extends Task {
    protected String startTime;
    protected String endTime;

    public Event(String description, String startTime, String endTime){
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskType = "[E]";
    }

    @Override
    public String toString() {
        return super.toString() + " (from: "  + startTime + ", to: " + endTime + ")";
    }
}
