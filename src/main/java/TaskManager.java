import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks; //initialize to a List so that it works flexibly with any 'list'

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTaskToList(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
    }

    public void markTask(int index) {
        tasks.get(index).toggleDone();
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

}
